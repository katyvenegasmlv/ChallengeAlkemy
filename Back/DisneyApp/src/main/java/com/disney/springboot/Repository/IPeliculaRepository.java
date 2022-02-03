package com.disney.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disney.springboot.Model.Pelicula;
import java.io.Serializable;


@Repository
public interface IPeliculaRepository extends JpaRepository <Pelicula, Serializable>{

}
