package com.sante.diagnostic.autodiagnostic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sante.diagnostic.autodiagnostic.service.DiagnosticServices;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller pour gérer les appels d'apis.
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class DiagnosticController {
	
	@Autowired
	private DiagnosticServices ds ;	
	
	
	@GetMapping(value="/capteur",produces = "application/json")
	public ResponseEntity<List<String>> getAffectationPatient(@RequestParam("index") int index) {
		
		List<String> affectation = ds.searchPatientaffectation(index);
		
		return new ResponseEntity<List<String>>(affectation, HttpStatus.OK);
	}
}
