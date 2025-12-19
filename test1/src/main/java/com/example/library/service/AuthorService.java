package com.example.library.service;

import com.example.library.model.Author;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.library.repository.AuthorRepository;

@Service
public class AuthorService {

    private final AuthorRepository ar;

    public AuthorService(AuthorRepository ar ){
        this.ar = ar;
    }

    public List<Author> getAllAuthors(){
       return ar.findAll();
    }

    public Author getAuthorById(Long id){
        return ar.findById(id).orElseThrow(()-> new RuntimeException("Author doesn't exist"));
    }

    public Author createAuthor(Author author){
        author
        return ar.save(author);
    }

    public Author updateAuthor(Long id , Author updatedAuthor)
    {
        Author a = getAuthorById(id);
        a.setName(updatedAuthor.getName());
        a.setBooks(updatedAuthor.getBooks());

        return ar.save(a);
        
    }

    public void deleteAuthor(Long id)
    {
        ar.deleteById(id);
    }
}
