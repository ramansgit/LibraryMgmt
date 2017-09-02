package com.library.test;

import java.util.Scanner;

import com.library.exception.ValidationException;
import com.library.model.BookPojo;
import com.library.model.UserPojo;
import com.library.service.LibraryAdminService;
import com.library.service.LibraryAdminServiceImpl;
import com.library.service.LibraryUserService;
import com.library.service.LibraryUserServiceImpl;

public class TestLibraryAdminInterface {

	public static void main(String[] args) {

		LibraryUserService userInterface = new LibraryUserServiceImpl();

		LibraryAdminService adminInterface = new LibraryAdminServiceImpl();
		Scanner sc = new Scanner(System.in);

		System.out.println("Please provide your inputs");

		System.out.println("0 for adding books to store");
		System.out.println("1 for adding users to store");
		System.out.println("2 for lending book");
		System.out.println("3 for returning book ");

		System.out.println("4 for search by author");

		System.out.println("5 for search by title");

		System.out.println("6 for search by userName");

		System.out.println("7 for exit");

		while (sc.hasNext()) {

			int input = sc.nextInt();
			/**
			 * we can use builder pattern here.
			 * 
			 * 
			 */

			if (input == 0) {

				BookPojo pojo = new BookPojo();
				pojo.setAuthor("Ramesh");
				pojo.setBookId("1");
				pojo.setTitle("C");

				BookPojo pojo1 = new BookPojo();
				pojo1.setAuthor("Sathish");
				pojo1.setBookId("2");
				pojo1.setTitle("Java");

				BookPojo pojo2 = new BookPojo();
				pojo2.setAuthor("suresh");
				pojo2.setBookId("3");
				pojo2.setTitle("c++");

				BookPojo pojo3 = new BookPojo();
				pojo3.setAuthor("sachin");
				pojo3.setBookId("4");
				pojo3.setTitle("sachin");

				try {
					adminInterface.addBook(pojo);
					adminInterface.addBook(pojo1);
					adminInterface.addBook(pojo2);
					adminInterface.addBook(pojo3);
				} catch (ValidationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("4 Books added successfully");

			}

			if (input == 1) {
				/**
				 * we can use builder pattern here.
				 * 
				 * 
				 */
				UserPojo user = new UserPojo();
				user.setUserId("satman");
				user.setUserName("raman");

				try {
					adminInterface.addUserToSystem(user);
				} catch (ValidationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				;
				System.out.println("1 User added successfully");

			}

			if (input == 2) {
				try {
					System.out.println("lended book ->"
							+ userInterface.lendBook("raman", "1"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Book Lended Successfully");

				// try {
				// System.out.println("lended book ->"+userInterface.lendBook("raman",
				// "2"));
				// } catch (Exception e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }
				// System.out.println("Lending success");
			}

			if (input == 3) {
				try {
					userInterface.returnBook("raman", "1");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Book returned Successfully to library");
			}

			if (input == 4) {

				try {
					System.out.println("Book search results by author ->"
							+ userInterface.searchBookByAuthor("Ramesh"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			if (input == 5) {

				try {
					System.out.println("Book search results by title ->"
							+ userInterface.searchBookByTitle("C"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			if (input == 6) {

				try {
					System.out.println("User search results by username ->"
							+ adminInterface.searchUserByName("raman"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		sc.close();
	}

}
