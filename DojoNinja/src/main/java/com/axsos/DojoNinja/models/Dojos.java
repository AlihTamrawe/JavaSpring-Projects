package com.axsos.DojoNinja.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

//...
@Entity
@Table(name="dojos")
public class Dojos {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
 private List<Ninjas> ninjas;
 
 public Dojos() {
     
 }

public Dojos(String name, List<Ninjas> ninjas) {
	super();
	this.name = name;
	this.ninjas = ninjas;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Ninjas> getNinjas() {
	return ninjas;
}

public void setNinjas(List<Ninjas> ninjas) {
	this.ninjas = ninjas;
}

public Long getId() {
	return id;
}
@PrePersist
protected void onCreate(){
    this.createdAt = new Date();
}
@PreUpdate
protected void onUpdate(){
    this.updatedAt = new Date();
}



 
}