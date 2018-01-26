/*
 * TestOrderTickets
 * 
 * 1.0.0
 *
 * 01/20/2018
 * 
 * @PoojaSampelly
 */
package com.walmartlabs.ticketing.onlineticketingservice.service;

import com.walmartlabs.ticketing.onlineticketingservice.model.CustomerManager;
import com.walmartlabs.ticketing.onlineticketingservice.model.Seat;
import com.walmartlabs.ticketing.onlineticketingservice.model.SeatHold;

import junit.framework.TestCase;

public class TestOrderTickets extends TestCase {

	

	public void testGetInstance() {
		OrderTickets orderTickets=new OrderTickets();
		assertTrue(orderTickets!=null);
	}

	public void testGetCustomerManager() {
		OrderTickets orderTickets=new OrderTickets();
		assertTrue(orderTickets.getCustomerManager()!=null);
		
	}

	public void testNumSeatsAvailable() {
		OrderTickets orderTickets=new OrderTickets();
		assertTrue(orderTickets.getNumOfAvailSeats()==100);
	}

	public void testFindAndHoldSeats() {
		OrderTickets orderTickets=new OrderTickets();
		assertTrue(orderTickets.findAndHoldSeats(3, "test@g.com")!=null);
		
	}

	public void testHoldSeats() {
		OrderTickets orderTickets=new OrderTickets();
		int[] selectedSeats= {99,95};
		String emailAddress="test@g.com";
		assertTrue(orderTickets.holdSeats(selectedSeats, emailAddress)!=null);
	}

	public void testUnholdSeats() {
		OrderTickets orderTickets=new OrderTickets();
		String emailAddress="test@g.com";
		Seat seat=new Seat(2,false);
		CustomerManager customerManager=new CustomerManager();
		customerManager.addCustomers(seat.getID(),emailAddress);
		assertTrue(orderTickets.unHoldSeats(emailAddress)==false);
	}

	public void testReserveSeatsIntString() {
		OrderTickets orderTickets=new OrderTickets();
		orderTickets.reserveSeats(2, "test@g.com");
		assertTrue((orderTickets.reserveSeats(2, "test@g.com"))!=null);
	}

	public void testReserveSeatsIntArrayString() {
		OrderTickets orderTickets=new OrderTickets();
		int[] selectedSeats= {99,95};
		orderTickets.reserveSeats(selectedSeats, "test@g.com");
		assertTrue((orderTickets.reserveSeats(selectedSeats, "test@g.com"))!=null);
	}

}
