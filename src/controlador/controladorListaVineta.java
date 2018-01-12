package controlador;

import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputListener;

import modelo.Vineta;
import vista.vistaMostrarVineta;

/* controlador para seleccionar las viñetas */
public class controladorListaVineta implements MouseInputListener{
	
	private Vineta vineta;
	private ImageIcon imagen;
	
	public controladorListaVineta() {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JList lista = (JList) e.getSource();
		Vineta v = (Vineta) lista.getSelectedValue();
		if(e.getClickCount() == 2) {
			imagen = new ImageIcon(v.toString());
			new vistaMostrarVineta(imagen, v.toString());	
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
