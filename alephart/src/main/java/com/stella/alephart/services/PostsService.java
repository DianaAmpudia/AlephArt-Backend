package com.stella.alephart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stella.alephart.dto.PostCreateDTO;
import com.stella.alephart.models.Posts;
import com.stella.alephart.models.User;
import com.stella.alephart.models.UserProfile;
import com.stella.alephart.repository.PostsRepository;
import com.stella.alephart.repository.UserProfileRepository;
import com.stella.alephart.repository.UserRepository;

@Service
public class PostsService {
	
	@Autowired
    private PostsRepository postRepository;
    
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private UserProfileRepository userProfileRepository;
    
	//GET
	
	public List<Posts> findAllPosts(){
		return postRepository.findAll();
	}
	
	public Optional <Posts> findPostById(Long id){
		return postRepository.findById(id);
	}
	
	//POST
	public Posts savePost(PostCreateDTO postCreateDTO) {
        User user = userRepository.findById(postCreateDTO.getUserId())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        UserProfile userProfile = userProfileRepository.findById(postCreateDTO.getUserProfileId())
            .orElseThrow(() -> new RuntimeException("UserProfile no encontrado"));

        Posts post = new Posts();
        post.setPost_date(postCreateDTO.getPost_date());
        post.setPost_file(postCreateDTO.getPost_file()); 
        post.setPost_description(postCreateDTO.getPost_description());
        post.setUser(user);
        post.setUserProfile(userProfile); 

        return postRepository.save(post);
    }
	
	
	//GET
	//updatedPost es un objeto que contiene los datos actualizados.
	public Posts updatePost(Long id, Posts updatedPost) {
        return postRepository.findById(id)
            .map(currentPost -> {
                currentPost.setPost_description(updatedPost.getPost_description());
                return postRepository.save(currentPost);
            })
            .orElseThrow(() -> new RuntimeException("Publicación con el id " + id + " no encontrada"));
    }
	
	//DELETE
	
	public void deletePost(Long id) {
		postRepository.deleteById(id);
	}
	

}