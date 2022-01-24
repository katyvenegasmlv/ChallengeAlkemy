package com.disney.springboot.Configuration;

import org.springframework.context.annotation.Bean;

import com.disney.springboot.Service.IPeliculaService;
import com.disney.springboot.Service.IPersonajeService;
import com.disney.springboot.Service.IUserService;
import com.disney.springboot.Service.PersonajeService;
import com.disney.springboot.Service.UserService;
import com.disney.springboot.Service.PeliculaService;

public class AppConfiguration {
	
	 @Bean
	    public IPersonajeService personajeConfiguration(){
	        return new PersonajeService();
	    }

	    @Bean
	    public IUserService userConfiguration(){
	        return new UserService();
	    }
	    
	    @Bean
	    public IPeliculaService peliculaConfiguration(){
	        return new PeliculaService();
	    }


}
