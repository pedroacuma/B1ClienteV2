package vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Medio;
import modelo.Serie;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Panel;
import javax.swing.JScrollBar;

public class VistaCrearVineta extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ANADIR = "ANADIR";
	public static final String CANCELAR = "CANCELAR";
	public static final String ANADIRPUBLICACION = "ANADIRPUBLICACION";
	public static final String ANADIRMEDIO = "ANADIRMEDIO";
	
	private JPanel panelSeries;
	private JPanel panelNombre;
	private JPanel panelAnotacion;
	private JPanel panelBotones;

	
	private JList<Serie> listSeries;
	private JScrollPane scrollSeries;

	
	private JTextField campoNombre;
	private JTextField anotacionPublica;
	
	private DefaultListModel<Serie> modeloLista;
	private JButton btnAnadir;
	private Panel panelinferior;
	private JLabel info;
	
	private JPanel panelVineta;
	
	/*Publicaciones*/
	
	private JPanel panelPublicaciones;
	
	//Medio
	private JPanel panelMedio;
	private JLabel labelMedio;
	private JScrollPane scrollMedio;
	private JList listMedio;
	private DefaultListModel<Medio> modeloMedio;
	
	//Anadir Medio
	private JPanel panelAnadirMedio;
	private JLabel labelAnadirMedio;
	private JTextField textoAnadirMedio;
	private JButton botonAnadirMedio;
	
	//Anadir Fecha
	private JPanel panelFecha;
	private JLabel labelFecha;
	private JTextField textoFecha;
	private JButton botonFecha;
	
	
	
	

	public VistaCrearVineta() {

		setLayout(new GridLayout(1, 2));
		
		//Montamos la parte de seleccion de serie/s
		panelSeries = new JPanel();
		panelSeries.setLayout(new BorderLayout());
		
		JLabel labelSeries = new JLabel("Seleccione la serie o series asociadas");
		labelSeries.setHorizontalAlignment(SwingConstants.CENTER);
		labelSeries.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		listSeries = new JList<>();
		listSeries.setFont(new Font("Arial", Font.BOLD, 14));
		listSeries.setBorder(new MatteBorder(4, 4, 4, 4, (Color) Color.BLUE));
		modeloLista = new DefaultListModel<>();
		listSeries.setModel(modeloLista);
		listarSeries(Serie.listSerie());
		scrollSeries = new JScrollPane(listSeries);
		
				
		panelSeries.add(labelSeries,BorderLayout.NORTH);
		panelSeries.add(scrollSeries,BorderLayout.CENTER);
		
		
		
		//Montamos la parte del nombre de la viñeta
		panelNombre = new JPanel();
		
		JLabel labelNombre = new JLabel("Introduzca el nombre de la imagen(incluyendo extensión)");
		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		campoNombre = new JTextField();
		panelNombre.setLayout(new BorderLayout(0, 0));
				
		panelNombre.add(labelNombre, BorderLayout.NORTH);
		panelNombre.add(campoNombre);
		
		
		
		//Montamos la parte de anotacion
		panelAnotacion = new JPanel();
		JLabel labelAnotacion = new JLabel("Introduzca, si desea, una anotación pública");
		labelAnotacion.setHorizontalAlignment(SwingConstants.CENTER);
		labelAnotacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		anotacionPublica = new JTextField();
		panelAnotacion.setLayout(new BorderLayout(0, 0));
		
		panelAnotacion.add(labelAnotacion, BorderLayout.NORTH);
		panelAnotacion.add(anotacionPublica);
		
		
		
		
		//En el panel inferior tenemos la botonera e información
		panelinferior = new Panel();
		panelAnotacion.add(panelinferior, BorderLayout.SOUTH);
		panelinferior.setLayout(new BorderLayout(0, 0));
		
		panelBotones = new JPanel();
		panelinferior.add(panelBotones, BorderLayout.NORTH);
		panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAnadir = new JButton("Añadir");
		panelBotones.add(btnAnadir);
		
		info = new JLabel("Mensaje de Informaci\u00F3n");
		panelinferior.add(info, BorderLayout.SOUTH);
		
		panelVineta = new JPanel();
		panelVineta.setLayout(new BorderLayout());
		panelVineta.add(panelSeries, BorderLayout.CENTER);
		panelVineta.add(panelNombre,BorderLayout.NORTH);
		panelVineta.add(panelAnotacion,BorderLayout.SOUTH);
		
		add(panelVineta);
		
		
		/*PANEL PUBLICACIONES*/
		
		panelPublicaciones = new JPanel();
		panelPublicaciones.setLayout(new BorderLayout());
		add(panelPublicaciones);
		
		//Medio
		panelMedio = new JPanel();
		panelMedio.setLayout(new BorderLayout());
		
		labelMedio = new JLabel("Seleccione el medio de publicación");
		labelMedio.setHorizontalAlignment(SwingConstants.CENTER);
		labelMedio.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		listMedio = new JList<>();
		listMedio.setFont(new Font("Arial", Font.BOLD, 14));
		listMedio.setBorder(new MatteBorder(4, 4, 4, 4, (Color) Color.BLUE));
		modeloMedio = new DefaultListModel<>();
		listMedio.setModel(modeloMedio);
		listarMedios(Medio.listMedios());
		scrollMedio = new JScrollPane(listMedio);
		
		panelMedio.add(labelMedio, BorderLayout.NORTH);
		panelMedio.add(scrollMedio, BorderLayout.CENTER);
		
		panelPublicaciones.add(panelMedio, BorderLayout.CENTER);
		
		//Anadir Medio
		panelAnadirMedio = new JPanel();
		panelAnadirMedio.setLayout(new BorderLayout());
		
		labelAnadirMedio = new JLabel("Añadir medio de publicación");
		labelAnadirMedio.setHorizontalAlignment(SwingConstants.CENTER);
		labelAnadirMedio.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textoAnadirMedio = new JTextField ("");
		botonAnadirMedio = new JButton ("Añadir");
		
		panelAnadirMedio.add(labelAnadirMedio, BorderLayout.NORTH);
		panelAnadirMedio.add(textoAnadirMedio, BorderLayout.CENTER);
		panelAnadirMedio.add(botonAnadirMedio, BorderLayout.EAST);
		
		panelPublicaciones.add(panelAnadirMedio, BorderLayout.NORTH);
		
		//Anadir Publicacion
		panelFecha = new JPanel();
		panelFecha.setLayout(new BorderLayout());
				
		labelFecha = new JLabel("Introducir fecha de la publicación (YYYY-MM-DD HH:MM:SS)");
		labelFecha.setHorizontalAlignment(SwingConstants.CENTER);
		labelFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textoFecha = new JTextField ("");
		botonFecha = new JButton ("Aceptar");
				
		panelFecha.add(labelFecha, BorderLayout.NORTH);
		panelFecha.add(textoFecha, BorderLayout.CENTER);
		panelFecha.add(botonFecha, BorderLayout.SOUTH);
		
		panelPublicaciones.add(panelFecha, BorderLayout.SOUTH);
		
		
		
	}
	
	private void listarSeries(List<Serie> lista) {
		for(Serie s : lista) {
			modeloLista.addElement(s);
		}
	}
	
	private void listarMedios(List<Medio> lista) {
		for(Medio m : lista) {
			modeloMedio.addElement(m);
		}
	}
	
	public void controlador(ActionListener c) {
		btnAnadir.addActionListener(c);
		btnAnadir.setActionCommand(ANADIR);	
		
		botonAnadirMedio.addActionListener(c);
		botonAnadirMedio.setActionCommand(ANADIRMEDIO);
		
		botonFecha.addActionListener(c);
		botonFecha.setActionCommand(ANADIRPUBLICACION);
	}
	
	
	public List<Serie> getSerie(){
		return listSeries.getSelectedValuesList();
	}
	
	public Medio getMedio() {
		return (Medio) listMedio.getSelectedValue();
	}
	
	public void AnadirUnMedio (Medio m) {
		this.modeloMedio.addElement(m);
	}
	
	public String getNombreVineta() {
		return campoNombre.getText();
	}
	
	public Timestamp getFecha() throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat ("YYYY-MM-DD HH:MM:SS");
	    java.util.Date parsedDate = format.parse(textoFecha.getText());
	    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
	    return timestamp;
	}
	
	public String getNombreMedio() {
		return textoAnadirMedio.getText();
	}
	
	public String getAnotacionPublica() {
		return anotacionPublica.getText();
	}
	
	public void mostrarMensaje(String msg) {
		info.setText(msg);
		info.setForeground(Color.green);
	}
	
	public void mostrarError(String msg) {
		info.setText(msg);
		info.setForeground(Color.RED);
	}
	
}
