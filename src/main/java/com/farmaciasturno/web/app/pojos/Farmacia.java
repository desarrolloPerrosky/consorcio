package com.farmaciasturno.web.app.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Farmacia {

	@JsonProperty("fecha")
	private String fecha;

	@JsonProperty("local_id")
	private String localId;

	@JsonProperty("local_nombre")
	private String localNombre;

	@JsonProperty("comuna_nombre")
	private String comunaNombre;

	@JsonProperty("localidad_nombre")
	private String localidadNombre;

	@JsonProperty("local_direccion")
	private String localDireccion;

	@JsonProperty("funcionamiento_hora_apertura")
	private String funcionamientoHoraApertura;

	@JsonProperty("funcionamiento_hora_cierre")
	private String funcionamientoHoraCierre;

	@JsonProperty("local_telefono")
	private String localTelefono;

	@JsonProperty("local_lat")
	private String localLat;

	@JsonProperty("local_lng")
	private String localLng;

	@JsonProperty("funcionamiento_dia")
	private String funcionamientoDia;

	@JsonProperty("fk_region")
	private String fkRegion;

	@JsonProperty("fk_comuna")
	private String fkComuna;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getLocalNombre() {
		return localNombre;
	}

	public void setLocalNombre(String localNombre) {
		this.localNombre = localNombre;
	}

	public String getComunaNombre() {
		return comunaNombre;
	}

	public void setComunaNombre(String comunaNombre) {
		this.comunaNombre = comunaNombre;
	}

	public String getLocalidadNombre() {
		return localidadNombre;
	}

	public void setLocalidadNombre(String localidadNombre) {
		this.localidadNombre = localidadNombre;
	}

	public String getLocalDireccion() {
		return localDireccion;
	}

	public void setLocalDireccion(String localDireccion) {
		this.localDireccion = localDireccion;
	}

	public String getFuncionamientoHoraApertura() {
		return funcionamientoHoraApertura;
	}

	public void setFuncionamientoHoraApertura(String funcionamientoHoraApertura) {
		this.funcionamientoHoraApertura = funcionamientoHoraApertura;
	}

	public String getFuncionamientoHoraCierre() {
		return funcionamientoHoraCierre;
	}

	public void setFuncionamientoHoraCierre(String funcionamientoHoraCierre) {
		this.funcionamientoHoraCierre = funcionamientoHoraCierre;
	}

	public String getLocalTelefono() {
		return localTelefono;
	}

	public void setLocalTelefono(String localTelefono) {
		this.localTelefono = localTelefono;
	}

	public String getLocalLat() {
		return localLat;
	}

	public void setLocalLat(String localLat) {
		this.localLat = localLat;
	}

	public String getLocalLng() {
		return localLng;
	}

	public void setLocalLng(String localLng) {
		this.localLng = localLng;
	}

	public String getFuncionamientoDia() {
		return funcionamientoDia;
	}

	public void setFuncionamientoDia(String funcionamientoDia) {
		this.funcionamientoDia = funcionamientoDia;
	}

	public String getFkRegion() {
		return fkRegion;
	}

	public void setFkRegion(String fkRegion) {
		this.fkRegion = fkRegion;
	}

	public String getFkComuna() {
		return fkComuna;
	}

	public void setFkComuna(String fkComuna) {
		this.fkComuna = fkComuna;
	}

}
