package com.cepheid.cloud.skel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Description")
public class Description extends AbstractEntity implements Serializable{
/**
	 * 
	 */
private static final long serialVersionUID = 1L;

protected Long mId;	
private String type;
private Long budget;
private Long release_year;


@ManyToOne
@JoinColumn(name = "item_id")
private Item item;


public Description() {
	
}



public Description(String type, Long budget, Long release_year, Item item) {
	super();
	this.type = type;
	this.budget = budget;
	this.release_year = release_year;
	this.item = item;
}



public Long getId() {
	return mId;
}



public void setId(Long Id) {
	this.mId = Id;
}



public String getType() {
	return type;
}





public void setType(String type) {
	this.type = type;
}



public Long getBudget() {
	return budget;
}



public void setBudget(Long budget) {
	this.budget = budget;
}



public Long getRelease_year() {
	return release_year;
}



public void setRelease_year(Long release_year) {
	this.release_year = release_year;
}



public Item getItem() {
	return item;
}



public void setItem(Item item) {
	this.item = item;
}



@Override
public String toString() {
	return "Description [mId=" + mId + ", type=" + type + ", budget=" + budget + ", release_year=" + release_year + "]";
}


}
