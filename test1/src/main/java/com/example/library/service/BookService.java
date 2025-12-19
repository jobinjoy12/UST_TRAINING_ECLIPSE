package com.example.library.service;

import java.util.List;

import com.example.library.model.Author;
import com.example.library.model.Book;

import org.springframework.stereotype.Service;

import com.example.library.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository br ;

    public BookService(BookRepository br)
    {
        this.br = br ;
    }

    public List<Book> getAllBooks()
    {
        return br.findAll();
    }

    public Book getBookById(Long id)
    {
        return br.findById(id).orElseThrow(()->new RuntimeException("Book not found"));
    }

    public Book createBook(Book book)
    {
        Author author = book.getAuthor();
        author.getBooks().add(book);
        return br.save(book);
    }

    public Book updateBook(Long id , Book updatedBook)
    {
        Book book = getBookById(id);
        book.setTitle(updatedBook.getTitle());
        book.setIsbn(updatedBook.getIsbn());
        book.setAuthor(updatedBook.getAuthor());
        return br.save(book);
    }

    public void deleteBook(Long id )
    {
        br.deleteById(id);
    }
}
