package week_3_task_project;

public class Book {
	
	private String ISBN;
	private String title;
	private String author;
	private  String genre;
	private boolean availability;
	
	public Book(String ISBN, String title, String author, String genre) {
		 
		  if (ISBN == null || ISBN.isBlank()) {
	            throw new IllegalArgumentException("ISBN cannot be empty.");
	        }

	        if (title == null || title.isBlank()) {
	            throw new IllegalArgumentException("Title cannot be empty.");
	        }

	        if (author == null || author.isBlank()) {
	            throw new IllegalArgumentException("Author cannot be empty.");
	        }

	        if (genre == null || genre.isBlank()) {
	            throw new IllegalArgumentException("Genre cannot be empty.");
	        }

		
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.availability = true;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	 public boolean borrowBook() {

	        if (!availability) {
	            return false;
	        }

	        availability = false;
	        return true;
	    }

     public boolean returnBook() {

	        if (availability) {
	            return false;
	        }

	        availability = true;
	        return true;
	    }
	
	 public void displayBookDetails() {

	        System.out.println("========== BOOK DETAILS ==========");
	        System.out.println("ISBN         : " + ISBN);
	        System.out.println("Title        : " + title);
	        System.out.println("Author       : " + author);
	        System.out.println("Genre        : " + genre);
	        System.out.println("Availability  : "+ (availability ? "Available" : "Borrowed"));
	    }

	@Override
	public String toString() {
		return "Book{" +
                "isbn='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", availability=" + availability +
                '}';
	}	

}
