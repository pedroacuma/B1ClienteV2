package vista;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class VistaCrearViñeta extends JFrame {
	public static final String ACEPTAR = "ACEPTAR";
	public static final String CANCELAR = "CANCELAR";
	
	private JFrame frmCrearViñeta;
	private Panel Panel_Inferior;
	TextField textSerie;
	TextField textViñeta;
	TextField textRuta;

	
	JButton bAceptar;
	JButton bCancelar;
	
	JLabel mensaje;
	
	public  VistaCrearViñeta() {
		frmCrearViñeta = new JFrame();
		frmCrearViñeta.setIconImage(VistaPrincipal.getIconImage());
		frmCrearViñeta.setFont(new Font("Dialog", Font.BOLD, 12));
		frmCrearViñeta.setTitle("Crear Viñeta");
		//frmCrearSerie.setBounds(100, 100, 450, 300);
		frmCrearViñeta.setSize(400,250);
		frmCrearViñeta.setLocationRelativeTo(null);
		frmCrearViñeta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Panel_Inferior = new Panel();
		frmCrearViñeta.getContentPane().add(Panel_Inferior, BorderLayout.SOUTH);
		Panel_Inferior.setLayout(new BorderLayout(0, 0));
		
		mensaje = new JLabel("Mensaje de Informaci\u00F3n");
		Panel_Inferior.add(mensaje, BorderLayout.SOUTH);
		
		JPanel panel_5 = new JPanel();
		Panel_Inferior.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		bAceptar = new JButton("Aceptar");
		panel_5.add(bAceptar);
		
		bCancelar = new JButton("Cancelar");
		panel_5.add(bCancelar);
		
		Panel panel_Label = new Panel();
		frmCrearViñeta.getContentPane().add(panel_Label, BorderLayout.NORTH);
		panel_Label.setLayout(new BorderLayout(0, 0));
		
		Label labelSerie = new Label("Nombre Serie");
		labelSerie.setFont(new Font("Dialog", Font.BOLD, 12));
		labelSerie.setAlignment(Label.CENTER);
		panel_Label.add(labelSerie, BorderLayout.NORTH);
		
		textSerie = new TextField();
		panel_Label.add(textSerie, BorderLayout.SOUTH);
		
		Panel panel = new Panel();
		frmCrearViñeta.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		Panel panel_1 = new Panel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Label labelViñeta = new Label("Nombre Viñeta");
		labelViñeta.setFont(new Font("Dialog", Font.BOLD, 12));
		labelViñeta.setAlignment(Label.CENTER);
		panel_1.add(labelViñeta, BorderLayout.NORTH);
		
		textViñeta = new TextField();
		panel_1.add(textViñeta, BorderLayout.SOUTH);
		
		Panel panel_2 = new Panel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		Panel panel_3 = new Panel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		Label label = new Label("Directorio de la imagen");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setAlignment(Label.CENTER);
		panel_3.add(label, BorderLayout.NORTH);
		
		textRuta = new TextField();
		panel_3.add(textRuta, BorderLayout.SOUTH);


		
		frmCrearViñeta.setVisible(true);
	}
	public void controlador(ActionListener ctr) {
		bAceptar.addActionListener(ctr);
		bAceptar.setActionCommand(ACEPTAR);
		
		bCancelar.addActionListener(ctr);
		bCancelar.setActionCommand(CANCELAR);
	}
	public String getNombreSerie() {
		return textSerie.getText();
	}

	

	public String getViñeta() {
		return textViñeta.getText();
	}

	public String getUrl() {
		return textRuta.getText();
	}

	public void mensaje(String msg) {
		mensaje.setText(msg);
	}
	
	public void alerta(String msg) {
		mensaje.setText(msg);
	}
	
	public void cerrar() {
		frmCrearViñeta.dispose();
	}
	
	
}
