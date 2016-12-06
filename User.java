package domain;

import java.util.List;

public class User {
	private String lastName, firstName, address, phoneNumber;
	private Membership membership;
	private List<Reservation> reservations;
	
	public User() {
		lastName = "NULL";
		firstName = "NULL";
		address ="NULL";
		phoneNumber = "NULL";
	}
	
	public User (String last, String first, String add, String phone) {
		lastName = last;
		firstName = first;
		address = add;
		phoneNumber = phone;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void addReservation(Reservation r) {
		reservations.add(r);
	}
	
}
