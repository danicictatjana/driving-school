package com.ftninformatika.jwd.modul3.test.service;

import java.util.List;

import com.ftninformatika.jwd.modul3.test.model.Polaganje;

public interface PolaganjeService {

	List<Polaganje> findAll();

	Polaganje findOne(Long id);

	Polaganje save (Polaganje polaganje);

	List<Polaganje> findByAutoSkolaId (Long autoSkolaId);

}
