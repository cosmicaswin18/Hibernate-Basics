 package com.aswin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aswin.hibernate.demo.entity.Course;
import com.aswin.hibernate.demo.entity.Instructor;
import com.aswin.hibernate.demo.entity.InstructorDetail;
import com.aswin.hibernate.demo.entity.Review;


public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Course tempCourse = new Course("Pacman - How To Score One Million Points");
			
			tempCourse.addReview(new Review("Great Course ... Loved it!"));
			tempCourse.addReview(new Review("Cool Course, job well done"));
			tempCourse.addReview(new Review("What a dumb course,you are an idiot!"));
			
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			
			session.getTransaction().commit();
			
		}
		
		finally {
			session.close();
			factory.close();
		}

	}

}
