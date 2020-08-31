package com.home.client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.home.entities.User;
import com.home.util.HibernateUtil;

public class SaveBatchUserDataClientTest {
	public static void main(String[] args) {
		Transaction tx = null;
		int batchSize = 5;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			tx = session.beginTransaction();
			for (int i = 1; i <= 1000; i++) {
				User user = new User();
				user.setFirstName("Vivek_" + i);
				user.setLastName("Garg_" + i);
				session.save(user);
				if (i > 0 && i % batchSize == 0) {
					System.out.println("Flush and clear the session");
					session.flush();
					session.clear();
				}
			}
			tx.commit();

		} catch (Exception e) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw e;
		}
	}

}
