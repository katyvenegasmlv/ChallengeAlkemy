package com.disney.springboot.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disney.springboot.Model.Personaje;

@Repository
public interface IPersonajeRepository extends JpaRepository <Personaje, Serializable> {

}
