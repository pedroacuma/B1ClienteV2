package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import modelo.*;

import vista.VistaCrearVineta;

public class ControladorCrearVineta implements ActionListener{
	
	private VistaCrearVineta vcv;
	private Vineta vineta;
	
	public ControladorCrearVineta(VistaCrearVineta vcv) {
		this.vcv = vcv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		switch(cmd) {
			case VistaCrearVineta.ANADIR : 
			try {
				String nombre = vcv.getNombreVineta();
				String anotacionPublica = vcv.getAnotacionPublica();
				//vineta = new Vineta(nombre,anotacionPublica);
				crearVinetaSeries(vcv.getNombreVineta(),vcv.getSerie());
				vcv.mostrarMensaje("Viñeta creada para todas las series :)");
			} catch (Exception e1) {
				e1.printStackTrace();
				vcv.mostrarError("No se ha podido crear");
			}
			break;
		}
	}
	
	
	private void crearVinetaSeries(String nombre,List<Serie> list) {
		int idv = vineta.getId();
		
		for(Serie s : list) {
			new VinetaSerie(idv,s.getId(), "");
		}
	}

}
