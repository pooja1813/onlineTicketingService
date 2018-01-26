/*
 * TestSeatHold
 * 
 * 1.0.0
 *
 * 01/20/2018
 * 
 * @PoojaSampelly
 */
package com.walmartlabs.ticketing.onlineticketingservice.model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestSeatHold extends TestCase {



	public void testAddSeats() {
		SeatHold holder=new SeatHold();
		Seat s=new Seat(1,true);
		holder.addSeats(s);
		Seat testSeat=holder.find(1);
		assertTrue(testSeat.getID()==1);
	}

	public void testFindavailabilty() {
		SeatHold holder=new SeatHold();
		Seat s=new Seat(1,true);
		holder.addSeats(s);
		boolean result=holder.findavailabilty(1);
		assertTrue(result==true);
		
	}

	public void testCount() {
		SeatHold holder=new SeatHold();
		Seat s=new Seat(1,true);
		holder.addSeats(s);
		assertTrue(holder.Count()==1);
		
	}
    
	public void testCountAvailable() {
		SeatHold holder=new SeatHold();
		Seat s=new Seat(1,true);
		holder.addSeats(s);
		assertTrue(holder.CountAvailable()==1);
	}
	public void testFind() {
		SeatHold holder=new SeatHold();
		Seat s=new Seat(1,true);
		holder.addSeats(s);
		s=holder.find(1);
		assertTrue(s!=null);
		
	}

	public void testGetavailableSeats() {
		SeatHold holder=new SeatHold();
		Seat s=new Seat(1,true);
		holder.addSeats(s);
		ArrayList List=holder.getavailableSeats();
		assertTrue(List.size()==1);
	    
	}

}
