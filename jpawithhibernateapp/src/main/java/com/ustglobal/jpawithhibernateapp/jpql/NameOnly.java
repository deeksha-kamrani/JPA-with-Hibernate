package com.ustglobal.jpawithhibernateapp.jpql;

import java.util.List;
import javax.persistence.*;
import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;

public class NameOnly {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String jpql = "select pname from ProductInfo ";
		Query query = entityManager.createQuery(jpql);
		
		List<String> productInfos = query.getResultList();
		for(String productInfo :productInfos) {
	}
		entityManager.close();
}
}