import java.util.*;

import controllers.ItemController;
import controllers.MembershipController;
import controllers.ReservationController;
import domain.Item;
import domain.Library;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
class EmployeeClient {
	
    public static void printAsterisks(){
        System.out.println("*******************************************************");
    }
    
    public static void main(String[] args) {
        Library lib = new Library();
    	boolean finished = false;
        while(!finished) {
            System.out.println("Welcome to the employee library management system\n\n");
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
                    System.out.println("\n1 - Add Item");
                    System.out.println("2 - Remove Item");
                    System.out.println("3 - Update Item");
                    System.out.println("4 - View all items");
                    System.out.println("5 - View checked out items");
                    System.out.println("6 - View lost items");
                    System.out.println("7 - View available items");
                    switch(s.nextInt()) {
                        case 1:  {
                          System.out.println("\nPlease enter item type (i.e. video, magazine, book, or newspaper: ");
                          String type = s.next();
                          System.out.println("\nPlease enter title: ");
                          String title = s.next();
                          System.out.println("\nPlease enter producer/author: ");
                          String producer = s.next();                          
                          System.out.println("\nPlease enter release date FORMAT mm/dd/yyyy");
                          String dateString = s.next();
                          DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
                          Date releaseDate = new Date();
                          try {
                                releaseDate = df.parse(dateString);
                            }
                            catch (Exception e) {
                                System.out.println("INVALID DATE, EXITING...");
                                finished = true;
                                continue;
                            }
                          ItemCtrl.addItem(type, title, producer, releaseDate);
                         }
                        break;
                        case 2: {
                          System.out.println("\nPlease enter item ID: ");
                          String identifier = s.next();
                          ItemCtrl.deleteItem(identifier);
                        }
                        break;
                       
                        case 3: {
                        	System.out.println("Please enter item ID: ");
                        	String id = s.next();
                        	boolean updated = false;
                        	for (Item i : ItemCtrl.getItems()) {
                        		if (i.getId().equals(id.trim())) {
                        			i.updateItem();
                        			System.out.println("Item updated");
                        		}
                        		updated = true;
                        	}
                        	if (!updated) {
                        		System.out.println("Item not found");
                        	}
                        }
                        break;
                        case 4: {
                        	ItemCtrl.viewAllItems();
                        }
                        break;
                        case 5: { 
                        	ItemCtrl.viewCheckedOutItems();
                        }
                        break;
                        case 6: {
                        	ItemCtrl.viewLostItems();
                        }
                        break;
                        
                        case 7: {
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
                    System.out.println("2 - update membership");
                    System.out.println("3 - delete membership");
                    System.out.println("4 - view all memberships");
                    System.out.println("5 - view active memberships");
                    System.out.println("6 - view expired memberships");
                	int choice = s.nextInt();
                	while (choice > 6 || choice < 1) {
                		System.out.println("Invalid choice.");
                		choice = s.nextInt();
                	}
                	switch (choice) {
                	case 1: {
                		MembershipCtrl.addMembership();
                	}
                	break;
                	case 2: {
                		System.out.println("Enter member name: ");
                		String name = s.next();
                		MembershipCtrl.updateMembership(name);
                	}
                	break;
                	case 3: {
                		System.out.println("Enter member name: ");
                		String name = s.next();
                		MembershipCtrl.removeMembership(name);
                	}
                	break;
                	case 4: {
                		MembershipCtrl.viewAllMemberships();
                	}
                	break;
                	case 5: {
                		MembershipCtrl.viewActiveMemberships();
                	}
                	break;
                	case 6: {
                		MembershipCtrl.viewExpiredMemberships();
                	}
                	break;
                	}
                }
                break;
                case 3: {
                	ReservationController ReservationCtrl = new ReservationController(lib.getReservations(), lib.getItems(), lib.getMemberships());
                	System.out.println("1 - create reservation (check out item)");
                    System.out.println("2 - delete reservation (check in item)");
                    System.out.println("3 - update reservation");
                    System.out.println("4 - view reservations");
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
                    case 3: ReservationCtrl.updateReservation();
                    	break;
                    case 4: ReservationCtrl.viewAllReservations();
                    	break;
                    default: 
                    	System.out.println("Invalid input.");
                    	continue;
                    }
                }
                break;
                default: System.out.println("Invalid input."
                		+ "");
                  continue;

            }


        }
    }
}