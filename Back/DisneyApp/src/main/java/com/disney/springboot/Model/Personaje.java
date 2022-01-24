package com.disney.springboot.Model;


import java.util.Set;

import javax.persistence.*;

//etiqueta entidad
@Entity
//etiqueta que identifica el nombre de la tabla personaje
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

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category=category;
    }
    
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public double getPeso(){
         return peso;
    }
    public void setPeso(double peso){
        this.peso=peso;
    }
    

    public double getEdad(){
        return edad;
    }
    public void setEdad (double edad){
        this.edad=edad;
    }
    
    public String getPicture(){
        return picture;
    }
    public void setPicture (String picture){
        this.picture=picture;
    }


}
