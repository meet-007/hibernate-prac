package com.hb.hibernate_prac;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class SelectOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		final Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().applyImplicitNamingStrategy(
				new org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl()).build();
		final SessionFactory sessionFactory = metadata.buildSessionFactory();
		final Session session = sessionFactory.openSession();
		session.beginTransaction();

		// final CriteriaBuilder builder = session.getCriteriaBuilder();
		//
		// final CriteriaQuery<Tuple> criteria = builder.createQuery( Tuple.class );
		//
		// final Root<Person> personRoot = criteria.from( Person.class );
		// final Root<Partner> partnerRoot = criteria.from( Partner.class );
		// criteria.multiselect( personRoot, partnerRoot );
		//
		// // final Predicate personRestriction = builder.and(
		// // builder.equal( personRoot.get( Person_.address ), "ahmedabad" ),
		// // builder.isNotEmpty( personRoot.get( Person_.phones ) )
		// // );
		// final Predicate partnerRestriction = builder.and(
		// // builder.like( partnerRoot.get( Partner_.name ), "d" ),
		// builder.equal( partnerRoot.get( Partner_.version ), 0 ));
		// criteria.where( partnerRestriction );
		//
		// final List<Tuple> tuples = session.createQuery( criteria ).getResultList();

		final CriteriaBuilder builder = session.getCriteriaBuilder();

		final CriteriaQuery<Phone> criteria = builder.createQuery(Phone.class);
		final Root<Phone> root = criteria.from(Phone.class);

		//		// Phone.person is a @ManyToOne
		//		final Join<Phone, Person> personJoin = root.join(Phone_.person);
		//		// Person.addresses is an @ElementCollection
		//		final Join<Person, String> addressesJoin = personJoin.join(Person_.addresses);
		//
		// Phone.person is a @ManyToOne
		final Fetch<Phone, Person> personFetch = root.fetch( Phone_.person );
		// Person.addresses is an @ElementCollection
		final Fetch<Person, String> addressesJoin = personFetch.fetch( Person_.addresses );

		// criteria.where( builder.equal( root.get( Phone_.TYPE ),PhoneType.LAND_LINE )
		// );

		final List<Phone> phones = session.createQuery(criteria).getResultList();

		for (final Phone phone : phones) {
			System.out.println(phone.getId() + " " + phone.getPerson().getName()+" "+phone.getNumber());
		}

		session.getTransaction().commit();

	}

}
