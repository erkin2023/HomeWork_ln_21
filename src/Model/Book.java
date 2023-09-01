package Model;

public class Book {
    /*Library(id, name, address, List<Book>books, List<Reader>readers)
Book(id, name, author, Genre genre)
Reader(id, fullName, email, phoneNumber, Gender gender)
Database(List<Library>libraries, List<Book>books,List<Reader>readers)*/
    public static int idd=1;
    private int id;
    private String bookName;
    private String author;
    private Genre genre;

    public Book(String bookName, String author, Genre genre) {
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
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

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "\n====== Book =====" +
                " Id = " + id +
                " BookName = " + bookName +
                " Author ='" + author  +
                " Genre = " + genre +"\n";
    }
}
