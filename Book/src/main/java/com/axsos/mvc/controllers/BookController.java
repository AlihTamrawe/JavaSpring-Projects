package com.axsos.mvc.controllers;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.mvc.models.Book;
import com.axsos.mvc.services.BookService;

@Controller
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
    	this.bookService=bookService;
    	
    }

	
	@RequestMapping("/books/{id}")
    public String show(@PathVariable("id") Long id,Model model) throws IOException  {
		  Book book = bookService.findBook(id);
	         
        
        if(book.getTitle() != null)
        {
        model.addAttribute("title", book.getTitle());
        model.addAttribute("desc", book.getDescription())	;
        model.addAttribute("lang", book.getLanguage())	;
        model.addAttribute("pages", book.getNumberOfPages())	;

        }
        return "show.jsp";
    }
	@RequestMapping("/books")
    public String all(Model model) throws IOException  {
		 ArrayList<Book>  books = (ArrayList<Book>) bookService.allBooks();
       
        model.addAttribute("books", books);
       
        
        return "all.jsp";
    }
    

}
