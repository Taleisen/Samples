/*
 * Written By Curtis Lynn
 */
package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "students")
public class Student {
	@Id
	private int rollNumber;
	private int id;
	
	
	private String emailId, courseName, first, last;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public Student(int id, int rollNumber, String emailId, String courseName, String first, String last) {
		super();
		this.id = id;
		this.rollNumber = rollNumber;
		this.emailId = emailId;
		this.courseName = courseName;
		this.first = first;
		this.last = last;
	}
	
}
