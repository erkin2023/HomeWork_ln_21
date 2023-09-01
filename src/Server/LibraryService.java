package Server;

import Interface.libraryServer;
import Model.Book;
import Model.Database;
import Model.Library;
import Model.Reader;

import java.util.ArrayList;
import java.util.Formattable;
import java.util.Iterator;
import java.util.List;

public class LibraryService implements libraryServer {
    private Database database;

    public LibraryService(Database database) {
        this.database = database;
    }

    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        List<Library> libraries1 = database.getLibraries();
        libraries1.addAll(libraries);
        System.out.println("save in library");
        return libraries1;
    }

    @Override
    public List<Library> getAllLibraries() {
        return database.getLibraries();
    }

    @Override
    public Library getLibraryById(Long id) {
        List<Library> arrayList = database.getLibraries();
        for (Library b : arrayList) {
            if (b.getId() == id) {
                System.out.println(b);
            }
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        List<Library> arrayList = database.getLibraries();
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).getId()==id){
                arrayList.set(i,library);
            }
        }
        return null;
    }

    @Override
    public String deleteLibrary(Long id) {
        Iterator<Library> iterator = database.getLibraries().iterator();
        while (iterator.hasNext()) {
            Library library = iterator.next();
            if (library.getId() == id) {
                iterator.remove(); // Удаление элемента с помощью итератора
            }
        }
        System.out.println("deleted library : "+id+"\n"+database.getLibraries());
        return null;
    }
}


