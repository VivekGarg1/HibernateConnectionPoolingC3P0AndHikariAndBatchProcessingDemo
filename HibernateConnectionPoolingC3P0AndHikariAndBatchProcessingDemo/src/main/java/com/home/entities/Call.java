package com.home.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="call_table")
public class Call {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "call_id")
	private Integer callId;
	
	@ManyToOne
	@JoinColumn(name="phone_id")
	private Phone phone;
	
	@Column(name="timestamp")
	private Date timeStamp;
	
	@Column(name="duration")
	private Integer duration;

	public Integer getCallId() {
		return callId;
	}

	public void setCallId(Integer callId) {
		this.callId = callId;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Call [callId=" + callId + ", timeStamp=" + timeStamp + ", duration=" + duration + "]";
	}

}
