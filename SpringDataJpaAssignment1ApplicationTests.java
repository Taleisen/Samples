package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.mysql.cj.Query;

import java.util.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
class SpringDataJpaAssignment1ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	StudentRepository students;
	
	@Test
	void testInsertion() 
	{	
		Student student1 = new Student(1,1001,"stu@dent.edu","Math 101","Stu", "Denton");
		Student student2 = new Student(2,1002,"jill@dent.edu","Programming 210", "Jill", "Johnson");
		Student student3 = new Student(3,1003,"jon@dent.edu","Biology 350", "Jon", "Smith");
		Student student4 = new Student(4,1004,"max@dent.edu","Art 200", "Max", "Brush");
		Student student5 = new Student(5,1005,"perma@dent.edu","Physics 957", "Perma", "Fields");
		Student student6 = new Student(6,1006,"mark@dent.edu","Sociology 215", "Mark","Sully");
		
		students.save(student1);
		students.save(student2);
		students.save(student3);
		students.save(student4);
		students.save(student5);
		students.save(student6);
		
		System.out.println("Student Information Successfully Saved to Database.");
	}
	
	@Test
	@Transactional
	@Rollback(false)
	void testDelete() 
	{
		String temp = "";
		List<Student> roll = students.findAllStudents(null);
		for(Student s: roll) 
		{
			if(s.getFirst().startsWith("M")) 
			{
				temp = s.getFirst();
				students.deleteStudentsByFirstName(temp);
			}
		}
		System.out.println("Students have been deleted.");
	}
	
	@Test
	void testSelect() 
	{
		String temp = "";
		List<Student> roll = students.findAllStudents(null);
		for(Student s: roll) 
		{
			if(s.getFirst().endsWith("n")) 
			{
				temp = s.getLast();
				students.findAllStudentsByLastName(temp);
			}
		}
		System.out.println("Student records selected.");
	}
	
}
