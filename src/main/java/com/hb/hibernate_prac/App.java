package com.hb.hibernate_prac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * arg0 Hello world!g
 *
 */
public class App {
	public static void main(String[] args) {
		final StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

		final SessionFactory sessionFactory = new MetadataSources(serviceRegistry).addAnnotatedClass(Student.class)
				.buildMetadata().buildSessionFactory();
		final Session session = sessionFactory.openSession();

		session.beginTransaction();

		final Student manthan = new Student();
		manthan.setName("manthan");
		manthan.setRoll_no("134");
		manthan.getPhones().add(new Phone("home", "9986565632"));
		manthan.getPhones().add(new Phone("work", "9986565634"));

		final Student meet = new Student();
		meet.setName("meet");
		meet.setRoll_no("5");
		meet.getPhones().add(new Phone("home", "9986565623"));
		meet.getPhones().add(new Phone("work", "8141740921"));

		final Laptop laptop = new Laptop();
		laptop.setCompany("dell");
		laptop.setName("dell inspiron");

		final Laptop laptop1 = new Laptop();
		laptop1.setCompany("hp");
		laptop1.setName("spector");

		final Laptop laptop2 = new Laptop();
		laptop2.setCompany("lenovo");
		laptop2.setName("ideapad");

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
