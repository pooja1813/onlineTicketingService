/*
 * Customer
 * 
 * 1.0.0
 *
 * 01/20/2018
 * 
 * @PoojaSampelly
 */
package com.walmartlabs.ticketing.onlineticketingservice.model;

import java.util.UUID;


/** This class holds the customer data*/
public class Customer {
    private static int customerId = 0;
    private String emailId;
    private String bookId;

    /** This method is a Constructor*/
    public Customer(String emailAddress) {

        customerId = customerId + 1;
        emailId = emailAddress;
        bookId = UUID.randomUUID().toString();
    }
    
    /** This method gets Customer Id*/
    public int getId() {
        return customerId;
    }
    
    /** This method sets the customer email*/    
    public void setEmail(String emailAddress) {
        emailId = emailAddress;
    }
    
    /** This method gets Customer email*/
    public String getEmail() {
        return emailId;
    }
    
    /** This method gets Booking Id*/
    public String getBookId() {
        return bookId;
    }


}