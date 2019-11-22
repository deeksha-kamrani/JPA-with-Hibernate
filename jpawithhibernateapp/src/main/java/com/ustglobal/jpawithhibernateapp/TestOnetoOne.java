package com.ustglobal.jpawithhibernateapp;

import javax.persistence.*;

import com.ustglobal.jpawithhibernateapp.onetoone.Person;
import com.ustglobal.jpawithhibernateapp.onetoone.VoterCard;

public class TestOnetoOne {

	public static void main(String[] args) {

		VoterCard vc = new VoterCard();
		vc.setVid(10);
		vc.setVname("Ram");
		

		Person p = new Person();
		p.setPid(1);
		p.setPname("Ram");
		p.setVotercard(vc);

		EntityTransaction Transaction = null;
		EntityManager Manager = null;

		try {

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			Manager = entityManagerFactory.createEntityManager();
			Transaction = Manager.getTransaction();
			Transaction.begin();
			VoterCard vCard= Manager.find(VoterCard.class, 10);
					vCard.getPerson().getPid();

			System.out.println("Record saved");
			Transaction.commit();

		}catch(Exception e) {
			e.printStackTrace();
			Transaction.rollback();
		}		
	}
}