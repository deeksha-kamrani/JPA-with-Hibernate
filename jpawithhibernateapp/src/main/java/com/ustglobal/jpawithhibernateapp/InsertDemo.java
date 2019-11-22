package com.ustglobal.jpawithhibernateapp;

import javax.persistence.*;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;

public class InsertDemo {

	public static void main(String[] args) {
		
		EntityTransaction entityTransaction = null;
		EntityManager entityManager = null;

		ProductInfo productInfo = new ProductInfo();
		productInfo.setPid(102);
		productInfo.setPname("Watch");
		productInfo.setQuantity(20);
		
		try {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(productInfo);
        System.out.println("Record saved");
        entityTransaction.commit();
        
		}catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		
        entityManager.close();
	}
}