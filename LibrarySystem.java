package week_3_task_project;

import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
	
	 private static final Scanner scanner = new Scanner(System.in);
	    private static final Library library = new Library();

	    public static void main(String[] args) {

	        loadSampleData();
	        showWelcomeMessage();

	        int choice;

	        do {
	            displayMenu();
	            choice =readInt("Enter your choice: ");
	            System.out.println();
	            try {

	                switch (choice) {

	                    case 1:
	                        addBook();
	                        break;

	                    case 2:
	                        removeBook();
	                        break;

	                    case 3:
	                        addMember();
	                        break;

	                    case 4:
	                        removeMember();
	                        break;

	                    case 5:
	                        borrowBook();
	                        break;

	                    case 6:
	                        returnBook();
	                        break;

	                    case 7:
	                        searchBook();
	                        break;

	                    case 8:
	                        displayAllBooks();
	                        break;

	                    case 9:
	                        displayAllMembers();
	                        break;

	                    case 0:
	                        exitApplication();
	                        break;

	                    default:
	                        System.out.println(
	                                "❌ Invalid choice. Please select an option from 0 to 13."
	                        );
	                }

	            } catch (Exception e) {

	                System.out.println();
	                System.out.println("❌ Operation Failed");
	                System.out.println("Reason: " + e.getMessage());
	            }

	            if (choice != 0) {
	                pause();
	            }

	        } while (choice != 0);

	        scanner.close();
	    }


	    private static void displayMenu() {

	        System.out.println();

	        System.out.println("╔════════════════════════════════════════════════════╗");
	        System.out.println("║           📚 LIBRARY MANAGEMENT SYSTEM             ║");
	        System.out.println("╠════════════════════════════════════════════════════╣");
	        System.out.println("║                                                    ║");
	        System.out.println("║  BOOK MANAGEMENT                                   ║");
	        System.out.println("║  1. Add Book                                       ║");
	        System.out.println("║  2. Remove Book                                    ║");
	        System.out.println("║                                                    ║");
	        System.out.println("║  MEMBER MANAGEMENT                                 ║");
	        System.out.println("║  3. Add Member                                     ║");
	        System.out.println("║  4. Remove Member                                  ║");
	        System.out.println("║                                                    ║");
	        System.out.println("║  LIBRARY OPERATIONS                                ║");
	        System.out.println("║  5. Borrow Book                                    ║");
	        System.out.println("║  6. Return Book                                    ║");
	        System.out.println("║  7. Search Book                                    ║");
	        System.out.println("║                                                    ║");
	        System.out.println("║  REPORTS                                           ║");
	        System.out.println("║  8. View All Books                                 ║");
	        System.out.println("║  9. View All Members                               ║");
	        System.out.println("║  0. Exit                                           ║");
	        System.out.println("║                                                    ║");
	        System.out.println("╚════════════════════════════════════════════════════╝" );
	    }

	
	    private static void addBook(){

	        System.out.println("========== ADD BOOK ==========");

	        String isbn = readString("Enter ISBN: ");
	        String title = readString("Enter title: ");
	        String author = readString("Enter author: ");
	        String genre = readString("Enter genre: ");
	        
	        Book book = new Book(isbn,title,author,genre);

	        library.addBook(book);
	        System.out.println();
	        System.out.println("✅ Book added successfully!");
	    }


	    private static void removeBook(){

	        System.out.println("========== REMOVE BOOK ==========");

	        String isbn = readString("Enter ISBN: ");
	        library.removeBook(isbn);

	        System.out.println();
	        System.out.println("✅ Book removed successfully!");
	    }

	    
	    private static void addMember(){
	    	
	        System.out.println("========== ADD MEMBER ==========");

	        int memberId = readInt("Enter member ID: ");
	        String name = readString("Enter member name: ");
	        String contact =readString("Enter contact number: ");

	        Member member = new Member(memberId,name,contact);
	        library.addMember(member);

	        System.out.println();
	        System.out.println("✅ Member added successfully!");
	    }

	
	    private static void removeMember(){

	        System.out.println("========== REMOVE MEMBER ==========");

	        int memberId = readInt("Enter member ID: ");

	        library.removeMember(memberId);

	        System.out.println();
	        System.out.println("✅ Member removed successfully!");
	    }


	    private static void borrowBook(){

	        System.out.println("========== BORROW BOOK ==========");

	        int memberId = readInt("Enter member ID: ");
	        String isbn = readString("Enter book ISBN: ");

	        library.borrowBook(memberId, isbn);

	        Book book = library.findBookByISBN(isbn);
	        Member member = library.findMemberById(memberId);

	        System.out.println();
	        System.out.println("╔══════════════════════════════════════════════╗");
	        System.out.println("║       ✅ BOOK BORROWED SUCCESSFULLY          ║");
	        System.out.println("╠══════════════════════════════════════════════╣");
	        System.out.printf("║ Member : %-34s ║%n",member.getName());
	        System.out.printf("║ Book   : %-34s ║%n",book.getTitle());
	        System.out.printf("║ ISBN   : %-34s ║%n",book.getISBN());
	        System.out.println("╚══════════════════════════════════════════════╝");
	    }


	    private static void returnBook(){

	        System.out.println("========== RETURN BOOK ==========");

	        int memberId = readInt("Enter member ID: ");
	        String isbn = readString("Enter book ISBN: ");

	        library.returnBook(memberId, isbn);

	        System.out.println();
	        System.out.println("✅ Book returned successfully!");
	    }


	    private static void searchBook() {

	        System.out.println("========== SEARCH BOOK ==========");

	        String keyword = readString("Enter title or author : ");

	        List<Book> results =library.searchBook(keyword);

	        if (results.isEmpty()) {

	            System.out.println();
	            System.out.println("❌ No books found.");

	            return;
	        }

	        System.out.println();
	        System.out.println("🔎 Search Results");
	        System.out.println("-----------------------------------------------");

	        for (Book book : results) {
	            System.out.println(book);
	        }

	        System.out.println("-----------------------------------------------");
	        System.out.println("Total results: " + results.size());
	    }

	   
	    private static void displayAllBooks() {

	        System.out.println("========== ALL BOOKS ==========");
	        library.displayAllBooks();
	    }


	    private static void displayAllMembers() {

	        System.out.println("========== ALL MEMBERS ==========");
	                library.displayAllMembers();
	    }


	    private static void loadSampleData() {

	        try {

	            library.addBook(
	                    new Book(
	                            "9780134685991",
	                            "Effective Java",
	                            "Joshua Bloch",
	                            "Programming"
	                    )
	            );

	            library.addBook(
	                    new Book(
	                            "9780132350884",
	                            "Clean Code",
	                            "Robert C. Martin",
	                            "Programming"
	                    )
	            );

	            library.addBook(
	                    new Book(
	                            "9781617294945",
	                            "Spring in Action",
	                            "Craig Walls",
	                            "Spring"
	                    )
	            );

	            library.addMember(
	                    new Member(
	                            101,
	                            "Souvik",
	                            "9876543210"
	                    )
	            );

	            library.addMember(
	                    new Member(
	                            102,
	                            "Rahul",
	                            "9876501234"
	                    )
	            );

	        } catch (Exception e) {

	            System.out.println("Sample data error: " +e.getMessage());
	        }
	    }

	    private static void showWelcomeMessage() {

	        System.out.println();
	        System.out.println("╔══════════════════════════════════════════════╗");
	        System.out.println("║                                              ║");
	        System.out.println("║       📚 WELCOME TO LIBRARY SYSTEM 📚        ║");
	        System.out.println("║                                              ║");
	        System.out.println("║     Manage Books • Members • Borrowing       ║");
	        System.out.println("║                                              ║");
	        System.out.println("╚══════════════════════════════════════════════╝");
	    }

	    private static int readInt(String message) {

	        while (true) {

	            try {

	                System.out.print(message);
	                return Integer.parseInt(scanner.nextLine().trim());

	            } catch (NumberFormatException e) {
	                System.out.println("Please enter a valid number.");
	            }
	        }
	    }
	    
	    private static String readString(String message) {

	        while (true) {

	            System.out.print(message);

	            String input = scanner.nextLine().trim();

	            if (!input.isEmpty()) {
	                return input;
	            }

	            System.out.println("Input cannot be empty.");
	        }
	    }

	    // =========================================================
	    // EXIT
	    // =========================================================

	    private static void exitApplication() {

	        System.out.println();
	        System.out.println(
	                "👋 Thank you for using Library Management System!"
	        );
	    }

	    // =========================================================
	    // PAUSE
	    // =========================================================

	    private static void pause() {

	        System.out.println();

	        System.out.print(
	                "Press ENTER to continue..."
	        );

	        scanner.nextLine();
	    }

}
