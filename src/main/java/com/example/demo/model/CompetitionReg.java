package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Lob;

@Document(collection="competitoinheld")
public class CompetitionReg {
	
	private String compiname;
	private String location;
	private String prizemoney;
	private String startdate;
	private String enddate;
	private String city;
	private String mobileno;
	private String _id;
	private String applied;
	
	
	
	
	@Lob
	@Column(columnDefinition="MEDIUMBLOB")
	private String data;
	
	public String getMobileno() {
		return mobileno;
	}
	
	public String getApplied() {
		return applied;
	}
	public void setApplied(String applied) {
		this.applied = applied;
	}
	
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	 
	
	public String getData() {
		return data;
	}
	public void setData(String string) {
		this.data = string;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCompiname() {
		return compiname;
	}
	public void setCompiname(String compiname) {
		this.compiname = compiname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPrizemoney() {
		return prizemoney;
	}
	public void setPrizemoney(String prizemoney) {
		this.prizemoney = prizemoney;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	@Override
	public String toString() {
		return "CompetitionReg [compiname=" + compiname + ", location=" + location + ", prizemoney=" + prizemoney
				+ ", startdate=" + startdate + ", enddate=" + enddate + "]";
	}
	
	
	

}
