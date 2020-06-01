package com.farmaciasturno.web.app.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.farmaciasturno.web.app.pojos.Farmacia;
import com.farmaciasturno.web.app.pojos.Local;

@Service
public class FarmaciasTurnoService {

	@Value("${farmanet.minsal.cl.ws.getLocalesRegion}")
	private String URI;

	public Iterable<String> getLocalesComunas(String comuna) {

		RestTemplate restTemplate = new RestTemplate();

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);

		Farmacia[] farmacias = restTemplate.getForObject(URI, Farmacia[].class);

		List<Farmacia> farmaciasList = Arrays.asList(farmacias);
		List<String> farmaciasComunas = farmaciasList.stream().filter(f -> comuna.equals(f.getFkComuna()))
				.map(Farmacia::getLocalNombre).map(String::trim).distinct().collect(Collectors.toList());

		return farmaciasComunas;
	}

	public Iterable<Local> getLocales(String comuna, String local) {

		RestTemplate restTemplate = new RestTemplate();

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);

		Farmacia[] farmacias = restTemplate.getForObject(URI, Farmacia[].class);

		List<Farmacia> farmaciasList = Arrays.asList(farmacias);
		List<Local> locales = null;

		if ("".equals(local)) {
			locales = farmaciasList.stream().filter(f -> comuna.equals(f.getFkComuna())).map(temp -> {
				Local loc = new Local();
				loc.setNombre(temp.getLocalNombre());
				loc.setDireccion(temp.getLocalDireccion());
				loc.setTelefono(temp.getLocalTelefono());
				loc.setLatitud(temp.getLocalLat());
				loc.setLongitud(temp.getLocalLng());
				return loc;
			}).collect(Collectors.toList());
		} else {
			locales = farmaciasList.stream()
					.filter(f -> comuna.equals(f.getFkComuna()) && local.equals(f.getLocalNombre().trim()))
					.map(temp -> {
						Local loc = new Local();
						loc.setNombre(temp.getLocalNombre());
						loc.setDireccion(temp.getLocalDireccion());
						loc.setTelefono(temp.getLocalTelefono());
						loc.setLatitud(temp.getLocalLat());
						loc.setLongitud(temp.getLocalLng());
						return loc;
					}).collect(Collectors.toList());
		}

		return locales;
	}
}
