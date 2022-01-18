package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.IPersonaDao;
import com.capgemini.entities.Persona;
import com.capgemini.service.IPersonaService;

// Implements IPersonaService
// @Service
// Implementar metodos con override
// Creamos daoPersona y le ponemos autowired para que se conecte

@Service
public class PersonaServiceImpl implements IPersonaService{
	
	@Autowired
	private IPersonaDao daoPersona;

	@Override
	public List<Persona> personas() {
		// TODO Auto-generated method stub
		return daoPersona.findAll();
	}

	@Override
	public Persona getPersona(String id) {
		// TODO Auto-generated method stub
		return daoPersona.getById(Long.parseLong(id));
	}

	@Override
	public void savePersona(Persona persona) {
		// TODO Auto-generated method stub
		daoPersona.save(persona);
	}

}
