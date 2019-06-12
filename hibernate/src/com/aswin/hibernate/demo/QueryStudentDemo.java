 package com.aswin.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aswin.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			
			List<Student> theStudents = session.createQuery("from Student").list(); 
			
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").list(); 
			
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where " +"s.lastName='Doe' OR s.firstName='Daffy'").list(); 
			
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where " + "s.email LIKE '%gmail.com'").list(); 
			
			displayStudents(theStudents);
			
			
			session.getTransaction().commit();
		}
		
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
