package com.disney.springboot.Model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

//etiqueta entidad
@Entity
//etiqueta que identifica el nombre de la tabla productos
@Table(name = "pelicula")
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id_pelicula;
	@ManyToMany(mappedBy= "likedPeliculas")
    Set<Personaje> likes;

	@Column(length = 50, nullable = false)
	private String title;


	@Column(length = 50)
	private String personaje;

	@Column(nullable = false)
	private double calificacion;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date fecha;

	@Column(nullable = true)
	private byte[] picture;

    @ManyToOne()
	@JoinColumn(name="id_genero")
	private Genero id_genero;

 
	public long getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(long id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}


	public String getpersonaje() {
		return personaje;
	}

	public void setpersonaje(String personaje) {
		this.personaje = personaje;
	}

	public double getcalificacion() {
		return calificacion;
	}

	public void setcalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public Date getfecha() {
		return fecha;
	}

	public void setdate(Date fecha) {
		this.fecha = fecha;
	}

	public byte[] getpicture() {
		return picture;
	}

	public void setpicture(byte[] picture) {
		this.picture = picture;
	}

	public Genero getId_genero() {
		return id_genero;
	}

	public void setId_genero(Genero id_genero) {
		this.id_genero = id_genero;
	}



}
