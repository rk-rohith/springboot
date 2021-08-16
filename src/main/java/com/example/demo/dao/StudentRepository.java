package com.example.demo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
	
	
	//Queries:
	List<Student> findByName(String name);
	List<Student> findByNameAndEmail(String name, String email);
	List<Student> findByNameOrEmail(String name, String email);
	List<Student> findByDepartmentDepartmentName(String deptname);
	List<Student> findBySubjectsSubjectName(String subName);
	List<Student> findByEmailIsLike(String email);
	List<Student> findByNameStartsWith(String name);
}
