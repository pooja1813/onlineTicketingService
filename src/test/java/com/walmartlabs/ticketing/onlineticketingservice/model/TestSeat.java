/*
 * TestSeat
 * 
 * 1.0.0
 *
 * 01/20/2018
 * 
 * @PoojaSampelly
 */
package com.walmartlabs.ticketing.onlineticketingservice.model;

import junit.framework.TestCase;

public class TestSeat extends TestCase {

	

	public void testSeat() {
		Seat seat=new Seat(1,true);
		assertTrue(seat!=null);
	}

	

	public void testGetID() {
		Seat seat=new Seat(1,true);
		int id=seat.getID();
		assertTrue(id==1);
	}

	public void testSetAvailabilty() {
		Seat seat=new Seat(1,true);
		seat.setAvailabilty(false);
		boolean testAvail=seat.getAvailabilty();
		assertTrue(testAvail==false);
		
	}

	public void testGetAvailabilty() {
		Seat seat=new Seat(1,true);
		boolean testAvail=seat.getAvailabilty();
		assertTrue(testAvail==true);
	}

}
