package com.ftninformatika.jwd.modul3.test.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.test.model.Polaznik;
import com.ftninformatika.jwd.modul3.test.repository.PolaznikRepository;
import com.ftninformatika.jwd.modul3.test.service.PolaznikService;

@Service
@Transactional
public class JpaPolaznikService implements PolaznikService {

	@Autowired
    private PolaznikRepository polaznikRepository;

	@Override
	public Polaznik findOne(Long id) {
		return polaznikRepository.findOneById(id);
	}

	@Override
	public Page<Polaznik> findAll(Integer pageNo) {
		return polaznikRepository.findAll(PageRequest.of(pageNo,3));
	}

	@Override
	public Polaznik update(Polaznik polaznik) {
		 return polaznikRepository.save(polaznik);
	}

	@Override
	public Polaznik delete(Long id) {
		Polaznik polaznik = polaznikRepository.findOneById(id);
		if(polaznik != null) {
			polaznik.getAutoSkola().getPolaznici().remove(polaznik);
			polaznik.setAutoSkola(null);
			polaznik = polaznikRepository.save(polaznik);
			polaznikRepository.delete(polaznik);
			return polaznik;
		}
		return null;
	}

	@Override
	public List<Polaznik> findByAutoSkolaId(Long autoSkolaId) {
		return polaznikRepository.findByAutoSkolaId(autoSkolaId);
	}

	@Override
	public Polaznik save(Polaznik polaznik) {
		return polaznikRepository.save(polaznik);
	}

	@Override
	public Page<Polaznik> find(Long autoSkolaId, String ime, Integer pageNo) {
		if(ime == null) {
			ime = "%%";
		}else {
			ime = "%" + ime + "%";
		}
		if(autoSkolaId == null) {
			return polaznikRepository.findByImeLike(ime, PageRequest.of(pageNo,3));
		}

		return polaznikRepository.findByAutoSkolaIdAndImeLike(autoSkolaId, ime, PageRequest.of(pageNo,3));
	}

}
