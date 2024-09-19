package com.stella.alephart.models;


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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="userprofile")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_user_profile")
public class UserProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user_profile;
	
	@Column
	private byte[] profile_photo;
	
	@Column
	private byte[] banner;
	
	@Column
	private String about_me;
	
	@Column
	private String profession;
	
	@OneToOne(mappedBy = "userProfile")
    private User user;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id_book", referencedColumnName = "id_book")
    private Book book;

    @OneToMany(mappedBy = "userProfile")
    private List<Posts> posts;

	
	public UserProfile() {}


	public UserProfile(Long id_user_profile, byte[] profile_photo, byte[] banner, String about_me, String profession,
			User user, Book book) {
		super();
		this.id_user_profile = id_user_profile;
		this.profile_photo = profile_photo;
		this.banner = banner;
		this.about_me = about_me;
		this.profession = profession;
		this.user = user;
		this.book = book;
	}


	public Long getId_user_profile() {
		return id_user_profile;
	}


	public void setId_user_profile(Long id_user_profile) {
		this.id_user_profile = id_user_profile;
	}


	public byte[] getProfile_photo() {
		return profile_photo;
	}


	public void setProfile_photo(byte[] profile_photo) {
		this.profile_photo = profile_photo;
	}


	public byte[] getBanner() {
		return banner;
	}


	public void setBanner(byte[] banner) {
		this.banner = banner;
	}


	public String getAbout_me() {
		return about_me;
	}


	public void setAbout_me(String about_me) {
		this.about_me = about_me;
	}


	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	@Override
	public String toString() {
		return "UserProfile [id_user_profile=" + id_user_profile + ", profile_photo=" + Arrays.toString(profile_photo)
				+ ", banner=" + Arrays.toString(banner) + ", about_me=" + about_me + ", profession=" + profession
				+ ", user=" + user + ", book=" + book + "]";
	}


	
	
}