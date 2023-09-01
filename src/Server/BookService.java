package Server;

import Interface.bookServer;
import Model.Book;
import Model.Database;
import Model.Library;

import java.util.Formattable;
import java.util.List;

public class BookService implements bookServer {
    private Database database;

    public BookService(Database database) {
        this.database = database;
    }
    public BookService(){

    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public Book saveBook(Long libraryId, Book book) {
        List<Library>libraries1 = database.getLibraries();
            for(Library b : libraries1){
                if (b.getId()==libraryId){
                    b.getBooks().add(book);
                }
            }
            System.out.println("saving at book"+libraries1);
        return null;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        List<Library>libraries1 = database.getLibraries();
        for (Library b: libraries1){
            if (b.getId()==libraryId){
                System.out.println(database.getBooks());
            }
        }
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        List<Book>books=database.getBooks();
        List<Library>library=database.getLibraries();
        for (Library l:library){
            if(l.getId()==libraryId){
                for(Book b:books){
                    if(b.getId()==bookId){
                        return b;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, int bookId) {
        boolean a = false ;
        List<Library>libraries1 = database.getLibraries();
        List<Book>books1 = database.getBooks();
        for (Library b: libraries1){
            if (b.getId()==libraryId){
                for (Book c:books1){
                    if (c.getId()==bookId){
                        System.out.println(
                        c.getBookName()+
                        c.getAuthor()+
                        c.getGenre());
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        List<Library>libraries1 = database.getLibraries();
        List<Book>books1 = database.getBooks();
        for (Library b: libraries1) {
            if (b.getId() == libraryId) {
                for (Book c : books1) {
                    if (c.getId() == bookId) {
                        books1.remove(c);
                    }
                }
            }
        }

        return null;
    }


    @Override
    public String deleteBook(Long libraryId, int bookId) {
        int a = bookId;
        List<Library>libraries1 = database.getLibraries();
        List<Book>books1 = database.getBooks();
        for (Library b: libraries1) {
            if (b.getId() == libraryId) {
                for (Book c : books1) {
                    if (c.getId() == bookId) {
                        books1.remove(a);
                    }
                }
            }return "deleted at book : "+books1;
        }
        return "deleted at book : "+books1;
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        List<Library> arrayLibrary = database.getLibraries();
        List<Book> books1 = database.getBooks();
        for (Library b : arrayLibrary) {
            if (b.getId() == libraryId) {
                books1.clear();
                System.out.println("Book at clear");
            }
        }
    }
}

