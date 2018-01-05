package vista;

import java.awt.BorderLayout;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;
import modelo.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JLabel;

import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class VistaPublicaciones extends JPanel {
	
	private JTable tablaPendientes;
	private JTable tablaHistorial;
	private static DefaultTableModel defaultModelPendientes;
	private static DefaultTableModel defaultModelHistorial;
	private static List<Publicacion> pubs;
	
	
	public VistaPublicaciones() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelTablas = new JPanel();
		add(panelTablas);
		panelTablas.setLayout(new GridLayout(0, 1, 10, 0));
		
		JPanel panelPendientes = new JPanel();
		panelTablas.add(panelPendientes);
		panelPendientes.setLayout(new BorderLayout(0, 0));
		
		JLabel labelPendientes = new JLabel("Publicaciones Pendientes");
		labelPendientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelPendientes.add(labelPendientes, BorderLayout.NORTH);
		
		
		
		//Creacion de los modelos para tablas
		defaultModelPendientes = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Medio", "Vi\u00F1eta", "Serie", "Fecha"
				}
			) {
				
				private static final long serialVersionUID = 1L;
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				public boolean isCellEditable(int filas, int columnas){
					return false;
				}
			};
			
		defaultModelHistorial = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Medio", "Vi\u00F1eta", "Serie", "Fecha"
				}
			) {
				
				private static final long serialVersionUID = 1L;
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				public boolean isCellEditable(int filas, int columnas){
					return false;
				}
			};
			
		//Fin creacion modelos	
			
		tablaPendientes = new JTable();
		tablaPendientes.setFont(new Font("Arial Black", Font.PLAIN, 12));
		tablaPendientes.setModel(defaultModelPendientes);
		
		tablaPendientes.getColumnModel().getColumn(0).setPreferredWidth(185);
		tablaPendientes.getColumnModel().getColumn(1).setPreferredWidth(219);
		tablaPendientes.getColumnModel().getColumn(2).setPreferredWidth(211);
		tablaPendientes.getColumnModel().getColumn(3).setPreferredWidth(175);
		
		JScrollPane scrollPanePendientes = new JScrollPane(tablaPendientes);
		panelPendientes.add(scrollPanePendientes, BorderLayout.CENTER);
		
		JPanel panelHistorial = new JPanel();
		panelTablas.add(panelHistorial);
		panelHistorial.setLayout(new BorderLayout(0, 0));
		
		tablaHistorial = new JTable();
		tablaHistorial.setFont(new Font("Arial Black", Font.PLAIN, 12));
		tablaHistorial.setModel(defaultModelHistorial);
		
		JScrollPane scrollPaneHistorial = new JScrollPane(tablaHistorial);
		panelHistorial.add(scrollPaneHistorial);
		

		JLabel lblNewLabel = new JLabel("Historial Publicaciones");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelHistorial.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panelAlarmas = new JPanel();
		add(panelAlarmas);
		
		JLabel tituloAlarmas = new JLabel("Alarmas");
		tituloAlarmas.setIcon(new ImageIcon("C:\\Users\\Pedro\\Documents\\GitHub\\Grupo8\\src\\Fuentes\\iconoAlarma.png"));
		tituloAlarmas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		tituloAlarmas.setForeground(Color.RED);
		tituloAlarmas.setHorizontalAlignment(SwingConstants.CENTER);
		panelAlarmas.add(tituloAlarmas);
		
		//Carga de datos en las tablas
		cargarDatosTablas();
	}
	
	public static void cargarDatosTablas(){
		 pubs = Publicacion.listPublicacion(); //LAS OBTENEMOS EN ORDEN DESCENDENTE
		 Date hoy = new Date();
		 for(Publicacion p : pubs) {
			
			 String nomVineta = p.getNombreVineta();
			 String medio = p.getMedio();
			 String date = p.getFecha().toString();
			 String serie = p.getSeries();
			 if(p.getFecha().after(hoy)) {
				 defaultModelPendientes.addRow(new Object[] {medio,nomVineta,serie,date});
			 }else {
				 defaultModelHistorial.addRow(new Object[] {medio,nomVineta,serie,date});
			 }
			 
		 }

	}
	
	public static void actualizarTablas(Publicacion p){
		 String nomVineta = p.getNombreVineta();
		 String medio = p.getMedio();
		 String fecha = p.getFecha().toString();
		 String serie = p.getSeries();
		 Date hoy = new Date();
		 if(p.getFecha().after(hoy)) {
			 defaultModelPendientes.addRow(new Object[] {medio,nomVineta,serie,fecha});
		 }else {
			 defaultModelHistorial.addRow(new Object[] {medio,nomVineta,serie,fecha});
		 }
	}
	
}
