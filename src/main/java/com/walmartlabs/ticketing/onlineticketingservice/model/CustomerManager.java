/*
 * CustomerManager
 * 
 * 1.0.0
 *
 * 01/20/2018
 * 
 * @PoojaSampelly
 */

package com.walmartlabs.ticketing.onlineticketingservice.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/** This class holds all the customer data*/
public class CustomerManager {
    private Hashtable < Integer, String > customers = new Hashtable < Integer, String > ();
    private Customer customer;
    public Customer addCustomer(String emailAddress) {
        customer = new Customer(emailAddress);
        return customer;
    }
    
    /** method to add Customers*/
    public void addCustomers(int seatId, String emailAddress) {

        customers.put(seatId, emailAddress);

    }

    /** method to remove customer*/
    public boolean remove(String emailAddress) {
        if (!customers.containsValue(emailAddress)) {
            return false;
        }
        customers.values().removeAll(Collections.singleton(emailAddress));
        return true;
    }
    
    /** method to get all seats in hold by customer*/
    public Set getAllSeats(String emailAddress) {
        if (!customers.containsValue(emailAddress)) {
            return null;
        }
        Set seats = new HashSet();

        for (Map.Entry entry: customers.entrySet()) {
            if (emailAddress.equals(entry.getValue())) {
                seats.add(entry.getKey()); //no break, looping entire hashtable
            }
        }

        return seats;
    }


}