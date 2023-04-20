package com.ftninformatika.jwd.modul3.test.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Polaganje {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable = false)
	private int brojMesta;

	@Column(nullable = false)
	private LocalDate datum;

	@JoinColumn(name="auto_skola_id")
	@ManyToOne
	private AutoSkola autoSkola2;

	public Polaganje() {
		super();
	}

	public Polaganje(Long id, int brojMesta, LocalDate datum, AutoSkola autoSkola2) {
		super();
		this.id = id;
		this.brojMesta = brojMesta;
		this.datum = datum;
		this.autoSkola2 = autoSkola2;
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

	public AutoSkola getAutoSkola2() {
		return autoSkola2;
	}

	public void setAutoSkola2(AutoSkola autoSkola2) {
		this.autoSkola2 = autoSkola2;
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
		Polaganje other = (Polaganje) obj;
		return Objects.equals(id, other.id);
	}

}
