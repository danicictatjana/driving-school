package com.ftninformatika.jwd.modul3.test.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AutoSkola {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(nullable = false, unique = true)
	private String naziv;

	@Column(nullable = false)
	private int godinaOsnivanja;

	@Column
	private int brojVozila;

	@OneToMany(mappedBy = "autoSkola", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Polaznik> polaznici = new ArrayList<>();

	@OneToMany(mappedBy = "autoSkola2", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Polaganje> polaganja = new ArrayList<>();

	public AutoSkola() {
		super();
	}

	public AutoSkola(Long id, String naziv, int godinaOsnivanja, int brojVozila) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.godinaOsnivanja = godinaOsnivanja;
		this.brojVozila = brojVozila;
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

	public List<Polaznik> getPolaznici() {
		return polaznici;
	}

	public void setPolaznici(List<Polaznik> polaznici) {
		this.polaznici = polaznici;
	}

	public List<Polaganje> getPolaganja() {
		return polaganja;
	}

	public void setPolaganja(List<Polaganje> polaganja) {
		this.polaganja = polaganja;
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
		AutoSkola other = (AutoSkola) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "AutoSkola [id=" + id + ", naziv=" + naziv + ", godinaOsnivanja=" + godinaOsnivanja + ", brojVozila="
				+ brojVozila + "]";
	}
}
