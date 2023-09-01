package Interface;

import Model.Reader;

import java.util.List;

public interface readerServer {
    void saveReader(Reader reader);

    List<Reader> getAllReaders();

    Reader getReaderById(Long id);

    Reader updateReader(Long id, Reader reader) throws IllegalAccessException;

    void assignReaderToLibrary(Long readerId,Long libraryId);
}
