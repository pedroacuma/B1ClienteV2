package controlador;
import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;

import vista.VistaCrearCategoria;
import vista.VistaCrearSerie;
import vista.VistaCrearViñeta;
import vista.VistaSeries;
import modelo.Conexion;
import modelo.Serie;
import modelo.Viñeta;


public class ControladorCrearViñeta implements ActionListener {
	VistaCrearViñeta vcv;
	VistaSeries vs;
	public ControladorCrearViñeta(VistaCrearViñeta vcv, VistaSeries vs) {
		this.vs = vs;
		this.vcv = vcv;
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch(cmd) {
		
		
			case VistaCrearViñeta.ACEPTAR : {
				String serie = vcv.getNombreSerie();
				String viñeta = vcv.getViñeta();
				String url = vcv.getUrl();
				crearViñeta(serie,viñeta,url);
			}
			break;
			
			case VistaCrearViñeta.CANCELAR : {
				vcv.cerrar();
				System.out.println("Cerrado");
			}
			
			break;
		}
		
	}
	//este metodo hay que modificar, lo de arriba creo que está bien
	private void crearViñeta(String serie, String viñeta, String url){
		if(serie.equals("") || viñeta.equals("") || url.equals("")  ){
			vcv.alerta("Rellene todos los campos");
		} else {
			Conexion con = new Conexion();
			boolean idOk = con.Select("SELECT * FROM vineta WHERE id = " + viñeta + "").isEmpty();
			boolean serieOk = !con.Select("SELECT * FROM serie WHERE nombre = '" + serie + "'").isEmpty();
			if(!idOk) {
				vcv.alerta("Ya exite una viñeta con ese id");
			}else if(!serieOk){
				vcv.alerta("No existe esa serie, créela");
			}else {
				//aqui se crea la serie: todo
				Viñeta v = new Viñeta(viñeta , url, Integer.parseInt(viñeta));
				vs.anadirVineta(v);
				vcv.mensaje("Serie creada con exito");
		}
	}
	
	}
	}
