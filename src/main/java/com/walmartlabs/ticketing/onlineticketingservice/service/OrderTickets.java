/*
 * OrderTickets
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
import java.util.Set;

/** This class implements TicketService*/
public class OrderTickets implements TicketService {

    //class variables
    private CustomerManager customerManager;
    private SeatHold holder;
    private Seat currentSeatSelected;
    private static OrderTickets instance;
    
    // constructor which initializes classes
    public OrderTickets() {
        
        customerManager = new CustomerManager();
        holder = new SeatHold();
        int total_seats = 100;

        for (int i = 1; i <= total_seats; i++) {
            currentSeatSelected = new Seat(i, true);
            holder.addSeats(currentSeatSelected);
        }

    }
    static {
        instance = new OrderTickets();
    }

    /** Static 'instance' method */
    public static OrderTickets getInstance() {
        return instance;
    }

    /** method to get customerManager Object */
    public CustomerManager getCustomerManager() {
        return customerManager;
    }
   
    /**method to get number of available seats */
    public int getNumOfAvailSeats() {
        int count = holder.CountAvailable();
        return count;
    }

    /**method to  findandHold Seats */
    public SeatHold findAndHoldSeats(int numSeats, String emailAddress) {
        // TODO Auto-generated method stub
        customerManager.addCustomer(emailAddress);
        return holder;
    }
    
    /**method to  hold Seats,synchronized method can be accessed by only one thread at once */
    public synchronized SeatHold holdSeats(int[] selectedSeats, String emailAddress) {
    	
        for (int i = 0; i < selectedSeats.length; i++) {
            if (holder.findavailabilty(selectedSeats[i]) == false) {
                return null;
            }
            Seat seat = holder.find(selectedSeats[i]);
            seat.setAvailabilty(false);
            holder.addSeats(seat);
            customerManager.addCustomers(selectedSeats[i], emailAddress);
        }
        
        return holder;
    }
    
    /**method to  unHold Seats */

    public boolean unHoldSeats(String emailAddress) {
        Set <Integer> seats = customerManager.getAllSeats(emailAddress);
        if(seats!=null) {
        for(int seatId: seats) {
            Seat seat = holder.find(seatId);
            seat.setAvailabilty(true);
            holder.addSeats(seat);
        }
        customerManager.remove(emailAddress);
        return customerManager.remove(emailAddress);}
        return false;
    }
    

    /**method to reserve a Seat */
    public String reserveSeats(int seatHoldId, String emailAddress) {
        return "Your Seat has been reserved";
    }
 
    /**method to reserve Seats */
    public String reserveSeats(int[] selectedSeats, String emailAddress) {
        return "Your Seat has been reserved";
    }



}