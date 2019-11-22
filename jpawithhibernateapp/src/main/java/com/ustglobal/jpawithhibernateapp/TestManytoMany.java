package com.ustglobal.jpawithhibernateapp;

import java.util.ArrayList;

import javax.persistence.*;

import com.ustglobal.jpawithhibernateapp.manytomany.Course;
import com.ustglobal.jpawithhibernateapp.manytomany.Student;

public class TestManytoMany {

	public static void main(String[] args) {
		
		Course course = new Course();
		course.setCid(101);
		course.setCname("java");
		
		Course course1 = new Course();
		course1.setCid(102);
		course1.setCname("jdbc");
		
		ArrayList<Course> alCourses =new ArrayList<Course>();
		alCourses.add(course1);
		alCourses.add(course);
		
		Student s1 = new Student();
		s1.setSid(201);
		s1.setSname("pari");
		s1.setCourse(alCourses);
		
		EntityTransaction Transaction = null;
		EntityManager Manager = null;
		
		try {
			
			EntityManagerFactory ManagerFactory = Persistence.createEntityManagerFactory("test");
			Manager = ManagerFactory.createEntityManager();
			Transaction = Manager.getTransaction();
			Transaction.begin();
			
			Manager.persist(s1);
			
			System.out.println("Record saved");
			Transaction.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			Transaction.rollback();
		}
        
		Manager.close();
	}

}
