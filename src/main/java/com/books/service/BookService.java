package com.books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.model.Book;
import com.books.model.Employee;
import com.books.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private EmployeeClient employeeClient;
	
	public BookRepository getRepository() {
		return this.repository;
	}
	
	public EmployeeClient getEmployeeClient() {
		return this.employeeClient;
	}

	public List<Book> getBooks() {
		return this.getRepository().findAll();
	}
	
	public void saveBook(Book book) {
		this.getRepository().save(book);
	}
	
	public void deleteBook(Integer id) {
		this.getRepository().deleteById(id);
	}
	
	public Optional<Book> viewBook(Integer id) {
		return this.getRepository().findById(id);
	}
	
	public List<Employee> getEmployees() {	
		System.out.println("Book Service getEmployees method called");
		return this.getEmployeeClient().getAll();
	}
}
