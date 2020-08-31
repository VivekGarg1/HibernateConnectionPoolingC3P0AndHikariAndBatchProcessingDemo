package com.home.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="phone",uniqueConstraints = @UniqueConstraint(name= "emloyee_phone_number",columnNames = { "phone_number","employee_id" }))
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phone_id")
	private Integer phoneId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name="phone_type")
	private PhoneType phoneType;
	
	@OneToMany(mappedBy = "phone",cascade =CascadeType.ALL ,orphanRemoval = true)
	private List<Call> call=new ArrayList<Call>();

	@Temporal(value = TemporalType.TIMESTAMP)
	//@Temporal(value = TemporalType.TIME)
	//@Temporal(value = TemporalType.DATE)
	@Column(name="phone_date")
	private Date phoneDate;
	//private LocalDate phoneDate;
	
	public Date getPhoneDate() {
		return phoneDate;
	}

	public void setPhoneDate(Date phoneDate) {
		this.phoneDate = phoneDate;
	}
	
	/*public LocalDate getPhoneDate() {
		return phoneDate;
	}

	public void setPhoneDate(LocalDate phoneDate) {
		this.phoneDate = phoneDate;
	}*/

	public Integer getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Integer phoneId) {
		this.phoneId = phoneId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	public List<Call> getCall() {
		return call;
	}

	public void setCall(List<Call> call) {
		this.call = call;
	}

	@Override
	public String toString() {
		return "Phone [phoneId=" + phoneId + ", employee=" + employee + ", phoneNumber=" + phoneNumber + ", phoneType="
				+ phoneType + ", phoneDate=" + phoneDate + "]";
	}
	
	
}
