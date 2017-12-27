package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import modelo.Categoria;

public class VistaBorrarCategoria extends JPanel{
	
	private static final long serialVersionUID = -8656262064906169081L;
	public static final String BORRAR = "B";

	private JLabel labelSeleccione;
	private JLabel mensaje;
	
	private JButton botonBorrar;
	private JRadioButton checkBorrar;
	
	private JList<Categoria> listCat;
	private DefaultListModel<Categoria> listModel;
	private JScrollPane scrollCategoria;
	
	
	public VistaBorrarCategoria() {
		
		this.setLayout(new BorderLayout());
		
		JPanel main = new JPanel();
		main.setLayout(new GridLayout(2,2));
		
		botonBorrar = new JButton("Borrar");
		checkBorrar = new JRadioButton("Confirmar",false);
		labelSeleccione = new JLabel("Seleccione categoría: ");
		mensaje = new JLabel();
		
		listCat = new JList<Categoria>();
		listModel = new DefaultListModel<>();
		listCat.setModel(listModel);
		scrollCategoria = new JScrollPane(listCat);
		mostrarCategorias();
		
		main.add(labelSeleccione);
		main.add(scrollCategoria);
		main.add(checkBorrar);
		main.add(botonBorrar);
		
		JPanel pMsg = new JPanel();
		pMsg.add(mensaje, FlowLayout.LEFT);
		
		this.add(main,BorderLayout.CENTER);
		this.add(pMsg,BorderLayout.SOUTH);
		
		
	}
	
	public void controlador(ActionListener ctr) {
		botonBorrar.addActionListener(ctr);
		botonBorrar.setActionCommand(BORRAR);
		
	}
	
	public boolean isChecked() {
		return checkBorrar.isSelected();
	}
	
	public void mostrarCategorias() {
		for(Categoria c : Categoria.listCategorias()) {
			listModel.addElement(c);
		}
	}
	
	public Categoria getCategoriaSeleccionada() {
		return listCat.getSelectedValue();
	}
	
	public void borrarCategoria(Categoria c) {
		listModel.removeElement(c);
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
