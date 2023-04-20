package com.ftninformatika.jwd.modul3.test.web.dto;

import java.time.LocalDate;

import javax.validation.constraints.Positive;

public class PolaganjeDTO {

	private Long id;

	@Positive(message = "Broj mesta nije pozitivan broj.")
	private int brojMesta;

	private LocalDate datum;

	private Long autoSkolaId;

    public PolaganjeDTO() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrojMesta() {
		return brojMesta;
	}

	public void setBrojMesta(int brojMesta) {
		this.brojMesta = brojMesta;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public Long getAutoSkolaId() {
		return autoSkolaId;
	}

	public void setAutoSkolaId(Long autoSkolaId) {
		this.autoSkolaId = autoSkolaId;
	}
}
