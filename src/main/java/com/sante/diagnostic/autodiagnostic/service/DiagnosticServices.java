package com.sante.diagnostic.autodiagnostic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

/**
 * Service pour gérer le calcul de l'affectation.
 */

@Log4j2
@Component
public class DiagnosticServices {

    /**
     * Retourne une list avec les affectation du patient.
     *
     * @param index : c'est l'index de santé du patient provenant du capteur
     * @return une liste des affectations
     */
	public List<String> searchPatientaffectation(int index) {
		
		List<String>  affectation ;
		
		int result1 , result2;

		try {
				result1 = index % 3;
				result2 = index % 5;
				
				if(result1== 0 && result2 == 0) {
					affectation = new ArrayList<String>();
					affectation.add("Cardiologie");
					affectation.add("Traumatologie");
					return affectation;
				}else if(result1 == 0){
					affectation = new ArrayList<String>();
					affectation.add("Cardiologie");
					return affectation;
				}else if(result2 == 0) {
					affectation = new ArrayList<String>();
					affectation.add("Traumatologie");
					return affectation;
				}
				
		} catch (Exception e) {
			log.info("issue with the processing of the index" +e.getMessage());
			System.out.println("issue with the processing of the index");
		}
		return new ArrayList<String>();
		
	}
}
