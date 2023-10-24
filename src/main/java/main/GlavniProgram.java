package main;

import crud.VlasnikCrud;
import model.Dvlasnik;

public class GlavniProgram {

	public static void main(String[] args) {
		VlasnikCrud vc = new VlasnikCrud();
		Dvlasnik v = new Dvlasnik();
		v.setBrtel("0611101341");
		v.setIme("Marina");
		v.setPrezime("Marinkovic");
		vc.insertVlasnik(v);
	}
	
}
