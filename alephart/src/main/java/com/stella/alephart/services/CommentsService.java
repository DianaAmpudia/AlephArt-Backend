package com.stella.alephart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stella.alephart.dto.CommentDTO;
import com.stella.alephart.dto.CommentUpdateDTO;
import com.stella.alephart.models.Comments;
import com.stella.alephart.models.Posts;
import com.stella.alephart.models.User;
import com.stella.alephart.repository.CommentsRepository;
import com.stella.alephart.repository.PostsRepository;
import com.stella.alephart.repository.UserRepository;

@Service
public class CommentsService {
	
		@Autowired
		private CommentsRepository commentRepository;
		
	    @Autowired
	    private PostsRepository postsRepository;

	    @Autowired
	    private UserRepository userRepository;

		
		public List<Comments> findAllComments(){
			return commentRepository.findAll();
		}
		
		public Optional<Comments> findCommentsById(Long id) {
			return commentRepository.findById(id);
		}
	
	
		 public Comments saveComment(CommentDTO commentDTO) {
		        Posts post = postsRepository.findById(commentDTO.getPostId())
		            .orElseThrow(() -> new RuntimeException("Post con id " + commentDTO.getPostId() + " no encontrado"));
		        
		        User user = userRepository.findById(commentDTO.getUserId())
		            .orElseThrow(() -> new RuntimeException("Usuario con id " + commentDTO.getUserId() + " no encontrado"));
		        
		        Comments comment = new Comments();
		        comment.setComment_date(commentDTO.getCommentDate());
		        comment.setComment_description(commentDTO.getCommentDescription());
		        comment.setPost(post);
		        comment.setUser(user);
		        comment.setUserProfile(user.getUserProfile());
		        
		        return commentRepository.save(comment);
		    }
		
		
		 public Comments updateComment(Long id, CommentUpdateDTO commentUpdateDTO) {
		        Comments comment = commentRepository.findById(id)
		            .orElseThrow(() -> new RuntimeException("Comentario con id " + id + " no encontrado"));
		        
		        comment.setComment_description(commentUpdateDTO.getCommentDescription());
		        
		        return commentRepository.save(comment);
		    }
		
		
		public void deleteComment(Long id) {
			commentRepository.deleteById(id);
		}
}
