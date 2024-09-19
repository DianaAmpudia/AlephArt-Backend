package com.stella.alephart.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="comments")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_comment")
public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_comment;
	@Column
	private String comment_date;
	@Column
	private String comment_description;
	
	@ManyToOne
    @JoinColumn(name = "posts_id_posts", nullable = false)
    private Posts post;
    
    @ManyToOne
    @JoinColumn(name="user_id_user", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "user_userprofile_id_user_profile", nullable = false)
    private UserProfile userProfile;
	
	public Comments() {}

	public Comments(Long id_comment, String comment_date, String comment_description, Posts post, User user,
			UserProfile userProfile) {
		super();
		this.id_comment = id_comment;
		this.comment_date = comment_date;
		this.comment_description = comment_description;
		this.post = post;
		this.user = user;
		this.userProfile = userProfile;
	}

	public Long getId_comment() {
		return id_comment;
	}

	public void setId_comment(Long id_comment) {
		this.id_comment = id_comment;
	}

	public String getComment_date() {
		return comment_date;
	}

	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}

	public String getComment_description() {
		return comment_description;
	}

	public void setComment_description(String comment_description) {
		this.comment_description = comment_description;
	}

	public Posts getPost() {
		return post;
	}

	public void setPost(Posts post) {
		this.post = post;
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

	@Override
	public String toString() {
		return "Comments [id_comment=" + id_comment + ", comment_date=" + comment_date + ", comment_description="
				+ comment_description + ", post=" + post + ", user=" + user + ", userProfile=" + userProfile + "]";
	}
	
	
}
