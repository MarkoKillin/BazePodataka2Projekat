package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the DZGRADA database table.
 * 
 */
@Entity
@NamedQuery(name="Dzgrada.findAll", query="SELECT d FROM Dzgrada d")
public class Dzgrada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DZGRADA_IDZ_GENERATOR", sequenceName="DZGRADA_PK")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DZGRADA_IDZ_GENERATOR")
	private long idz;

	private BigDecimal broj;

	private String ulica;

	//bi-directional many-to-one association to Dstan
	@OneToMany(mappedBy="dzgrada")
	private List<Dstan> dstans;

	public Dzgrada() {
		this.dstans = new ArrayList<>();
	}

	public long getIdz() {
		return this.idz;
	}

	public void setIdz(long idz) {
		this.idz = idz;
	}

	public BigDecimal getBroj() {
		return this.broj;
	}

	public void setBroj(BigDecimal broj) {
		this.broj = broj;
	}

	public String getUlica() {
		return this.ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public List<Dstan> getDstans() {
		return this.dstans;
	}

	public void setDstans(List<Dstan> dstans) {
		this.dstans = dstans;
	}

	public Dstan addDstan(Dstan dstan) {
		getDstans().add(dstan);
		dstan.setDzgrada(this);

		return dstan;
	}

	public Dstan removeDstan(Dstan dstan) {
		getDstans().remove(dstan);
		dstan.setDzgrada(null);

		return dstan;
	}

	@Override
	public String toString() {
		return "Dzgrada [" + idz + ", broj=" + broj + ", ulica=" + ulica + "]";
	}

}