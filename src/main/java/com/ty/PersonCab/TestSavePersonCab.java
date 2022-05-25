package com.ty.PersonCab;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonCab {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Cab cab1=new Cab();
		cab1.setDriverName("Neeraj");
		cab1.setCost(2000);
		
		Cab cab2=new Cab();
		cab2.setDriverName("Sandeep");
		cab2.setCost(3000);
		
		Cab cab3=new Cab();
		cab3.setDriverName("deepak");
		cab3.setCost(3000);
		
		Cab cab4=new Cab();
		cab4.setDriverName("Rose");
		cab4.setCost(4000);
		
		Person person1=new Person();
		person1.setName("Nitish");
		person1.setAge(24);
		person1.setEmail("niti@gmail.com");
		
		Person person2=new Person();
		person2.setName("Nishitha");
		person2.setAge(24);
		person2.setEmail("nishitha@gmail.com");
		
		Person person3=new Person();
		person3.setName("Lily");
		person3.setAge(44);
		person3.setEmail("lily@gmail.com");
		
		List<Person> persons1=new ArrayList<Person>();
		persons1.add(person1);
		persons1.add(person2);
		
		List<Person> persons2=new ArrayList<Person>();
		persons2.add(person1);
		persons2.add(person2);
		persons2.add(person3);
		
		List<Person> persons3=new ArrayList<Person>();
		persons3.add(person1);
		persons3.add(person3);

		List<Cab> cabs1=new ArrayList<Cab>();
		cabs1.add(cab1);
		cabs1.add(cab2);
		
		List<Cab> cabs2=new ArrayList<Cab>();
		cabs2.add(cab1);
		cabs2.add(cab2);
		cabs2.add(cab4);
		
		
		List<Cab> cabs3=new ArrayList<Cab>();
		cabs3.add(cab1);
		cabs3.add(cab3);

		cab1.setPerson(persons1);
		cab2.setPerson(persons2);
		cab3.setPerson(persons3);
		cab4.setPerson(persons1);
			
		person1.setCab(cabs1);
		person1.setCab(cabs3);
		person1.setCab(cabs2);
		
		entityTransaction.begin();
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(person3);
		entityManager.persist(cab1);
		entityManager.persist(cab2);
		entityManager.persist(cab3);
		entityManager.persist(cab4);

		entityTransaction.commit();
		
	}

}
