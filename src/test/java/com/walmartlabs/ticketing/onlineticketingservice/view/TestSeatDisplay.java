/*
 * TestSeatDisplay
 * 
 * 1.0.0
 *
 * 01/20/2018
 * 
 * @PoojaSampelly
 */
package com.walmartlabs.ticketing.onlineticketingservice.view;

import com.walmartlabs.ticketing.onlineticketingservice.model.SeatHold;

import junit.framework.TestCase;

public class TestSeatDisplay extends TestCase {
    SeatDisplayer seatDisplay=new SeatDisplayer();


	public void testIsValidEmail() {
		String emailAddress="";
		assertFalse(seatDisplay.checkEmailValidity(emailAddress));
		
	}

	

}
