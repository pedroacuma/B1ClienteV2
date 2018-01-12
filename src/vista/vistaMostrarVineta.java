package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class vistaMostrarVineta {
	private JFrame frmMostrarVineta;
	private Panel panel_Medio, panel_Inferior;
	private JLabel etiqueta_Foto, nombre_Vin;
	private final int TAM_INFO = 4;
	
	public vistaMostrarVineta(ImageIcon imagen, String vineta) {
		frmMostrarVineta = new JFrame("Viñeta_"+ vineta.substring(6, vineta.length() - 4));
		frmMostrarVineta.setIconImage(VistaPrincipal.getIconImage());
		frmMostrarVineta.setSize(800,800);
		frmMostrarVineta.setLocationRelativeTo(null);
		frmMostrarVineta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		nombre_Vin = new JLabel(vineta.substring(6, vineta.length() - 4));
		
		frmMostrarVineta.getContentPane().add(nombre_Vin, BorderLayout.NORTH);
		
		panel_Medio = new Panel();
		frmMostrarVineta.getContentPane().add(panel_Medio, BorderLayout.CENTER);
		etiqueta_Foto = new JLabel(imagen);
		panel_Medio.add(etiqueta_Foto);
		
		panel_Inferior = new Panel();
		frmMostrarVineta.getContentPane().add(panel_Inferior, BorderLayout.SOUTH);
		panel_Inferior.setLayout(new BorderLayout(0, 0));
		rellenarPanelInferior(panel_Inferior, vineta); // le pasamos la ruta por parametro
		
		
		
		frmMostrarVineta.setVisible(true);		
	}
	public void rellenarPanelInferior(Panel panel, String vineta) {
		/* Uso de variables locales*/
		Panel paux = new Panel(new GridLayout(TAM_INFO, 1));
		JLabel informacion = new JLabel ("Información");
		JLabel[] info = new JLabel [TAM_INFO];
		String[] info_String = new String[TAM_INFO];
		
		info_String[0] = new String("Nombre: " + (vineta.substring(6, vineta.length() - 4)));
		info_String[1] = new String("Serie relacionada: ");
		info_String[2] = new String("Fecha de creacion: ");
		info_String[3] = new String("Ruta de contenido: " + vineta);
		
		for(int i = 0; i < TAM_INFO; i++) {
			info[i] = new JLabel(info_String[i]);
			paux.add(info[i]);
		}
				
		panel.add(informacion, BorderLayout.NORTH);
		panel.add(paux, BorderLayout.CENTER);
	}

}
