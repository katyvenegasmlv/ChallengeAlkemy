package com.disney.springboot.Configuration;

import org.springframework.context.annotation.Bean;

import com.disney.springboot.Service.IPeliculaService;
import com.disney.springboot.Service.IPersonajeService;
import com.disney.springboot.Service.IUserService;
import com.disney.springboot.Service.personajeService;
import com.disney.springboot.Service.userService;
import com.disney.springboot.Service.peliculaService;

public class AppConfiguration {
	
	 @Bean
	    public IPersonajeService personajeConfiguration(){
	        return new personajeService();
	    }

	    @Bean
	    public IUserService userConfiguration(){
	        return new userService();
	    }
	    
	    @Bean
	    public IPeliculaService peliculaConfiguration(){
	        return new peliculaService();
	    }


}
