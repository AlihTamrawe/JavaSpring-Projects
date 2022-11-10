package com.axsos.loginregistration.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.axsos.loginregistration.models.Book;
import com.axsos.loginregistration.models.LoginUser;
import com.axsos.loginregistration.models.User;
import com.axsos.loginregistration.repositories.BookRepository;
import com.axsos.loginregistration.repositories.UserRepository;
    

    
@Service
public class UserService {
    
    @Autowired
    private final  UserRepository userRepo;
    
	private final BookRepository bookRepository;

    
    public UserService(UserRepository userRepo ,BookRepository bookRepository){
    	this.userRepo = userRepo;
    	this.bookRepository = bookRepository;
//    	this.borrowRepository = borrowRepository;
    }
    
    public Book findBook(Long id) {
    	
    	return  bookRepository.findById(id).get();
    }
 public Book createBook(Book book)  throws IOException{

    	return  bookRepository.save(book);
    }
 
 public List<Book> allBook() {
     return bookRepository.findAll();
 }
 public User AddBooktouser(Book book,User user)  throws IOException{
	 
	 List<Book> mybooks = userRepo.findById(user.getId()).get().getBooks();
	 
	 mybooks.add(book);
	 
	 user.setBooks(mybooks);
	 userRepo.save(user);
	 book.setUser(user);
	 bookRepository.save(book);
      return  user;

 
 }
    public User find(Long id) {
    	
    	return  userRepo.findById(id).get();
    }
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());

    	
    	if(result.hasErrors()) {
        	return null;

    	}else {
    		if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    		    
    		}
    		else {
    			
    			if(!potentialUser.isPresent()) {
        			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());

    				newUser.setPassword(hashed);
        			userRepo.save(newUser);
        			return newUser;
    			}
    		}

    	}
    	return null;


    }
    public User findbyemail(String email) {
    	return userRepo.findByEmail(email).get();
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
    	if(result.hasErrors()) {
        	return null;

    	}
    		Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    		if(potentialUser.isPresent()) {
    			
    			if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())) {
    			    result.rejectValue("password", "Matches", "Invalid Password!");
    	        	return null;

    			}
    			}
    		
    		if(!potentialUser.isPresent()) {
			    result.rejectValue("email", "Matches", "Invalid email!");

				return null;

    		}
    		
    		
    		return potentialUser.get();

    	
    	

    }
    
    public Book UpdatedBook(Long id,Book book)  throws IOException{
    	Book book1 = bookRepository.findById(id).get();
    	book1.setTitle(book.getTitle());
    	book1.setAuthor(book.getAuthor());
    	book1.setThoughts(book.getThoughts());
   	 
         return  bookRepository.save(book1);


    
     
 }
    public void deletebook(Long id) {
    	Book book1 = bookRepository.findById(id).get();
    	
   	 
           bookRepository.delete(book1);
           

    
     
 }
    public User borrowbook(Book book , User user) {
    	
//    	List<Book> borrowbooks = user.getBorrowBooks();
//    	
//    	borrowbooks.add(book);
//    	
//    	user.setBooks(borrowbooks);
//    	userRepo.save(user);
      	book.setBorrower(user);
      	bookRepository.save(book);
    	
    	return user;
    	
    }
 public void undoborrowbook(Book  br,User user) {

//  	List<Book> borrowbook = user.getBorrowBooks();
//  	int count =0 ;
//  	for(Book b:borrowbook) {
//  		
//  		if(b.getId()==br.getId()) {
//  		break;
//  		}
//  		count++;
//  	}
//  	borrowbook.remove(count);
//  	user.setBorrowBooks(borrowbook);  
//  	userRepo.save(user);
	 	User user2=null;
		br.setBorrower(user2);
		
		
      	bookRepository.save(br);

  	
 }
    
// public void findborrow(User user) {
//	 
////	 borrowRepository.findById()
// }
 

}