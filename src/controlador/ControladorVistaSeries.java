package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.Vineta;
import vista.VistaSeries;
import vista.VistaPublicaciones;

public class ControladorVistaSeries implements ActionListener {

	VistaSeries vs;
	private VistaPublicaciones vp;
		
	public ControladorVistaSeries (VistaSeries vs) {
		this.vs = vs;
		
	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		String comando = evento.getActionCommand();
		switch (comando) {

			case VistaSeries.CC: {	
				CreadorVentanas.crearVentanaCC(vs);			
				break;
			}
			
			case VistaSeries.BC: {
				CreadorVentanas.crearVentanaBC(vs);
				break;
			}
			
			case VistaSeries.CS :{
				CreadorVentanas.crearVentanaCS(vs);
				break;
			}
			
			case VistaSeries.BS :{ //borramos una serie
				CreadorVentanas.crearVentanaBS(vs);
				break;
			}
			
			case VistaSeries.CV :{
				CreadorVentanas.crearVentanaCV(vs);
				break;
			}
			
			//Controla el boton borrarVineta
			case VistaSeries.BV :{
				Vineta vi = vs.getSelectedVineta();
				
				if(vi != null) {
					int dialogResult = JOptionPane.YES_NO_OPTION;
					dialogResult = JOptionPane.showConfirmDialog(null,"¿Desea borrar la viñeta " + vi.getNombre(), "Atención",JOptionPane.YES_NO_OPTION);
					
					if(dialogResult == JOptionPane.YES_OPTION) {
						vs.borrarVineta(vi);
						vi.borrar();
						vp.actualizarBorradoPendientes();
						
						JOptionPane.showMessageDialog(vs,"La viñeta ha sido borrada con éxito","Borrado Exitoso",JOptionPane.INFORMATION_MESSAGE);
					}
					
				}else {
					JOptionPane.showMessageDialog(vs,"Debe seleccionar una viñeta");
				}
			}
		}
	}
}
