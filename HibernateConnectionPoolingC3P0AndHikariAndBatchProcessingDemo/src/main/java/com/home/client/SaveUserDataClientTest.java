package com.home.client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.home.entities.User;
import com.home.util.HibernateUtil;

public class SaveUserDataClientTest {
 public static void main(String[] args) {
	 Transaction tx=null;
	 try (Session session=HibernateUtil.getSessionFactory().openSession()){
			
			tx=session.beginTransaction();
			
			for(int i=1; i<=100;i++){
				User user=new User();
				user.setFirstName("Vivek_"+i);
				user.setLastName("Garg_"+i);
				session.save(user);
			}
			tx.commit();
			
		} catch (Exception e) {
			if(tx !=null && tx.isActive())
				tx.rollback();
			throw e;
		}
}
	
}

