package modelo;

public class Vineta {
	private int id;
	private String nombre;
	private String anotacionPublica;
	private int id_publicacion;
	
	public Vineta(String nombre,String anotacion, int id_publicacion) {
		Conexion con = new Conexion();
		
		this.nombre = nombre;
		this.anotacionPublica = anotacion;
		this.id_publicacion = id_publicacion;
		con.Insert("INSERT INTO VINETA (nombre, anotacionPublica, ID_PUBLICACION) VALUES "
				+ "('" + nombre + "','"
				+ anotacion	+"', "+id_publicacion+")");
		
		this.id = (int) con.Select("SELECT MAX(ID) FROM VINETA").get(0)[0];
	}
	
	public Vineta(int id) {
		Conexion con = new Conexion();
		Object[] tupla = con.Select("SELECT * FROM VINETA WHERE ID=" + id).get(0);
		
		this.id = (int) tupla[0];
		this.nombre = (String) tupla[1];
		this.anotacionPublica = (String) tupla[2];
		this.id_publicacion = (int) tupla[3];
	}
	
	public void borrar() {
		Conexion con = new Conexion();
		//Parece que tal y como está nuestra BD no se produce borrado en cascada
		con.Delete("DELETE FROM VINETASERIE WHERE IDVINETA=" + id);
		con.Delete("DELETE FROM VINETA WHERE ID=" + id);
		Publicacion p = new Publicacion (id_publicacion);
		p.borrarPublicacion();
		id = -1;
		nombre = null;
		anotacionPublica = null;
		id_publicacion = -1;
	}

	public int getId() {
		return id;
	}
	
	public int getId_Publicacion() {
		return id_publicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getAnotacionPublica() {
		return anotacionPublica;
	}
	
	public String toString() {
		return nombre;
	}
}
