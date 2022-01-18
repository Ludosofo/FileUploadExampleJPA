package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.Persona;

// Extiende/Hereda de JpaRepository; Hay que anotarlo con Stereotype repository
// Ahora hay que crearle la capa de servicio

@Repository
public interface IPersonaDao extends JpaRepository<Persona, Long>{

}
