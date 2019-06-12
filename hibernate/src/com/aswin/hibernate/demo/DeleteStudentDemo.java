 package com.aswin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aswin.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//int studentId=5;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Student myStudent = session.get(Student.class, studentId);
			
			//session.delete(myStudent );
			
			session.createQuery("delete from Student where id =4").executeUpdate();
			
			session.getTransaction().commit();
			
		}
		
		finally {
			factory.close();
		}

	}

}
