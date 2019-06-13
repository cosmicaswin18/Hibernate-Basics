 package com.aswin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aswin.hibernate.demo.entity.Course;
import com.aswin.hibernate.demo.entity.Instructor;
import com.aswin.hibernate.demo.entity.InstructorDetail;


public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor tempInstructor = new Instructor("Susan","Public","susan.public@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com","Video Games");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			session.save(tempInstructor);
			
			session.getTransaction().commit();
		}
		
		finally {
			session.close();
			factory.close();
		}

	}

}
