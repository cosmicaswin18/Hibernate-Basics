 package com.aswin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aswin.hibernate.demo.entity.Instructor;
import com.aswin.hibernate.demo.entity.InstructorDetail;


public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			/*Instructor tempInstructor = new Instructor("Cosmic","Aswin","cosmic@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.manga.com/youtube","Read Manga");
			*/
			Instructor tempInstructor = new Instructor("Madhu","Patel","madhu@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com","Guitar");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			session.save(tempInstructor);
			
			session.getTransaction().commit();
		}
		
		finally {
			factory.close();
		}

	}

}
