package com.stella.alephart.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stella.alephart.models.Book;
import com.stella.alephart.repository.BookRepository;

@Service
public class BookService {

	// Inyección de dependencias 
		@Autowired
		private BookRepository bookRepository;
		// GET all
		public List<Book> findAllBooks(){
			return bookRepository.findAll();
		}
		// GET single
		public Optional<Book> findBookById(Long id){
			return bookRepository.findById(id);
		}	
		// POST
		public Book saveBook(Book book) {
			return bookRepository.save(book);
		}
		// PUT #EDIT
		public Book updateBook(Long id, Book book) {
			Optional<Book> existingBookOptional = bookRepository.findById(id);
			
			// Si el book existe...
			if (existingBookOptional.isPresent()) {
				Book existingBook = existingBookOptional.get();
				
				// Actualizar datos del book
				existingBook.setBook_photo(book.getBook_photo());
				existingBook.setBook_name(book.getBook_name());
				existingBook.setBook_description(book.getBook_description());
				
				//Guardar el book actualizado
				return bookRepository.save(existingBook);
			} else {
				// Si no se encuentra el book
				throw new RuntimeException("Book no encontrado");
			}	
		}
		
		
		// DELETE 
		public void deleteBook(Long id) {
			bookRepository.deleteById(id);
		}
		
		
	}
	
	
	

