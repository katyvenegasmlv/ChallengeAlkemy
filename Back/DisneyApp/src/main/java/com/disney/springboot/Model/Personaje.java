package com.disney.springboot.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

//etiqueta entidad
@Entity
//etiqueta que identifica el nombre de la tabla productos
@Table(name="personaje")
public class Personaje {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id_personaje;
	
    @ManyToMany
    @JoinTable(
            name = "pelicula_personaje",
            joinColumns = @JoinColumn(name = "id_personaje", nullable = false),
            inverseJoinColumns = @JoinColumn(name="id_pelicula", nullable = false)
        )
    Set<Pelicula> likedPeliculas;

    @Column(length = 50,nullable = false )
    private String name;

    @Column(length = 50,nullable = false )
    private String category;

    @Column(length = 50)
    private String description;

    @Column(nullable = false )
    private double peso;

    @Column(nullable = false )
    private double edad;

    @Column(nullable = true )
    private String picture;
    
  
     //   @ManyToMany(cascade = CascadeType.ALL)
    //    private List<Pelicula> peliculas;
       
   //     public void addPelicula(Pelicula pelicula){
    //        if(this.peliculas == null){
     //           this.peliculas = new ArrayList<>();
     //       }
            
      //      this.peliculas.add(pelicula);
     //   }


   

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
