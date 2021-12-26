package com.disney.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.disney.springboot.Model.Pelicula;

public interface IPeliculaRepository extends JpaRepository <Pelicula,Long>{

}
