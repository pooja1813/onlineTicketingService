/*
 * TestCustomManager
 * 
 * 1.0.0
 *
 * 01/20/2018
 * 
 * @PoojaSampelly
 */
package com.walmartlabs.ticketing.onlineticketingservice.model;


import java.util.Set;

import junit.framework.TestCase;


public class TestCustomerManager extends TestCase {
    String email="pooja.sampelly13@gmail.com";
	public void testAddCustomer() {
		CustomerManager c=new CustomerManager();
		Customer customer=c.addCustomer(email);
		assertTrue(customer!=null);
		String testEmail=customer.getEmail();
		assertTrue(testEmail==email);
	}

	public void testRemove() {
		CustomerManager c=new CustomerManager();
		email="testemail@gmail.com";
		c.addCustomers(24, email);
		boolean result=c.remove(email);
		assertTrue(result==true);
	}

	public void testAddCustomers() {
		CustomerManager c=new CustomerManager();
		email="mitu1@gmail.com";
		c.addCustomers(20,email);		
		Set seats=c.getAllSeats(email);
	    int count=seats.size();
	    assertTrue(count==1);
		
		
	}

	public void testGetAllSeats() {
		CustomerManager c=new CustomerManager();
		email="mitu@gmail.com";
		c.addCustomers(25, email);
		int countTest=c.getAllSeats(email).size();
		assertTrue(countTest==1);
	}

}
