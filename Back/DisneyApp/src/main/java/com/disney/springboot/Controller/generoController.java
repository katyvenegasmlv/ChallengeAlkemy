package com.disney.springboot.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.disney.springboot.Model.Genero;
import com.disney.springboot.Service.generoService;

public class generoController {

	@Autowired
    private generoService servicio;


    @Autowired(required = true)
    ///Metodo para buscar muchas peliculas
    //Devuelve un listado de peliculas
    @GetMapping("/GetMovies")
    public List<Genero> GetGenero(){

        //Creo una lista de tipo peliculas que voy a llenar y devolver
        List<Genero> genero = new ArrayList<Genero>();

        //Lleno la lista de tipo peliculas
        genero = servicio.findAll();

        //Retorna la lista de tipo Pelicula con la informacion
        return genero;
    } 

    ///Metodo para crear una pelicula
    ///Recibe por parametro la pelicula
    //Devuelve true en caso de exito
    @PostMapping("/InsertMovies")
    public boolean InsertPelicula(@RequestBody Genero genero){

        boolean result = true;

        genero.id_genero=0;

        servicio.save(genero);
        
        return result;
    } 

    ///Metodo para actualizar un personajeo
    ///Recibe por parametro el personajeo
    //Devuelve true en caso de exito
    @RequestMapping(value="/UpdateMovies/{id_genero}", method=RequestMethod.PUT)
    public boolean UpdateGenero(@RequestBody Genero genero){

        boolean result = true;


        servicio.save(genero);

        return result;
    } 

    ///Metodo para buscar una pelicula
    ///Recibe por parametro el name
    //Devuelve la pelicula
    @GetMapping("/GetMovies{id_genero}")
    public Genero GetGenero(long id_genero){
        Genero genero = new Genero();

        genero=servicio.findById(id_genero);

        return genero;
    } 

    ///Metodo para eliminar una pelicula
    ///Recibe por parametro el name
    //Devuelve true en caso de exito
    @RequestMapping(value="/DeleteMovies/{id_genero}", method=RequestMethod.DELETE)
    public boolean DeleteGenero(@PathVariable long id_genero){
        boolean result = true;

        servicio.deleteById(id_genero);
        
        return result;
    } 

}
