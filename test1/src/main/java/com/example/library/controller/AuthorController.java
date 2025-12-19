package com.example.library.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.library.model.Author;
import com.example.library.service.AuthorService;


@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService as ; 

    public AuthorController(AuthorService as)
    {
        this.as = as ;
    }

    @GetMapping()
    public ResponseEntity<List<Author>> findAllAuthors(){
        List<Author> list = as.getAllAuthors();
        if(list!=null){
        return new ResponseEntity<>(list,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findAuthorById(@PathVariable Long id){
        try{
        Author a = as.getAuthorById(id);
        return new ResponseEntity<>(a,HttpStatus.OK);
        
        }catch(RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
       Author a = as.createAuthor(author);
       if(a!= null){
        return new ResponseEntity<>(a,HttpStatus.CREATED);
       }
       else{
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author){
        try{
        Author a = as.updateAuthor(id, author);
        return new ResponseEntity<>(a,HttpStatus.OK);
       }catch(RuntimeException e){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthor(@PathVariable Long id)
    {
        as.deleteAuthor(id);
        if(as.getAuthorById(id)==null)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
