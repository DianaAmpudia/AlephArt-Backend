package com.stella.alephart.models;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="posts")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_posts")
public class Posts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_posts")
	private Long id_posts;
	
	@Column(name="posts_date")
	private String post_date;
	
	@Column(name="posts_description")
	private String post_description;
	
	@Column(name="post_file")
	private byte[] post_file;
	
	//FK user_id_user
	//FK user_userprofile_id_user_profile
	
	@ManyToOne
    @JoinColumn(name="user_id_user", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "user_userprofile_id_user_profile", nullable = false)
    private UserProfile userProfile;
    
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comments> comments = new ArrayList<>();
	
	public Posts() {}

	public Posts(Long id_posts, String post_date, String post_description, byte[] post_file, User user,
			UserProfile userProfile, List<Comments> comments) {
		super();
		this.id_posts = id_posts;
		this.post_date = post_date;
		this.post_description = post_description;
		this.post_file = post_file;
		this.user = user;
		this.userProfile = userProfile;
		this.comments = comments;
	}

	public Long getId_posts() {
		return id_posts;
	}

	public void setId_posts(Long id_posts) {
		this.id_posts = id_posts;
	}

	public String getPost_date() {
		return post_date;
	}

	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}

	public String getPost_description() {
		return post_description;
	}

	public void setPost_description(String post_description) {
		this.post_description = post_description;
	}

	public byte[] getPost_file() {
		return post_file;
	}

	public void setPost_file(byte[] post_file) {
		this.post_file = post_file;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comments comment) {
        comments.add(comment);
        comment.setPost(this);
    }
    
    public void removeComment(Comments comment) {
        comments.remove(comment);
        comment.setPost(null);
    }

	@Override
	public String toString() {
		return "Posts [id_posts=" + id_posts + ", post_date=" + post_date + ", post_description=" + post_description
				+ ", post_file=" + Arrays.toString(post_file) + ", user=" + user + ", userProfile=" + userProfile
				+ ", comments=" + comments + "]";
	}
	
	

	
}