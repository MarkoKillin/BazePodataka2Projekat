package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DSTAN database table.
 * 
 */
@Entity
@NamedQuery(name="Dstan.findAll", query="SELECT d FROM Dstan d")
public class Dstan implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DstanPK id;

	private int brojstana;

	private double kvadratura;

	private int sprat;

	//bi-directional many-to-one association to Dvlasnik
	@ManyToOne
	@JoinColumn(name="VLASNIK_IDV")
	private Dvlasnik dvlasnik;

	//bi-directional many-to-one association to Dzgrada
	@ManyToOne
	@JoinColumn(name="ZGRADA_IDZ")
	@MapsId("zgradaIdz")
	private Dzgrada dzgrada;

	public Dstan() {
	}

	public DstanPK getId() {
		return this.id;
	}

	public void setId(DstanPK id) {
		this.id = id;
	}

	public int getBrojstana() {
		return this.brojstana;
	}

	public void setBrojstana(int brojstana) {
		this.brojstana = brojstana;
	}

	public double getKvadratura() {
		return this.kvadratura;
	}

	public void setKvadratura(double kvadratura) {
		this.kvadratura = kvadratura;
	}

	public int getSprat() {
		return this.sprat;
	}

	public void setSprat(int sprat) {
		this.sprat = sprat;
	}

	public Dvlasnik getDvlasnik() {
		return this.dvlasnik;
	}

	public void setDvlasnik(Dvlasnik dvlasnik) {
		this.dvlasnik = dvlasnik;
	}

	public Dzgrada getDzgrada() {
		return this.dzgrada;
	}

	public void setDzgrada(Dzgrada dzgrada) {
		this.dzgrada = dzgrada;
	}

	@Override
	public String toString() {
		return "stan [broj=" + brojstana + ", " + kvadratura + ", sprat=" + sprat
				+ ", dvlasnik=" + dvlasnik;
	}
	
	

}