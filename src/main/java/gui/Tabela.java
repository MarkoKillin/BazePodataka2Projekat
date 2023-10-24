package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Dstan;

public class Tabela extends AbstractTableModel {

	String[] kolone = {"Sprat", "Broj stana", "Zgrada"};
	List<Dstan> stanovi;	
	
	public Tabela(List<Dstan> stanovi) {
		super();
		this.stanovi = stanovi;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return stanovi.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Dstan s = stanovi.get(rowIndex);
		switch (columnIndex) {
			case 0: return s.getSprat();
			case 1: return s.getBrojstana();
			case 2: return s.getDzgrada();
		}
		return null;
	}

	public String nazsivKolone(int index) {
		return kolone[index];
	}
}
