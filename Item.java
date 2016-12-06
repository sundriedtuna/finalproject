package domain;

import java.util.ArrayList;
import java.util.List;

import etc.ItemStatus;

public abstract class Item {
	private String id;
	private String title;
	private ItemStatus status;
	private List<String> notes;
	public Item (String title) {
		this.title = title;
		this.status = ItemStatus.Available;
		this.id = generateId();
		this.notes = new ArrayList<String>();
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ItemStatus getStatus() {
		return status;
	}
	public void setStatus(ItemStatus status) {
		this.status = status;
	}
	public void addNote(String note) {
		if (note.isEmpty()) {
			throw new IllegalArgumentException("Note cannot be empty!");
		}
	}
	public void removeNote(int index) {
		if (index > notes.size()) {
			throw new IllegalArgumentException("Index cannot exceed number of notes!");
		}
		notes.remove(index);
	}
	public String generateId() {
		String id = Integer.toString(this.hashCode());
		return id;
	}
	public void display() {
		System.out.println(this.toString());
	}
	public String toString() {
		String result = "";
		result += "ID: " + this.getId();
		result += "\tTitle: " +this.getTitle();
		result += "\tStatus: ";
	    switch (this.getStatus()) {
	    case Available: 
	    	result += "Available";
	    	break;
	    case CheckedOut:
	    	result += "Checked out";
	    	break;
	    case Lost:
	    	result += "Lost";
	    	break;
	    }
	    if (this instanceof Video)
	    	result +="\tType: Video";
	    else if (this instanceof Newspaper) 
	    	result += "\tType: Newspaper";
	    else if (this instanceof Magazine) 
	    	result += "\tType: Magazine";
	    else if (this instanceof Book) 
	    	result += "\tType: Book";
		return result;
	}
	public void updateItem() {
	}
}
