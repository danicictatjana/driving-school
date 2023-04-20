package com.ftninformatika.jwd.modul3.test.web.controller;

import java.util.List;

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

import com.ftninformatika.jwd.modul3.test.model.AutoSkola;
import com.ftninformatika.jwd.modul3.test.model.Polaganje;
import com.ftninformatika.jwd.modul3.test.service.AutoSkolaService;
import com.ftninformatika.jwd.modul3.test.service.PolaganjeService;
import com.ftninformatika.jwd.modul3.test.support.AutoSkolaToAutoSkolaDTO;
import com.ftninformatika.jwd.modul3.test.support.PolaganjeToPolaganjeDTO;
import com.ftninformatika.jwd.modul3.test.web.dto.AutoSkolaDTO;
import com.ftninformatika.jwd.modul3.test.web.dto.PolaganjeDTO;

@RestController
@RequestMapping(value = "/api/autoskole", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class AutoSkolaController {

	 @Autowired
	 private AutoSkolaService autoSkolaService;

	 @Autowired
	 private PolaganjeService polaganjeService;

	 @Autowired
	 private AutoSkolaToAutoSkolaDTO autoSkolaDTO;

	 @Autowired
	 private PolaganjeToPolaganjeDTO polaganjeDTO;

	 @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	 @GetMapping
	 public ResponseEntity<List<AutoSkolaDTO>> getAll(){

		List<AutoSkola> autoSkole = autoSkolaService.findAll();

		return new ResponseEntity<>(autoSkolaDTO.convert(autoSkole), HttpStatus.OK);
	}

	 @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	    @GetMapping("/{id}/polaganja")
	    public ResponseEntity<List<PolaganjeDTO>> getDetails(@PathVariable Long id){

		 List<Polaganje> polaganja = polaganjeService.findByAutoSkolaId(id);

	     return new ResponseEntity<>(polaganjeDTO.convert(polaganja), HttpStatus.OK);

	    }
}
