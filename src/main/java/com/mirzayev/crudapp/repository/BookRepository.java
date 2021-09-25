package com.mirzayev.crudapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirzayev.crudapp.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	/* 
	 * With the help of JpaRepository, there is no need to implement those methods:
	 * save()
	 * findOne()
	 * findById()
	 * findAll()
	 * count()
	 * delete()
	 * deleteById() */

	// Query creation from method names
	
	List<Book> findByPublished(boolean published);
	
	// where title like ?1 (parameter wrapped in % like this => '%' + ?1 + '%')
	List<Book> findByTitleContaining(String title);
}
