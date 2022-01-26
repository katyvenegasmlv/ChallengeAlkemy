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
import com.disney.springboot.Service.GeneroService;

public class GeneroController {

	@Autowired
    private GeneroService servicio;


    @Autowired(required = true)
    ///Metodo que retorna listado completo de genero
    // return un listado de genero
    @GetMapping("/GetMovies")
    public List<Genero> getGenero(){

        //Creo una lista de tipo genero que voy a llenar y devolver
        List<Genero> genero = new ArrayList<Genero>();

        //Lleno la lista de tipo genero
        genero = servicio.findAll();

        //Retorna la lista de tipo genero con la informacion
        return genero;
    } 

    ///Metodo para crear un genero
    ///@RequestBody recibe por parametro el genero
    // return true en caso de exito
    @PostMapping("/InsertMovies")
    public boolean insertPelicula(@RequestBody Genero genero){

        boolean result = true;


        servicio.save(genero);
        
        return result;
    } 

    ///Metodo para actualizar un genero
    ///@RequestBody recibe por parametro el genero
    // return true en caso de exito
    @RequestMapping(value="/UpdateMovies/{id_genero}", method=RequestMethod.PUT)
    public boolean updateGenero(@RequestBody Genero genero){

        boolean result = true;


        servicio.save(genero);

        return result;
    } 

    ///Metodo para buscar un genero
    ///Recibe por parametro el id
    //return el genero
    @GetMapping("/GetMovies{id_genero}")
    public Genero getGenero(long id_genero){
        Genero genero = new Genero();

        genero=servicio.findById(id_genero);

        return genero;
    } 

    ///Metodo para eliminar un genero
    ///@PathVariable recibe por parametro el id
    //return true en caso de exito
    @RequestMapping(value="/DeleteMovies/{id_genero}", method=RequestMethod.DELETE)
    public boolean deleteGenero(@PathVariable long id_genero){
        boolean result = true;

        servicio.deleteById(id_genero);
        
        return result;
    } 

}
