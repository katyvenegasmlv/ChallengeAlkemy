package com.disney.springboot.Controller;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.Multipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.disney.springboot.Model.Genero;
import com.disney.springboot.Model.Pelicula;
import com.disney.springboot.Model.User;
import com.disney.springboot.Service.peliculaService;


@RestController
@RequestMapping(path = "/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class peliculaController {
	
	@Autowired
    private peliculaService servicio;





    @Autowired(required = true)
    ///Metodo para buscar muchas peliculas
    //Devuelve un listado de peliculas
    @GetMapping("/GetMovies")
    public List<Pelicula> getMovies(){

        //Creo una lista de tipo peliculas que voy a llenar y devolver
        List<Pelicula> pelicula = new ArrayList<Pelicula>();

        //Lleno la lista de tipo peliculas
        pelicula = servicio.findAll();

        //Retorna la lista de tipo Pelicula con la informacion
        return pelicula;
    } 
    
    

	/// Metodo para crear una pelicula
	/// Recibe por parametro la pelicula
	// Devuelve true en caso de exito
    @RequestMapping(value="/InsertMovies", method = RequestMethod.POST)
	public boolean insertPelicula(@RequestBody Pelicula pelicula) {

    	
	 boolean result = true;

			pelicula.id_pelicula = 0;

		
			servicio.save(pelicula);

		return result;

	}


    ///Metodo para actualizar un personajeo
    ///Recibe por parametro el personajeo
    //Devuelve true en caso de exito
    @RequestMapping(value="/UpdateMovies/{id_pelicula}", method=RequestMethod.PUT)
    public boolean updatePelicula(@RequestBody Pelicula pelicula){

        boolean result = true;


        servicio.save(pelicula);

        return result;
    } 

    ///Metodo para buscar una pelicula
    ///Recibe por parametro el name
    //Devuelve la pelicula
    @GetMapping("/GetMovies{id_pelicula}")
    public Pelicula getPelicula(long id_pelicula){
        Pelicula pelicula = new Pelicula();

        pelicula=servicio.findById(id_pelicula);

        return pelicula;
    } 

    ///Metodo para eliminar una pelicula
    ///Recibe por parametro el name
    //Devuelve true en caso de exito
    @RequestMapping(value="/DeleteMovies/{id_pelicula}", method=RequestMethod.DELETE)
    public boolean deletePelicula(@PathVariable long id_pelicula){
        boolean result = true;

        servicio.deleteById(id_pelicula);
        
        return result;
    } 



}
