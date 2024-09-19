package com.stella.alephart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stella.alephart.models.User;
import com.stella.alephart.services.UserService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build(); // HTTP 204 No Content si la lista está vacía
        }
        return ResponseEntity.ok(users);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getId_user(@PathVariable("id") Long id) {
		return userService.findUserById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PutMapping("/{id}") // No tendría que ser por first_name??
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id, 
											@RequestBody User updatedUser) {
        return userService.findUserById(id)
            .map(user -> {
                user.setPassword(updatedUser.getPassword());
                userService.saveUser(user); 
                return ResponseEntity.ok(user);
            })
            .orElse(ResponseEntity.notFound().build());
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
	    try {
	        userService.deleteUser(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (EntityNotFoundException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	/*
	 * 
	
	POST
	 
	{
	"first_name": "Nombre",
	"last_name": "Apellido",
	"phone_number": "5612836477",
	"password": "password@Us",
	"email": "usuario@gmail.com"
	}

	 * 
	 * */


}
