package vista;



import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;
import javax.swing.border.TitledBorder;

import modelo.Categoria;
import modelo.Serie;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;

public class VistaBorrarSerie {

	private JFrame frmBorrarSerie;
	JLabel mensaje;
	JList<Serie> list;
	private DefaultListModel<Serie> listModel;
	JButton bBorrar;
	JRadioButton confirmar;
	public static final String BORRAR = "BS";
	

	public VistaBorrarSerie() {
		frmBorrarSerie = new JFrame();
		frmBorrarSerie.setTitle("Borrar Serie");
		//frmBorrarSerie.setBounds(100, 100, 450, 300);
		frmBorrarSerie.setSize(450, 300);
		frmBorrarSerie.setLocationRelativeTo(null); // ponemos la ventana en medio de la pantalla 
		frmBorrarSerie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBorrarSerie.getContentPane().setLayout(new BorderLayout(0, 0));
		frmBorrarSerie.setIconImage(getIconImage()); // asociamos el icono a la ventana
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 255)));
		frmBorrarSerie.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		list = new JList<Serie>();
		listModel = new DefaultListModel<>();
		list.setModel(listModel);
		
		list.setBorder(new TitledBorder(null, "Lista de Series:", TitledBorder.LEADING, TitledBorder.LEFT, null, new Color(0, 102, 204)));
		list.setToolTipText("");
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scroll = new JScrollPane(list);
		panel_2.add(scroll);
		
		mostrarSeries(); //ponemos las series en el list
		
		JPanel panel = new JPanel();
		frmBorrarSerie.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 255)));
		panel.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		mensaje = new JLabel("Mensaje de Informaci\u00F3n");
		panel_4.add(mensaje);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 255)));
		panel.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_5.add(panel_1, BorderLayout.WEST);
		
		confirmar = new JRadioButton("Confirmar Borrado");
		panel_1.add(confirmar);
		
		JPanel panel_3 = new JPanel();
		panel_5.add(panel_3, BorderLayout.CENTER);
		
		bBorrar = new JButton("Borrar");
		panel_3.add(bBorrar);
		
		frmBorrarSerie.setVisible(true);
	}
	
	public void controlador(ActionListener ctr) {
		bBorrar.addActionListener(ctr);
		bBorrar.setActionCommand(BORRAR);
	}
	
	public boolean isChecked() {
		return confirmar.isSelected();
	}
	
	public void alerta(String msg) {
		mensaje.setForeground(Color.RED);
		mensaje.setText(msg);
	}
	
	public Serie getSerieSeleccionada() {
		return list.getSelectedValue();
	}
	
	public void borrarSerie(Serie s) {
		listModel.removeElement(s);
	}
	
	public void mensaje(String msg) {
		mensaje.setForeground(Color.GREEN);
		mensaje.setText(msg);
	}
	
	public void mostrarSeries() {
		for(Serie s : Serie.listSerie()) {
			listModel.addElement(s);
		}
	}
	
	//------------------------------------------------------------------------------------//
	// para poner el icono																  //
	//------------------------------------------------------------------------------------//
	public Image getIconImage() {
		   Image retValue = Toolkit.getDefaultToolkit().
		         getImage(ClassLoader.getSystemResource("Fuentes/DC.png"));
		   return retValue;
	}
}
