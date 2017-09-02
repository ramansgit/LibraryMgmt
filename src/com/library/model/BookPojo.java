package com.library.model;

/**
 * caries book information in the system
 * @author Test
 *
 */
public class BookPojo {

	private String bookId;
	private String author;
	
	public boolean isIslendeded() {
		return islendeded;
	}
	public void setIslendeded(boolean islendeded) {
		this.islendeded = islendeded;
	}
	public String getLendedTo() {
		return lendedTo;
	}
	public void setLendedTo(String lendedTo) {
		this.lendedTo = lendedTo;
	}
	private boolean islendeded;

	private String lendedTo;
	private String title;
	
	private long price;
	private String publication;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	@Override
	public String toString() {
		return "BookPojo [bookId=" + bookId + ", author=" + author
				+ ", islendeded=" + islendeded + ", lendedTo=" + lendedTo
				+ ", title=" + title + ", price=" + price + ", publication="
				+ publication + "]";
	}
	
	
	
	
	
}
