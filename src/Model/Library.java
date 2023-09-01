package Model;

import java.util.List;

public class Library {
    /*Library(id, name, address, List<Book>books, List<Reader>readers)
    Book(id, name, author, Genre genre)
    Reader(id, fullName, email, phoneNumber, Gender gender)
    Database(List<Library>libraries, List<Book>books,List<Reader>readers)*/
    public static int idd=1;
    private int id;
    private String name;
    private String address;
    private List<Book> books;
    private List<Reader>readers;

    public Library( String name, String address, List<Book> books,List<Reader> readers) {

        this.name = name;
        this.address = address;
        this.books = books;
        this.readers = readers;
        this.id=idd++;
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.id = idd;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    @Override
    public String toString() {
        return "\n===== Library ====" +
                " Id = " + id +
                " Name =" + name +
                " Address ='" + address +
                " Books=   " + books +
                " Readers= " + readers +"\n" ;
    }
}
