package com.ftninformatika.jwd.modul3.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.test.model.AutoSkola;
import com.ftninformatika.jwd.modul3.test.repository.AutoSkolaRepository;
import com.ftninformatika.jwd.modul3.test.service.AutoSkolaService;

@Service
public class JpaAutoSkolaService implements AutoSkolaService{

	@Autowired
    private AutoSkolaRepository autoSkolaRepository;

	@Override
	public List<AutoSkola> findAll() {
		return autoSkolaRepository.findAll();
	}

	@Override
	public AutoSkola findOne(Long id) {
		return autoSkolaRepository.findOneById(id);
	}

}
