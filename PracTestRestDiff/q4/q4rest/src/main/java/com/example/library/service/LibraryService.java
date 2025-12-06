package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Library;
import com.example.library.repository.BookRepository;
import com.example.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private BookRepository bookRepository;

    public Library createLibrary(Library library) {
        // TODO: Implement the logic to save a new library
        Library lib = libraryRepository.save(library);
        return lib; // Placeholder
    }

    public Optional<Library> getLibraryById(Long id) {
        // Helper method, not a direct TODO for the main task but useful
        return libraryRepository.findById(id);
    }

    public Book addBookToLibrary(Long libraryId, Book book) {
        // TODO: Implement the logic to add a book to a specific library.
        //  - Find the library by libraryId using getLibraryById().
        //  - If found, set the book's library, then save the book.
        //  - If not found, return null or throw an appropriate exception.
        //List<Book> list = bookRepository.findByLibraryId(libraryId);
        Optional<Library> lib = libraryRepository.findById(libraryId);
        if(lib.isEmpty())
        {
            return null;
        }
        book.setLibrary(lib.get());
        return bookRepository.save(book) ; // Placeholder
    }

    public List<Book> getBooksByLibraryId(Long libraryId) {

        // TODO: Implement the logic to retrieve all books housed by a specific library.
        //  - Use BookRepository to find books by libraryId.
        //  - If the library doesn't exist, you might return an empty list or null.
        return bookRepository.findByLibraryId(libraryId); // Placeholder
    }
}