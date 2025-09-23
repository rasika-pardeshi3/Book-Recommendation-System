package org.book.recommend.clientapp;

import java.util.*;
import java.util.List;

import org.book.recommend.model.AuthorModel;
import org.book.recommend.model.BookModel;
import org.book.recommend.model.CategoryModel;
import org.book.recommend.model.PublicationModel;
import org.book.recommend.service.BookService;
import org.book.recommend.service.BookServiceImpl;
import org.book.recommend.service.CategoryService;
import org.book.recommend.service.CategoryServiceImpl;
import org.book.recommend.service.PubService;
import org.book.recommend.service.PubServiceImpl;
import org.book.recommend.service.AuthorService;
import org.book.recommend.service.AuthorServiceImpl;

public class BookClientApplication {
	static Scanner xyz = new Scanner(System.in);
	static BookService bookService = new BookServiceImpl();
	static PubService pubService = new PubServiceImpl();
	static CategoryService catService = new CategoryServiceImpl();
	static AuthorService authService = new AuthorServiceImpl();

	public static void main(String[] args) {

		do {
			System.out.println("- - - Book Recommendation System - - -");
			System.out.println("1: Book Master");
			System.out.println("2: Publication Master");
			System.out.println("3: Category Master");
			System.out.println("4: Author Master");
			System.out.println("5: User Master");
			System.out.println("6: User Review And Ratings");
			System.out.println("7: Recommendation Logics");
			System.out.println("8: Exit");
			System.out.println("Enter your choice");
			int choice = xyz.nextInt();
			switch (choice) {
			case 1:
				bookMenu();
				break;
			case 2:
				pubMenu();
				break;
			case 3:
				catMenu();
				break;
			case 4:
				authMenu();
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong choice");
			}
		} while (true);
	}

	public static void bookMenu() {
		boolean flag = true;
		do {
			System.out.println("1: Add New Book");
			System.out.println("2: View All Books");
			System.out.println("3: Search Books");
			System.out.println("4: Update Book By Name");
			System.out.println("5: Delete Book By Name");
			System.out.println("6: Return to main menu");
			int choice = xyz.nextInt();
			switch (choice) {
			case 1:
				xyz.nextLine();
				System.out.println("Enter book name price publish date and description");
				String bookName = xyz.nextLine();
				float bookprice = xyz.nextFloat();
				// System.out.printf("%f", bookPrice);
				xyz.nextLine();
				String date = xyz.nextLine();
				String briefDesc = xyz.nextLine();
				BookModel bookModel = new BookModel(0, bookName, bookprice, date, briefDesc);
				boolean b = bookService.isAddNewBook(bookModel);
				if (b) {
					System.out.println("Book Added In Database Table");
				} else {
					System.out.println("Some problem is there.........");
				}
				break;
			case 2:
				List<BookModel> list = bookService.getAllBooks();
				if (list != null) {
					list.forEach((bk) -> System.out.println(bk.getId() + "\t" + bk.getName() + "\t" + bk.getBprice()
							+ "\t" + bk.getPyear() + "\t" + bk.getBriefDesc()));

				} else {
					System.out.println("There is not book present");
				}
				break;
			case 3:
				xyz.nextLine();
				System.out.println("Enter name for search");
				bookName = xyz.nextLine();
				BookModel ref = bookService.getBookByName(bookName);
				if (ref != null) {
					System.out.println(ref.getId() + "\t" + ref.getName() + "\t" + ref.getBprice() + "\t"
							+ ref.getPyear() + "\t" + ref.getBriefDesc());
				} else {
					System.out.println("Book not found");
				}
				break;
			case 4:
				xyz.nextLine();
				System.out.println("Enter book name for search");
				String bookNameForSerach = xyz.nextLine();
				ref = bookService.getBookByName(bookNameForSerach);
				if (ref != null) {
					System.out.println("Enter new data for book");
					System.out.println("Enter book name price publish date and description");
					bookName = xyz.nextLine();
					bookprice = xyz.nextFloat();
					// System.out.printf("%f", bookPrice);
					xyz.nextLine();
					date = xyz.nextLine();
					briefDesc = xyz.nextLine();
					bookModel = new BookModel(0, bookName, bookprice, date, briefDesc);
					b = bookService.isUpdateBook(bookModel, bookNameForSerach);
					if (b) {
						System.out.println("Book updated successfully..............");
					} else {
						System.out.println("Some problem is there............ ");
					}
				} else {
					System.out.println("Book not found");
				}
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("Wrong choice");
			}

		} while (flag);
	}

