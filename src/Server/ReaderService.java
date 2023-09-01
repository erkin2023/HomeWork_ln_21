package Server;

import Interface.readerServer;
import Model.Book;
import Model.Database;
import Model.Library;
import Model.Reader;

import java.util.ArrayList;
import java.util.List;

public class ReaderService implements readerServer {
    private Database database;

    public ReaderService(Database database) {
        this.database = database;
    }

    public ReaderService(){}
    @Override
    public void saveReader(Reader reader) {
        List<Reader>saveReaders= database.getReaders();
        saveReaders.add(reader);
        System.out.println("saving Reader");
        }

    @Override
    public List<Reader> getAllReaders() {
        for (Reader n:database.getReaders()) {
            System.out.println(n);
        }


        return null;
    }

    @Override
    public Reader getReaderById(Long id) {
        for(Reader c:database.getReaders()){
            if (c.getId()==id){
                System.out.println(c);
            }
        }
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) throws IllegalAccessException {
        List<Reader>readers=database.getReaders();
        for (int i = 0; i < readers.size(); i++) {
            Reader student=readers.get(i);
                if(student.getId()==id){
                    readers.set(i,reader);
                    return reader;
                }
            }


        throw new IllegalAccessException("Читаталеь с ID"+id+" не найден ");
    }
    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        List<Library> libraries = database.getLibraries();
        List<Reader> readers = database.getReaders();

        Reader selectedReader = null;
        Library selectedLibrary = null;

        // Найдем выбранного читателя и библиотеку
        for (Reader red : readers) {
            if (red.getId() == readerId) {
                selectedReader = red;
                break; // Выходим из цикла, так как читатель найден
            }
        }

        for (Library l : libraries) {
            if (l.getId() == libraryId) {
                selectedLibrary = l;
                break; // Выходим из цикла, так как библиотека найдена
            }
        }

        // Проверим, что читатель и библиотека найдены
        if (selectedReader != null && selectedLibrary != null) {
            selectedLibrary.getReaders().add(selectedReader);
            System.out.println("Читатель успешно перемещен в библиотеку: " + selectedLibrary);
        } else {
            System.out.println("Данная библиотека или читатель не найдены");
        }
    }


//    @Override
//    public void assignReaderToLibrary(Long readerId, Long libraryId) {
//        List<Library> libraries = database.getLibraries();
//        List<Reader> readers = database.getReaders();
//        for (Reader red : readers) {
//            if (red.getId() == readerId) {
//                for (Library l : libraries) {
//                    if (l.getId() == libraryId) {
//                        l.getReaders().add(red);
//                        database.getLibraries().add(l);
//                        System.out.println("Читатель успешно перемещен: " + l);
//                    }
//                }
//            }
//        }
//        System.out.println("Данная библиотека или же читатель не найден");
//    }

    @Override
    public String toString() {
        return "ReaderService{" +
                "database=" + database +
                '}';
    }
}
