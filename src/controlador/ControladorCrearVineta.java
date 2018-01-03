package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;

import modelo.*;

import vista.VistaCrearVineta;

public class ControladorCrearVineta implements ActionListener{
	
	private VistaCrearVineta vcv;
	private Vineta vineta;
	
	public ControladorCrearVineta(VistaCrearVineta vcv) {
		this.vcv = vcv;
		vineta = null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		switch(cmd) {
			case VistaCrearVineta.ANADIR : 
				try {
					String nombre = vcv.getNombreVineta();
					String anotacionPublica = vcv.getAnotacionPublica();
					vineta = new Vineta(nombre,anotacionPublica);
					crearVinetaSeries(vcv.getNombreVineta(),vcv.getSerie());
					vcv.mostrarMensaje("Viñeta creada para todas las series :)");
				} catch (Exception e1) {
					e1.printStackTrace();
					vcv.mostrarError("No se ha podido crear");
				}
			break;
			case VistaCrearVineta.ANADIRMEDIO :
				String nombre = vcv.getNombreMedio();
				Medio m = new Medio (nombre);
				vcv.AnadirUnMedio(m);
				vcv.mostrarMensaje("Medio creado con éxito");
			break;
			case VistaCrearVineta.ANADIRPUBLICACION :
				try {
					Date fecha = vcv.getFecha();
					String medio = vcv.getMedio().getNombre();
					int idv = vineta.getId();
					Publicacion p = new Publicacion(idv, fecha, medio);
					vcv.mostrarMensaje("Publicación añadida con éxito");
					
				} catch (ParseException e1) {
					e1.printStackTrace();
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
