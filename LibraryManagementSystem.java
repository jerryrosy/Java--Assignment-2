import java.util.*;

// Book class
class Book {
    int id;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author;
    }
}

// Library Management System
public class LibraryManagementSystem {

    // List - stores all books
    static List<Book> books = new ArrayList<>();

    // Set - stores unique member names
    static Set<String> members = new HashSet<>();

    // Map - maps book ID to book details
    static Map<Integer, Book> bookMap = new HashMap<>();

    // Queue - stores book borrowing requests
    static Queue<String> borrowQueue = new LinkedList<>();

    public static void main(String[] args) {

        // Adding books to List
        books.add(new Book(101, "Java Programming", "James Gosling"));
        books.add(new Book(102, "Python Basics", "Guido van Rossum"));
        books.add(new Book(103, "Data Structures", "Mark Allen"));

        // Adding books to Map
        for (Book book : books) {
            bookMap.put(book.id, book);
        }

        // Adding members to Set
        members.add("Ananya");
        members.add("Diya");
        members.add("Meera");
        members.add("Ananya"); // Duplicate will not be added

        // Adding borrowing requests to Queue
        borrowQueue.add("Ananya - Book ID 101");
        borrowQueue.add("Diya - Book ID 103");
        borrowQueue.add("Meera - Book ID 102");

        // Display all books
        System.out.println("===== LIBRARY MANAGEMENT SYSTEM =====");

        System.out.println("\n--- Available Books ---");
        for (Book book : books) {
            System.out.println(book);
        }

        // Display members
        System.out.println("\n--- Library Members ---");
        for (String member : members) {
            System.out.println(member);
        }

        // Search book using Map
        System.out.println("\n--- Searching for Book ID 102 ---");

        int searchId = 102;

        if (bookMap.containsKey(searchId)) {
            System.out.println("Book Found: " + bookMap.get(searchId));
        } else {
            System.out.println("Book not found.");
        }

        // Process borrowing requests using Queue
        System.out.println("\n--- Processing Borrow Requests ---");

        while (!borrowQueue.isEmpty()) {
            String request = borrowQueue.poll();
            System.out.println("Processing request: " + request);
        }

        // Display total number of books and members
        System.out.println("\n--- Library Statistics ---");
        System.out.println("Total Books: " + books.size());
        System.out.println("Total Members: " + members.size());
        System.out.println("Remaining Borrow Requests: " + borrowQueue.size());

        System.out.println("\n===== PROGRAM COMPLETED =====");
    }
}