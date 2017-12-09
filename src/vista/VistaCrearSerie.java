package vista;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import modelo.Categoria;


public class VistaCrearSerie extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5265666892857942303L;
	public static final String ACEPTAR = "ACEPTAR";
	public static final String CANCELAR = "CANCELAR";


	private JFrame frmCrearSerie;
	private Panel Panel_Inferior;
	
	private TextField textSerie, textAutor;
	// private TextField textCategoria;
	private JTextArea areaDescripcion;
	private JList<Categoria> listCat;
	private DefaultListModel<Categoria> listModel;
	private JScrollPane scrollCategoria;
	private JButton bAceptar, bCancelar;
	JLabel mensaje;

	public  VistaCrearSerie() {
		frmCrearSerie = new JFrame();
		frmCrearSerie.setFont(new Font("Dialog", Font.BOLD, 12));
		frmCrearSerie.setTitle("Crear Serie");
		frmCrearSerie.setIconImage(VistaPrincipal.getIconImage());
		//frmCrearSerie.setBounds(100, 100, 450, 300);
		frmCrearSerie.setSize(400,400);
		frmCrearSerie.setLocationRelativeTo(null);
		frmCrearSerie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Panel_Inferior = new Panel();
		frmCrearSerie.getContentPane().add(Panel_Inferior, BorderLayout.SOUTH);
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
		frmCrearSerie.getContentPane().add(panel_Label, BorderLayout.NORTH);
		panel_Label.setLayout(new BorderLayout(0, 0));
		
		Label labelSerie = new Label("Nombre Serie");
		labelSerie.setFont(new Font("Dialog", Font.BOLD, 12));
		labelSerie.setAlignment(Label.CENTER);
		panel_Label.add(labelSerie, BorderLayout.NORTH);
		
		textSerie = new TextField();
		panel_Label.add(textSerie, BorderLayout.SOUTH);
		
		Panel panel = new Panel();
		frmCrearSerie.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		Panel panel_1 = new Panel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Label labelCategoria = new Label("Nombre Categor\u00EDa");
		labelCategoria.setFont(new Font("Dialog", Font.BOLD, 12));
		labelCategoria.setAlignment(Label.CENTER);
		panel_1.add(labelCategoria, BorderLayout.NORTH);
		
		/*textCategoria = new TextField();
		panel_1.add(textCategoria, BorderLayout.SOUTH);*/
		listCat = new JList<Categoria>();
		listModel = new DefaultListModel<>();
		listCat.setModel(listModel);
		scrollCategoria = new JScrollPane(listCat);
		mostrarCategorias();
		panel_1.add(scrollCategoria, BorderLayout.SOUTH);
		
		Panel panel_2 = new Panel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		Panel panel_3 = new Panel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		Label label = new Label("Nombre Autor");
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		label.setAlignment(Label.CENTER);
		panel_3.add(label, BorderLayout.NORTH);
		
		textAutor = new TextField();
		panel_3.add(textAutor, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		areaDescripcion = new JTextArea();
		areaDescripcion.setBackground(new Color(255, 255, 255));
		areaDescripcion.setBorder(new TitledBorder("Descripción:"));
		JScrollPane scroll = new JScrollPane(areaDescripcion);
		
		panel_4.add(scroll);
		frmCrearSerie.setVisible(true);
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

	public String getCategoria() {
		return listCat.getSelectedValue().toString();
	}

	public String getAutor() {
		return textAutor.getText();
	}

	public String getDescripcion() {
		return areaDescripcion.getText();
	}

	public void mensaje(String msg) {
		mensaje.setText(msg);
	}
	
	public void alerta(String msg) {
		mensaje.setText(msg);
	}
	
	public void cerrar() {
		frmCrearSerie.dispose();
	}
	
	public void mostrarCategorias() {
		for(Categoria c : Categoria.listCategorias()) {
			listModel.addElement(c);
		}
	}
	
}
