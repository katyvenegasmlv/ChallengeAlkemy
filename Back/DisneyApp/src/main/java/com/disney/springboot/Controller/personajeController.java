package com.disney.springboot.Controller;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.disney.springboot.Model.Personaje;
import com.disney.springboot.Service.personajeService;

@RestController
@RequestMapping(path = "/personaje")
@CrossOrigin(origins = "http://localhost:3000")
public class personajeController {
	
	@Autowired
    private personajeService servicio;


    @Autowired(required = true)
    ///Metodo para buscar muchos personajeos
    //Devuelve un listado de personajeos
    @GetMapping("/GetPersonajes")
    public List<Personaje> GetPersonajes(){

        //Creo una lista de tipo personajeo que voy a llenar y devolver
        List<Personaje> personajes = new ArrayList<Personaje>();

        //Lleno la lista de tipo personajeo
        personajes = servicio.findAll();

        //Retorna la lista de tipo Personajeo con la informacion
        return personajes;
    } 

    ///Metodo para crear un personaje
    ///Recibe por parametro el personaje
    //Devuelve true en caso de exito
    @PostMapping("/InsertPersonaje")
    public boolean InsertPersonaje(@RequestBody Personaje personaje){
    	

    	
    	boolean result = true;

        personaje.id_personaje=0;
        

        servicio.save(personaje);
        
        return result;
    } 

    ///Metodo para actualizar un personajeo
    ///Recibe por parametro el personajeo
    //Devuelve true en caso de exito
    @RequestMapping(value="/UpdatePersonaje/{id_personaje}", method=RequestMethod.PUT)
    public boolean UpdatePersonaje(@RequestBody Personaje personaje){

    	
        boolean result = true;


        servicio.save(personaje);

        return result;
    } 

    ///Metodo para buscar un personajeo
    ///Recibe por parametro el name
    //Devuelve el personajeo
    @GetMapping("/GetPersonaje{id_personaje}")
    public Personaje GetPersonaje(long id_personaje){
        Personaje personaje = new Personaje();

        personaje=servicio.findById(id_personaje);

        return personaje;
    } 

    ///Metodo para eliminar un personajeo
    ///Recibe por parametro el name
    //Devuelve true en caso de exito
    @RequestMapping(value="/DeletePersonaje/{id_personaje}", method=RequestMethod.DELETE)
    public boolean DeletePersonaje(@PathVariable long id_personaje){
        boolean result = true;

        servicio.deleteById(id_personaje);
        
        return result;
    } 

}
