package com.ustglobal.jpawithhibernateapp.jpql;

import javax.persistence.*;

public class DynamicDelete {

	public static void main(String[] args) {

		EntityTransaction transaction = null;
		EntityManager entityManager = null;

		try {
			EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = " delete from ProductInfo where pid=:id";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", 101);
			int result = query.executeUpdate();
			System.out.println(result);
			transaction.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			
		}finally {

		entityManager.close();
		}
	}	
	}