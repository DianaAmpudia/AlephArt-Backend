package com.stella.alephart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stella.alephart.models.UserProfile;
import com.stella.alephart.repository.UserProfileRepository;

@Service
public class UserProfileService {
	// inyección
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	public List<UserProfile> findAllUsersProfiles(){
		return userProfileRepository.findAll();
	}
	
	public Optional<UserProfile> findUserById(Long id) {
		return userProfileRepository.findById(id);
	}
	
	public UserProfile saveUserProfile(UserProfile userProfile) {
		return userProfileRepository.save(userProfile);
	}
	
	public Optional<UserProfile> updateUserProfile(Long id, UserProfile updatedProfile) {
        Optional<UserProfile> existingProfile = userProfileRepository.findById(id);

        if (existingProfile.isPresent()) {
            UserProfile profile = existingProfile.get();

            // Actualizar/modificar
            profile.setProfile_photo(updatedProfile.getProfile_photo());
            profile.setBanner(updatedProfile.getBanner());
            profile.setAbout_me(updatedProfile.getAbout_me());
            profile.setProfession(updatedProfile.getProfession());

            userProfileRepository.save(profile);
            return Optional.of(profile); // Devuelve el perfil actualizado

        } else {
            return Optional.empty(); // Si no se encuentra, devuelve un Optional vacío
        }
    }
	
	public void deleteUserProfile(Long id) {
		userProfileRepository.deleteById(id);
	}
	
}
