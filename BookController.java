package com.RestApi.SpringRestApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RestApi.SpringRestApi.Entities.Books;
import com.RestApi.SpringRestApi.Services.BookServices;

@RestController
@RequestMapping("/bookapi")
public class BookController {
	
	@Autowired
	private BookServices bookServ;
	
	
	@GetMapping("/allBooks")
	public List<Books> retrivedBooks(Books obj)
	{
		return bookServ.getallBooks(obj);
	}
	
	@GetMapping("/genre/{genre}")
	public List<Books> getgenre(@PathVariable String genre){
		return bookServ.getGenreOfBook(genre);
	}
	
	@GetMapping("/author/{author}")
	public List<Books> getauthor(@PathVariable String author)
	{
		return bookServ.getAuthorOfBook(author);
	}
	
	@PostMapping("/addbook")
	public Books addbooks(@RequestBody Books obj)
	{
		return bookServ.addBook(obj);
	}

	@PutMapping("/updatebook")
	public Books updateBook(@RequestParam String bookid,@RequestParam float price)
	{
		return bookServ.editbook(bookid, price);
	}
	
	@DeleteMapping("/deletebook")
	public String deleteBooks(@RequestParam String bookid)
	{
		return bookServ.removeBook(bookid);
	}
}
