package DesignPatterns.LibararyManagementSystem;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class LibraryManager {
    private static LibraryManager libraryManager;
    private final Map<String , Book> catalog;
    private final Map<String , Member> members;
    private final int MAX_BOOK_PER_MEMBER = 5;
    private final int LOAN_DURATION_DAYS = 14;

    private LibraryManager(){
        catalog = new ConcurrentHashMap<>();
        members = new ConcurrentHashMap<>();
    }

    public static synchronized LibraryManager getInstance() {
        if (libraryManager == null) {
            libraryManager = new LibraryManager();
        }
        return libraryManager;
    }

    public Book getBook(String isbn){
        return this.catalog.values().stream().filter(b-> b.getISBN() == isbn).toList().getFirst();
    }

    public void registerMember(Member member){
        this.members.put(member.getMemberId(), member);
    }

    public void addBook(Book book){
        catalog.put(book.getISBN() , book);
    }

    public List<Book> searchBooks(String keyword){
       return this.catalog.values().stream()
               .filter(book -> book.getAuthor().contains(keyword) || book.getTitle().contains(keyword))
               .collect(Collectors.toList());
    }

    public synchronized void borrowBook(String memberId , String isbn) {
          Member member = this.members.get(memberId);
          Book book = this.catalog.get(isbn);

          Optional.ofNullable(book)
                .filter(Book::getIsAvailable)
                .ifPresentOrElse(b -> Optional.ofNullable(member)
                                .filter(m -> m.getBorrowedBooks().size() < MAX_BOOK_PER_MEMBER)
                                .ifPresentOrElse(m -> {
                                    m.borrowBook(b);
                                    b.setIsAvailable(false);
                                    System.out.println("Book :" + b.getTitle() + " borrowed by : " + m.getName());
                                },()-> System.out.println("Member has reached max number of borrowed books")),
                        ()-> System.out.println("Member or Book is not available !!")
                );
    }

    public synchronized void returnBook(String memberId , String isbn){
        Member member = this.members.get(memberId);
        Book book = this.catalog.get(isbn);

        if(member!=null && book!=null){
            member.returnBook(book);
            book.setIsAvailable(true);
            System.out.println("Book returned : " + book.getTitle() + " by : " + member.getName());
        } else {
            System.out.println("Book or Member Not found !!");
        }
    }
}
