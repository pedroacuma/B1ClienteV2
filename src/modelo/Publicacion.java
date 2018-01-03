package modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {
	
	private int id;
	private Date fecha;
	private String medio;
	private int id_vineta;
	
	public static List<Publicacion> listPublicacion() {
		ArrayList<Publicacion> list = new ArrayList<>();
		Conexion con = new Conexion();
		for(Object[] tupla : con.Select("SELECT id FROM PUBLICACION")) {
			int i = (int) tupla[0];
			list.add(new Publicacion(i));
		}
		return list;
	}
	
	public Publicacion (int id_vineta, Date fecha, String medio) {
		Conexion con = new Conexion();
		List<Object[]> pub = con.Select("SELECT * FROM PUBLICACION WHERE ID_VINETA = '"+this.id_vineta+"' AND MEDIO = '"+medio+"'");
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
		this.fecha = (Date) tupla[1];
		this.medio = (String) tupla[2];
		this.id_vineta = (int) tupla[3];

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

	public Date getFecha() {
		return fecha;
	}

	public String getMedio() {
		return medio;
	}
	
	public String toString() {
		return medio+" "+fecha.toString();
	}

}
