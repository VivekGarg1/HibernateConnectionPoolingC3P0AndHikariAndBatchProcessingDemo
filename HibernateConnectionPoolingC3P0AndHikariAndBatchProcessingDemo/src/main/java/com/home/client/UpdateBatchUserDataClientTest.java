package com.home.client;

import org.hibernate.CacheMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.home.entities.User;
import com.home.util.HibernateUtil;

public class UpdateBatchUserDataClientTest {
	public static void main(String[] args) {
		Session session=null;
		Transaction tx = null;
		int batchSize = 25;
		ScrollableResults scrollableResults = null;
		try  {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			scrollableResults = session.createQuery("select u from User u").setCacheMode(CacheMode.IGNORE)
					.scroll(ScrollMode.FORWARD_ONLY);

			int count = 0;
			while (scrollableResults.next()) {
				User user = (User) scrollableResults.get(0);
				processUser(user);
				if (++count % batchSize == 0) {
					System.out.println("Session is flushed");
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
		finally {
			if(scrollableResults !=null)
				scrollableResults.close();
			if(session !=null)
				session.close();
		}
	}

	private static void processUser(User user) {
        user.setFirstName(user.getFirstName()+"_updated");
	}

}
