package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VistaCrearSerie;
import vista.VistaSeries;
import modelo.Conexion;
import modelo.Serie;

public class ControladorCrearSerie implements ActionListener{
	
	private VistaSeries vs;
	private VistaCrearSerie vcs;
	
	public ControladorCrearSerie(VistaCrearSerie vcs, VistaSeries vs) {
		this.vs = vs;
		this.vcs = vcs;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch(cmd) {
			case VistaCrearSerie.ACEPTAR : {
				String nombre = vcs.getNombreSerie();
				String autor = vcs.getAutor();
				String descripcion = vcs.getDescripcion();
				String categoria = vcs.getCategoria();
				crearSerie(nombre,autor,descripcion,categoria);
			}
			break;
			
			case VistaCrearSerie.CANCELAR : {
				vcs.cerrar();
				System.out.println("Cerrado");
			}
			
			break;
		}
		
	}
	
	private void crearSerie(String nombre, String autor, String descripcion,String categoria) {
		if(nombre.equals("") || autor.equals("") || descripcion.equals("") || categoria.equals("") ){
			vcs.alerta("Rellene todos los campos");
		}
		else {
			Conexion con = new Conexion();
			boolean nombreOk = con.Select("SELECT * FROM serie WHERE nombre = '" + nombre + "'").isEmpty();
			boolean categoriaOk = !con.Select("SELECT * FROM categoria WHERE nombre = '" + categoria + "'").isEmpty();
			if(!nombreOk) {
				vcs.alerta("Ya exite una serie con ese nombre");
			}else if(!categoriaOk){
				vcs.alerta("No existe esa categoria, créela");
			}else {
				Serie s = new Serie(nombre,autor,descripcion,categoria);
				vs.anadirSerie(s);
				vcs.mensaje("Serie creada con exito");
			}
		}
	}
	
}
