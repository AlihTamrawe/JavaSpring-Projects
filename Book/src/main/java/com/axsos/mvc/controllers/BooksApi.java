package com.axsos.mvc.controllers;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axsos.mvc.models.Book;
import com.axsos.mvc.services.BookService;
@RestController
public class BooksApi {
    private final BookService bookService;
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    @RequestMapping("")
    public void welcome(HttpServletResponse response) throws IOException {
        response.sendRedirect("/api/books");
    }
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id ,HttpServletResponse response) throws IOException {
       
    
        bookService.deleteBook(id);
        
        response.sendRedirect("/showdelete");
        
    }
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public String Update(@PathVariable("id") Long id ,@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) throws IOException {
       
    
        
        
        return bookService.Updatedtitle(id,title)+bookService.Updateddesc(id, desc)+bookService.Updatedlanguage(id, lang)+bookService.Updatedpages(id, numOfPages); 
        }
    
    @RequestMapping("/showdelete")
    public String show() {
     
        return "Delete it successufully";
    }
    
}