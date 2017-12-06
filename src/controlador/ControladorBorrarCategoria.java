package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Categoria;
import modelo.Conexion;
import vista.VistaBorrarCategoria;
import vista.VistaSeries;

public class ControladorBorrarCategoria implements ActionListener {
	
	VistaBorrarCategoria vbc;
	VistaSeries vs;
	
	public ControladorBorrarCategoria(VistaBorrarCategoria vbc, VistaSeries vs) {
		this.vbc = vbc;
		this.vs = vs;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch(cmd) {
			case  VistaBorrarCategoria.BORRAR : {
					boolean checked = vbc.isChecked();
					if(checked) {
						Categoria c = vbc.getCategoriaSeleccionada();
						Conexion con = new Conexion();
						boolean ok = con.Select("SELECT * FROM serie WHERE categoria='" + c.toString() + "'").isEmpty();
						if (ok) {
							c.borrarCategoria();
							vs.actualizar();
							vbc.borrarCategoria(c);
							vbc.mensaje("Categoria Borrada");
						}else {
							vbc.alerta("Existe alguna serie asociada a esta categoria");
						}
						
					}
					else vbc.alerta("Por favor marque confirmar");
				break;
			}
		}
		
	}

}
