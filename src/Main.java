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
            // Добавьте остальные варианты кейсов

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Метод для сохранения библиотеки
                    List<Library> savedLibraries = libraryService.saveLibrary(arrayLibraries);
                    break;
                case 2:
                    // Метод для получения всех библиотек
                    List<Library> allLibraries = libraryService.getAllLibraries();
                    break;
                case 3:
                    // Метод для получения библиотеки по ID
                    Library libraryById = libraryService.getLibraryById(1L);
                    break;
                // Добавьте остальные кейсы здесь
                default:
                    System.out.println("Неверный номер кейса");
                    break;
            }

            System.out.println("Продолжить? (1 - Да, 0 - Нет)");
            int continueChoice = scanner.nextInt();
            if (continueChoice == 0) {
                break;
            }
        }

        scanner.close();
    }
}
