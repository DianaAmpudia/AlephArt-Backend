package com.stella.alephart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stella.alephart.models.Book;
import com.stella.alephart.models.User;
import com.stella.alephart.models.UserProfile;
import com.stella.alephart.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;


@Service
public class UserService {
	// Inyección de dependencias
	@Autowired
	private UserRepository userRepository;

	public List<User> findAllUsers() {
        return userRepository.findAll();
    }
	
	public Optional<User> findUserById(Long id){
		return userRepository.findById(id);
	}
		
	public User saveUser(User user) {
	    UserProfile userProfile = user.getUserProfile();
	    
	    // Si no se proporciona un UserProfile, crear uno por defecto
	    if (userProfile == null) {
	        userProfile = new UserProfile();
	        userProfile.setAbout_me("Ingresa tu about me aquí");
	        userProfile.setProfession("Ingresa tu profesión");
	        user.setUserProfile(userProfile); // Asignar el perfil al usuario
	    } else {
	        // Si se proporciona un UserProfile pero faltan algunos campos, asignar valores por defecto
	        if (userProfile.getAbout_me() == null) {
	            userProfile.setAbout_me("Ingresa tu about me aquí");
	        }
	        if (userProfile.getProfession() == null) {
	            userProfile.setProfession("Ingresa tu profesión");
	        }
	    }

	    // Si el UserProfile no tiene un Book, crear uno por defecto
	    if (userProfile.getBook() == null) {
	        Book defaultBook = new Book();
	        defaultBook.setBook_name("Portafolio");
	        defaultBook.setBook_description("Ingresa una descripción para tu portafolio.");
	        userProfile.setBook(defaultBook); 
	    }

	    // Guardar el usuario (junto con el UserProfile y el Book, si existen)
	    return userRepository.save(user);
	}

	
	public User updateUser(Long id, User user) {
		Optional<User> existingUserOptional = userRepository.findById(id);
		
		if (existingUserOptional.isPresent()) {
			User existingUser = existingUserOptional.get();
			// Actualizar datos de usuario === JUST IN CASE ===
			//existingUser.setFirst_name(user.getFirst_name());
			//existingUser.setLast_name(user.getLast_name());
			//existingUser.setEmail(user.getEmail());
			//existingUser.setPhone_number(user.getPhone_number());
			existingUser.setPassword(user.getPassword());
			
			return userRepository.save(user);
		} else {
			throw new RuntimeException("Usuario no encontrado");
		}
	}
	
	public void deleteUser(Long id) {
	    User existingUser = userRepository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
	    userRepository.delete(existingUser);
	}

}
