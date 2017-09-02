package com.library.service;

import com.library.config.LibraryAppConstants;
import com.library.exception.BookUnavailableException;
import com.library.exception.UserConstraintReachedException;
import com.library.exception.ValidationException;
import com.library.model.BookPojo;
import com.library.store.LibraryBookStoreManager;
import com.library.store.LibraryUserManager;

/**
 * 
 * @author Test
 *
 *user related actions are performed via this interface
 */
public class LibraryUserServiceImpl implements LibraryUserService {

	/**
	 * lending the book from store
	 * 
	 *  - checks whether constraint not violated
	 *  - checks whether book available in store and not given to some one
	 *  - add constraint 
	 *  - reserve book in the store hence no one else allowed to take the same book
	 */
	@Override
	public BookPojo lendBook(String userName, String bookId) throws Exception {

		if (bookId != null && !bookId.isEmpty()) {

			LibraryBookStoreManager manager = LibraryBookStoreManager
					.getInstance();
			LibraryUserManager userMgr = LibraryUserManager.getInstance();
			// check user constraint not reached

			if (!userMgr.checkUserConstraintsReached(userName)) {
				// check book available

				if (manager.checkBookAvailableInStore(bookId)) {

					// increase constraint to 1
					userMgr.addToUserConstraint(userName, bookId);
					// reserve Book
					manager.reserveBookInStore(bookId, userName);
					return manager.getBookFromStore(bookId);
				} else {
					throw new BookUnavailableException(
							LibraryAppConstants.BOOK_UNAVIALABLE,
							LibraryAppConstants.BOOK_UNAVIALABLE_MSG);
				}

			} else {
				throw new UserConstraintReachedException(
						LibraryAppConstants.USER_CONSTRAINT_LIMIT_REACHED,
						LibraryAppConstants.USER_CONSTRAINT_LIMIT_REACHED_MSG);
			}

		}
		return null;
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
	 * returning the book to store
	 * 
	 *  - decrease constraint from user constraints
	 *  - unreserve the book, hence book is ready for some one else.
	 *  - 
	 */
	@Override
	public void returnBook(String userName, String bookId) {

		if (bookId != null && !bookId.isEmpty()) {

			LibraryBookStoreManager manager = LibraryBookStoreManager
					.getInstance();
			LibraryUserManager userMgr = LibraryUserManager.getInstance();

			// decrease user constraint
			userMgr.removeFromUserConstraint(userName, bookId);

			// unreserve the book

			manager.unReserveBookInStore(bookId, userName);

		}

	}

}
