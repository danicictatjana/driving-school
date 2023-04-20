package com.ftninformatika.jwd.modul3.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.model.AutoSkola;
import com.ftninformatika.jwd.modul3.test.web.dto.AutoSkolaDTO;

@Component
public class AutoSkolaToAutoSkolaDTO implements Converter<AutoSkola, AutoSkolaDTO> {

	@Override
	public AutoSkolaDTO convert(AutoSkola autoSkola) {
		AutoSkolaDTO dto = new AutoSkolaDTO();
        dto.setId(autoSkola.getId());
        dto.setNaziv(autoSkola.getNaziv());
        dto.setGodinaOsnivanja(autoSkola.getGodinaOsnivanja());
        dto.setBrojVozila(autoSkola.getBrojVozila());
        return dto;
	}

	public List<AutoSkolaDTO> convert(List<AutoSkola> autoSkole){
        List<AutoSkolaDTO> autoSkoleDto = new ArrayList<>();

        for(AutoSkola autoSkola : autoSkole) {
        	autoSkoleDto.add(convert(autoSkola));
        }

        return autoSkoleDto;
    }

}
