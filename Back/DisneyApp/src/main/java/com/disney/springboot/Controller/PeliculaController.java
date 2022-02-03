package com.disney.springboot.Controller;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.disney.springboot.Model.Pelicula;
import com.disney.springboot.Service.PeliculaService;


@RestController
@RequestMapping(path = "/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class PeliculaController {
	
	@Autowired
    private PeliculaService servicio;





    @Autowired(required = true)
    ///Metodo para buscar muchas peliculas
    //return un listado de peliculas
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
	/// @RequestBody recibe por parametro la pelicula
	// return true en caso de exito
    @RequestMapping(value="/InsertMovies", method = RequestMethod.POST)
	public boolean insertPelicula(@RequestBody Pelicula pelicula) {
    	

    	
	 boolean result = true;

			servicio.save(pelicula);

		return result;

	}


    ///Metodo para actualizar un personajeo
    ///@RequestBody recibe por parametro el personajeo
    //return true en caso de exito
    @RequestMapping(value="/UpdateMovies/{id_pelicula}", method=RequestMethod.PUT)
    public boolean updatePelicula(@RequestBody Pelicula pelicula){

        boolean result = true;


        servicio.save(pelicula);

        return result;
    } 

    ///Metodo para buscar una pelicula
    ///Recibe por parametro el id
    //return la pelicula
    @GetMapping("/GetMovies{id_pelicula}")
    public Pelicula getPelicula(long id_pelicula){
        Pelicula pelicula = new Pelicula();

        pelicula=servicio.findById(id_pelicula);

        return pelicula;
    } 

    ///Metodo para eliminar una pelicula
    ///Recibe por parametro el id
    //return true en caso de exito
    @RequestMapping(value="/DeleteMovies/{id_pelicula}", method=RequestMethod.DELETE)
    public boolean deletePelicula(@PathVariable long id_pelicula){
        boolean result = true;

        servicio.deleteById(id_pelicula);
        
        return result;
    } 



}
