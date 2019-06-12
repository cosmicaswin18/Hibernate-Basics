 package com.aswin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aswin.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId=5;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studentId);
			
			myStudent.setFirstName("Scooby");
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student s set email='foo@gmail.com' where s.id=5").executeUpdate();
			
			session.getTransaction().commit();
			
		}
		
		finally {
			factory.close();
		}

	}

}
