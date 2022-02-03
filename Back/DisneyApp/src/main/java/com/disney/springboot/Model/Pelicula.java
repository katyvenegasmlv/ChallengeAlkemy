package com.disney.springboot.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//etiqueta entidad
@Entity
@Table(name = "pelicula")
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pelicula;

	@Column(length = 50, nullable = false)
	private String title;
	
	@ManyToMany (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "pelicula_personaje", 
	joinColumns = @JoinColumn(name = "id_pelicula", nullable = false), 
	inverseJoinColumns = @JoinColumn(name = "id_personaje", nullable = false))
	@JsonIgnoreProperties(value= {"pelicula"})
	private List<Personaje> personaje;
	
	

	@Column(nullable = false)
	private double calificacion;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date fecha;

	@Column(nullable = true)
	private String picture;

	@ManyToOne()
	@JoinColumn(name = "id_genero")
	private Genero id_genero;


	public Pelicula() {}
	
	public long getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(long id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}




	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Genero getId_genero() {
		return id_genero;
	}

	public void setId_genero(Genero id_genero) {
		this.id_genero = id_genero;
	}
	
	public List<Personaje> getPersonajes() {
        return personaje;
    }

    public void setPersonajes(List<Personaje> personaje) {
        this.personaje = personaje;
    }



}
