package modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	String nombre;
	
	///Devuelve una lista con todas las categorias existentes en la base de datos
	public static List<Categoria> listCategorias() {
		Conexion con = new Conexion();
		List<Categoria> listCat = new ArrayList<>();
		List<Object[]> categorias = con.Select("SELECT * FROM categoria");
		
		for(Object[] o : categorias) {
			String nomCat = (String) o[0];
			Categoria c = new Categoria(nomCat);
			listCat.add(c);
		}
		
		return listCat;
	}
	
	// Crea el objeto cargando sus valores de la base de datos, si no existe lo inserta
	public Categoria(String nombre) {
		Conexion con = new Conexion();
		List<Object[]> cats = con.Select("SELECT * FROM categoria WHERE NOMBRE ='" + nombre + "'");
		if(cats.isEmpty()) {
			con.Insert("INSERT INTO categoria VALUES ('" + nombre + "')");
		}
		
		this.nombre = nombre;
		
	}
	
	// Actualiza el atributo en memoria y en la base de datos
    public void borrarCategoria() 
    {     	
    	Conexion con = new Conexion();
    	con.Delete("DELETE FROM  categoria WHERE NOMBRE ='"+ this.nombre + "'");    	
    	nombre = null;
    }
	
	public String toString() {
		return nombre;
	}
	
	
}
