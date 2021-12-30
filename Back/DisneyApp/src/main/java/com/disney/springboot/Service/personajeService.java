package com.disney.springboot.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.disney.springboot.Model.Personaje;
import com.disney.springboot.Repository.IPersonajeRepository;

@Service
public class personajeService implements IPersonajeService{
	 @Autowired
	    private IPersonajeRepository repositorio;

	    @Override
	    @Transactional(readOnly=true)
	    public List<Personaje> findAll() {
	        
	        List<Personaje> listaPersonajes = repositorio.findAll();

	        return listaPersonajes;
	    }

	    @Override
	    public Personaje save(Personaje personaje) {
	        
	        return repositorio.save(personaje);
	    }

	    @Override
	    public void deleteById(long id_personaje) {
	        repositorio.deleteById(id_personaje);        
	    }

	    @Override
	    public Personaje findById(long id_personaje){
	        Personaje personaje = repositorio.findById(id_personaje).orElse(new Personaje());

	        return personaje;
	    }


	

}
