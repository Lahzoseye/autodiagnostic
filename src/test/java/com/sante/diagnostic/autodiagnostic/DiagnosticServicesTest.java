package com.sante.diagnostic.autodiagnostic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sante.diagnostic.autodiagnostic.service.DiagnosticServices;

class DiagnosticServicesTest {

private DiagnosticServices diagnostisService ;
	
	@BeforeEach
    public void setUp() {
		
        // Initialisation du service avant test
		
		diagnostisService = new DiagnosticServices();
    }

	@Test
	void testsearchPatientaffectation_Success1() throws Exception{
		
		int index  = 33;
		
		// Appeler la méthode à tester
		List<String> resultat = diagnostisService.searchPatientaffectation(index);
		
		// Vérifier le résultat
		assertFalse(resultat.isEmpty());
		assertFalse(resultat.size() != 1);
		assertEquals("Cardiologie",resultat.get(0));	
		
	}
	
	@Test
	void testsearchPatientaffectation_Success2() throws Exception{
		
		int index  = 45;
		
		// Appeler la méthode à tester
		List<String> resultat = diagnostisService.searchPatientaffectation(index);
		
		// Vérifier le résultat
		assertFalse(resultat.isEmpty());
		assertFalse(resultat.size() != 2);
		assertEquals("Cardiologie",resultat.get(0));	
		
	}
	
	@Test
	void testsearchPatientaffectation_false() throws Exception{
		
		int index  = 10;
		
		// Appeler la méthode à tester
		List<String> resultat = diagnostisService.searchPatientaffectation(index);
		
		// Vérifier le résultat
		assertTrue(resultat.size()== 1);
		assertFalse("Cardiologie".equalsIgnoreCase(resultat.get(0)));
		
	}

}
