import java.util.ArrayList;
import java.util.List;

class Book {
    String title, author;
    boolean isCheckedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void checkout() { isCheckedOut = true; }
    public void checkin() { isCheckedOut = false; }

    public void displayInfo() {
        System.out.printf("Title: %s\nAuthor: %s\nAvailable: %s\n", title, author, !isCheckedOut ? "Yes" : "No");
    }

    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("Harry Potter", "J. Rowling");

        library.addBook(book1);
        library.addBook(book2);

        Reader reader = new Reader("Zhanibek");

        library.displayAvailableBooks();
        reader.checkoutBook(book1);
        reader.displayInfo();

        library.displayAvailableBooks();
        reader.checkinBook(book1);
        reader.displayInfo();

        library.displayAvailableBooks();
    }
}

class Reader {
    String name;
    List<Book> checkedOutBooks = new ArrayList<>();

    public Reader(String name) { this.name = name; }

    public void checkoutBook(Book book) {
        if (!book.isCheckedOut) {
            book.checkout();
            checkedOutBooks.add(book);
        } else {
            System.out.println("Book taken.");
        }
    }

    public void checkinBook(Book book) {
        if (checkedOutBooks.remove(book)) book.checkin();
    }

    public void displayInfo() {
        System.out.printf("Reader: %s\nBooks taken:\n", name);
        if (checkedOutBooks.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            for (Book book : checkedOutBooks) {
                book.displayInfo();
            }
        }
        System.out.println(); 
    }
}

class Library {
    List<Book> books = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }

    public void displayAvailableBooks() {
        System.out.println("Available books:");
        for (Book book : books) {
            if (!book.isCheckedOut) {
                book.displayInfo();
            }
        }
        System.out.println(); 
    }
}
