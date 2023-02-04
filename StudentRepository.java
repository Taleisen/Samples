/*
 * Written By Curtis Lynn
 */
package com.example.demo;

import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.*;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>
{
	@Modifying
	@Query("delete from Student where first = :first")
	void deleteStudentsByFirstName(@Param("first") String firstName);
	
	@Query("from Student where last = :last")
	List<Student> findAllStudentsByLastName(@Param("last") String lastName);
	
	@Query("from Student")
	List<Student> findAllStudents(Pageable pageable);
}


