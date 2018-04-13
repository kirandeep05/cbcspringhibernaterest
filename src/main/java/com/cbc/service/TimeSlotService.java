package com.cbc.service;

import java.util.List;

import com.cbc.bean.TimeSlot;

public interface TimeSlotService {
	public TimeSlot findById(long id);
	public List<TimeSlot> listAllTimeSlots();
	public void saveTimeSlot(TimeSlot timeSlot);
	public void deleteTimeSlot(long id);

}
