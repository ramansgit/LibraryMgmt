package com.library.service;

import com.library.exception.BookUnavailableException;
import com.library.exception.ValidationException;
import com.library.model.BookPojo;

public interface LibraryUserService {


	
	/**
	 * allows user to request for a book
	 * @param title
	 */
	public BookPojo lendBook(String userName,String bookId) throws Exception;
	
	
	

	/**
	 * allows user to return a book
	 * @param id
	 */
	public void returnBook(String userName,String id);


	/**
	 * allows user to search book by title
	 * @param title
	 */
	public BookPojo searchBookByTitle(String title) throws BookUnavailableException,
			ValidationException;

	/**
	 * allows user to search book by author
	 * @param title
	 */
	public BookPojo searchBookByAuthor(String author) throws BookUnavailableException,
	ValidationException;


	
}
