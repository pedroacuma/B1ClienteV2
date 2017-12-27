package controlador;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Serie;
import vista.VistaSeries;

public class CtrListSeries implements ListSelectionListener{

	private VistaSeries vs;
	
	public CtrListSeries(VistaSeries vs)
	{
		this.vs = vs;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
		if(!e.getValueIsAdjusting()) {
			JList<Serie> source = (JList<Serie>) e.getSource();
	        Serie selected = source.getSelectedValue();
			vs.muestraInfoSerie(selected);
		}
	}
}

