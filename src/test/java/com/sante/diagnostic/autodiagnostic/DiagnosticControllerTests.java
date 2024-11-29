package com.sante.diagnostic.autodiagnostic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.sante.diagnostic.autodiagnostic.controller.DiagnosticController;
import com.sante.diagnostic.autodiagnostic.service.DiagnosticServices;



@WebMvcTest(controllers = DiagnosticController.class)
class DiagnosticControllerTests {

	@Autowired
	private MockMvc mocMvc ;
	
	@MockBean
	private DiagnosticServices diagnostisService ;

	@Test
	void testGetAffectationPatient() throws Exception {
		int index = 45;
		List<String> affectation = new ArrayList<>();
		affectation.add("Cardiologie");
		affectation.add("Traumatologie");
		
		// Simuler le comportement du service pour un index 45
		when(diagnostisService.searchPatientaffectation(index)).thenReturn(affectation);
		
		mocMvc.perform(get("/api/capteur?index=45").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0]").value("Cardiologie"))
		.andExpect(jsonPath("$[1]").value("Traumatologie"))
		.andDo(MockMvcResultHandlers.print());
	}


}
