package com.ftninformatika.jwd.modul3.test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.test.model.Polaznik;
import com.ftninformatika.jwd.modul3.test.service.PolaznikService;
import com.ftninformatika.jwd.modul3.test.support.PolaznikDTOToPolaznik;
import com.ftninformatika.jwd.modul3.test.support.PolaznikToPolaznikDTO;
import com.ftninformatika.jwd.modul3.test.web.dto.PolaznikDTO;

@RestController
@RequestMapping(value = "/api/polaznici", produces = MediaType.APPLICATION_JSON_VALUE)
public class PolaznikController {

	 	@Autowired
	    private PolaznikService polaznikService;

	    @Autowired
	    private PolaznikDTOToPolaznik toPolaznik;

	    @Autowired
	    private PolaznikToPolaznikDTO toPolaznikDTO;

	    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	    @GetMapping
	    public ResponseEntity<List<PolaznikDTO>> getAll(
	    		@RequestParam(required=false) Long autoSkolaId,
	    		@RequestParam(required=false) String ime,
	            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo){

	        Page<Polaznik> page;
	        if(autoSkolaId != null || ime != null) {
	        	page = polaznikService.find(autoSkolaId, ime, pageNo);
	        }else {
	        	page = polaznikService.findAll(pageNo);
	        }

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

	        return new ResponseEntity<>(toPolaznikDTO.convert(page.getContent()), headers, HttpStatus.OK);
	    }

	    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	    @GetMapping("/{id}")
	    public ResponseEntity<PolaznikDTO> getOne(@PathVariable Long id){
	        Polaznik polaznik = polaznikService.findOne(id);

	        if(polaznik != null) {
	            return new ResponseEntity<>(toPolaznikDTO.convert(polaznik), HttpStatus.OK);
	        }else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PreAuthorize("hasRole('ADMIN')")
	    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<PolaznikDTO> create(@Valid @RequestBody PolaznikDTO polaznikDTO){
	    	Polaznik polaznik = toPolaznik.convert(polaznikDTO);

	        if(polaznik.getAutoSkola() == null) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        polaznik.setOdslusaoTeoriju(false);
	        polaznik.setOdradioVoznju(false);
	        polaznik.setPolozio(false);
	        polaznik.setPrijavljen(false);

	        Polaznik sacuvanPolaznik = polaznikService.save(polaznik);

	        return new ResponseEntity<>(toPolaznikDTO.convert(sacuvanPolaznik), HttpStatus.CREATED);
	    }

	    @PreAuthorize("hasRole('ADMIN')")
	    @PutMapping(value= "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<PolaznikDTO> update(@PathVariable Long id, @Valid @RequestBody PolaznikDTO polaznikDTO){

	        if(!id.equals(polaznikDTO.getId())) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        Polaznik polaznik = toPolaznik.convert(polaznikDTO);

	        if(polaznik.getAutoSkola() == null) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        Polaznik sacuvanPolaznik = polaznikService.update(polaznik);

	        return new ResponseEntity<>(toPolaznikDTO.convert(sacuvanPolaznik),HttpStatus.OK);
	    }

	    @PreAuthorize("hasRole('ADMIN')")
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id){

	    	Polaznik obrisanPolaznik = polaznikService.delete(id);

	        if(obrisanPolaznik != null) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	    @GetMapping("/{id}/voznja")
	    public ResponseEntity<PolaznikDTO> odradioVoznju(@PathVariable Long id){
	        Polaznik polaznik = polaznikService.findOne(id);

	        if(polaznik != null) {
	        	polaznik.setOdradioVoznju(true);
	        	Polaznik sacuvanPolaznik = polaznikService.save(polaznik);
	            return new ResponseEntity<>(toPolaznikDTO.convert(sacuvanPolaznik), HttpStatus.OK);
	        }else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	    @GetMapping("/{id}/teorija")
	    public ResponseEntity<PolaznikDTO> odslusaoTeoriju(@PathVariable Long id){
	        Polaznik polaznik = polaznikService.findOne(id);

	        if(polaznik != null) {
	        	polaznik.setOdslusaoTeoriju(true);
	        	Polaznik sacuvanPolaznik = polaznikService.save(polaznik);
	            return new ResponseEntity<>(toPolaznikDTO.convert(sacuvanPolaznik), HttpStatus.OK);
	        }else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	    @GetMapping("/{id}/polaganje")
	    public ResponseEntity<PolaznikDTO> polozio(@PathVariable Long id){
	        Polaznik polaznik = polaznikService.findOne(id);

	        if(polaznik != null) {
	        	polaznik.setPolozio(true);
	        	Polaznik sacuvanPolaznik = polaznikService.save(polaznik);
	            return new ResponseEntity<>(toPolaznikDTO.convert(sacuvanPolaznik), HttpStatus.OK);
	        }else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

}
