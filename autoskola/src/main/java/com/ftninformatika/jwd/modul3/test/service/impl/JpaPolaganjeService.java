package com.ftninformatika.jwd.modul3.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.test.model.Polaganje;
import com.ftninformatika.jwd.modul3.test.repository.PolaganjeRepository;
import com.ftninformatika.jwd.modul3.test.service.PolaganjeService;

@Service
public class JpaPolaganjeService implements PolaganjeService {

	@Autowired
    private PolaganjeRepository polaganjeRepository;

	@Override
	public List<Polaganje> findAll() {
		return polaganjeRepository.findAll();
	}

	@Override
	public Polaganje findOne(Long id) {
		return polaganjeRepository.findOneById(id);
	}

	@Override
	public List<Polaganje> findByAutoSkolaId(Long autoSkolaId) {
		return polaganjeRepository.findByAutoSkola2Id(autoSkolaId);
	}

	@Override
	public Polaganje save(Polaganje polaganje) {
		return polaganjeRepository.save(polaganje);
	}

}
