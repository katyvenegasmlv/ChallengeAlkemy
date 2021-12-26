package com.disney.springboot.Services;

import java.util.List;

import com.disney.springboot.Model.Pelicula;

public interface IPeliculaService {

	 //Metodo de busqueda de todos los productos
    public List<Pelicula> findAll();

    //Metodo de guardado de un producto
    public Pelicula save(Pelicula pelicula);

    //Metodo de eliminar de un producto por Id
    public void deleteById(long id_pelicula);

    //Metodo de busqueda de un producto por Id
    public Pelicula findById (long id_pelicula);
    

}
