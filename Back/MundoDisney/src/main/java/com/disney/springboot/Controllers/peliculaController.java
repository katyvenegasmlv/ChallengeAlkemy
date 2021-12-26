package com.disney.springboot.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.disney.springboot.Model.Pelicula;
import com.disney.springboot.Services.peliculaService;

public class peliculaController {
	
	@Autowired
    private peliculaService servicio;


    @Autowired(required = true)
    ///Metodo para buscar muchos personajeos
    //Devuelve un listado de personajeos
    @GetMapping("/GetPeliculas")
    public List<Pelicula> GetMovies(){

        //Creo una lista de tipo personajeo que voy a llenar y devolver
        List<Pelicula> pelicula = new ArrayList<Pelicula>();

        //Lleno la lista de tipo personajeo
        pelicula = servicio.findAll();

        //Retorna la lista de tipo Personajeo con la informacion
        return pelicula;
    } 

    ///Metodo para crear un personajeo
    ///Recibe por parametro el personajeo
    //Devuelve true en caso de exito
    @PostMapping("/InsertMovies")
    public boolean InsertPelicula(@RequestBody Pelicula pelicula){

        boolean result = true;

        pelicula.id_pelicula=0;

        servicio.save(pelicula);
        
        return result;
    } 

    ///Metodo para actualizar un personajeo
    ///Recibe por parametro el personajeo
    //Devuelve true en caso de exito
    @RequestMapping(value="/UpdateMovies/{id_pelicula}", method=RequestMethod.PUT)
    public boolean UpdatePelicula(@RequestBody Pelicula pelicula){

        boolean result = true;


        servicio.save(pelicula);

        return result;
    } 

    ///Metodo para buscar un personajeo
    ///Recibe por parametro el name
    //Devuelve el personajeo
    @GetMapping("/GetMovies{id_pelicula}")
    public Pelicula GetPelicula(long id_pelicula){
        Pelicula pelicula = new Pelicula();

        pelicula=servicio.findById(id_pelicula);

        return pelicula;
    } 

    ///Metodo para eliminar un personajeo
    ///Recibe por parametro el name
    //Devuelve true en caso de exito
    @RequestMapping(value="/DeleteMovies/{id_pelicula}", method=RequestMethod.DELETE)
    public boolean DeletePelicula(@PathVariable long id_pelicula){
        boolean result = true;

        servicio.deleteById(id_pelicula);
        
        return result;
    } 


}
