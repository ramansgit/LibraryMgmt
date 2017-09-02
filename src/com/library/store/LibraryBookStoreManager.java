package com.library.store;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.library.config.LibraryAppConstants;
import com.library.exception.BookUnavailableException;
import com.library.model.BookPojo;

/**
 * class responsible for managing books in the store. This store is managed by
 * admin user only.
 * 
 * @author Test
 *
 */
public class LibraryBookStoreManager {

	private static volatile LibraryBookStoreManager bookInstance;

	/**
	 * map for managing book objects in the store.
	 */
	private static Map<String, BookPojo> bookStoreMap = new ConcurrentHashMap<String, BookPojo>();

	/**
	 * map for performing author search in the store
	 */
	private static Map<String, String> bookByAuthorMap = new ConcurrentHashMap<String, String>();

	/**
	 * map for performing title search in the store
	 */
	private static Map<String, String> bookByTitleMap = new ConcurrentHashMap<String, String>();

	private LibraryBookStoreManager() {

	}

	/**
	 * singleton class
	 * 
	 * @return
	 */
	public static LibraryBookStoreManager getInstance() {
		if (bookInstance == null) {
			synchronized (LibraryBookStoreManager.class) {
				bookInstance = new LibraryBookStoreManager();
			}
		}
		return bookInstance;
	}

	/**
	 * add book to system
	 * 
	 * @param user
	 */
	public void addBookToStore(BookPojo book) {
		bookStoreMap.put(book.getBookId(), book);
		bookByAuthorMap.put(book.getAuthor(), book.getBookId());
		bookByTitleMap.put(book.getTitle(), book.getBookId());
	}
	
	/**
	 * returns book from pojo
	 * @param bookId
	 * @return
	 */
	public BookPojo getBookFromStore(String bookId){
		
		return bookStoreMap.get(bookId);
	}

	/**
	 * search book by title
	 * 
	 * @param title
	 * @return
	 * @throws BookUnavailableException
	 */
	public BookPojo searchByTitle(String title) throws BookUnavailableException {

		String bookId = bookByTitleMap.get(title);

		BookPojo book = bookStoreMap.get(bookId);
		if (book == null) {
			throw new BookUnavailableException(
					LibraryAppConstants.BOOK_UNAVIALABLE,
					LibraryAppConstants.BOOK_UNAVIALABLE_MSG);
		}
		return book;
	}

	/**
	 * search book by author
	 * 
	 * @param title
	 * @return
	 * @throws BookUnavailableException
	 */
	public BookPojo searchByAuthor(String title)
			throws BookUnavailableException {

		String bookId = bookByAuthorMap.get(title);

		BookPojo book = bookStoreMap.get(bookId);
		if (book == null) {
			throw new BookUnavailableException(
					LibraryAppConstants.BOOK_UNAVIALABLE,
					LibraryAppConstants.BOOK_UNAVIALABLE_MSG);
		}
		return book;
	}

	/**
	 * 
	 * @param bookId
	 * @return
	 */
	public boolean checkBookAvailableInStore(String bookId) {
		BookPojo pojo = bookStoreMap.get(bookId);
		if (!pojo.isIslendeded()) {
			return true;
		}
		return false;
	}

	/**
	 * reserve the book
	 * @param bookId
	 * @return
	 */
	public void reserveBookInStore(String bookId, String userId) {
		BookPojo pojo = bookStoreMap.get(bookId);

		pojo.setIslendeded(true);
		pojo.setLendedTo(userId);

		bookStoreMap.put(bookId, pojo);
	}

	/**
	 * unReserveBookfromStore
	 * @param bookId
	 * @return
	 */
	public void unReserveBookInStore(String bookId, String userId) {
		BookPojo pojo = bookStoreMap.get(bookId);

		pojo.setIslendeded(false);
		pojo.setLendedTo("");

		bookStoreMap.put(bookId, pojo);
	}

}
