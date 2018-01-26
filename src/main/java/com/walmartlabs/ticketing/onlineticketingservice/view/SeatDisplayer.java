/*
 * SeatDisplayer
 * 
 * 1.0.0
 *
 * 01/20/2018
 * 
 * @PoojaSampelly
 */

package com.walmartlabs.ticketing.onlineticketingservice.view;
import com.walmartlabs.ticketing.onlineticketingservice.model.SeatHold;
import com.walmartlabs.ticketing.onlineticketingservice.service.OrderTickets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;
/** This class allows user to select, hold and reserve seats through console, It acts as UI*/

public class SeatDisplayer {
    
	//class variables
    private static OrderTickets orderTickets = OrderTickets.getInstance();
    private static ArrayList < Integer > seatList;
    private static long timer = 60000; // in milliseconds
    private static SeatHold seatHolder;
    
    public static void main(String[] args) {
    	
    	//variable declarations
        long startTime = System.currentTimeMillis();
        int numOfAvailSeats = 0;
        int bookTicketsNum = 0;
        String emailAddress = null;
        Scanner sc = new Scanner(System.in);
        long timeElapsed;
        int[] selectedSeats = null;

        numOfAvailSeats = orderTickets.getNumOfAvailSeats();
        timeElapsed = System.currentTimeMillis() - startTime;
        
        //checking for elapsed time
        if (timeElapsed < timer) {
            System.out.println("\n Please enter number of tickets");
            bookTicketsNum = sc.nextInt();
            if (bookTicketsNum <= 0) {
                System.out.println("\n Standing is not allowed, you need atleast one seat!Please run the program again");
            }
            if (numOfAvailSeats < bookTicketsNum) {
                System.out.println("\n Sorry! there are only few seats available");
                System.exit(0);
            }

            System.out.println("\n Please enter emailAddress");
            sc.nextLine();
            emailAddress = sc.nextLine();

            //email address server side validation
            //assuming client side validation is done to perfection.
            boolean validity = checkEmailValidity(emailAddress);
            if (validity) {
                System.out.println("\n Welcome to the seating arragement");
                seatHolder = orderTickets.findAndHoldSeats(bookTicketsNum, emailAddress);
                seatList = seatHolder.getavailableSeats();
                display(seatList);
            } else {

                System.out.println("\n Invalid email!please run the program again");
                System.exit(0);
            }
        } else {
            System.out.println("\n Session TimedOut");
            System.exit(0);
        }
        
        timeElapsed = System.currentTimeMillis() - startTime;
        //checking timer before holding seats action
        if (timeElapsed < timer) {
            System.out.println("\n please enter seat numbers");
            selectedSeats = seatSelection(bookTicketsNum, emailAddress, startTime);
        } else {
            System.out.println("\n Session TimedOut");
            System.exit(0);
        }

        timeElapsed = System.currentTimeMillis() - startTime;
        if (selectedSeats.length == 1) {
        	//checking elapsed time before reserve seats
            if (timeElapsed < timer) {
                String message = orderTickets.reserveSeats(selectedSeats[0], emailAddress);
                System.out.println("\n"+message);
                seatHolder = orderTickets.findAndHoldSeats(bookTicketsNum, emailAddress);
                seatList =seatHolder.getavailableSeats();
                display(seatList);
            } else {

                System.out.println("\n Session TimedOut");
                orderTickets.unHoldSeats(emailAddress);
                seatHolder = orderTickets.findAndHoldSeats(bookTicketsNum, emailAddress);
                seatList =seatHolder.getavailableSeats();
                display(seatList);
                System.exit(0);
            }
        } else {
            if (timeElapsed < timer) {
                String message = orderTickets.reserveSeats(selectedSeats, emailAddress);
                System.out.println("\n"+message);
                seatHolder = orderTickets.findAndHoldSeats(bookTicketsNum, emailAddress);
                seatList =seatHolder.getavailableSeats();
                display(seatList);
            } else {
                orderTickets.unHoldSeats(emailAddress);
                seatHolder = orderTickets.findAndHoldSeats(bookTicketsNum, emailAddress);
                seatList =seatHolder.getavailableSeats();
                display(seatList);
                System.out.println("\n Session TimedOut");
                System.exit(0);
            }
        }
        sc.close();
    } 


    /** this method allows user to select and hold seats*/
    public static int[] seatSelection(int bookTickets, String emailAddress, long startTime) {
        int[] selectedSeats = new int[bookTickets];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < bookTickets; i++) {
            selectedSeats[i] = input.nextInt();
        }
        seatHolder = orderTickets.holdSeats(selectedSeats, emailAddress);
        long estimatedTime = System.currentTimeMillis() - startTime;
        
        //check if another user thread has already holden the seats and elapsed time check before holding seats
        if (seatHolder == null && estimatedTime < timer) {
            System.out.println("\nSorry! error Ocuured !please select seat numbers");
            seatHolder = orderTickets.findAndHoldSeats(bookTickets, emailAddress);
            seatList = seatHolder.getavailableSeats();
            seatHolder.getavailableSeats();
            seatSelection(bookTickets, emailAddress, startTime);
        }

        input.close();
        return selectedSeats;

    }

    /** This method checks the validity of email address*/
    public static boolean checkEmailValidity(String emailAddress) {
        String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher match = pattern.matcher(emailAddress);
        return match.matches();
    }

    /** This method displays the seating arrangement */
    public static void display(List < Integer > seatList) {
        for (int i = 1; i <= 100; i++) {
            if (seatList.contains(i)) {
                System.out.print(i + ((i % 10 == 0) ? "\n" : " "));
            } else if (i % 10 == 0) {
                System.out.print("B\n");
            } else {
                System.out.print("B  ");
            }

        }


    }
}