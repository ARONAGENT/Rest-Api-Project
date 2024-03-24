package com.RestApi.SpringRestApi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestApi.SpringRestApi.Entities.Books;

public interface BooksRepository extends JpaRepository<Books, String> {
	List<Books> findByAuthor(String author);
	Books findByBookid(String bookid);
	List<Books> findByGenre(String genre);
	List<Books> findByPriceLessThan(float price);
	List<Books> findByGenreAndLanguage(String genre,String language);
	List<Books> findByPublicationyear(int publicationyear);
	List<Books> findByPagesLessThan(int pages);

}
