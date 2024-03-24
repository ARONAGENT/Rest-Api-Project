package com.RestApi.SpringRestApi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestApi.SpringRestApi.Entities.Books;
import com.RestApi.SpringRestApi.Repository.BooksRepository;

@Service
public class BookServices {

	@Autowired
	private BooksRepository bookRepo;
	
	public List<Books> getallBooks(Books obj)
	{
		List<Books> blist=bookRepo.findAll();
		return blist;
	}
	
	public List<Books> getGenreOfBook(String genre)
	{
		List<Books> genrelist=bookRepo.findByGenre(genre);
		
		return genrelist;
	}
	 
	public List<Books> getAuthorOfBook(String author)
	{
		List<Books> authorlist=bookRepo.findByAuthor(author);
	
		return authorlist;
	}
	
	public Books addBook(Books obj)
	{
		return bookRepo.save(obj);
	}
	
	public Books editbook(String bookid,float price)
	{
		 Books obj=bookRepo.findByBookid(bookid);
		 obj.setPrice(price);
		  bookRepo.save(obj);
		  return obj;
	}
	
	public String removeBook(String bookid)
	{
		Books obj=bookRepo.findByBookid(bookid);
		String stat="";
		if(obj!=null)
		{
			bookRepo.delete(obj);
			 stat= "Book Delete Succesfully";	
		}
		else
		{
			 stat="Invalied BookId";
		}
		
		return stat;
	}
	
}
