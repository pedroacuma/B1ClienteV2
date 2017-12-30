package modelo;

public class VinetaSerie {
	
	private int idVineta;
	private int idSerie;
	private String anotacionPrivada;
	
	public VinetaSerie(int idv,int ids,String nota) {
		idVineta = idv;
		idSerie = ids;
		anotacionPrivada = nota;
		
		Conexion con = new Conexion();
		con.Insert("INSERT INTO VINETASERIE (idvineta,idserie,anotacionprivada) VALUES (" + idv + "," + ids + ",'" + nota + "')");
	}
	
	public void borrar() {
		idVineta = -1;
		idSerie = -1;
		anotacionPrivada = null;
	}
}
