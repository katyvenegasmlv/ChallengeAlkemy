package com.disney.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.disney.springboot.Model.Genero;

public interface IGeneroRepository extends JpaRepository <Genero,Long> {

}
