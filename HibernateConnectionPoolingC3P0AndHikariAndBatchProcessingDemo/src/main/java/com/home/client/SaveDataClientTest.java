package com.home.client;

import java.util.Date;

import org.hibernate.Session;
import com.home.entities.Call;
import com.home.entities.Employee;
import com.home.entities.Partner;
import com.home.entities.Phone;
import com.home.entities.PhoneType;
import com.home.util.HibernateUtil;

public class SaveDataClientTest {

	public static void main(String[] args) {
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			session.beginTransaction();
			
			Employee employee1=new Employee();
			employee1.setEmployeeName("Paras");
			employee1.setEmail("paras@gmail.com");
			employee1.setDoj(new Date());
			employee1.setSalary(16000.00);
			employee1.setNaturalId("987-1234567890");

			Phone phone1=new Phone();
			phone1.setPhoneNumber("123456789");
			phone1.setPhoneType(PhoneType.MOBILE);
			phone1.setPhoneDate(new Date());
			phone1.setEmployee(employee1);
			
			employee1.getPhone().add(phone1);
			
			Call call1=new Call();
			call1.setTimeStamp(new Date());
			call1.setDuration(30);
			call1.setPhone(phone1);
			
			Call call2=new Call();
			call2.setTimeStamp(new Date());
			call2.setDuration(20);
			call2.setPhone(phone1);
			
			phone1.getCall().add(call1);
			phone1.getCall().add(call2);
			
			Employee employee2=new Employee();
			employee2.setEmployeeName("Prabhat Singh");
			employee2.setEmail("prabhat.singh@gmail.com");
			employee2.setDoj(new Date());
			employee2.setSalary(17000.00);
			employee2.setNaturalId("123-9876543210");
			
			Phone phone2=new Phone();
			phone2.setPhoneNumber("987654321");
			phone2.setPhoneType(PhoneType.LAND_LINE);
			phone2.setPhoneDate(new Date());
			phone2.setEmployee(employee2);
			
			employee2.getPhone().add(phone2);
			
			Call call3=new Call();
			call3.setTimeStamp(new Date());
			call3.setDuration(56);
			call3.setPhone(phone2);
			
			Call call4=new Call();
			call4.setTimeStamp(new Date());
			call4.setDuration(15);
			call4.setPhone(phone2);
			
			phone2.getCall().add(call3);
			phone2.getCall().add(call4);
			
			Phone phone3=new Phone();
			phone3.setPhoneNumber("987654320");
			phone3.setPhoneType(PhoneType.MOBILE);
			phone3.setPhoneDate(new Date());
			phone3.setEmployee(employee2);
			
			employee2.getPhone().add(phone3);
			
			Call call5=new Call();
			call5.setTimeStamp(new Date());
			call5.setDuration(15);
			call5.setPhone(phone3);
			
			phone3.getCall().add(call5);
			
			Partner partner = new Partner();
			partner.setPartnerName("Vivek Garg");
			partner.setVersion(1);
			
			
			session.save(employee1);
			session.save(employee2);
			session.save(partner);
			session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
