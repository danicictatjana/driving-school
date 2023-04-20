package com.ftninformatika.jwd.modul3.test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.model.Polaznik;
import com.ftninformatika.jwd.modul3.test.service.AutoSkolaService;
import com.ftninformatika.jwd.modul3.test.service.PolaznikService;
import com.ftninformatika.jwd.modul3.test.web.dto.PolaznikDTO;

@Component
public class PolaznikDTOToPolaznik implements Converter<PolaznikDTO, Polaznik>{

	@Autowired
    private PolaznikService polaznikService;

    @Autowired
    private AutoSkolaService autoSkolaService;

	@Override
	public Polaznik convert(PolaznikDTO dto) {

		Polaznik polaznik;
		if(dto.getId() == null){
            polaznik = new Polaznik();
        }else{
        	polaznik = polaznikService.findOne(dto.getId());
        }

		if(polaznik != null){
			polaznik.setIme(dto.getIme());
			polaznik.setPrezime(dto.getPrezime());
			polaznik.setGodinaRodjenja(dto.getGodinaRodjenja());
			polaznik.setMesto(dto.getMesto());
			polaznik.setAutoSkola(autoSkolaService.findOne(dto.getAutoSkolaId()));
			polaznik.setOdslusaoTeoriju(dto.isOdslusaoTeoriju());
			polaznik.setOdradioVoznju(dto.isOdradioVoznju());
			polaznik.setPolozio(dto.isPolozio());
			polaznik.setPrijavljen(dto.isPrijavljen());
        }
        return polaznik;
	}

}
