/*
 * TicketService
 * 
 * 1.0.0
 *
 * 01/20/2018
 * 
 * @PoojaSampelly
 */
package com.walmartlabs.ticketing.onlineticketingservice.service;

import com.walmartlabs.ticketing.onlineticketingservice.model.SeatHold;

public interface TicketService {

	int getNumOfAvailSeats();
    SeatHold findAndHoldSeats(int numSeats,String customerEmail);
	String reserveSeats(int seatHoldId,String customerEmail);
	
}
