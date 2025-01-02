package DesignPatterns.LibararyManagementSystem;

import java.util.Objects;

public class Book {
    private final String title;
    private final String author ;
    private final String ISBN;
    private final String publication_year;
    private boolean isAvailable;

    public Book(String title,String author , String isbn, String publication_year ){
        this.title = title;
        this.author = author;
        this.ISBN = isbn;
        this.publication_year = publication_year;
        this.isAvailable = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(ISBN, book.ISBN) &&
                Objects.equals(publication_year, book.publication_year);
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public boolean getIsAvailable(){
        return this.isAvailable;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setIsAvailable(boolean available){
        this.isAvailable = available;
    }

    public String getPublication_year() {
        return publication_year;
    }
}
