package com.wallet.cloud.skel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Player")
public class Player extends AbstractEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Long mId;
	@Column(unique = true)
	private String name;
	private Gender gender;
	private Integer age;
	@OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
	
	
	public Player() {
		super();
	}





	public Player(String name, Gender gender, Integer age, Account account) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.account = account;
	}




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



	public Gender getGender() {
		return gender;
	}



	public void setGender(Gender gender) {
		this.gender = gender;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}





	public Account getAccount() {
		return account;
	}





	public void setAccount(Account account) {
		this.account = account;
	}





	@Override
	public String toString() {
		return "Player [mId=" + mId + ", name=" + name + ", gender=" + gender + ", age=" + age + ", account=" + account
				+ "]";
	}
	
	
	
	

}
