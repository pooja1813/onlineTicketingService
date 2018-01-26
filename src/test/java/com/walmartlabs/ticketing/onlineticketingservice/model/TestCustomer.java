/*
 * TestCustomer
 * 
 * 1.0.0
 *
 * 01/20/2018
 * 
 * @PoojaSampelly
 */
package com.walmartlabs.ticketing.onlineticketingservice.model;

import junit.framework.TestCase;

public class TestCustomer extends TestCase {
	String email="pooja.sam@gmail.com";
	

	public void testCustomer() {
		
		Customer customer=new Customer(email);
		assertTrue(customer!=null);
		
	}

	public void testGetId() {
	   Customer customer=new Customer(email);
	   int id=customer.getId();
	   assertTrue(id!=0);
	}

	public void testSetEmail() {
		String testEmail="pooja.sam13";
		Customer customer=new Customer(email);
		customer.setEmail(testEmail);
		email=customer.getEmail();
		assertTrue(testEmail==email);
		
	}

	public void testGetEmail() {
		Customer customer=new Customer(email);
		String testEmail=customer.getEmail();
		assertTrue(testEmail==email);
		
	}

	public void testGetBookId() {
		Customer customer=new Customer(email);
		String testBookId=customer.getBookId();
		assertTrue(testBookId!=null);
		
	}

}
