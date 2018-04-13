package com.cbc.dao;

import java.util.List;

import com.cbc.bean.TimeSlot;

public interface TimeSlotDAO {
	public TimeSlot findById(long id);
	public List<TimeSlot> listAllTimeSlots();
	public void saveTimeSlot(TimeSlot timeSlot);
	public void deleteTimeSlot(long id);
}
