package Model;

import java.util.List;

public class Database {
    private List<Library>libraries;
    private List<Book>books;
    private List<Reader> readers;

    public Database(List<Library> libraries, List<Book> books, List<Reader> readers) {
        this.libraries = libraries;
        this.books = books;
        this.readers = readers;
    }

    public Database() {}

    public List<Library> getLibraries() {
        return libraries;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    @Override
    public String toString() {
        return  "\n= Database = " +"\n"+
                "\n= Libraries="+"\n" + libraries +
                "\n== Books ===" +"\n"+ books +
                "\n== Readers =" +"\n"+ readers ;
    }
}
