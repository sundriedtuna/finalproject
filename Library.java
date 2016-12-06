package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
	private String name, address, phoneNumber;
	private List<Item> items;
	private List<Membership> memberships;
	private List<Reservation> reservations;
	public Library() {
		name = "NULL";
		address = "NULL";
		phoneNumber = "NULL";
		items = new ArrayList<Item>();
		memberships = new ArrayList<Membership>();
		reservations = new ArrayList<Reservation>();
	}
	
	public Library(String n, String add, String phone) {
		name = 	n;
		address = add;
		phoneNumber = phone;
		items = new ArrayList<Item>();
		
	}
	public Library(List<Item> items, List<Membership> memberships, List<Reservation> reservations) {
		this.items = items;
		this.memberships = memberships;
		this.reservations = reservations;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Membership> getMemberships() {
		return memberships;
	}

	public void setMemberships(List<Membership> memberships) {
		this.memberships = memberships;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
}
