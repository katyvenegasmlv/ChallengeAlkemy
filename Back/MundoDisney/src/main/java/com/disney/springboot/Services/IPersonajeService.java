package com.disney.springboot.Services;

import java.util.List;

import com.disney.springboot.Model.Personaje;

public interface IPersonajeService {
	 //Metodo de busqueda de todos los productos
    public List<Personaje> findAll();

    //Metodo de guardado de un producto
    public Personaje save(Personaje personaje);

    //Metodo de eliminar de un producto por Id
    public void deleteById(long id_personaje);

    //Metodo de busqueda de un producto por Id
    public Personaje findById (long id_personaje);
    


}
