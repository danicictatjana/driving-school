package com.ftninformatika.jwd.modul3.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.test.model.Polaganje;

@Repository
public interface PolaganjeRepository extends JpaRepository<Polaganje,Long>{

	@Override
	List<Polaganje> findAll();

	Polaganje findOneById (Long id);

	List<Polaganje> findByAutoSkola2Id (Long autoSkolaId);

}
