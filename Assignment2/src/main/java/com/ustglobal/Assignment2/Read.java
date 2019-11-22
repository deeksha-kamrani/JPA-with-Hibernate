package com.ustglobal.Assignment2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ustglobal.Assignment2.dto.EmployeeInfo;



public class Read {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerfactory =Persistence.createEntityManagerFactory("test");

		EntityManager entityManager = entityManagerfactory.createEntityManager();
		EmployeeInfo employee = entityManager.find(EmployeeInfo.class,101);
		System.out.println("ID---"+employee.getEid());
		System.out.println("Name--"+employee.getEname());
		System.out.println("Quantity--"+employee.getMobile());
		entityManager.close();

	}
	
}
