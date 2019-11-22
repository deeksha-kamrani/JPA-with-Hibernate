package com.ustglobal.jpawithhibernateapp;

import javax.persistence.*;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;

public class GetReference {

	public static void main(String[] args) {

		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		entityManager = entityManagerFactory.createEntityManager();
		
//		ProductInfo productInfo = entityManager.getReference(ProductInfo.class, 101);
		
		ProductInfo productInfo = entityManager.find(ProductInfo.class, 101);
		System.out.println(productInfo.getClass());
		
		/*
		 * System.out.println(productInfo.getPid());
		 * System.out.println(productInfo.getPname());
		 * System.out.println(productInfo.getQuantity());
		 */
		
		entityManager.close();
	}
}