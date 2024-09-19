package com.stella.alephart.models;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_book;
	
	@Column
	private byte[] book_photo;
	
	@Column
	private String book_name;
	
	@Column
	private String book_description;
	
	@OneToOne(mappedBy = "book")
    @JsonBackReference("userProfile-book")
    private UserProfile userProfile;
	
	public Book() {}

	public Book(Long id_book, byte[] book_photo, String book_name, String book_description) {
		super();
		this.id_book = id_book;
		this.book_photo = book_photo;
		this.book_name = book_name;
		this.book_description = book_description;
	}

	public Long getId_book() {
		return id_book;
	}

	public void setId_book(Long id_book) {
		this.id_book = id_book;
	}

	public byte[] getBook_photo() {
		return book_photo;
	}

	public void setBook_photo(byte[] book_photo) {
		this.book_photo = book_photo;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_description() {
		return book_description;
	}

	public void setBook_description(String book_description) {
		this.book_description = book_description;
	}

	@Override
	public String toString() {
		return "Book [id_book=" + id_book + ", book_photo=" + Arrays.toString(book_photo) + ", book_name=" + book_name
				+ ", book_description=" + book_description + "]";
	}
	

	
	
}