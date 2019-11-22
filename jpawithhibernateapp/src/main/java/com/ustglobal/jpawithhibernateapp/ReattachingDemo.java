package com.ustglobal.jpawithhibernateapp;

import javax.persistence.*;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;

public class ReattachingDemo {
	
	public static void main(String[] args) {
		
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		ProductInfo productInfo = entityManager.find(ProductInfo.class, 101);
		System.out.println(entityManager.contains(productInfo));
		
		entityManager.detach(productInfo);
		System.out.println(entityManager.contains(productInfo));
		
		ProductInfo productInfo2 = entityManager.merge(productInfo);
		productInfo2.setPname("Pari");
		
		System.out.println("Updated Record");
		entityTransaction.commit();
	
		}catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		entityManager.close();
	}
}