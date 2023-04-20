package com.ftninformatika.jwd.modul3.test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.ftninformatika.jwd.modul3.test.model.Polaganje;
import com.ftninformatika.jwd.modul3.test.service.AutoSkolaService;
import com.ftninformatika.jwd.modul3.test.service.PolaganjeService;
import com.ftninformatika.jwd.modul3.test.web.dto.PolaganjeDTO;

public class PolaganjeDTOToPolaganje implements Converter<PolaganjeDTO, Polaganje>{

	@Autowired
    private PolaganjeService polaganjeService;

	@Autowired
    private AutoSkolaService autoSkolaService;

	@Override
	public Polaganje convert(PolaganjeDTO dto) {

		Polaganje polaganje;
		if(dto.getId() == null){
			polaganje = new Polaganje();
        }else{
        	polaganje = polaganjeService.findOne(dto.getId());
        }

		if(polaganje != null){
			polaganje.setBrojMesta(dto.getBrojMesta());
			polaganje.setDatum(dto.getDatum());
			polaganje.setAutoSkola2(autoSkolaService.findOne(dto.getAutoSkolaId()));
        }
        return polaganje;
	}
}
