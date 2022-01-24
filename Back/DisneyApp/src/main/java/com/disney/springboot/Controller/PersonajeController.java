package com.disney.springboot.Controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.disney.springboot.Model.Personaje;
import com.disney.springboot.Service.PersonajeService;

@RestController
@RequestMapping(path = "/personaje")
@CrossOrigin(origins = "http://localhost:3000")
public class PersonajeController {
	
	@Autowired
    private PersonajeService servicio;


    @Autowired(required = true)
    ///Metodo para buscar listado de personajes
    //return un listado de personajes
    @GetMapping("/GetPersonajes")
    public List<Personaje> getPersonajes(){

        //Creo una lista de tipo personaje que voy a llenar y devolver
        List<Personaje> personajes = new ArrayList<Personaje>();

        //Lleno la lista de tipo personaje
        personajes = servicio.findAll();

        //Retorna la lista de tipo Personaje con la informacion
        return personajes;
    } 

    ///Metodo para crear un personaje
    ///@RequestBody recibe por parametro el personaje
    //return true en caso de exito
    @PostMapping("/InsertPersonaje")
    public boolean insertPersonaje(@RequestBody Personaje personaje){
    	

    	
    	boolean result = true;

        servicio.save(personaje);
        
        return result;
    } 

    ///Metodo para actualizar un personajeo
    ///@RequestBody recibe por parametro el personajeo
    //return true en caso de exito
    @RequestMapping(value="/UpdatePersonaje/{id_personaje}", method=RequestMethod.PUT)
    public boolean updatePersonaje(@RequestBody Personaje personaje){

    	
        boolean result = true;


        servicio.save(personaje);

        return result;
    } 

    ///Metodo para buscar un personaje
    ///Recibe por parametro el id
    //return devuelve el personaje
    @GetMapping("/GetPersonaje{id_personaje}")
    public Personaje getPersonaje(long id_personaje){
        Personaje personaje = new Personaje();

        personaje=servicio.findById(id_personaje);

        return personaje;
    } 

    ///Metodo para eliminar un personaje
    ///Recibe por parametro el id
    //return true en caso de exito
    @RequestMapping(value="/DeletePersonaje/{id_personaje}", method=RequestMethod.DELETE)
    public boolean deletePersonaje(@PathVariable long id_personaje){
        boolean result = true;

        servicio.deleteById(id_personaje);
        
        return result;
    } 

}
