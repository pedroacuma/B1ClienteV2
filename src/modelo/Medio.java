package modelo;

import java.util.ArrayList;
import java.util.List;

public class Medio {
	
	private String nombre;
	
	//Devuelve una lista con todos los medios existentes en la base de datos
	public static List<Medio> listMedios() {
		Conexion con = new Conexion();
		List<Medio> listM = new ArrayList<>();
		List<Object[]> l = con.Select("SELECT * FROM MEDIO");
		
		for(Object[] o : l) {
			String n = (String) o[0];
			Medio med = new Medio(n);
			listM.add(med);
		}
		
		return listM;
	}
	
	// Crea el objeto cargando sus valores de la base de datos, si no existe lo inserta
	public Medio(String nombre) {
		Conexion con = new Conexion();
		List<Object[]> med = con.Select("SELECT * FROM MEDIO WHERE NOMBRE ='" + nombre + "'");
		if(med.isEmpty()) {
			con.Insert("INSERT INTO MEDIO VALUES ('" + nombre + "')");
		}
		
		this.nombre = nombre;
		
	}
	
	// Actualiza el atributo en memoria y en la base de datos
    public void borrarCategoria() 
    {     	
    	Conexion con = new Conexion();
    	con.Delete("DELETE FROM  MEDIO WHERE NOMBRE ='"+ this.nombre + "'");    	
    	nombre = null;
    }
    
    public String getNombre() {
		return nombre;
	}
	
	public String toString() {
		return nombre;
	}

}
