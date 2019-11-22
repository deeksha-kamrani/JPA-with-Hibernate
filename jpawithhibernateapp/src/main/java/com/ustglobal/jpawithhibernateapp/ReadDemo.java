package com.ustglobal.jpawithhibernateapp;

import javax.persistence.*;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;

public class ReadDemo {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerfactory =Persistence.createEntityManagerFactory("test");

		EntityManager entityManager = entityManagerfactory.createEntityManager();
		ProductInfo productDetail = entityManager.find(ProductInfo.class,101);
		System.out.println("ID---"+productDetail.getPid());
		System.out.println("Name--"+productDetail.getPname());
		System.out.println("Quantity--"+productDetail.getQuantity());
		entityManager.close();

	}

}
