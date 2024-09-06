// Digital Library to add books

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Book Class
class Book {

    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title='" + title + '\'' + ", author='" + author + '\'' + ", isAvailable=" + isAvailable + '}';
    }
}

// User Class
class User {

    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}

// LibraryManager Class
class LibraryManager {

    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added successfully!");
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book issued to user " + userId);
        } else {
            System.out.println("Book not available.");
        }
    }

    public void returnBook(int bookId) {
        Book book = findBookById(bookId);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book not found or already available.");
        }
    }

    private Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void listUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}

// Main Class
public class Main {

    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        // Adding some initial data
        libraryManager.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        libraryManager.addBook(new Book(2, "1984", "George Orwell"));
        libraryManager.addUser(new User(1, "Alice"));
        libraryManager.addUser(new User(2, "Bob"));

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Books");
            System.out.println("6. List Users");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book id: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    libraryManager.addBook(new Book(bookId, title, author));
                    break;
                case 2:
                    System.out.print("Enter user id: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    libraryManager.addUser(new User(userId, name));
                    break;
                case 3:
                    System.out.print("Enter book id to issue: ");
                    int issueBookId = scanner.nextInt();
                    System.out.print("Enter user id: ");
                    int issueUserId = scanner.nextInt();
                    libraryManager.issueBook(issueBookId, issueUserId);
                    break;
                case 4:
                    System.out.print("Enter book id to return: ");
                    int returnBookId = scanner.nextInt();
                    libraryManager.returnBook(returnBookId);
                    break;
                case 5:
                    libraryManager.listBooks();
                    break;
                case 6:
                    libraryManager.listUsers();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
