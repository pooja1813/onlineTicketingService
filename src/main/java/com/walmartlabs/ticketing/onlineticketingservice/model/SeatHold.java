/*
 * SeatHold
 * 
 * 1.0.0
 *
 * 01/20/2018
 * 
 * @PoojaSampelly
 */

package com.walmartlabs.ticketing.onlineticketingservice.model;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/** This class Holds the seats*/
public class SeatHold {

    private Hashtable < Integer, Seat > Seats = new Hashtable < Integer, Seat > ();
    public SeatHold() {}
    
    /** method to addSeats */
    public void addSeats(Seat seat) {
        Seats.put(seat.getID(), seat);
    }

    /** method to find availabity of a seat */
    public boolean findavailabilty(int id) {
        boolean avail = Seats.get(id).getAvailabilty();
        return avail;
    }

    /** method to get Total Count of seats */
    public int Count() {
        int count = Seats.size();
        return count;
    }
    
    /** method to get available Seats Count*/
    public int CountAvailable() {
        ArrayList < Integer > seatList = getavailableSeats();
        return seatList.size();
    }


    /** method to get find a seat */
    public Seat find(int id) {
        return Seats.get(id);
    }
    
    /** method to get List of Available Seats*/
    public ArrayList < Integer > getavailableSeats() {
        
        Set < Integer > keys = Seats.keySet();
        int num = 0;
        ArrayList < Integer > seatList = new ArrayList < Integer > ();

        //Obtaining iterator over set entries
        Iterator < Integer > itr = keys.iterator();

        //Displaying Key and value pairs
        while (itr.hasNext()) {
            // Getting Key
            num = itr.next();

            if (Seats.get(num).getAvailabilty() == true) {
                seatList.add(num);
            }
        }
        return seatList;
    }
}