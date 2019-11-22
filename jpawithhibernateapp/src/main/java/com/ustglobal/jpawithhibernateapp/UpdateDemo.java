package com.ustglobal.jpawithhibernateapp;

import javax.persistence.*;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;

public class UpdateDemo {

	public static void main(String[] args) {
		
		EntityTransaction entityTransaction = null;
		EntityManager entityManager = null;
		
		try {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");

		  entityManager = entityManagerFactory.createEntityManager();
		  entityTransaction = entityManager.getTransaction();
		  entityTransaction.begin();
		  ProductInfo productInfo = entityManager.find(ProductInfo.class, 101);
		  productInfo.setPname("Pari");
		  System.out.println("Updated Record");
		  entityTransaction.commit();
		
		}catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
	
	entityManager.close();
}
}
