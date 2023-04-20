package com.ftninformatika.jwd.modul3.test.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.test.model.Polaganje;
import com.ftninformatika.jwd.modul3.test.model.Polaznik;
import com.ftninformatika.jwd.modul3.test.service.PolaganjeService;
import com.ftninformatika.jwd.modul3.test.service.PolaznikService;
import com.ftninformatika.jwd.modul3.test.support.PolaganjeToPolaganjeDTO;
import com.ftninformatika.jwd.modul3.test.web.dto.PolaganjeDTO;

@RestController
@RequestMapping(value = "/api/polaganja", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class PolaganjeController {

	 @Autowired
	 private PolaganjeService polaganjeService;

	 @Autowired
	 private PolaznikService polaznikService;

     @Autowired
     private PolaganjeToPolaganjeDTO toPolaganjeDTO;

     @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	    @GetMapping("/{polaganjeId}/{polaznikId}")
	    public ResponseEntity<PolaganjeDTO> getOne(@PathVariable Long polaganjeId, @PathVariable Long polaznikId){
	        Polaganje polaganje = polaganjeService.findOne(polaganjeId);
	        Polaznik polaznik = polaznikService.findOne(polaznikId);

	        if(polaganje != null && polaganje.getBrojMesta() > 0) {
	        	polaganje.setBrojMesta(polaganje.getBrojMesta() - 1);
	        	Polaganje sacuvanoPolaganje = polaganjeService.save(polaganje);
	        	polaznik.setPrijavljen(true);
	        	polaznikService.save(polaznik);
	            return new ResponseEntity<>(toPolaganjeDTO.convert(sacuvanoPolaganje), HttpStatus.OK);
	        }else {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }





}
