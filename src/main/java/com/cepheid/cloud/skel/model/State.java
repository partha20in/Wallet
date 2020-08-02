package com.cepheid.cloud.skel.model;

import java.io.Serializable;

public enum State implements Serializable{
	
		  UNDEFINED("UNDEFINED"),
		  VALID("VALID"),
		  INVALID("INVALID");
	private String name;
	
	State(String name) {
	 this.name=name;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getState() {
        return this.name();
    }
		
}
