package com.disney.springboot.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.disney.springboot.Services.IPersonajeService;
import com.disney.springboot.Services.IUserService;
import com.disney.springboot.Services.personajeService;
import com.disney.springboot.Services.userService;

@Configuration
public class AppConfiguration {
	
	 @Bean
	    public IPersonajeService productConfiguration(){
	        return new personajeService();
	    }

	    @Bean
	    public IUserService userConfiguration(){
	        return new userService();
	    }

}
