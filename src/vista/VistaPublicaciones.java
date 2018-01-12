package vista;

import java.awt.BorderLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablaPendientes;
	private JTable tablaHistorial;
	private JTable tablaAlarmas;
	private static DefaultTableModel defaultModelPendientes;
	private static DefaultTableModel defaultModelHistorial;
	private static DefaultTableModel defaultModelAlarmas;
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
			defaultModelAlarmas = new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Medio", "Vi\u00F1eta", "Serie", "Hora"
					}
				) {
					
					private static final long serialVersionUID = 1L;
					@SuppressWarnings("rawtypes")
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class
					};
					@SuppressWarnings({ "unchecked", "rawtypes" })
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
//----------------------------------------------------------------------------------------------
		//Paneles para el icono de la alarma y la tabla de publicaciones para hoy
		JPanel panelAlarmas = new JPanel();
		add(panelAlarmas);
		panelAlarmas.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelIcono = new JPanel();
		panelAlarmas.add(panelIcono);
		panelIcono.setLayout(new BorderLayout(0, 0));
		
		JLabel tituloAlarmas = new JLabel("Alarmas");
		tituloAlarmas.setIcon(new ImageIcon("src\\Fuentes\\iconoAlarma.png"));
		tituloAlarmas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		tituloAlarmas.setForeground(Color.RED);
		tituloAlarmas.setHorizontalAlignment(SwingConstants.CENTER);
		panelIcono.add(tituloAlarmas, BorderLayout.CENTER);
		
		JPanel panelTablaAlarmas = new JPanel();
		panelAlarmas.add(panelTablaAlarmas);
		panelTablaAlarmas.setLayout(new BorderLayout(0, 0));
		
		JLabel labelAlarmas = new JLabel("PUBLICACIONES PENDIENTES PARA HOY");
		labelAlarmas.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelAlarmas.setForeground(Color.RED);
		labelAlarmas.setHorizontalAlignment(SwingConstants.CENTER);
		panelTablaAlarmas.add(labelAlarmas, BorderLayout.NORTH);
		
		tablaAlarmas = new JTable();
		tablaAlarmas.setFont(new Font("Arial Black", Font.PLAIN, 12));
		tablaAlarmas.setModel(defaultModelAlarmas);
		
		tablaAlarmas.getColumnModel().getColumn(0).setPreferredWidth(185);
		tablaAlarmas.getColumnModel().getColumn(1).setPreferredWidth(219);
		tablaAlarmas.getColumnModel().getColumn(2).setPreferredWidth(211);
		tablaAlarmas.getColumnModel().getColumn(3).setPreferredWidth(175);
		
		JScrollPane scrollPanelAlarmas = new JScrollPane(tablaAlarmas);
		panelTablaAlarmas.add(scrollPanelAlarmas);
		
		//Carga de datos en las tablas
		cargarDatosTablas();
		cargarAlarmas();
	}
	//Jairo
	public static void cargarDatosTablas(){
		 pubs = Publicacion.listPublicacion(); //LAS OBTENEMOS EN ORDEN DESCENDENTE
		 
		 Date hoy = new Date();
		 
		 for(Publicacion p : pubs) {
			 //long aux = p.getFecha().getTime();
			 //Date fechaP = new Date(aux);
			 String nomVineta = p.getNombreVineta();
			 String medio = p.getMedio();
			 String date = p.getFecha().toString();
			 String serie = p.getSeries();
			 
			 //if(fechaP.compareTo(hoy)>=0) {	
			 if(p.getFecha().after(hoy)){
				 defaultModelPendientes.addRow(new Object[] {medio,nomVineta,serie,date});
			 }else {
				 defaultModelHistorial.addRow(new Object[] {medio,nomVineta,serie,date});
			 }
			 
		 }

	}
	//carga de la tabla alarmas al iniciar la app
	public static void cargarAlarmas(){
		int numFilas = defaultModelPendientes.getRowCount();
		String medio, vineta,serie,hora;
		String fechaPendiente;
		
		for (int i = 0 ; i< numFilas; i++){
			fechaPendiente = (String) defaultModelPendientes.getValueAt(i, 3);
			if(compararFechas(fechaPendiente)){
				medio = (String) defaultModelPendientes.getValueAt(i,0);
				vineta = (String) defaultModelPendientes.getValueAt(i,1);
				serie = (String) defaultModelPendientes.getValueAt(i,2);
				hora = fechaPendiente.substring(11, 19);
				
				String[] valores = {medio,vineta,serie,hora};
				defaultModelAlarmas.addRow(valores);
			}
		}
	}
	public static boolean compararFechas(String fechaP){
		
		boolean aux = false;
		// fecha actual de java
		
		Calendar fecha = Calendar.getInstance();
		
        //para que el mes tenga dos digitos como el de la base de datos
		Date fechaActual = new Date();
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String mes = formatoFecha.format(fechaActual);
        mes = mes.substring(3, 5);
        String dia = formatoFecha.format(fechaActual);
        dia = dia.substring(0, 2);
        String año = String.valueOf(fecha.get(Calendar.YEAR));
     
        //Fecha de la base de datos
		String diaPendiente = fechaP.substring(8, 10);
		String mesPendiente = fechaP.substring(5, 7);
		String añoPendiente = fechaP.substring(0, 4);
		System.out.println("Fecha Java  : " + dia + " " + mes + " " + año);
		System.out.println("Fecha derby : " + diaPendiente + " " + mesPendiente + " " + añoPendiente);
		if( (dia.equals(diaPendiente)) && (mes.equals(mesPendiente)) && (año.equals(añoPendiente)) ){
			aux=true;
		}
		
		return aux;
	}
	// actualiza la tabla alarmas al introucir una publicacion
	public static void actualizarAlarmas(Publicacion p){
		if(compararFechas(p.getFecha().toString())){
			String nomVineta = p.getNombreVineta();
			String medio = p.getMedio();
			String fecha = p.getFecha().toString();
			String hora = fecha.substring(11, 19);
			String serie = p.getSeries();
			defaultModelAlarmas.addRow(new Object[] {medio,nomVineta,serie,hora});
		}
	}
	//Jairo
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
	//Al borrar una viñeta actualizo publicaciones y alarmas
	public static void actualizarBorradoPendientes() {
		
		for (int i = defaultModelPendientes.getRowCount()-1; i>=0 ;i-- ) {
			System.out.println(i);
			defaultModelPendientes.removeRow(i);
		}
		pubs = Publicacion.listPublicacion(); // LAS OBTENEMOS EN ORDEN
												// DESCENDENTE
		Date hoy = new Date();
		for (Publicacion p : pubs) {

			String nomVineta = p.getNombreVineta();
			String medio = p.getMedio();
			String date = p.getFecha().toString();
			String serie = p.getSeries();

			if (p.getFecha().after(hoy)) {
				defaultModelPendientes.addRow(new Object[] { medio, nomVineta,
						serie, date });
			}
		}
		actualizarBorradoAlarmas();
	}
	//Actualiza la tabla de alarmas cuando se elimina una vuñeta
	public static void actualizarBorradoAlarmas(){
	
		for(int i=defaultModelAlarmas.getRowCount()-1 ; i>=0 ; i--){
			defaultModelAlarmas.removeRow(i);
		}
		int numFilas = defaultModelPendientes.getRowCount();
		String medio, vineta,serie,hora;
		String fechaPendiente;
		
		for (int i = 0 ; i< numFilas; i++){
			fechaPendiente = (String) defaultModelPendientes.getValueAt(i, 3);
			if(compararFechas(fechaPendiente)){
				medio = (String) defaultModelPendientes.getValueAt(i,0);
				vineta = (String) defaultModelPendientes.getValueAt(i,1);
				serie = (String) defaultModelPendientes.getValueAt(i,2);
				hora = fechaPendiente.substring(11, 19);
				
				String[] valores = {medio,vineta,serie,hora};
				defaultModelAlarmas.addRow(valores);
			}
		}
	}
}
