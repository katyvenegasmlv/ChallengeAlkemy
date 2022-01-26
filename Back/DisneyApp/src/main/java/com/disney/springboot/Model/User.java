package com.disney.springboot.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



//etiqueta entidad
@Entity
//etiqueta que identifica el nombre de la tabla users
@Table(name="users")
public class User implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private long id_users;

	   @Column(length = 50,nullable = false )
	   private String user_name;

	   @Column(length = 50,nullable = false )
	   private String password;

	   @Column(length = 50,nullable = false )
	   private String email;

	   @Column(length = 50,nullable = false )
	   private String last_name;

	   @Column(length = 50 )
     	
	   private String role= "view";
	   

	   public long getId_users(){
	      return id_users;
	   }
	   public void setId_users(long id_users){
	      this.id_users = id_users;
	   }

	   public String getUser_name(){
	      return user_name;
	   }
	   public void setUser_name(String user_name){
	      this.user_name=user_name;
	   }
	   public String getPassword(){
	      return password;
	   }
	   public void setPassword(String password){
	      this.password=password;
	   }

	   public String getEmail(){
	      return email;
	   }
	   public void setEmail(String email){
	      this.email=email;
	   }


	   public String getLast_name(){
	      return last_name;
	   }
	   public void setLast_name(String last_name){
	      this.last_name=last_name;
	   }
	   public String getRole(){
		    
	      return role;
	   }
	   public void setRole(String role){
	      this.role=role;
	      
	      
	   }
	   
	   
	  


}
