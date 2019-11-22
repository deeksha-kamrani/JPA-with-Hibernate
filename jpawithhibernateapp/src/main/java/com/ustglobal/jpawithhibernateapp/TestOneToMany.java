package com.ustglobal.jpawithhibernateapp;

import javax.persistence.*;

import com.ustglobal.jpawithhibernateapp.onetomany.Pencil;
import com.ustglobal.jpawithhibernateapp.onetomany.PencilBox;

public class TestOneToMany {

	public static void main(String[] args) {
		
		PencilBox b = new PencilBox();
		b.setBid(21);
		b.setBname("Pari");
		
		Pencil p = new Pencil();
		p.setPid(22);
		p.setColor("black");
		p.setPencilBox(b);
		
		Pencil p1 = new Pencil();
		p1.setPid(23);
		p1.setColor("black");
		p1.setPencilBox(b);

		EntityTransaction Transaction = null;
		EntityManager Manager = null;

		try {

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			Manager = entityManagerFactory.createEntityManager();
			Transaction = Manager.getTransaction();
			Transaction.begin();
			Manager.persist(p);	
			Manager.persist(p1);	
			System.out.println("Record saved");
			Transaction.commit();

		}catch(Exception e) {
			e.printStackTrace();
			Transaction.rollback();
		}		
	}	
	}