import Model.*;
import Server.BookService;
import Server.LibraryService;
import Server.ReaderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        //BOOK
        List<Book>arrayBook1 = new ArrayList<>(List.of(
                new Book("Ak keme","Chyngyz Aytmatov", Genre.Adventure),
                new Book("New generated history","erkin", Genre.HistoricalFiction),
                new Book("That should be your meaning of life","jandar", Genre.Romance)));
        List<Book>arrayBook2 = new ArrayList<>(List.of(
                new Book("2050 generated programmers","adlia ", Genre.Fantasy),
                new Book("Legend","messi", Genre.Biography),
                new Book("All you need for success is discipline","ronaldo", Genre.SelfDevelopment)
        ));
        //ARRAY BOOK
         List<Book>arrayBooks = new ArrayList<>();
         arrayBooks.addAll(arrayBook1);
         arrayBooks.addAll(arrayBook2);

         // TO ADD BOOK
        Book book1 = new Book("new book -1234567546","eeerrrrkinnn ", Genre.Fantasy);

        //READER
        List<Reader>arrayReader1 = new ArrayList<>(List.of(
                new Reader("jandar","jandar@gmail.com","+996709095524",Genre.Male),
                new Reader("zalkar","zalkar@gmail.com","+996709095524",Genre.Male),
                new Reader("alina","alina@gmail.com","+996709095524",Genre.Female)));
        List<Reader>arrayReader2 = new ArrayList<>(List.of(
                new Reader("tunuk","tunuk@gmail.com","+996709095524",Genre.Female),
                new Reader("nurusa","nurusa@gmail.com","+996709095524",Genre.Female),
                new Reader("balal","balal@gmail.com","+996709095524",Genre.Male)
        ));
        // TO ADD READER
        Reader reader =  new Reader("newReader","aaaa@gmail.com","+996709095524",Genre.Male);
        //ARRAY READER
        List<Reader>arrayReaders = new ArrayList<>();
        arrayReaders.addAll(arrayReader1);
        arrayReaders.addAll(arrayReader2);

        //LIBRARY 1
        List<Library>arrayLibrary1 = new ArrayList<>(List.of(
                new Library("KNU","chuy150",arrayBook1,arrayReader1)));

        //LIBRARY 2
        List<Library>arrayLibrary2 = new ArrayList<>(List.of(
                new Library("Biskek","manas150",arrayBook2,arrayReader2)));

        //LIBRARY 3 UPDATED
               Library library3 = new Library("MANAS","-----",arrayBooks,arrayReaders);

        //ARRAY LIBRARY
        List<Library>arrayLibraries = new ArrayList<>();
        arrayLibraries.addAll(arrayLibrary1);
        arrayLibraries.addAll(arrayLibrary2);

        //DATE OF BASE
        Database database = new Database(arrayLibraries,arrayBooks,arrayReaders);

        // Server
        LibraryService libraryService = new LibraryService(database);
        BookService bookService = new BookService(database);
        ReaderService readerService = new ReaderService(database);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1 - Сохранить библиотеку");
            System.out.println("2 - Получить все библиотеки");
            System.out.println("3 - Получить библиотеку по ID");
            System.out.println("4 - Обновить библиотеку по ID");
            System.out.println("5 - Удалить библиотеку по ID");
            System.out.println("6 - Сохранить книгу");
            System.out.println("7 - Получить все книги в библиотеке");
            System.out.println("8 - Получить книгу по ID в библиотеке");
            System.out.println("9 - Удалить книгу по ID в библиотеке");
            System.out.println("10 - Удалить все книги в библиотеке по ID библиотеки");
            System.out.println("11 - Сохранить читателя");
            System.out.println("12 - Получить всех читателей");
            System.out.println("13 - Получить читателя по ID");
            System.out.println("14 - Обновить читателя по ID");
            System.out.println("15 - Назначить читателя в библиотеку");
            System.out.println("0 - Выйти");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Метод для сохранения библиотеки
                    System.out.println(libraryService.saveLibrary(arrayLibraries));
                    break;
                case 2:
                    // Метод для получения всех библиотек
                    libraryService.getAllLibraries();
                    break;
                case 3:
                    // Метод для получения библиотеки по ID
                    System.out.println(libraryService.getLibraryById(1L));
                    break;
                case 4:
                    // Метод для обновления библиотеки по ID
                    System.out.println(libraryService.updateLibrary(2L, library3));
                    break;
                case 5:
                    // Метод для удаления библиотеки по ID
                    libraryService.deleteLibrary(2L);
                    break;
                case 6:
                    // Метод для сохранения книги
                    System.out.println(bookService.saveBook(1L, book1));
                    break;
                case 7:
                    // Метод для получения всех книг в библиотеке
                    bookService.getAllBooks(1L);
                    break;
                case 8:
                    // Метод для получения книги по ID в библиотеке
                    System.out.println(bookService.getBookById(1L, 1L));
                    break;
                case 9:
                    // Метод для удаления книги по ID в библиотеке
                    bookService.deleteBook(1L, 1L);
                    break;
                case 10:
                    // Метод для удаления всех книг в библиотеке по ID библиотеки
                    bookService.clearBooksByLibraryId(1L);
                    break;
                case 11:
                    // Метод для сохранения читателя
                    readerService.saveReader(reader);
                    break;
                case 12:
                    // Метод для получения всех читателей
                    readerService.getAllReaders();
                    break;
                case 13:
                    // Метод для получения читателя по ID
                    readerService.getReaderById(1L);
                    break;
                case 14:
                    // Метод для обновления читателя по ID
                    readerService.updateReader(1L, reader);
                    break;
                case 15:
                    // Метод для назначения читателя в библиотеку
                    readerService.assignReaderToLibrary(1L, 1L);
                    break;
                case 0:
                    System.out.println("Завершение программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный номер кейса");
                    break;
            }
        }
    }
}
