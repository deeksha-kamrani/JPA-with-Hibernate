package com.ustglobal.jpawithhibernateapp.jpql;

import java.util.*;

import javax.persistence.*;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;



public class RetrieveDemo {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from ProductInfo";
		Query query = entityManager.createQuery(jpql);
		
		List<ProductInfo> productInfos = query.getResultList();
		for(ProductInfo productInfo :productInfos) {
			System.out.println(productInfo.getPid());
			System.out.println(productInfo.getPname());
			System.out.println(productInfo.getQuantity());
		}
		entityManager.close();
	}
}
