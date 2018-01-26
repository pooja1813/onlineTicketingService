/*
 * Seat
 * 
 * 1.0.0
 *
 * 01/20/2018
 * 
 * @PoojaSampelly
 */

package com.walmartlabs.ticketing.onlineticketingservice.model;

/** This class creates the seat details*/
public class Seat {
    private int seatId;
    private boolean available;
    
    public Seat() {};
    public Seat(int id, boolean avail) {
        seatId = id;
        available = avail;

    }
    /** method to get seatId*/
    public int getID() {
        return seatId;
    }
    
    /** method to set seat availability*/
    public void setAvailabilty(boolean avail) {
        available = avail;
    }
    
    /** method to get seat availability*/
    public boolean getAvailabilty() {
        return available;
    }


}