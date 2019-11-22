package com.ustglobal.Assignment2;

import javax.persistence.*;

import com.ustglobal.Assignment2.dto.EmployeeInfo;

public class Insert {

	public static void main(String[] args) {

		EntityTransaction entityTransaction = null;
		EntityManager entityManager = null;
		
		EmployeeInfo employeeInfo = new EmployeeInfo();
		employeeInfo.setEid(1);
		employeeInfo.setEname("Dk");
		employeeInfo.setMobile(89898);
		
		try {
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(employeeInfo);
			System.out.println("Record Saved");
			entityTransaction.commit();			
		}catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
        entityManager.close();		
	}
}