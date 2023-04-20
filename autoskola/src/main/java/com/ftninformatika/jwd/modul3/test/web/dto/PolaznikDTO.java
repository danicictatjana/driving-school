package com.ftninformatika.jwd.modul3.test.web.dto;

import javax.validation.constraints.Size;

public class PolaznikDTO {

	private Long id;

	@Size(max = 30)
	private String ime;

	private String prezime;

	private int godinaRodjenja;

	private String mesto;

	private Long autoSkolaId;

	private String autoSkolaNaziv;

	private boolean odslusaoTeoriju;

	private boolean odradioVoznju;

	private boolean prijavljen;

	private boolean polozio;

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

	public Long getAutoSkolaId() {
		return autoSkolaId;
	}

	public void setAutoSkolaId(Long autoSkolaId) {
		this.autoSkolaId = autoSkolaId;
	}

	public String getAutoSkolaNaziv() {
		return autoSkolaNaziv;
	}

	public void setAutoSkolaNaziv(String autoSkolaNaziv) {
		this.autoSkolaNaziv = autoSkolaNaziv;
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

	public boolean isPrijavljen() {
		return prijavljen;
	}

	public void setPrijavljen(boolean prijavljen) {
		this.prijavljen = prijavljen;
	}


}
