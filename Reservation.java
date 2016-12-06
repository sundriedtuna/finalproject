package domain;

import java.util.Date;
import java.util.List;

import etc.ReservationStatus;

public class Reservation {
	private ReservationStatus status;
	private Date reservedDate;
	private Date dueDate;
	private List<String> notes;
	private Item item;
	private String memberName;
	
	public Reservation(Date reservedDate, Date dueDate, Item item, String memberName) {
		this.reservedDate = reservedDate;
		this.dueDate = dueDate;
		this.item = item;
		this.status = ReservationStatus.CheckedOut;
		this.memberName = memberName;
	}
	
	public ReservationStatus getStatus() {
		return status;
	}
	public void setStatus(ReservationStatus status) {
		this.status = status;
	}
	public Date getReservedDate() {
		return reservedDate;
	}
	public void setReservedDate(Date reserved_date) {
		this.reservedDate = reserved_date;
	}
	public List<String> getNotes() {
		return notes;
	}
	public void setNotes(List<String> notes) {
		this.notes = notes;
	}
	public void addNote(String note) {
		if(note.isEmpty()) {
			throw new IllegalArgumentException("Note cannot be empty!");
		}
		notes.add(note);	
	}
	public void removeNote(int index) {
		if(index > notes.size()) {
			throw new IllegalArgumentException("Index cannot exceed number of notes!");
		}
		notes.remove(index);
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String membername) {
		this.memberName = membername;
	}
	public String toString() {
		String result = "Name: " + this.memberName;
		result += "\tItem ID: " + this.item.getId();
		result += "\tStatus: " + this.getStatus().toString();
		result += "\nChecked out date: " + reservedDate.toString();
		result += "\nDue date: " + dueDate.toString();
		return result;
	}

}
