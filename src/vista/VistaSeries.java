package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

import controlador.CtrListSeries;
import modelo.Categoria;
import modelo.Conexion;
import modelo.Serie;
import modelo.Viñeta;

public class VistaSeries extends JPanel implements IVistaSeries {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton crearCategoria;
	private JButton borrarCategoria;
	private JButton crearSerie;
	private JButton borrarSerie;
	private JButton crearViñeta;
	private JButton borrarViñeta;
	
	private JScrollPane scrollCategoria;
	private JScrollPane scrollSerie;
	private JScrollPane scrollViñeta;
	
	private JList<Categoria> listCategoria;
	private JList<Serie> listSerie;
	private JList<Viñeta> listViñeta;
	private JTextArea infoSerie;
	
	private JLabel labelCategoria;
	private JLabel labelSerie;
	private JLabel labelViñeta;
	private JLabel labelInformacion;
	
	private DefaultListModel <Categoria> modeloListaCats;
	private DefaultListModel <Serie> modeloListaSeries;
	private DefaultListModel <Viñeta> modeloListaViñetas;
	
	
	public VistaSeries() {
		
		labelCategoria = new JLabel ("Categorías");
		labelSerie = new JLabel ("Series");
		labelViñeta = new JLabel ("Viñetas");
		labelInformacion = new JLabel ("Información");
		
		crearCategoria = new JButton ("Crear Categoría");
		borrarCategoria = new JButton ("Borrar Categoría");
		crearSerie = new JButton ("Crear Serie");
		borrarSerie = new JButton ("Borrar Serie");
		crearViñeta = new JButton ("Crear Viñeta");
		borrarViñeta = new JButton ("Borrar Viñeta");
		
		//Montamos la lista de categorias
		listCategoria = new JList<Categoria>();
		modeloListaCats = new DefaultListModel<Categoria>();
		listCategoria.setModel(modeloListaCats);
		mostrarCategorias();
		
		//Montamos la lista de Series
		listSerie = new JList<Serie>();
		modeloListaSeries = new DefaultListModel<Serie>();
		listSerie.setModel(modeloListaSeries);
		mostrarSeries();
		
		//Se le añade el controlador para la seleccion de una serie
		CtrListSeries cls = new CtrListSeries(this);
		setControladorListaSeries(cls);
		
		
		//Montamos la lista de Viñetas
		listViñeta = new JList<Viñeta>();
		modeloListaViñetas = new DefaultListModel<Viñeta>();
		listViñeta.setModel(modeloListaViñetas);
		
		String[] viñeta = {"Aqui se mostrarían las viñetas de la serie seleccionada"};
		listViñeta = new JList(viñeta);
		
		infoSerie = new JTextArea("Información de la serie seleccionada");
		
		scrollCategoria = new JScrollPane(listCategoria);
		scrollSerie = new JScrollPane(listSerie);
		scrollViñeta = new JScrollPane(listViñeta);
			
		
		// Botonera
		JPanel botonera = new JPanel();
		botonera.setLayout(new GridLayout(2, 3));
		botonera.add(crearCategoria);
		botonera.add(crearSerie);
		botonera.add(crearViñeta);
		botonera.add(borrarCategoria);	
		botonera.add(borrarSerie);
		botonera.add(borrarViñeta);
		
		//Scrolls y sus labels
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.add(labelSerie, BorderLayout.NORTH);
		panel1.add(scrollSerie, BorderLayout.CENTER);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.add(labelViñeta, BorderLayout.NORTH);
		panel2.add(scrollViñeta, BorderLayout.CENTER);
		
		//Panel Central
		JPanel panelC = new JPanel();
		panelC.setLayout(new GridLayout(2, 1));
		panelC.add(panel1);
		panelC.add(panel2);
		
		//Panel Derecha
		JPanel panelI = new JPanel();
		panelI.setLayout(new BorderLayout());
		panelI.add(labelCategoria, BorderLayout.NORTH);
		panelI.add(scrollCategoria, BorderLayout.CENTER);
		
				
		//Panel Izquierda
		JPanel panelD = new JPanel();
		panelD.setLayout(new BorderLayout());
		panelD.add(labelInformacion, BorderLayout.NORTH);
		panelD.add(infoSerie, BorderLayout.CENTER);
		
		
		// Confeccion del panel de contenidos
		JPanel panelPrinci = new JPanel();
		panelPrinci.setLayout(new GridLayout (1, 3));
		panelPrinci.add(panelI);
		panelPrinci.add(panelC);
		panelPrinci.add(panelD);
		
		this.setLayout(new BorderLayout());
		this.add(botonera, BorderLayout.NORTH);
		this.add(panelPrinci, BorderLayout.CENTER);
		
	}

	
	@Override
	public void controlador(ActionListener ctr) {
		// TODO Auto-generated method stub
		crearCategoria.addActionListener(ctr);
		crearCategoria.setActionCommand(CC);
		
		borrarCategoria.addActionListener(ctr);
		borrarCategoria.setActionCommand(BC);
		
		crearSerie.addActionListener(ctr);
		crearSerie.setActionCommand(CS);
		
		borrarSerie.addActionListener(ctr);
		borrarSerie.setActionCommand(BS);
		
		crearViñeta.addActionListener(ctr);
		crearViñeta.setActionCommand(CV);
		
		borrarViñeta.addActionListener(ctr);
		borrarViñeta.setActionCommand(BV);
		 
	}

	//Carga categorias en panel categorias
	public void mostrarCategorias() {
		for(Categoria c : Categoria.listCategorias()) {
			this.modeloListaCats.addElement(c);
		}
	}
	
	public void anadirCategoria(Categoria c) {
		this.modeloListaCats.addElement(c);
	}
	
	public void actualizar() {
		modeloListaCats.removeAllElements();
		mostrarCategorias();
		modeloListaSeries.removeAllElements();
		mostrarSeries();
	}
	
	public void borrarCategoria(Categoria c) {
		modeloListaCats.removeElement(c);
	}
	
	public void mostrarSeries() {
		for(Serie s : Serie.listSerie()) {
			modeloListaSeries.addElement(s);
		}
	}
	
	public void anadirSerie(Serie s) {
		modeloListaSeries.addElement(s);
	}
	
	public void borrarSerie(Serie s) {
		modeloListaSeries.removeElement(s);
	}
	
	public void anadirVineta(Viñeta v){
		modeloListaViñetas.addElement(v);
	}
	
	//Métodos para mostrar info. Se establece el ListSelectionEvent y un método para mostrar la info en esta vista
	private void setControladorListaSeries(ListSelectionListener ctrLista)
	{
		listSerie.addListSelectionListener(ctrLista);
	}
	
	public void muestraInfoSerie(Serie s) {
		infoSerie.setText(s.getInfo());
	}
	

}
