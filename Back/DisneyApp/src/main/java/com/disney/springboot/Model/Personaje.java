package com.disney.springboot.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//etiqueta entidad
@Entity
//etiqueta que identifica el nombre de la tabla productos
@Table(name="personaje")
public class Personaje {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id_personaje;

    @Column(length = 50,nullable = false )
    public String name;

    @Column(length = 50,nullable = false )
    public String category;

    @Column(length = 50)
    public String description;

    @Column(nullable = false )
    public double peso;

    @Column(nullable = false )
    public double edad;

    @Column(nullable = true )
    public String picture;

    public long getId_personaje(){
        return id_personaje;
    }
    public void setId_personaje(long id_personaje){
        this.id_personaje = id_personaje;
    }

    public String getname(){
        return name;
    }
    public void setname(String name){
        this.name=name;
    }

    public String getcategory(){
        return category;
    }
    public void setcategory(String category){
        this.category=category;
    }
    
    public String getdescription(){
        return description;
    }
    public void setdescription(String description){
        this.description=description;
    }

    public double getpeso(){
         return peso;
    }
    public void setpeso(double peso){
        this.peso=peso;
    }
    

    public double getedad(){
        return edad;
    }
    public void setedad (double edad){
        this.edad=edad;
    }
    
    public String getpicture(){
        return picture;
    }
    public void setpicture (String picture){
        this.picture=picture;
    }


}
