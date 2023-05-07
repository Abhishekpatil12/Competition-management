package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="participantdetails")
public class ParticipantReg {
    
	private String username;
    private String Number;
	private String password;
	private String confirm_password;
	
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String Number) {
		this.Number = Number;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getconfirm_password() {
		return confirm_password;
	}
	public void setconfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	
	@Override
	public String toString() {
		return "Participant [username=" + username + ", Number=" + Number + ", password=" + password +", confirm_password=" + confirm_password +"]";
	}
}
