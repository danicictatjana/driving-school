package com.ftninformatika.jwd.modul3.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.test.model.AutoSkola;

@Repository
public interface AutoSkolaRepository extends JpaRepository<AutoSkola,Long>{

	@Override
	List<AutoSkola> findAll();

	AutoSkola findOneById (Long id);

}
