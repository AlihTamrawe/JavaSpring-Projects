package com.axsos.mvc1.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Travel")
public class Travel {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	
	 	
	 	@NotNull
	    @Size(min = 5, max = 200, message="expense must be at least 5 characters.")
	    private String expense;
	 	
	 	@NotNull
	 	@Size(min = 3, max = 40, message="vendor must be at least 3 characters.")
	    private String vendor;
	 	
	 	@NotNull
	 	@Min(value=1, message="Must be at least 1$.")
	 	private long amount;
	 	
	 	@NotNull
	    @Size(min = 5, max = 200, message="description must be at least 2 characters.")
	    private String description;
	 	
	 	 @Column(updatable=false)
	     @DateTimeFormat(pattern="yyyy-MM-dd")
	     private Date createdAt;
	     @DateTimeFormat(pattern="yyyy-MM-dd")
	     private Date updatedAt;
	     
	     
	    
	     public Travel(String expense, String vendor, long amount,String description) {
			this.expense = expense;
			this.vendor = vendor;
			this.amount = amount;
			this.description = description;
		
		}



		public Travel(){
	    	 
	     }
	 	
	 	
		 @PrePersist
		    protected void onCreate(){
		        this.createdAt = new Date();
		    }
		    @PreUpdate
		    protected void onUpdate(){
		        this.updatedAt = new Date();
		    }



			public Long getId() {
				return id;
			}



			



			public String getExpense() {
				return expense;
			}



			public void setExpense(String expense) {
				this.expense = expense;
			}



			public String getVendor() {
				return vendor;
			}



			public void setVendor(String vendor) {
				this.vendor = vendor;
			}



			public long getAmount() {
				return amount;
			}



			public void setAmount(long amount) {
				this.amount = amount;
			}



			public String getDescription() {
				return description;
			}



			public void setDescription(String description) {
				this.description = description;
			}
	 	
	 	
	
	

}
