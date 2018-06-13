package com.hb.hibernate_prac;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * arg0 Hello world!g
 *
 */
public class App {
	public static void main(String[] args) {
		new Configuration();
		// ServiceRegistry serviceRegistry = new serviceregistryb
		final StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		final  Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(Student.class).getMetadataBuilder().applyImplicitNamingStrategy(new  org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl()).build();
		final SessionFactory sessionFactory = metadata.buildSessionFactory();
		// final SessionFactory sessionFactory = new
		// MetadataSources(serviceRegistry).addAnnotatedClass(Student.class)
		// .buildMetadata().buildSessionFactory();
		final Session session = sessionFactory.openSession();

		session.beginTransaction();
		final StudentName meetName = new StudentName();
		final StudentName meetNickName = new StudentName();
		meetNickName.setFname("mitu");
		meetName.setFname("meet");
		meetName.setMname("pareshkumar");
		meetName.setLname("chaudhary");

		final StudentName manthanNickName = new StudentName();
		manthanNickName.setFname("manthu");
		final StudentName manthanName = new StudentName();
		manthanName.setFname("manthan");
		manthanName.setMname("idk");
		manthanName.setLname("patel");

		final Student manthan = new Student();
		manthan.setStudentNickName(manthanNickName);
		manthan.setStudentName(manthanName);
		manthan.setRoll_no("134");
		// meet.setLaptop(laptop);
		//

		final Student meet = new Student();
		meet.setStudentNickName(meetNickName);
		meet.setStudentName(meetName);
		meet.setRoll_no("5");
		// manthan.setLaptop(laptop1);
		//
		//
		final Laptop laptop = new Laptop();
		laptop.setCompany("dell");
		laptop.setName("dell inspiron");
		final ArrayList<Student> laptapStudents = new ArrayList<Student>();
		laptapStudents.add(meet);
		laptapStudents.add(manthan);
		laptop.setStudent(laptapStudents);

		final Laptop laptop1 = new Laptop();
		laptop1.setCompany("hp");
		laptop1.setName("spector");
		final ArrayList<Student> laptap1Students = new ArrayList<Student>();
		laptap1Students.add(meet);
		laptop1.setStudent(laptap1Students);

		final Laptop laptop2 = new Laptop();
		laptop2.setCompany("lenovo");
		laptop2.setName("ideapad");
		final ArrayList<Student> laptap2Students = new ArrayList<Student>();
		laptap2Students.add(manthan);
		laptop2.setStudent(laptap2Students);

		final List<Laptop> meetlaptops = new ArrayList<Laptop>();
		meetlaptops.add(laptop2);
		meet.setLaptops(meetlaptops);

		final List<Laptop> laptops = new ArrayList<Laptop>();
		laptops.add(laptop);
		laptops.add(laptop1);
		manthan.setLaptops(laptops);

		session.save(laptop);
		session.save(laptop1);
		session.save(laptop2);

		// saves students

		session.save(meet);
		session.save(manthan);

		// save laptops

		session.getTransaction().commit();
		session.close();

	}
}
