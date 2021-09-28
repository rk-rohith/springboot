package com.example.demo.service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	public String deleteStudent(String id) {
		studentRepository.deleteById(id);
		return "Student has been deleted.";
	}

	public Student getStudentById(String id) {
		return studentRepository.findById(id).get();
	}

	public List<Student> getStudentsByName(String name) {
		return studentRepository.findByName(name);
	}

	public List<Student> getStudentsByNameAndMail(String name, String email) {
		return studentRepository.findByNameAndEmail(name, email);
	}

	public List<Student> getStudentsByNameOrMail(String name, String email) {
		return studentRepository.findByNameOrEmail(name, email);
	}

	public List<Student> byDepartmentName(String deptName) {
		return studentRepository.findByDepartmentDepartmentName(deptName);
	}

	public List<Student> bySubjectName(String subName) {
		return studentRepository.findBySubjectsSubjectName(subName);
	}

	public List<Student> emailLike(String email) {
		return studentRepository.findByEmailIsLike(email);
	}

	public List<Student> nameStartsWith(String name) {
		return studentRepository.findByNameStartsWith(name);
	}

	public List<Student> getAllWithPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return studentRepository.findAll(pageable).getContent();
	}

	public List<Student> allWithSorting() {
		Sort sort = Sort.by(Sort.Direction.ASC, "name", "email ");
		return studentRepository.findAll(sort);
	}

	public List<Student> getByLocation(String location) {
		Query query = new Query();
		query.addCriteria(Criteria.where("department.location").is(location));
		return mongoTemplate.find(query, Student.class);
	}
}
