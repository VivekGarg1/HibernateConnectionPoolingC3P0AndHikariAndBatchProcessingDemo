package com.home.client;

import org.hibernate.CacheMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import com.home.entities.User;
import com.home.util.HibernateUtil;

public class UpdateBatchWithStatelessSessionUserDataClientTest {
	public static void main(String[] args) {
		StatelessSession session=null;
		Transaction tx = null;
		int batchSize = 25;
		ScrollableResults scrollableResults = null;
		try  {
			session = HibernateUtil.getSessionFactory().openStatelessSession();
			tx = session.beginTransaction();
			scrollableResults = session.createQuery("select u from User u")
					.scroll(ScrollMode.FORWARD_ONLY);

			int count = 0;
			while (scrollableResults.next()) {
				User user = (User) scrollableResults.get(0);
				processUser(user);
				session.update(user);
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
        user.setFirstName(user.getFirstName()+"_updated1");
	}

}
