package com.example.library.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.library.model.Book;
import com.example.library.service.BookService;

@RestController
@RequestMapping("/api/books")

public class BookController {


    private final BookService bs;

    public BookController(BookService bs)
    {
        this.bs = bs;
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks()
    {
       List<Book> list =  bs.getAllBooks();
        if(list != null){
        return new ResponseEntity<>(list,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id)
    {
        try{Book book = bs.getBookById(id);
             return new ResponseEntity<>(book,HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
       
    }

    @PostMapping()
    public ResponseEntity<Book> createBook(@RequestBody Book book1)
    {
        Book book = bs.createBook(book1);
        if(book != null){
        return new ResponseEntity<>(book,HttpStatus.CREATED);}
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id , @RequestBody Book book)
    {
        try{Book book2 = bs.updateBook(id, book);
        return new ResponseEntity<>(book2,HttpStatus.OK);
        }catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id)
    {
        bs.deleteBook(id);
        if(bs.getBookById(id)==null)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
