package com.ftninformatika.jwd.modul3.test.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.test.model.Polaznik;

@Repository
public interface PolaznikRepository extends JpaRepository<Polaznik,Long>{

	Polaznik findOneById(Long id);

	List<Polaznik> findByAutoSkolaId(Long autoSkolaId);

	Page<Polaznik> findByAutoSkolaIdAndImeLike(Long autoSkolaId, String ime, Pageable pageable);

	Page<Polaznik> findByImeLike(String ime, Pageable pageable);

}
