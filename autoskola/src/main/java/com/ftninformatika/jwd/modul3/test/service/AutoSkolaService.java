package com.ftninformatika.jwd.modul3.test.service;

import java.util.List;

import com.ftninformatika.jwd.modul3.test.model.AutoSkola;

public interface AutoSkolaService {

	List<AutoSkola> findAll();

	AutoSkola findOne(Long id);
}
