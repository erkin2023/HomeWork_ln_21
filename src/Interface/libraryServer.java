package Interface;

import Model.Library;

import java.util.List;

public interface libraryServer {
     List<Library> saveLibrary(List<Library>libraries);

     List<Library>getAllLibraries();

     Library getLibraryById(Long id);

     Library updateLibrary(Long id, Library library);

     String deleteLibrary(Long id);
}
