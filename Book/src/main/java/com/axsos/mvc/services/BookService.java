package com.axsos.mvc.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.axsos.mvc.models.Book;
import com.axsos.mvc.repositories.BookRepository;
@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public void deleteBook(Long id) {
    	 Optional<Book> optionalBook = bookRepository.findById(id);
    	 
         if(optionalBook.isPresent()) {
        	 bookRepository.delete(optionalBook.get());
         } else {
        	 
         }	
    }
    public String Updatedtitle(Long id,String title)  throws IOException{
    	 Optional<Book> optionalBook = bookRepository.findById(id);

        if(optionalBook.isPresent()) {
        	Book b = optionalBook.get();
        	b.setTitle(title);
        	

           	bookRepository.save(b);

            return "Successful";


        } else {
        	
        	return "Failed";

        }
        
    }
    public String Updateddesc(Long id,String desc)  throws IOException{
   	 Optional<Book> optionalBook = bookRepository.findById(id);

       if(optionalBook.isPresent()) {
       	Book b = optionalBook.get();
       	b.setDescription(desc);
       	

       	bookRepository.save(b);

           return "Successful";


       } else {
       	
       	return "Failed";

       }
       
   }
    public String Updatedlanguage(Long id,String lang)  throws IOException{
   	 Optional<Book> optionalBook = bookRepository.findById(id);

       if(optionalBook.isPresent()) {
       	Book b = optionalBook.get();
       	b.setLanguage(lang);
       	
       	bookRepository.save(b);

           return "Successful";


       } else {
       	
       	return "Failed setNumberOfPages";

       }
       
   }
    public String Updatedpages(Long id,int numOfPages)  throws IOException{
   	 Optional<Book> optionalBook = bookRepository.findById(id);

       if(optionalBook.isPresent()) {
       	Book b = optionalBook.get();
       	b.setNumberOfPages(numOfPages);
       	bookRepository.save(b);
           return "Successful setNumberOfPages";


       } else {
       	
       	return "Failed setNumberOfPages";

       }
       
   }
    
}