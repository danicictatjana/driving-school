package com.ftninformatika.jwd.modul3.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.test.model.Polaznik;
import com.ftninformatika.jwd.modul3.test.web.dto.PolaznikDTO;

@Component
public class PolaznikToPolaznikDTO implements Converter<Polaznik, PolaznikDTO>{

	@Override
	public PolaznikDTO convert(Polaznik polaznik) {
		PolaznikDTO polaznikDTO = new PolaznikDTO();
		polaznikDTO.setId(polaznik.getId());
		polaznikDTO.setIme(polaznik.getIme());
		polaznikDTO.setPrezime(polaznik.getPrezime());
		polaznikDTO.setGodinaRodjenja(polaznik.getGodinaRodjenja());
		polaznikDTO.setMesto(polaznik.getMesto());
		polaznikDTO.setAutoSkolaId(polaznik.getAutoSkola().getId());
		polaznikDTO.setAutoSkolaNaziv(polaznik.getAutoSkola().getNaziv());
		polaznikDTO.setOdslusaoTeoriju(polaznik.isOdslusaoTeoriju());
		polaznikDTO.setOdradioVoznju(polaznik.isOdradioVoznju());
		polaznikDTO.setPolozio(polaznik.isPolozio());
		polaznikDTO.setPrijavljen(polaznik.isPrijavljen());
        return polaznikDTO;
	}

	public List<PolaznikDTO> convert(List<Polaznik> polaznici){
        List<PolaznikDTO> polazniciDTO = new ArrayList<>();

        for(Polaznik polaznik : polaznici) {
        	polazniciDTO.add(convert(polaznik));
        }

        return polazniciDTO;
    }

}
