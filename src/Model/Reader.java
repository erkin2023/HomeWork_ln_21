package Model;

public class Reader {
    /*Library(id, name, address, List<Book>books, List<Reader>readers)
Book(id, name, author, Genre genre)
Reader(id, fullName, email, phoneNumber, Gender gender)
Database(List<Library>libraries, List<Book>books,List<Reader>readers)*/
    private static int idd=1;
    private int id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private Genre genre;

    public Reader( String fullName, String email, String phoneNumber, Genre genre) {

        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.genre = genre;
        this.id=idd++;
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "\n===== Reader =====" +
                " Id = "+ id +
                " FullName ='" + fullName +
                " Email =" + email +
                " PhoneNumber = " + phoneNumber +
                " Genre = " + genre +"\n";
    }
}