	public static void pubMenu() {
		boolean flag = true;
		do {
			System.out.println("1: Add New Publications");
			System.out.println("2: View All Publications");
			System.out.println("3: Search Publications");
			System.out.println("4: Update Publications");
			System.out.println("5: Delete Publications");
			System.out.println("6: Return to main menu");
			int choice = xyz.nextInt();
			switch (choice) {
			case 1:
				xyz.nextLine();
				System.out.println("Enter publication name");
				String pubName = xyz.nextLine();
				PublicationModel model = new PublicationModel(0, pubName);
				boolean b = pubService.isAddNewPublication(model);
				if (b) {
					System.out.println("Publication Added Successfully........");
				} else {
					System.out.println("Some Problem is there........");
				}
				break;
			case 2:

				break;
			case 3:
				catMenu();
				break;
			case 4:
				authMenu();
				break;
			case 6:
				break;
			default:
				System.out.println("Wrong choice");
			}

		} while (flag);
	}

	public static void catMenu() {
		boolean flag = true;
		do {
			System.out.println("1: Add New Category");
			System.out.println("2: View All Category ");
			System.out.println("3: Search Category");
			System.out.println("4: Update Category");
			System.out.println("5: Delete Category");
			System.out.println("6: Return to main menu");
			int choice = xyz.nextInt();
			switch (choice) {
			case 1:
				xyz.nextLine();
				System.out.println("Enter Category name");
				String catName = xyz.nextLine();
				CategoryModel cmodel = new CategoryModel(0, catName);
				boolean b = catService.isAddNewCategory(cmodel);
				if (b) {
					System.out.println("New Category Addded");
				} else {
					System.out.println("Some problem is there...........");
				}
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:
				break;
			case 6:
				break;
			default:
				System.out.println("Wrong choice");
			}

		} while (flag);
	}

	public static void authMenu() {
		boolean flag = true;
		do {

			System.out.println("1: Author Master");
			System.out.println("2: View Authors ");
			System.out.println("3: Search Author");
			System.out.println("4: Update Author");
			System.out.println("5: Delete Author");
			System.out.println("6: Return to main menu");
			int choice = xyz.nextInt();
			switch (choice) {
			case 1:
				xyz.nextLine();
				System.out.println("Enter Author Name");
				String authName = xyz.nextLine();
				String qual = "";
				int age = 0;
				boolean status =false;
				int result = authService.getAuthorId(authName);
				if (result != 1) {
					System.out.println("It is existing author or consider as new");
					String msg = xyz.nextLine();
					if (msg.equals("yes")) {
						System.out.println("No need to take existing author info");
						status=false;
					} else {
						System.out.println("Enter new author qualification and age");
						qual = xyz.nextLine();
						age = xyz.nextInt();
					}
				} else {
					System.out.println("Enter new author qualification and age");
					qual = xyz.nextLine();
					age = xyz.nextInt();
				}
				xyz.nextLine();
				System.out.println("Enter book name price publish date and description");
				String bookName = xyz.nextLine();
				float bookprice = xyz.nextFloat();
				// System.out.printf("%f", bookPrice);
				xyz.nextLine();
				String date = xyz.nextLine();
				String briefDesc = xyz.nextLine();
				System.out.println("Select Book Category id");
				System.out.println("***********************************");
				List<CategoryModel> list = catService.getAllCategories();
				list.forEach((cat) -> System.out.println(cat.getId() + "\t" + cat.getName()));
				System.out.println("Select Publication ID");
				System.out.println("************************************");
				List<PublicationModel> pubList = pubService.getAllPublication();
				pubList.forEach((p) -> System.out.println(p.getId() + "\t" + p.getName()));
				System.out.println("Enter Category Id");
				int catId=xyz.nextInt();
				BookModel bookModel = new BookModel(0, bookName, bookprice, date, briefDesc);
				AuthorModel authModel = new AuthorModel(0,  authName, age, qual);
				if (bookService.isAddNewBook(bookModel) && authService.isAddNewAuthor(authModel))  {
					System.out.println("Book AND AUTHOR Added");
//					boolean b = authService
				} else {
					System.out.println("Some problem is there.........");
				}
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:
				break;
			case 6:
				break;
			default:
				System.out.println("Wrong choice");
			}

		} while (flag);
	}

}
