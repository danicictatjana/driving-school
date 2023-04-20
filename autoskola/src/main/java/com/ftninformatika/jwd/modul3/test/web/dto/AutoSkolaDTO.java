package com.ftninformatika.jwd.modul3.test.web.dto;

import javax.validation.constraints.Size;

public class AutoSkolaDTO {

    private Long id;

    @Size(max = 50)
    private String naziv;

    private int godinaOsnivanja;

    private int brojVozila;

    public AutoSkolaDTO() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getGodinaOsnivanja() {
		return godinaOsnivanja;
	}

	public void setGodinaOsnivanja(int godinaOsnivanja) {
		this.godinaOsnivanja = godinaOsnivanja;
	}

	public int getBrojVozila() {
		return brojVozila;
	}

	public void setBrojVozila(int brojVozila) {
		this.brojVozila = brojVozila;
	}
}
