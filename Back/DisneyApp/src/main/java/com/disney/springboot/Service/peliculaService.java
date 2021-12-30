package com.disney.springboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.disney.springboot.Model.Pelicula;
import com.disney.springboot.Repository.IPeliculaRepository;

@Service
public class peliculaService implements IPeliculaService{

	 @Autowired
	    private IPeliculaRepository repositorio;

	    @Override
	    @Transactional(readOnly=true)
	    public List<Pelicula> findAll() {
	        
	        List<Pelicula> listaPeliculas = repositorio.findAll();

	        return listaPeliculas;
	    }

	    @Override
	    public Pelicula save(Pelicula pelicula) {
	        
	        return repositorio.save(pelicula);
	    }

	    @Override
	    public void deleteById(long id_pelicula) {
	        repositorio.deleteById(id_pelicula);        
	    }

	    @Override
	    public Pelicula findById(long id_pelicula){
	        Pelicula pelicula = repositorio.findById(id_pelicula).orElse(new Pelicula());

	        return pelicula;
	    }

}
