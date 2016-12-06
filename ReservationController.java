package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import domain.Item;
import domain.Membership;
import domain.Reservation;
import etc.ItemStatus;
import etc.MembershipStatus;
import etc.ReservationStatus;

public class ReservationController {
	List<Reservation> reservations;
	List<Item> items;
	List<Membership> memberships;
	
	public ReservationController(List<Reservation> reservations, List<Item> items, List<Membership> memberships) {
		this.reservations = reservations;
		this.items = items;
		this.memberships = memberships;
	}
	@SuppressWarnings("deprecation")
	public void createReservation() {
		System.out.println("Enter member name: ");
		Scanner s = new Scanner(System.in);
		String name = s.next();
		System.out.println("Enter itemID: ");
		String id = s.next();
		boolean validItem = false;
		boolean validMember = false;
		Item toCheckOut = null;
		for (Item i : items) {
			if (i.getId().equals(id)) {
				if (i.getStatus() == ItemStatus.Available) {
					validItem = true;
					toCheckOut = i;
					break;
				}
			}
		}
		for (Membership m : memberships) {
			if (m.getName().equalsIgnoreCase(name)) {
				if(m.getStatus() == MembershipStatus.Active) {
					validMember = true;
					break;
				}
			}
		}
		if(validItem && validMember) {
			Date reservedDate = new Date();
			Date dueDate = new Date();
			dueDate.setDate(dueDate.getDate() + 14);
			Reservation r = new Reservation(reservedDate, dueDate, toCheckOut, name);
			toCheckOut.setStatus(ItemStatus.CheckedOut);
			reservations.add(r);
		}
		else {
			System.out.println("This user cannot check out this item");
		}
		
	}
	public void deleteReservation(String memberName, String itemId) {
		boolean removed = false;
		for (int i = 0; i < reservations.size(); i++) {
			if (reservations.get(i).getMemberName().equalsIgnoreCase(memberName) && reservations.get(i).getItem().getId().equalsIgnoreCase(itemId)) {
				reservations.get(i).getItem().setStatus(ItemStatus.Available);
				reservations.remove(i);
				System.out.println("Reservation removed");
				removed = true;
			}
		}
		if (!removed) {
			System.out.println("Reservation not found");
		}
	}
	public void updateReservation() {
		System.out.println("Enter member name: ");
		Scanner s = new Scanner(System.in);
		String memberName = s.next();
		System.out.println("Enter item ID: ");
		String itemId = s.next();
		boolean updated = false;
		for (int i = 0; i < reservations.size(); i++) {
			if (reservations.get(i).getMemberName().equalsIgnoreCase(memberName) && reservations.get(i).getItem().getId().equalsIgnoreCase(itemId)) {
				System.out.println("Enter attribute to update: ");
				String attribute = s.next();
				while (!attribute.equalsIgnoreCase("duedate") && !attribute.equalsIgnoreCase("status")) {
					System.out.println("Invalid input: ");
					attribute = s.next();
				}
				switch (attribute) {
				case "duedate": 
					System.out.println("Enter month (1-12): ");
					reservations.get(i).getDueDate().setMonth(Integer.parseInt(s.next()));
					System.out.println("Enter date: (1-31): ");
					reservations.get(i).getDueDate().setDate(Integer.parseInt(s.next()));
					System.out.println("Enter year (YYYY): ");
					reservations.get(i).getDueDate().setYear(Integer.parseInt(s.next()));
					break;
				case "status":
					System.out.println("Enter status: ");
					String status = s.next();
					while (!status.equalsIgnoreCase("returned") && !status.equalsIgnoreCase("overdue") && !status.equalsIgnoreCase("checkedout")) {
						System.out.println("Invalid input: ");
						status = s.next();
					}
					switch (status) {
					case "returned": reservations.get(i).setStatus(ReservationStatus.Returned);
					break;
					case "overdue": reservations.get(i).setStatus(ReservationStatus.Overdue);
					break;
					case "checkedout": reservations.get(i).setStatus(ReservationStatus.CheckedOut);
					break;
					}
				}
				updated = true;
			}
		}
		if (!updated) {
			System.out.println("Reservation not found");
		}
		else 
			System.out.println("Reservation updated");
	}
	public void viewAllReservations() {
		if (reservations.size() > 0) {
			for (Reservation r : reservations) {
				System.out.println(r.toString());
			}
		}
		else 
			System.out.println("No  memberships to display");
	}
	
}

