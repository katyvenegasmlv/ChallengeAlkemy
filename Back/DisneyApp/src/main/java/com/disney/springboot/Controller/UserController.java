package com.disney.springboot.Controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.disney.springboot.Model.User;
import com.disney.springboot.Service.UserService;
import com.disney.springboot.Service.EmailService;

@RestController
//Path despues inicio de la URL
@RequestMapping(path = "/user")
//inicio de la URL
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {

	@Autowired
	private UserService servicio;

	@Autowired
	EmailService emailService;

	/// Metodo para buscar muchos usuarios
	// return un listado de usuarios
	@GetMapping("/GetUsers")
	public List<User> getUsers() {

		List<User> users = new ArrayList<User>();

		users = servicio.findAll();
		return users;
	}

	/// Metodo para crear un usuario
	/// @RequestBody recibe por parametro el usuario
	// return true en caso de exito
	@PostMapping("/InsertUser")
	public long insertUser(@RequestBody User users) {
		long result = 0;

		servicio.save(users);
		

		String toEmail = users.getEmail();
		String body = users.getUser_name() + " te damos la bienvenida a Mundo Disney App" + "\n"
				+ "Tu cuenta se generó correctamente";
		String subject = "Bienvenida";

		emailService.enviarMail(toEmail, body, subject);

		List<User> usuarios = new ArrayList<User>();

		usuarios = servicio.findAll();

		for (User user : usuarios) {

			if (user.getEmail().equals(users.getEmail())) {
				result = user.getId_users();
			}
		}

		return result;
		

	}

	/// Metodo para actualizar un usuario
	/// @RequestBody recibe por parametro el usuario
	// return true en caso de exito
	@RequestMapping(value = "/UpdateUser/{id_users}", method = RequestMethod.PUT)
	public void updateUser(@RequestBody User users) {
		servicio.save(users);
	}

	/// Metodo para buscar un usuario
	/// Recibe por parametro el id
	// return el usuario
	@RequestMapping(value = "/GetUser/{id_users}", method = RequestMethod.POST)
	public User getUser(@PathVariable long id_users) {
		User users = new User();
		users = servicio.findById(id_users);
		return users;
	}

	/// Metodo para eliminar un usuario
	/// Recibe por parametro el usuario
	// return true en caso de exito
	@RequestMapping(value = "/DeleteUser/{id_users}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable long id_users) {
		servicio.deleteById(id_users);
	}

	/// Metodo para buscar un usuario por login y pass
	/// @RequestBody recibe por parametro el usuario
	// return el usuario
	@RequestMapping(value = "/FindUserByEmailAndPass", method = RequestMethod.POST)
	public User findUserByEmailAndPass(@RequestBody User userRequest) {

		User usuario = new User();

		List<User> users = new ArrayList<User>();

		users = servicio.findAll();

		String contraseña = userRequest.getPassword();
	
		byte[] bytesDecodificados = Base64.getDecoder().decode(contraseña);
		String cadenaDecodificada = new String(bytesDecodificados);

	
		for (User user : users) {

			String passwordInterno = user.getPassword();
			
			byte[] bytesDecodificadosInterno = Base64.getDecoder().decode(passwordInterno);
			String password = new String(bytesDecodificadosInterno);
		
			if (user.getEmail().equals(userRequest.getEmail()) && password.equals(cadenaDecodificada)) {
				usuario = user;
			}
		}

		System.out.print(usuario);

		return usuario;
	}

	@RequestMapping(value = "/FindUserByEmail", method = RequestMethod.POST)
	public User findUserByEmail(@RequestBody User userRequest) {

		User usuario = new User();

		List<User> users = new ArrayList<User>();

		users = servicio.findAll();

		for (User user : users) {

			if (user.getEmail().equals(userRequest.getEmail())) {
				usuario = user;
			}
		}

		System.out.print(usuario);

		return usuario;
	}

}
