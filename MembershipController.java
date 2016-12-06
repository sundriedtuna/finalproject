package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import domain.Membership;
import etc.MembershipStatus;
import etc.Role;

public class MembershipController {
	private List<Membership> memberships;
	
	public MembershipController(List<Membership> memberships) {
		this.memberships = memberships;
	}
	@SuppressWarnings("deprecation")
	public void addMembership(){
		System.out.println("Enter name: ");
		Scanner s = new Scanner(System.in);
		String name = s.next();
		System.out.println("Enter role: ");
		String role = s.next();
		while (!role.equalsIgnoreCase("employee") && !role.equalsIgnoreCase("user")) {
			System.out.println("Invalid input: ");
			role = s.next();
		}
		if (role.equalsIgnoreCase("employee")) {
			Date expires = new Date();
			expires.setYear(expires.getYear() + 1);
			Membership m = new Membership(name, Role.Employee, expires); 
			if(!m.equals(null)) {
				memberships.add(m);
				System.out.println(m.getName() + "'s membership has been added.");
			}
		}
		else {
			Date expires = new Date();
			expires.setYear(expires.getYear() + 1);
			Membership m = new Membership(name, Role.User, expires);
			if(!m.equals(null)) {
				memberships.add(m);
				System.out.println(m.getName() + "'s membership has been added.");
			}
		}
		
	}
	public void removeMembership(String name){
		boolean removed = false;
		for (int i = 0; i < memberships.size(); i++) {
			if (memberships.get(i).getName().equals(name)) {
				memberships.remove(i);
				System.out.println("Membership removed");
				removed = true;
			}
		}
		if(!removed) {
			System.out.println("Invalid name, no membership removed");
		}
	}
	@SuppressWarnings("deprecation")
	public void updateMembership(String name) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < memberships.size(); i++) {
			if(memberships.get(i).getName().equals(name)) {
				System.out.println("Enter attribute to update: ");
				String attribute = sc.next();
				while (!attribute.equalsIgnoreCase("name") && !attribute.equalsIgnoreCase("status") && !attribute.equalsIgnoreCase("startdate") && !attribute.equalsIgnoreCase("role") && !attribute.equalsIgnoreCase("expiredate")) {
					System.out.println("Invalid input: ");
					attribute = sc.next();
				}
				if (attribute.equalsIgnoreCase("name")) {
					System.out.println("Enter new name: ");
					memberships.get(i).setName(sc.next());
				}
				else if (attribute.equalsIgnoreCase("status")) {
					System.out.println("Enter new status: ");
					String status = sc.next();
					while(!status.equalsIgnoreCase("cancelled") && !status.equalsIgnoreCase("active") && !status.equalsIgnoreCase("expired")) {
						System.out.println("Invalid input: ");
						status = sc.next();
					}
					if (status.equalsIgnoreCase("Active")) {
						memberships.get(i).setStatus(MembershipStatus.Active);
					}
					else if (status.equalsIgnoreCase("Cancelled")) {
						memberships.get(i).setStatus(MembershipStatus.Cancelled);
					}
					else if (status.equalsIgnoreCase("Expired")) {
						memberships.get(i).setStatus(MembershipStatus.Expired);
					}
				}
				else if (attribute.equalsIgnoreCase("startdate")) {
					System.out.println("Enter month (1-12): ");
					memberships.get(i).getStartDate().setMonth(Integer.parseInt(sc.next()));
					System.out.println("Enter date: (1-31): ");
					memberships.get(i).getStartDate().setDate(Integer.parseInt(sc.next()));
					System.out.println("Enter year (YYYY): ");
					memberships.get(i).getStartDate().setYear(Integer.parseInt(sc.next()));
				}
				else if (attribute.equalsIgnoreCase("role")) {
					System.out.println("Enter new role: ");
					String role = sc.next();
					while (!role.equalsIgnoreCase("user") || !role.equalsIgnoreCase("Employee")) {
						System.out.println("Invalid input: ");
						role = sc.next();
					}
					if (role.equalsIgnoreCase("employee")) {
						memberships.get(i).setRole(Role.Employee);
					}
					else if (role.equalsIgnoreCase("user")) {
						memberships.get(i).setRole(Role.User);
					}
				}
				else if (attribute.equalsIgnoreCase("expire date")) {
					
				}
			}			
		}
	}
	public void viewAllMemberships() {
		if (memberships.size() > 0) {
			for (Membership m : memberships) {
				System.out.println(m.toString());
			}
		}
		else {
			System.out.println("No memberships to display");
		}
	}
	
	public void viewExpiredMemberships() {
		ArrayList<Membership> expiredMemberships = new ArrayList<Membership>();
		for (Membership m : memberships) {
			if (m.getStatus() == MembershipStatus.Expired) {
				expiredMemberships.add(m);
			}
		}
		if (expiredMemberships.size() > 0) {
			for (Membership m : expiredMemberships) {
				System.out.println(m.toString());
			}
		}
		else 
			System.out.println("No expired memberships to display");
	}
	public void viewActiveMemberships() {
		ArrayList<Membership> activeMemberships = new ArrayList<Membership>();
		for (Membership m : memberships) {
			if (m.getStatus() == MembershipStatus.Active) {
				activeMemberships.add(m);
			}
		}
		if (activeMemberships.size() > 0) {
			for (Membership m : activeMemberships) {
				System.out.println(m.toString());
			}
		}
		else 
			System.out.println("No active memberships to display");
	}
}
