package com.ftninformatika.jwd.modul3.test.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.test.model.Polaznik;

public interface PolaznikService {

	Polaznik findOne(Long id);

    Page<Polaznik> findAll(Integer pageNo);

    Polaznik save(Polaznik polaznik);

    Polaznik update(Polaznik polaznik);

    Polaznik delete(Long id);

    Page<Polaznik> find(Long autoSkolaId, String ime, Integer pageNo);

    List<Polaznik> findByAutoSkolaId(Long autoSkolaId);

}
