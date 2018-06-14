package com.hb.hibernate_prac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class SelectStudent {
	public static void main(String args[]) {
		final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		final  Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(Student.class).addAnnotatedClass(StudDetails.class).getMetadataBuilder().applyImplicitNamingStrategy(new  org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl()).build();
		final SessionFactory sessionFactory = metadata.buildSessionFactory();
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		final Student student = session.get(Student.class,1);
		final Student student1 = session.get(Student.class,2);
		System.out.println(student);
		System.out.println(student1);
		final Object[] sd =  (Object[])session.createQuery("select sd.studentName,sd.phone from student_details sd where id = 1").getSingleResult();
		System.out.println(sd[0]);
		System.out.println(sd[1]);
		//		System.out.println(student.getPhones().get(0));
		//		System.out.println(student.getPhones().get(1));
		//		System.out.println(student.getPhones().get(0));
		//		session.save(student);
		session.getTransaction().commit();
		// System.out.println(student.getLaptops().get(0));
		session.close();

	}
}
