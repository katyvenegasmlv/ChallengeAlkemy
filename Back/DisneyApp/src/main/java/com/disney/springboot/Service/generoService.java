package com.disney.springboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.disney.springboot.Model.Genero;
import com.disney.springboot.Repository.IGeneroRepository;

@Service
public class generoService implements IGeneroService{
	 @Autowired
	    private IGeneroRepository repositorio;

	    @Override
	    @Transactional(readOnly=true)
	    public List<Genero> findAll() {
	        
	        List<Genero> listaGeneros = repositorio.findAll();

	        return listaGeneros;
	    }

	    @Override
	    public Genero save(Genero genero) {
	        
	        return repositorio.save(genero);
	    }

	    @Override
	    public void deleteById(long id_genero) {
	        repositorio.deleteById(id_genero);        
	    }

	    @Override
	    public Genero findById(long id_genero){
	        Genero genero = repositorio.findById(id_genero).orElse(new Genero());

	        return genero;
	    }

	

}
