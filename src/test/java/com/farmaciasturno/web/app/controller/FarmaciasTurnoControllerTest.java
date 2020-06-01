package com.farmaciasturno.web.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.farmaciasturno.web.app.controllers.FarmaciasTurnoController;
import com.farmaciasturno.web.app.pojos.Local;
import com.farmaciasturno.web.app.services.FarmaciasTurnoService;

@ExtendWith(MockitoExtension.class)
class FarmaciasTurnoControllerTest {

	@InjectMocks
	FarmaciasTurnoController farmaciasTurnoController;

	@Mock
	FarmaciasTurnoService farmaciasTurnoService;

	@Test
	void getLocalesComunas() {

		List<String> lista = new ArrayList<>();
		lista.add("BUIN");
		lista.add("COLINA");
		lista.add("SANTIAGO");

		when(farmaciasTurnoService.getLocalesComunas(any(String.class))).thenReturn(lista);

		Iterable<String> response = farmaciasTurnoController.getLocalesComunas("");

		assertThat(response.equals(lista));
	}

	@Test
	void getFarmaciasTurno() {

		List<Local> lista = new ArrayList<>();
		lista.add(new Local("Local1", "Direccion1", "Telefono1", "Latitud1", "Longitud1"));
		lista.add(new Local("Local2", "Direccion2", "Telefono2", "Latitud2", "Longitud2"));

		when(farmaciasTurnoService.getLocales(any(String.class), any(String.class))).thenReturn(lista);

		Iterable<Local> response = farmaciasTurnoController.getFarmaciasTurno("", "");

		assertThat(response.equals(lista));
	}
}