package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="competition")
public class User {
	
	@Id
	private String uname;
	private String pass;
	private String name;
	private String applied;
	private String held;
	
	
	
	public String getHeld() {
		return held;
	}
	public void setHeld(String held) {
		this.held = held;
	}
	public String getApplied() {
		return applied;
	}
	public void setApplied(String applied) {
		this.applied = applied;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User() {
		super();
	}
	public User(String uname, String pass,String name) {
		super();
		this.uname = uname;
		this.pass = pass;
		this.name = name;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "User [uname=" + uname+ ", pass=" + pass + "]";
	}
	

}
