package com.disney.springboot.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//etiqueta entidad
@Entity
//etiqueta que identifica el nombre de la tabla productos
@Table(name = "genero")
public class Genero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id_genero;

	@Column(length = 50, nullable = false)
	private String nombre;

	@Column(nullable = true)
	private byte[] picture;

	public Genero() {}

	public Genero(long id_genero) {
	    this.id_genero = id_genero;
	}
	
	public long getId_genero() {
		return id_genero;
	}

	public void setId_genero(long id_genero) {
		this.id_genero = id_genero;
	}

	public String getnombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public byte[] getpicture() {
		return picture;
	}

	public void setpicture(byte[] picture) {
		this.picture = picture;
	}

}
