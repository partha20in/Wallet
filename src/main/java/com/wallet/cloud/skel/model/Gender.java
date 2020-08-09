package com.wallet.cloud.skel.model;

import java.io.Serializable;

public enum Gender implements Serializable{
	
		  MALE("MALE"),
		  FEMALE("FEMALE"),
		  NOT_DISCLOSE("NOT_DISCLOSE");
		  
	private String name;
	
	Gender(String name) {
	 this.name=name;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
        return this.name();
    }
		
}
