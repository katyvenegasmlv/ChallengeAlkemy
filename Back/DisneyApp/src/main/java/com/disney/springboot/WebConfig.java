package com.disney.springboot;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
@EnableWebMvc

public class WebConfig implements WebMvcConfigurer{
	
	@Override
	 public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	        .allowedOrigins("http://localhost:3000")
	        .allowedMethods("GET", "POST","PUT", "DELETE", "OPTIONS")
	        .allowedHeaders("Accept", "Origin", "Content-Type", "Depth", "User-Agent", "If-Modified-Since,",
	                "Cache-Control", "Authorization", "X-Req", "X-File-Size", "X-Requested-With", "X-File-Name","multipart/form-data")
	        .maxAge(0);
	
	 }

      

	
	
}
