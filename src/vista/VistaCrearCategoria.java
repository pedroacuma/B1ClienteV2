package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaCrearCategoria extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public static final String ACEPTAR = "A";
	
	private JTextField introducirNombre;
	private JLabel labelNombre;
	public JLabel mensaje;
	private JButton botonAceptar;
	
	public VistaCrearCategoria() {
		introducirNombre = new JTextField (50);
		labelNombre = new JLabel ("Introduzca un nombre");
		mensaje = new JLabel (" ");
		botonAceptar = new JButton ("Aceptar");
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout (1, 2));
		panel.add(labelNombre);
		panel.add(introducirNombre);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout (2, 1));
		panel2.add(panel);
		panel2.add(botonAceptar);
		
		setLayout(new BorderLayout());
		add(panel2, BorderLayout.CENTER);
		add(mensaje, BorderLayout.SOUTH);
		
	}
	
	public String getNombre() {
		return introducirNombre.getText();
	}
	
	public void controlador(ActionListener ctr) {
		botonAceptar.addActionListener(ctr);
		botonAceptar.setActionCommand(ACEPTAR);
	}
	
	public void mensaje(String msg) {
		mensaje.setForeground(Color.GREEN);
		mensaje.setText(msg);
	}
	
	public void alerta(String msg) {
		mensaje.setForeground(Color.RED);
		mensaje.setText(msg);
	}

}
