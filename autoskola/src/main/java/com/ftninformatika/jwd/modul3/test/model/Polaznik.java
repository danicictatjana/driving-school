package com.ftninformatika.jwd.modul3.test.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Polaznik {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable = false)
	private String ime;

	@Column(nullable = false)
	private String prezime;

	@Column
	private int godinaRodjenja;

	@Column
	private String mesto;

	@ManyToOne
	private AutoSkola autoSkola;

	@Column
	private boolean odslusaoTeoriju;

	@Column
	private boolean odradioVoznju;

	@Column
	private boolean prijavljen;

	@Column
	private boolean polozio;

	public Polaznik() {
        super();
    }

	public Polaznik(Long id, String ime, String prezime, int godinaRodjenja, String mesto, AutoSkola autoSkola,
			boolean odslusaoTeoriju, boolean odradioVoznju, boolean polozio) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.godinaRodjenja = godinaRodjenja;
		this.mesto = mesto;
		this.autoSkola = autoSkola;
		this.odslusaoTeoriju = odslusaoTeoriju;
		this.odradioVoznju = odradioVoznju;
		this.polozio = polozio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getGodinaRodjenja() {
		return godinaRodjenja;
	}

	public void setGodinaRodjenja(int godinaRodjenja) {
		this.godinaRodjenja = godinaRodjenja;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public AutoSkola getAutoSkola() {
		return autoSkola;
	}

	public void setAutoSkola(AutoSkola autoSkola) {
		this.autoSkola = autoSkola;
	}

	public boolean isOdslusaoTeoriju() {
		return odslusaoTeoriju;
	}

	public void setOdslusaoTeoriju(boolean odslusaoTeoriju) {
		this.odslusaoTeoriju = odslusaoTeoriju;
	}

	public boolean isOdradioVoznju() {
		return odradioVoznju;
	}

	public void setOdradioVoznju(boolean odradioVoznju) {
		this.odradioVoznju = odradioVoznju;
	}

	public boolean isPolozio() {
		return polozio;
	}

	public void setPolozio(boolean polozio) {
		this.polozio = polozio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Polaznik other = (Polaznik) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Polaznik [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", godinaRodjenja=" + godinaRodjenja
				+ ", mesto=" + mesto + ", autoSkola=" + autoSkola + ", odslusaoTeoriju=" + odslusaoTeoriju
				+ ", odradioVoznju=" + odradioVoznju + ", polozio=" + polozio + "]";
	}

	public boolean isPrijavljen() {
		return prijavljen;
	}

	public void setPrijavljen(boolean prijavljen) {
		this.prijavljen = prijavljen;
	}
}
