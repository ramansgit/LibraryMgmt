package com.library.service;

import com.library.exception.BookUnavailableException;
import com.library.exception.UserNotFoundException;
import com.library.exception.ValidationException;
import com.library.model.BookPojo;
import com.library.model.UserPojo;

/**
 * admin related actions are done via this interface.
 * @author Test
 *
 */
public interface LibraryAdminService {



	
	/**
	 * allows user to request for a book
	 * @param title
	 */
	public void addBook(BookPojo book)  throws ValidationException;
	
	/**
	 * allows admin to add user to the system
	 * @param title
	 */
	public void addUserToSystem(UserPojo user)  throws ValidationException;
	
	/**
	 * allows admin to search a book by title.
	 * @param id
	 */
	public  BookPojo searchBookByTitle(String title) throws BookUnavailableException,ValidationException;
	
	
	/**
	 * allows admin to search a book by author name
	 * @param author
	 */
	public  BookPojo searchBookByAuthor(String author)throws BookUnavailableException,ValidationException;
	
	/**
	 * allows admin to search user by name
	 * @param author
	 * @throws UserNotFoundException 
	 */
	public  UserPojo searchUserByName(String userName)throws ValidationException, UserNotFoundException;
}
