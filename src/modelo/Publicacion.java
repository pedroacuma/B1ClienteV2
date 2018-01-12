package modelo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {
	
	private int id;
	private Timestamp fecha;
	private String medio;
	private int id_vineta;
	
	public static List<Publicacion> listPublicacion() {
		ArrayList<Publicacion> list = new ArrayList<>();
		Conexion con = new Conexion();
		for(Object[] tupla : con.Select("SELECT id FROM PUBLICACION ORDER BY fecha DESC")) {
			int i = (int) tupla[0];
			list.add(new Publicacion(i));
		}
		return list;
	}
	
	public Publicacion (int id_vineta, Timestamp fecha, String medio) {
		Conexion con = new Conexion();
		List<Object[]> pub = con.Select("SELECT * FROM PUBLICACION WHERE ID_VINETA = "+this.id_vineta+" AND MEDIO = '"+medio+"'");
		if (pub.isEmpty()) {
			con.Insert("INSERT INTO PUBLICACION (ID_VINETA, FECHA, MEDIO) VALUES ("+id_vineta+", '"+fecha+"','"+medio+"')");
		}
		this.id = (int) con.Select("SELECT MAX(ID) FROM PUBLICACION").get(0)[0];
		this.fecha = fecha;
		this.medio = medio;
		this.id_vineta = id_vineta;
	}
	
	public Publicacion (int id) {
		Conexion con = new Conexion();
		Object[] tupla = con.Select("SELECT * FROM PUBLICACION WHERE id=" +  id).get(0);
		
		this.id = (int) tupla[0];
		this.medio = (String) tupla[1];
		this.id_vineta = (int) tupla[2];

		//El casting para timestamp es algo complicado
		try {
		    this.fecha = (Timestamp) (tupla[3]);
		} catch(Exception e) { 
			e.printStackTrace();
		}
		
		

	}
	
	public void borrarPublicacion() {
		Conexion con = new Conexion();
		System.out.println(this.id);
		con.Delete("DELETE FROM PUBLICACION WHERE ID ='" + this.id + "'");
		id = -1;
		fecha = null;
		medio = null;
		id_vineta = -1;
		
	}
	
	public int getId() {
		return id;
	}
	
	public int getIdVineta() {
		return id_vineta;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public String getMedio() {
		return medio;
	}
	
	public String getNombreVineta() {
		Conexion con = new Conexion();
		return (String)con.Select("SELECT NOMBRE FROM VINETA WHERE ID=" + id_vineta).get(0)[0];
	}
	
	public String getSeries() {
		Conexion con = new Conexion();
		List<Object[]> series = con.Select("SELECT SERIE.NOMBRE FROM SERIE, VINETASERIE WHERE IDSERIE=SERIE.ID AND IDVINETA=" + this.id_vineta);
		String res = "";
		for(Object[] idSerie : series) {
			res += " " + idSerie[0];
		}
		return res;
	}
	
	public String toString() {
		Conexion con = new Conexion();
		String nomVin = (String) con.Select("SELECT nombre FROM VINETA WHERE IDVINETA=" + this.id_vineta).get(0)[0];
		return nomVin + " " + medio+" "+fecha.toString();
	}

}
