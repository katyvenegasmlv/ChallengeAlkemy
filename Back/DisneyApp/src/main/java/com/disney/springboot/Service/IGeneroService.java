package com.disney.springboot.Service;

import java.util.List;

import com.disney.springboot.Model.Genero;

public interface IGeneroService {

	 //Metodo de busqueda de todas las peliculas
    public List<Genero> findAll();

    //Metodo de guardado de una pelicula
    public Genero save(Genero genero);

    //Metodo de eliminar de una pelicula por Id
    public void deleteById(long id_genero);

    //Metodo de busqueda de una pelicula por Id
    public Genero findById (long id_genero);
    

}
