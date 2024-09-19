package com.stella.alephart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stella.alephart.models.Book;
import com.stella.alephart.services.BookService;



@RestController
@RequestMapping("/api/books")
public class BooksController {

	//inyección	
		@Autowired
		private BookService bookService; 

	//métodos para el CRUD
		
		//GET 
		@GetMapping
		public List<Book> getAllBooks() {
				return bookService.findAllBooks();
		}

		//Get para un sólo book
		@GetMapping("/{id}") 
		public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
				return bookService.findBookById(id)
						.map(ResponseEntity::ok) 
						.orElse(ResponseEntity.notFound().build()); 
		}
		// POST
		@PostMapping
		public Book createBook(@RequestBody Book book) {
			return bookService.saveBook(book);
		}
		
		//PUT #EDIT
		@PutMapping("/{id}")
		public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
		    try {
		        Book updatedBook = bookService.updateBook(id, book);
		        return ResponseEntity.ok(updatedBook); 
		    } catch (RuntimeException e) {
		        return ResponseEntity.notFound().build(); 
		    }
		}
		
		//DELETE
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id){
			return bookService.findBookById(id) 
						.map(book ->{
							bookService.deleteBook(id);
							return ResponseEntity.ok().<Void>build(); 
						})
						.orElse(ResponseEntity.notFound().build()); 
		}

		/*
		 * 	 
		 PUT
		/api/books/12
		 **Se coloca el ID del book que se quiere modificar en la URL

		{
		"book_photo": null,
		"book_name": "Nombre del portafolio actualizado",
		"book_description": "Descripción del portafolio actualizado."
		}
		 
		 * 
		 * */
	
	
}
