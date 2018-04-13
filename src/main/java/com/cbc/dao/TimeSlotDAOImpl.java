package com.cbc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cbc.bean.TimeSlot;

@Repository
public class TimeSlotDAOImpl implements TimeSlotDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.openSession();
	}
	
	@Override
	public TimeSlot findById(long id) {
		return (TimeSlot)getSession().get(TimeSlot.class, id);
	}

	@Override
	public List<TimeSlot> listAllTimeSlots() {
		return getSession().createCriteria(TimeSlot.class).list();
	}

	@Override
	public void saveTimeSlot(TimeSlot timeSlot) {
		getSession().save(timeSlot);
	}

	@Override
	public void deleteTimeSlot(long id) {
		getSession().delete(id);
	}

}
