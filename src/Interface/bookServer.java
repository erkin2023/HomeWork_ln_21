package Interface;

import Model.Book;

import java.util.List;

public interface bookServer {
    Book saveBook(Long libraryId,Book book);

    List<Book> getAllBooks(Long libraryId);

    Book getBookById(Long libraryId, Long bookId);

    Book getBookById(Long libraryId, int bookId);

    String deleteBook(Long libraryId, Long bookId);

    String deleteBook(Long libraryId, int bookId);

    void clearBooksByLibraryId(Long libraryId);
}
