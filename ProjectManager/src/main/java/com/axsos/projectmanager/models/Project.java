package com.axsos.projectmanager.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name="projects")
public class Project {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	
	 	@NotNull
	 	@Size(min=3, max=30, message="Username must be between 3 and 30 characters")
	    private String title;
	 	
	 	
		@NotNull
	 	@Size(min=3, max=30, message="Username must be between 3 and 30 characters")
	    private String description;
		
		@NotNull
	    @JsonFormat(pattern = "dd/MM/yyyy")
	    private Date date;
		
	     
		 @ManyToOne(fetch = FetchType.LAZY)
		    @JoinColumn(name="leader_id")
		    private User teamLead;
		 
		 @OneToMany(mappedBy="project", fetch = FetchType.LAZY)
		    private List<Task> tasks;
	     
	     @ManyToMany(fetch = FetchType.LAZY)
	     @JoinTable(
	         name = "members", 
	         joinColumns = @JoinColumn(name = "project_id"), 
	         inverseJoinColumns = @JoinColumn(name = "member_id")
	     )
	     private List<User> participant;
	     
	     public Project() {
	    	 
	     }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public User getTeamLead() {
			return teamLead;
		}

		public void setTeamLead(User teamLead) {
			this.teamLead = teamLead;
		}

		public List<User> getParticipant() {
			return participant;
		}

		public void setParticipant(List<User> participant) {
			this.participant = participant;
		}
	     

	     
	     
}
