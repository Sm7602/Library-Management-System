package week_3_task_project;

import java.util.ArrayList;
import java.util.List;

public class Library {
	
	    private List<Book> books;
	    private List<Member> members;
	    
	    public Library() {
	        books = new ArrayList<>();
	        members = new ArrayList<>();
	    }
	    
	  //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<BOOK>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	    
	    public void addBook(Book book) {

	        if (book == null) {
	            throw new IllegalArgumentException("Book cannot be null.");
	        }

	        if (findBookByISBN(book.getISBN()) != null) {
	            throw new IllegalArgumentException("Book with this ISBN already exists.");
	        }

	        books.add(book);

	        System.out.println("Book added successfully.");
	    }

	    public void removeBook(String isbn) {

	        Book book = findBookByISBN(isbn);

	        if (book == null) {
	            throw new IllegalArgumentException("Book not found.");
	        }

	        if (!book.isAvailability()) {
	            throw new IllegalStateException("Cannot remove a borrowed book.");
	        }

	        books.remove(book);

	        System.out.println("Book removed successfully.");
	    }

	    public Book findBookByISBN(String isbn) {

	        for (Book book : books) {
	            if (book.getISBN().equalsIgnoreCase(isbn)) {
	                return book;
	            }
	        }

	        return null;
	    }

	  //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<MEMBER>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	    
	    public void addMember(Member member) {

	        if (member == null) {
	            throw new IllegalArgumentException("Member cannot be null.");
	        }

	        if (findMemberById(member.getMemberId()) != null) {
	            throw new IllegalArgumentException("Member with this ID already exists.");
	        }

	        members.add(member);

	        System.out.println("Member added successfully.");
	    }
	    
	    public void removeMember(int memberId) {

	    	Member member = findMemberById(memberId);

	        if (member == null) {
	            throw new IllegalArgumentException("member not found.");
	        }

	        members.remove(member);

	        System.out.println("Book removed successfully.");
	    }

	    public Member findMemberById(int memberId) {

	        for (Member member : members) {
	            if (member.getMemberId() == memberId) {
	                return member;
	            }
	        }

	        return null;
	    }
	    
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<BORROW BOOK>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	    public void borrowBook(int memberId, String isbn) {

	        Member member = findMemberById(memberId);
	        Book book = findBookByISBN(isbn);

	        if (member == null) {
	            throw new IllegalArgumentException("Member not found.");
	        }

	        if (book == null) {
	            throw new IllegalArgumentException("Book not found.");
	        }

	        if (!book.isAvailability()) {
	            throw new IllegalStateException("Book is currently unavailable.");
	        }

	        member.borrowBook(book);

	        System.out.println("Book borrowed successfully by " + member.getName());
	    }

	 //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<RETURN BOOK>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	    public void returnBook(int memberId, String isbn) {

	        Member member = findMemberById(memberId);
	        Book book = findBookByISBN(isbn);

	        if (member == null) {
	            throw new IllegalArgumentException("Member not found.");
	        }

	        if (book == null) {
	            throw new IllegalArgumentException("Book not found.");
	        }

	        member.returnBook(book);

	        System.out.println("Book returned successfully.");
	    }
	    
    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SEARCH BOOK>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
  
	    public List<Book> searchBook(String keyword) {

	        List<Book> result = new ArrayList<>();

	        for (Book book : books) {
	            if (book.getTitle()
	                    .toLowerCase()
	                    .contains(keyword.toLowerCase()) 
	                    ||book.getAuthor()
	                    .toLowerCase()
	                    .contains(keyword.toLowerCase())) {

	                result.add(book);
	            }
	        }

	        return result;
	    }

	   
	    
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<DISPLAY>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 
	    public void displayAllBooks() {

	        if (books.isEmpty()) {
	            System.out.println("No books available in library.");
	            return;
	        }

	        System.out.println("\n========== ALL BOOKS ==========");

	        for (Book book : books) {
	            System.out.println(book);
	        }
	    }

	    public void displayAllMembers() {

	        if (members.isEmpty()) {
	            System.out.println("No members registered.");
	            return;
	        }

	        System.out.println("\n========== ALL MEMBERS ==========");

	        for (Member member : members) {
	            System.out.println(member);
	        }
	    }
}
