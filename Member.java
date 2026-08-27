package week_3_task_project;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private int memberId;
	private String name;
	private String contact;
    private List<Book> borrowedBooks;
    
	public Member(int memberId, String name, String contact) {
		  if (memberId <= 0) {
	            throw new IllegalArgumentException("Member ID must be positive.");
	        }

	        if (name == null || name.isBlank()) {
	            throw new IllegalArgumentException("Member name cannot be empty.");
	        }

	        if (contact == null || contact.isBlank()) {
	            throw new IllegalArgumentException("Contact cannot be empty.");
	        }
		this.memberId = memberId;
		this.name = name;
		this.contact = contact;
        this.borrowedBooks = new ArrayList<>();

	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
	
	 public boolean borrowBook(Book book){
		
		    if (book == null) {
	            System.out.println("Invalid book.");
	            return false;
	        }
	        if (borrowedBooks.contains(book)) {
	            System.out.println("You have already borrowed this book.");
	            return false;
	        }

	        if (!book.isAvailability()) {
	            System.out.println("Book is currently unavailable.");
	            return false;
	        }

	        if (!book.borrowBook()) {
	            System.out.println("Unable to borrow the book.");
	            return false;
	        }

	        borrowedBooks.add(book);

	        System.out.println("Book borrowed successfully: "+ book.getTitle());
	        
	        return true;
		
	}
	
	
	 public boolean returnBook(Book book) {

	        if (book == null) {
	            System.out.println("Invalid book.");
	            return false;
	        }

	        if (!borrowedBooks.contains(book)) {
	            System.out.println("You have not borrowed this book.");
	            return false;
	        }

	        if (!book.returnBook()) {
	            System.out.println("Unable to return the book.");
	            return false;
	        }

	        borrowedBooks.remove(book);

	        System.out.println("Book returned successfully: "+ book.getTitle());
	        return true;
	    }

	 @Override
	 public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", contact=" + contact + ", borrowedBooks="
				+ borrowedBooks + "]";
	 }
}
