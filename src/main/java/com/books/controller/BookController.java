package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.model.Book;
import com.books.model.Employee;
import com.books.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService service;
	
	public BookService getService() {
		return this.service;
	}
	
	@GetMapping
	public List<Book> getAllBooks() {
		return this.getService().getBooks();
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return this.getService().getEmployees();
	}
	
	@PostMapping
	public void saveBook(@RequestBody Book book) {
		this.getService().saveBook(book);
	}
	
	@GetMapping("/{id}")
	public Book getBook(@PathVariable Integer id) {
		return this.getService().viewBook(id).orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Integer id) {
		this.getService().deleteBook(id);
	}
}
