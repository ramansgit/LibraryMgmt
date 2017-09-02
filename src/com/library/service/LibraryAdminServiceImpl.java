package com.library.service;

import com.library.config.LibraryAppConstants;
import com.library.exception.BookUnavailableException;
import com.library.exception.UserNotFoundException;
import com.library.exception.ValidationException;
import com.library.model.BookPojo;
import com.library.model.UserPojo;
import com.library.store.LibraryBookStoreManager;
import com.library.store.LibraryUserManager;

/**
 * responsible for library admin to perform actions in the system
 * @author Test
 *
 */
public class LibraryAdminServiceImpl implements LibraryAdminService {

	/**
	 * add book to to system
	 * 
	 * @throws ValidationException
	 */
	@Override
	public void addBook(BookPojo book) throws ValidationException {

		LibraryBookStoreManager manager = LibraryBookStoreManager.getInstance();
		if (book != null) {
			manager.addBookToStore(book);
			
		}
		else{
		throw new ValidationException(LibraryAppConstants.BAD_REQUEST,
				LibraryAppConstants.BAD_REQUEST_MSG);
		}
	}

	/**
	 * search by title
	 * 
	 * @throws ValidationException
	 */
	@Override
	public BookPojo searchBookByTitle(String title)
			throws BookUnavailableException, ValidationException {

		LibraryBookStoreManager manager = LibraryBookStoreManager.getInstance();

		if (title != null && !title.isEmpty()) {
			return manager.searchByTitle(title);

		}
		throw new ValidationException(LibraryAppConstants.BAD_REQUEST,
				LibraryAppConstants.BAD_REQUEST_MSG);

	}

	/**
	 * search by author
	 * 
	 * @throws ValidationException
	 */
	@Override
	public BookPojo searchBookByAuthor(String author)
			throws BookUnavailableException, ValidationException {

		LibraryBookStoreManager manager = LibraryBookStoreManager.getInstance();
		if (author != null && !author.isEmpty()) {
			return manager.searchByAuthor(author);

		}

		throw new ValidationException(LibraryAppConstants.BAD_REQUEST,
				LibraryAppConstants.BAD_REQUEST_MSG);

	}

	/**
	 * search user ny name
	 * 
	 * @param userName
	 * @return
	 * @throws BookUnavailableException
	 * @throws ValidationException
	 * @throws UserNotFoundException
	 */
	@Override
	public UserPojo searchUserByName(String userName)
			throws ValidationException, UserNotFoundException {

		LibraryUserManager manager = LibraryUserManager.getInstance();
		if (userName != null && !userName.isEmpty()) {
			return manager.searchUserByName(userName);

		}

		throw new ValidationException(LibraryAppConstants.BAD_REQUEST,
				LibraryAppConstants.BAD_REQUEST_MSG);

	}

	/**
	 * adds user to the system
	 */
	@Override
	public void addUserToSystem(UserPojo user) throws ValidationException {
		// TODO Auto-generated method stub
		LibraryUserManager manager = LibraryUserManager.getInstance();
		manager.addUsers(user);
	}

}
