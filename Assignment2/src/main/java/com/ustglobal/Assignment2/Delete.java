package com.ustglobal.Assignment2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.Assignment2.dto.EmployeeInfo;

public class Delete {
	
	public static void main(String[] args) {

		EntityTransaction entityTransaction = null;
		EntityManager entityManager = null;

		try {

			EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("test");

			entityManager = entityManagerFactory.createEntityManager();

			entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();

			EmployeeInfo employee = entityManager.find(EmployeeInfo.class, 1);

			entityManager.remove(employee);

			System.out.println("Record Remove");

			entityTransaction.commit();

		}catch(Exception e) {
			e.printStackTrace();
			
			entityTransaction.rollback();
		}
		
		entityManager.close();
	}


}
