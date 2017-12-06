package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Categoria;
import modelo.Conexion;
import vista.VistaCrearCategoria;
import vista.VistaSeries;

public class ControladorCrearCategoria implements ActionListener {
	
	VistaCrearCategoria vcc;
	VistaSeries vs;
	
	public ControladorCrearCategoria(VistaCrearCategoria vcc,VistaSeries vs) {
		this.vcc = vcc;
		this.vs = vs;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		String comando = evento.getActionCommand();
		switch (comando) {

			case VistaCrearCategoria.ACEPTAR: {
				String nomCat = vcc.getNombre();
				if(nomCat.equals("")) {
					vcc.alerta("Debes introducir un nombre");
				}else {
					checkAndCreate(nomCat);
				}
			
				break;
			}
		}
		
	}
	
	private void checkAndCreate(String nomCat) {
		Conexion con = new Conexion();
		String selCat = "SELECT * FROM categoria WHERE NOMBRE ='" + nomCat + "'"; 
		boolean ok = con.Select(selCat).isEmpty();
		if(ok) {
			Categoria c = new Categoria(nomCat);
			vcc.mensaje("Categoria creada exitosamente");
			vs.anadirCategoria(c);
		}else {
			vcc.alerta("Categoria " + nomCat + " ya existe");
		}
	}
	

}
