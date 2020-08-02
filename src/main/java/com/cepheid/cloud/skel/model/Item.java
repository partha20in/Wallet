package com.cepheid.cloud.skel.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Item")
public class Item extends AbstractEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
   
	protected Long mId;
	private String name;
	private State state;
	
	@OneToMany(mappedBy = "item",fetch = FetchType.EAGER)
	private List<Description> desc;
	
	

	public Long getId() {
		return mId;
	}

	public void setId(Long Id) {
		this.mId = Id;
	}

	public String getName() {
		return name;
	}

	

	public void setName(String name) {
		this.name = name;
	}

	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Item() {
	}


	public Item(String name, State state) {
		super();
		this.name = name;
		this.state = state;
		
	}

	@Override
	public String toString() {
		return "Item [mId=" + mId + ", name=" + name + ", state=" + state + ", desc=" + desc + "]";
	}
	

		
	
}
