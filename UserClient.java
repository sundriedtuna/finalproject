import java.util.*;

import controllers.ItemController;
import controllers.MembershipController;
import controllers.ReservationController;
import domain.Item;
import domain.Library;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
class UserClient {
	
    public static void printAsterisks(){
        System.out.println("*******************************************************");
    }
    
    public static void main(String[] args) {
        Library lib = new Library();
    	boolean finished = false;
        while(!finished) {
            System.out.println("Welcome to the user library management system\n\n");
            printAsterisks();
            System.out.println("Please select the resource that you would like to create/modify/view");
            System.out.println("1 - Library Item");
            System.out.println("2 - Membership");
            System.out.println("3 - Reservation");
            printAsterisks();
            System.out.println("\n");
            Scanner s = new Scanner(System.in);
            switch (s.nextInt()) {
                case 1: {
                	ItemController ItemCtrl = new ItemController(lib.getItems());
                    System.out.println("1 - View all items");
                    System.out.println("2 - View checked out items");
                    System.out.println("3 - View available items");
                    switch(s.nextInt()) {
                       
                        case 1: {
                        	ItemCtrl.viewAllItems();
                        }
                        break;
                        case 2: { 
                        	ItemCtrl.viewCheckedOutItems();
                        }
                        break;
                        case 3: {
                        	ItemCtrl.viewAvailableItems();
                        }
                        break;
                        default: System.out.println("Invalid input.");
                          continue;
                    }
                }
                break;
                case 2: { 
                	MembershipController MembershipCtrl = new MembershipController(lib.getMemberships());
                	System.out.println("1 - create membership");
                	int choice = s.nextInt();
                	switch (choice) {
                	case 1: {
                		MembershipCtrl.addMembership();
                	}
                	break;
                	default: System.out.println("Invalid input");
                	break;
                	}
                }
                break;
                case 3: {
                	ReservationController ReservationCtrl = new ReservationController(lib.getReservations(), lib.getItems(), lib.getMemberships());
                	System.out.println("1 - create reservation (check out item)");
                    System.out.println("2 - delete reservation (check in item)");
                    int choice = s.nextInt();
                    switch (choice) {
                    case 1: 
                    	ReservationCtrl.createReservation();
                    	break;
                    case 2:
                    	System.out.println("Enter member name: ");
                    	String memberName = s.next();
                    	System.out.println("Enter Item ID: ");
                    	String itemId = s.next();
                    	ReservationCtrl.deleteReservation(memberName, itemId);
                    	break;
                    default: 
                    	System.out.println("Invalid input.");
                    	continue;
                    }
                }
                break;
                default: System.out.println("Invalid input.");
                  continue;

            }


        }
    }
}