package com.hb.hibernate_prac;

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
		final Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().applyImplicitNamingStrategy(
				new org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl()).build();
		final SessionFactory sessionFactory = metadata.buildSessionFactory();
		// final SessionFactory sessionFactory = new
		// MetadataSources(serviceRegistry).addAnnotatedClass(Student.class)
		// .buildMetadata().buildSessionFactory();
		final Session session = sessionFactory.openSession();
		session.beginTransaction();
		// final Person person = new Person();
		// person.setId(new Long(19));
		// final int updatedEntities = session.createQuery(
		// "update Phone set number = :number , type = :type where person = :person and
		// order_id = :order_id")
		// .setParameter("number", "846923232").setParameter("type", PhoneType.MOBILE)
		// .setParameter("person", person).setParameter("order_id", 0).executeUpdate();
		// final int updatedEntities = session.createQuery(
		// "insert into Partner (id, name) " +
		// "select p.id, p.name "+
		// "from Person p")
		// .executeUpdate();
		// final List<Person> persons = session.createQuery(
		// "select distinct pr " + "from Person pr " + "join pr.phones ph " + "where
		// ph.type = :phoneType",
		// Person.class).setParameter("phoneType", PhoneType.LAND_LINE).getResultList();

		// final List<Person> persons = session
		// .createQuery("select pr " + "from Person pr " + "left outer join pr.phones ph
		// " + "where "
		// + " ph.type = :phoneType", Person.class)
		// .setParameter("phoneType", PhoneType.LAND_LINE).getResultList();
		//
		// for (final Person person : persons) {
		// System.out.println(person.getName() + " " + person.getCreatedOn() + " " +
		// person.getAddress());
		// }

		final List<Partner> partners = session.createNativeQuery("select * from Partner",Partner.class).getResultList();
		for(final Partner partner : partners) {
			System.out.println("partner id :" + partner.getId() + "partner name"+partner.getName());
		}

		//
		// System.out.println(updatedEntities);
		// final Phone phone = session
		// .createNamedQuery( "get_phone_by_number", Phone.class )
		// .setParameter( "number", person.getPhones().get(0) )
		// .getSingleResult();
		// System.out.println("phone type" + phone.getType() + "phone " +
		// phone.getPerson().getName());
		//
		// final org.hibernate.query.Query query =
		// session.getNamedQuery("get_person_by_name").setParameter("name", "meet");;
		// final Person p = (Person)query.getSingleResult();
		// System.out.println(p.getName() + " " + p.getCreatedOn());
		// session.getTransaction().commit();
		session.close();

	}
}
