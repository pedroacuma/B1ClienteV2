package modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Serie {
	
	private int id;
	private String nombre;
	private String autor;
	private Date fecha;
	private String descripcion;
	private String categoria;
	
	
	public static List<Serie> listSerie() {
		ArrayList<Serie> list = new ArrayList<>();
		Conexion con = new Conexion();
		for(Object[] tupla : con.Select("SELECT id FROM serie")) {
			list.add(new Serie((Integer) tupla[0]));
		}
		return list;
	}
	
	public Serie(int id) {
		Conexion con = new Conexion();
		Object[] res = con.Select("SELECT * FROM serie WHERE id=" +  id).get(0);
		
		this.id = (Integer) res[0];
		this.nombre = (String) res[1];
		this.autor = (String) res[2];
		this.fecha = (Date) res[3];
		this.descripcion = (String) res[4];
		this.categoria = (String) res[5];

	}
	
	public Serie(String nombre,String autor,String descripcion, String categoria) {
		Conexion con = new Conexion();
		java.util.Date fechaUtil = new java.util.Date();
		Date fecha = new Date(fechaUtil.getTime());
		
		con.Insert("INSERT INTO serie (nombre,autor,fecha,descripcion,categoria) VALUES('" + nombre + "','" + autor + "','"+ fecha + "','"+ descripcion + "','" + categoria + "')");
		
		this.id = (Integer) con.SelectEscalar("SELECT id FROM serie WHERE nombre ='" + nombre + "'");
		this.nombre = nombre;
		this.autor = autor;
		this.fecha = fecha;
		this.categoria = categoria;
		this.descripcion = descripcion;
	}
	
	public void borrarSerie() {
		Conexion con = new Conexion();
		System.out.println(this.id);
		con.Delete("DELETE FROM serie WHERE nombre ='" + nombre + "'");
		id = -1;
		nombre = null;
		autor = null;
		fecha = null;
		descripcion = null;
		categoria = null;
		
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getAutor() {
		return autor;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getCategoria() {
		return categoria;
	}
	
	public String toString() {
		return nombre;
	}
	
	public String getInfo() {
		return "Nombre: " + this.nombre + "\n"
				+ "Autor: " + this.autor + "\n"
				+ "Fecha de creación: " + this.fecha + "\n"
				+ "Categoria: " + this.categoria + "\n"
				+ "Descripcion: " + this.descripcion;
	}
}
