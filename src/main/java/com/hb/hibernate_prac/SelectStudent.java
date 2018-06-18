package com.hb.hibernate_prac;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class SelectStudent {
	public static void main(String args[]) {
		final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		final Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(Student.class)
				.getMetadataBuilder().applyImplicitNamingStrategy(
						new org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl())
				.build();
		final SessionFactory sessionFactory = metadata.buildSessionFactory();
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		final Student student = session.get(Student.class, 1);
		final Student student1 = session.get(Student.class, 2);
		System.out.println(student);
		System.out.println(student1);
		session.getTransaction().commit();
		// System.out.println(student.getLaptops().get(0));

		System.out.println("printing meet's laptop");
		for (final Laptop laptop : student.getLaptops()) {
			System.out.println(laptop);
		}

		System.out.println("printing manthan's laptop");
		for (final Laptop laptop : student1.getLaptops()) {
			System.out.println(laptop);
		}

		final Laptop laptop = session.get(Laptop.class, 4);
		System.out.println(laptop.getStudent() + laptop.getName());

		System.out.println("using named query.....................");
		//
		// final Query query = session.createNamedQuery("Student.byid");
		// query.setParameter(1, 2);
		// final Student student3 = (Student) query.uniqueResult();
		//
		// System.out.println(student3);

		System.out.println("using named sql query.....................");

		final Query query1 = session.createNamedQuery("Student.byid.sql");
		query1.setInteger(1, 1);
		final List<Student> student4 = query1.list();

		for (final Student studentList : student4) {
			System.out.println(studentList);
		}

		// using criteria
		// System.out.println("hibernate criteria example starts here");
		// final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		// final CriteriaQuery<Student> criteria =
		// criteriaBuilder.createQuery(Student.class);
		// final Root<Student> root = criteria.from(Student.class);
		// criteria.select(root);
		// criteria.where(criteriaBuilder.equal(root.get(Student_.roll_no), "5"));
		// final List<Student> studentsCriteriaList =
		// session.createQuery(criteria).getResultList();
		// for (final Student s : studentsCriteriaList) {
		// System.out.println(s);
		// }

		final CriteriaBuilder builder = session.getCriteriaBuilder();

		final CriteriaQuery<Tuple> criteria = builder.createQuery(Tuple.class);
		final Root<Student> root = criteria.from(Student.class);

		final Path<Integer> idPath = root.get(Student_.id);
		final Path<StudentName> nickNamePath = root.get(Student_.studentName);

		criteria.multiselect(idPath, nickNamePath);
		criteria.where(builder.greaterThan(root.get(Student_.id), 0));

		final List<Tuple> tuples = session.createQuery(criteria).getResultList();
		for(final Tuple tuple : tuples) {
			System.out.println(tuple.get(idPath) + " " + tuple.get(nickNamePath) );
		}

	}
}
