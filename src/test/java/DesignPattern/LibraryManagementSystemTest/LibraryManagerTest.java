package DesignPattern.LibraryManagementSystemTest;

import DesignPatterns.LibararyManagementSystem.Book;
import DesignPatterns.LibararyManagementSystem.LibraryManager;
import DesignPatterns.LibararyManagementSystem.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagerTest {
    static LibraryManager libraryManager = LibraryManager.getInstance();
    @BeforeAll
    public static void init(){
        libraryManager.addBook(new Book("Book 1", "Author 1", "ISBN1" , "2019"));
        libraryManager.addBook(new Book("Book 2", "Author 2", "ISBN2" , "2029"));
        libraryManager.addBook(new Book("Book 3", "Author 3", "ISBN3" , "2039"));
        libraryManager.addBook(new Book("Book 4", "Author 4", "ISBN4" , "2049"));
        libraryManager.addBook(new Book("Book 5", "Author 5", "ISBN5" , "2049"));
        libraryManager.addBook(new Book("Book 6", "Author 6", "ISBN6" , "2049"));

        libraryManager.registerMember(new Member("M1", "John Doe", "john@exaple.com"));
        libraryManager.registerMember(new Member("M2", "Jane Smith", "jane@exaple.com"));
    }


    @Test
    public void SearchBooksTest(){
        List<Book> result = libraryManager.searchBooks("Book 1");
        List<Book> expected = new ArrayList<>(List.of(new Book("Book 1", "Author 1", "ISBN1" , "2019")));
        Assertions.assertEquals(expected, result);
    }


    @Test
    public void borrowBookTest(){
        libraryManager.borrowBook("M2", "ISBN1");
        libraryManager.borrowBook("M2", "ISBN2");
        libraryManager.borrowBook("M2", "ISBN3");
        libraryManager.borrowBook("M2", "ISBN4");
        libraryManager.borrowBook("M2", "ISBN5");
        libraryManager.borrowBook("M2", "ISBN6");
        Assertions.assertFalse(libraryManager.getBook("ISBN1").getIsAvailable());
        libraryManager.borrowBook("M1", "ISBN1");
    }


    @Test
    public void returnBookTest(){
        libraryManager.returnBook("M1", "ISBN1");
        Assertions.assertTrue(libraryManager.getBook("ISBN1").getIsAvailable());
    }
  }
