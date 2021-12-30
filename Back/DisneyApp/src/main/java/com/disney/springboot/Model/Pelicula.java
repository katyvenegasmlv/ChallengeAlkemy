package com.disney.springboot.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

//etiqueta entidad
@Entity
//etiqueta que identifica el nombre de la tabla productos
@Table(name="pelicula")
public class Pelicula {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id_pelicula;

    @Column(length = 50,nullable = false )
    public String title;

    @Column(length = 50,nullable = false )
    public String category;

    @Column(length = 50)
    public String personaje;

    @Column(nullable = false )
    public double calificacion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date fecha;

    @Column(nullable = true )
    public byte[] picture;

    public long getId_personaje(){
        return id_pelicula;
    }
    public void setId_pelicula(long id_pelicula){
        this.id_pelicula = id_pelicula;
    }

    public String gettitle(){
        return title;
    }
    public void settitle(String title){
        this.title=title;
    }

    public String getcategory(){
        return category;
    }
    public void setcategory(String category){
        this.category=category;
    }
    
    public String getpersonaje(){
        return personaje;
    }
    public void setpersonaje(String personaje){
        this.personaje=personaje;
    }

    public double getcalificacion(){
         return calificacion;
    }
    public void setcalificacion(double calificacion){
        this.calificacion=calificacion;
    }
    

    public Date getfecha(){
        return fecha;
    }
    public void setdate (Date fecha){
        this.fecha=fecha;
    }
    
    public byte[] getpicture(){
        return picture;
    }
    public void setpicture (byte[] picture){
        this.picture=picture;
    }

}
