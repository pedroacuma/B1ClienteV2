package modelo;

import java.util.ArrayList;
import java.util.List;

public class VinetaSerie {
	
	private int idVineta;
	private int idSerie;
	private String anotacionPrivada;
	
	//Devuelve las viñetas asociadas a una serie
	//Pedro
//	public static List<VinetaSerie> listVinetaSerie(int idSerie){
//		Conexion con = new Conexion();
//		List<Object[]> vinetas = con.Select("SELECT * FROM VINETASERIE WHERE idserie =" + idSerie);
//		List<VinetaSerie> lista = new ArrayList<>();
//		
//		for(Object[] vin : vinetas){
//			int idv = (int) vin[0];
//			int ids = (int) vin[1];
//			
//			lista.add(new VinetaSerie(idv,ids));
//		}
//		
//		return lista;
//	}
	
//	public VinetaSerie(int idv,int ids) {
//		Conexion con = new Conexion();
//		Object[] vin = con.Select("SELECT * FROM VINETASERIE WHERE IDSERIE =" + ids + " AND IDVINETA=" + idv).get(0);
//
//		this.idVineta = (int) vin[0];
//		this.idSerie = (int) vin[1];
//		this.anotacionPrivada = (String) vin[2];
//				
//	}
	
	public VinetaSerie(int idv,int ids,String nota) {
		idVineta = idv;
		idSerie = ids;
		anotacionPrivada = nota;
		
		Conexion con = new Conexion();
		con.Insert("INSERT INTO VINETASERIE (idvineta,idserie,anotacionprivada) VALUES (" + idv + "," + ids + ",'" + nota + "')");
	}

	
	public void borrar() {
		Conexion con = new Conexion();
		con.Delete("DELETE FROM VINETASERIE WHERE IDVINETA="+ idVineta + " AND IDSERIE=" + idSerie);
		idVineta = -1;
		idSerie = -1;
		anotacionPrivada = null;
	}
}
