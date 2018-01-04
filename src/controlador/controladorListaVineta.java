package controlador;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Vineta;
import vista.vistaMostrarVineta;

/* controlador para seleccionar las viñetas */
public class controladorListaVineta implements ListSelectionListener{
	
	private Vineta vineta;
	private ImageIcon imagen;
	
	public controladorListaVineta() {
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList lista = (JList) e.getSource();
		Vineta v = (Vineta) lista.getSelectedValue();
		if(!e.getValueIsAdjusting() && v!=null) {
			imagen = new ImageIcon(v.toString());
			new vistaMostrarVineta(imagen, v.toString());	
		}
	}
}
