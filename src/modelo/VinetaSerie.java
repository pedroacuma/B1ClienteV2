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
		Conexion con = new Conexion();
		con.Delete("DELTE FROM VINETASERIE WHERE IDVINETA="+ idVineta + " AND IDSERIE=" + idSerie);
		idVineta = -1;
		idSerie = -1;
		anotacionPrivada = null;
	}
}
