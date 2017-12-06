package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VistaBorrarSerie;
import vista.VistaSeries;
import modelo.Serie;


public class ControladorBorrarSerie implements ActionListener{
	
	VistaBorrarSerie vbs;
	VistaSeries vs;
	
	public ControladorBorrarSerie(VistaBorrarSerie vbs, VistaSeries vs) {
		this.vbs = vbs;
		this.vs = vs;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cmd = arg0.getActionCommand(); // obtenemos donde hemos tenido el evento
		switch (cmd) {
			case VistaBorrarSerie.BORRAR :{
				boolean checked = vbs.isChecked();
				if(checked) { //se ha marcado el radiobutton
					Serie s = vbs.getSerieSeleccionada();
					s.borrarSerie();
					vs.actualizar();
					vbs.borrarSerie(s);
					
					vbs.mensaje("Serie Borrada");					
				}else {
					vbs.alerta("Por favor marque confirmar");
				}
			}
		}		
	}
}
