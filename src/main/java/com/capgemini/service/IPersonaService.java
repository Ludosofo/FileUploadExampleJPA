package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Persona;

public interface IPersonaService {
	public List<Persona> personas(); // Obtener multiples personas????
	// public Persona getPersona(); // Necesitamos un metodo para obtener persona
	public void savePersona(Persona persona); // Guardamos persona
	public Persona getPersona(String id);
}
