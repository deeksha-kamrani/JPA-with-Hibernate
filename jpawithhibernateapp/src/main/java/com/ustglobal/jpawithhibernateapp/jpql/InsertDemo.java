package com.ustglobal.jpawithhibernateapp.jpql;

import javax.persistence.*;

public class InsertDemo {

	public static void main(String[] args) {

		EntityTransaction entityTransaction = null;
		EntityManager entityManager = null;
		
		try {
			
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		String jpql =" Insert into ProductInfo (pid , pname) values (:id , :name)";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", 101);
		query.setParameter("name", "Pari");
		int result = query.executeUpdate();
		System.out.println(result);
		entityTransaction.commit();
		
		}catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		finally {
		entityManager.close();
		}
	}
}