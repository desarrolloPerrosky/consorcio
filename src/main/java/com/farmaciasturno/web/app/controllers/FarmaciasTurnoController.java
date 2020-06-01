package com.farmaciasturno.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farmaciasturno.web.app.pojos.Local;
import com.farmaciasturno.web.app.services.FarmaciasTurnoService;

@RestController
public class FarmaciasTurnoController {

	@Autowired
	FarmaciasTurnoService farmaciasTurnoService;

	@PostMapping("/localesComunas")
	public Iterable<String> getLocalesComunas(@RequestParam(value = "comuna") String comuna) {
		return farmaciasTurnoService.getLocalesComunas(comuna);
	}

	@PostMapping("/farmaciasTurno")
	public Iterable<Local> getFarmaciasTurno(@RequestParam(value = "comuna") String comuna,
			@RequestParam(value = "local") String local) {
		return farmaciasTurnoService.getLocales(comuna, local);
	}

}
