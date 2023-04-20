package com.ftninformatika.jwd.modul3.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.model.Polaganje;
import com.ftninformatika.jwd.modul3.test.web.dto.PolaganjeDTO;

@Component
public class PolaganjeToPolaganjeDTO implements Converter<Polaganje, PolaganjeDTO>{

	@Override
	public PolaganjeDTO convert(Polaganje polaganje) {
		PolaganjeDTO polaganjeDTO = new PolaganjeDTO();
		polaganjeDTO.setId(polaganje.getId());
		polaganjeDTO.setBrojMesta(polaganje.getBrojMesta());
		polaganjeDTO.setDatum(polaganje.getDatum());
		polaganjeDTO.setAutoSkolaId(polaganje.getAutoSkola2().getId());
        return polaganjeDTO;
	}

	public List<PolaganjeDTO> convert(List<Polaganje> polaganja){
        List<PolaganjeDTO> polaganjaDTO = new ArrayList<>();

        for(Polaganje polaganje : polaganja) {
        	polaganjaDTO.add(convert(polaganje));
        }

        return polaganjaDTO;
    }

}
