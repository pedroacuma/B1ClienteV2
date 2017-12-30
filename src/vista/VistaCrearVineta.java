package vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Panel;

public class VistaCrearVineta extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ANADIR = "ANADIR";
	public static final String CANCELAR = "CANCELAR";

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

	public VistaCrearVineta() {
		
		
		
		setLayout(new BorderLayout());
		
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
		
		add(panelSeries, BorderLayout.CENTER);
		
		//Montamos la parte del nombre de la viñeta
		panelNombre = new JPanel();
		
		JLabel labelNombre = new JLabel("Introduzca el nombre de la imagen(incluyendo extensión)");
		labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		campoNombre = new JTextField();
		panelNombre.setLayout(new BorderLayout(0, 0));
				
		panelNombre.add(labelNombre, BorderLayout.NORTH);
		panelNombre.add(campoNombre);
		
		add(panelNombre,BorderLayout.NORTH);
		
		//Montamos la parte de anotacion
		panelAnotacion = new JPanel();
		JLabel labelAnotacion = new JLabel("Introduzca, si desea, una anotación pública");
		labelAnotacion.setHorizontalAlignment(SwingConstants.CENTER);
		labelAnotacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		anotacionPublica = new JTextField();
		panelAnotacion.setLayout(new BorderLayout(0, 0));
		
		panelAnotacion.add(labelAnotacion, BorderLayout.NORTH);
		panelAnotacion.add(anotacionPublica);
		
		add(panelAnotacion,BorderLayout.SOUTH);
		
		
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
		
		
	}
	
	private void listarSeries(List<Serie> lista) {
		for(Serie s : lista) {
			modeloLista.addElement(s);
		}
	}
	
	public void controlador(ActionListener c) {
		btnAnadir.addActionListener(c);
		btnAnadir.setActionCommand(ANADIR);	
	}
	
	
	public List<Serie> getSerie(){
		return listSeries.getSelectedValuesList();
	}
	
	public String getNombreVineta() {
		return campoNombre.getText();
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
