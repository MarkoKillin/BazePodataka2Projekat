package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the DVLASNIK database table.
 * 
 */
@Entity
@NamedQuery(name="Dvlasnik.findAll", query="SELECT d FROM Dvlasnik d")
public class Dvlasnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DVLASNIK_IDV_GENERATOR", sequenceName="DVLASNIK_PK")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DVLASNIK_IDV_GENERATOR")
	private long idv;

	private String brtel;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to Dstan
	@OneToMany(mappedBy="dvlasnik")
	private List<Dstan> dstans;

	public Dvlasnik() {
		this.dstans = new ArrayList<>();
	}

	public long getIdv() {
		return this.idv;
	}

	public void setIdv(long idv) {
		this.idv = idv;
	}

	public String getBrtel() {
		return this.brtel;
	}

	public void setBrtel(String brtel) {
		this.brtel = brtel;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Dstan> getDstans() {
		return this.dstans;
	}

	public void setDstans(List<Dstan> dstans) {
		this.dstans = dstans;
	}

	public Dstan addDstan(Dstan dstan) {
		getDstans().add(dstan);
		dstan.setDvlasnik(this);

		return dstan;
	}

	public Dstan removeDstan(Dstan dstan) {
		getDstans().remove(dstan);
		dstan.setDvlasnik(null);

		return dstan;
	}

	@Override
	public String toString() {
		return "Dvlasnik [" + idv + ", brtel=" + brtel + ", ime=" + ime + ", prezime=" + prezime + "]";
	}

}