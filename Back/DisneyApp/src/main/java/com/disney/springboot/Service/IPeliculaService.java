package com.disney.springboot.Service;

import java.util.List;

import com.disney.springboot.Model.Pelicula;

public interface IPeliculaService {
	
	 //Metodo de busqueda de todas las peliculas
    public List<Pelicula> findAll();

    //Metodo de guardado de una pelicula
    public Pelicula save(Pelicula pelicula);

    //Metodo de eliminar de una pelicula por Id
    public void deleteById(long id_pelicula);

    //Metodo de busqueda de una pelicula por Id
    public Pelicula findById (long id_pelicula);
    

}
