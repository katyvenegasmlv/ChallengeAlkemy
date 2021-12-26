package com.disney.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.disney.springboot.Model.Personaje;


public interface IPersonajeRepository extends JpaRepository <Personaje,Long>{

}
