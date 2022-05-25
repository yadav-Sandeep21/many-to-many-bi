package com.ty.StudentCourse;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class TestSaveStudentCourses {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student student1=new Student();
		student1.setName("Neeraj");
		student1.setAge(24);
		
		Student student2=new Student();
		student2.setName("Nitish");
		student2.setAge(25);
		
		Student student3=new Student();
		student3.setName("Sandeep");
		student3.setAge(23);
		
		Course courses1=new Course();
		courses1.setName("Java");
		courses1.setDuration(10);
		
		Course courses2=new Course();
		courses2.setName("HTML");
		courses2.setDuration(5);
		
		Course courses3=new Course();
		courses3.setName("CSS");
		courses3.setDuration(1);
		
		List<Course> courses=new ArrayList<Course>();
		courses.add(courses1);
		courses.add(courses2);
		courses.add(courses3);
		
		List<Student> students=new ArrayList<Student>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		
		student1.setCourse(courses);
		student2.setCourse(courses);
		student3.setCourse(courses);

		courses1.setStudent(students);
		courses2.setStudent(students);
		courses3.setStudent(students);
		
		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);
		entityManager.persist(courses1);
		entityManager.persist(courses2);
		entityManager.persist(courses3);
		entityTransaction.commit();
	}

}
