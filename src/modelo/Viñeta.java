package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class Viñeta {
	//creo que son los atributos correctos

	private String id;
	private String img;
	public static List<Viñeta> listViñetas() {
		Conexion con = new Conexion();
		List<Viñeta> listViñeta = new ArrayList<>();
		List<Object[]> viñetas = con.Select("SELECT * FROM vineta");
		
		for(Object[] o : viñetas) {
			String idV = (String) o[0];
			Viñeta v = new Viñeta(idV);
			listViñeta.add(v);
		}
		
		return listViñeta;
	}
	public Viñeta(String idv){
		Conexion con = new Conexion();
		List<Object[]> viñs = con.Select("SELECT * FROM vineta WHERE id ='" + idv + "'");
		if(viñs.isEmpty()) {
			//con.Insert("INSERT INTO vineta VALUES ('" + nombre + "')");
		}
		
		//id = viñs[0];
		//img = viñs[1];
		
	}
	//a partir de aquí hacia abajo hay que modificarlo según los atributos
	public Viñeta(String nom, String url, int seri){
			Conexion con=new Conexion();
			
			try {
				
				con.Insert("INSERT INTO vineta (id, img) VALUES  (" + nom + " , '" +  convertFileContentToBlob(url) + "') ");
				con.Insert("INSERT INTO composicion VALUES(" + seri + "," + nom +  ")");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			id = nom; //(Integer) con.SelectEscalar("SELECT id FROM viñeta WHERE img ='" + imgn + "'");
			
			img=url;
			
	
	}
	public String getImagen(){
		return img;
	}
	public String getId(){
		return id;
	}
	public List<Integer> getSeries(){
		Conexion con=new Conexion();
		List<Object[]> o =con.Select("SELECT SERIE_ID WHERE vineta_ID =" + id + ";");
		List <Integer> ids =new ArrayList<>();;
		for(Object[] ow : o) {
			int idV = (int) ow[0];
			ids.add(idV);
		}
		
		return ids;
	}
	public static byte[] convertFileContentToBlob(String filePath) throws IOException {
		byte[] fileContent = null;
	        // initialize string buffer to hold contents of file
		StringBuffer fileContentStr = new StringBuffer("");
		BufferedReader reader = null;
		try {
	                // initialize buffered reader  
			reader = new BufferedReader(new FileReader(filePath));
			String line = null;
	                // read lines of file
			while ((line = reader.readLine()) != null) {
	                        //append line to string buffer
				fileContentStr.append(line).append("\n");
			}
	                // convert string to byte array
			fileContent = fileContentStr.toString().trim().getBytes();
		} catch (IOException e) {
			throw new IOException("Unable to convert file to byte array. " + e.getMessage());
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return fileContent;
	}
	
	
	
	
	
	
}
