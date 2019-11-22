package com.ustglobal.jpawithhibernateapp;

import javax.persistence.*;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;

public class DeleteDemo {

	public static void main(String[] args) {

		EntityTransaction entityTransaction = null;
		EntityManager entityManager = null;

		try {

			EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("test");

			entityManager = entityManagerFactory.createEntityManager();

			entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();

			ProductInfo productInfo = entityManager.find(ProductInfo.class, 101);

			entityManager.remove(productInfo);

			System.out.println("Record Remove");

			entityTransaction.commit();

		}catch(Exception e) {
			e.printStackTrace();
			
			entityTransaction.rollback();
		}
		
		entityManager.close();
	}
}