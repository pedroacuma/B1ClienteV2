package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaSeries;

public class ControladorVistaSeries implements ActionListener {

	VistaSeries vs;
		
	public ControladorVistaSeries (VistaSeries vs) {
		this.vs = vs;
		
	}
	
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
			
			
		}
	}
}
