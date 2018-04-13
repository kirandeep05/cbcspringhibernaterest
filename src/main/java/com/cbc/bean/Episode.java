package com.cbc.bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="episode")
public class Episode {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	
	@OneToMany
	private Collection<TimeSlot> timeSlot = new ArrayList<TimeSlot>();

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<TimeSlot> getTimeSlot() {
		return timeSlot;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTimeSlot(Collection<TimeSlot> timeSlot) {
		this.timeSlot = timeSlot;
	}
}
