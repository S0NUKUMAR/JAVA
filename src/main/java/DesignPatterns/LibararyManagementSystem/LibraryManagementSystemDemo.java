package DesignPatterns.LibararyManagementSystem;

import java.util.List;

public class LibraryManagementSystemDemo {
    public static void main(String[] args) {
        System.out.println("Library Management System");
        LibraryManager libraryManager = LibraryManager.getInstance();

        libraryManager.addBook(new Book("Book 1", "Author 1", "ISBN1" , "2019"));
        libraryManager.addBook(new Book("Book 2", "Author 2", "ISBN2" , "2029"));
        libraryManager.addBook(new Book("Book 3", "Author 3", "ISBN3" , "2039"));
        libraryManager.addBook(new Book("Book 4", "Author 4", "ISBN4" , "2049"));

        libraryManager.registerMember(new Member("M1", "John Doe", "john@exaple.com"));
        libraryManager.registerMember(new Member("M2", "Jane Smith", "jane@exaple.com"));


        libraryManager.borrowBook("M1", "ISBN1");
        libraryManager.borrowBook("M2", "ISBN2");
        libraryManager.borrowBook("M2", "ISBN1");

        libraryManager.returnBook("M1", "ISBN1");

        List<Book> searchResult = libraryManager.searchBooks("Book");
        for(Book book: searchResult){
            System.out.println(book.getTitle() + "By " + book.getAuthor());
        }
    }
}
