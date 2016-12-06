package controllers;

import java.util.ArrayList;
import java.util.List;

import domain.Book;
import domain.Item;
import domain.Video;
import domain.Magazine;
import domain.Newspaper;
import java.util.Date;
import etc.ItemStatus;

public class ItemController {
	
	List<Item> items;
	
	public ItemController() {
		items = new ArrayList<Item>();
	}
	public ItemController(List<Item> items) {
		this.items = items;
	}
	public void addItem(String type, String title, String publisher, Date publish_date) {
		switch(type){
			case "book":
				Book b = new Book(title, 1, publisher);
				System.out.println("Adding book to library.");
				this.items.add(b);
				System.out.println(b.toString());
				break;
			case "video":
				Video v = new Video(title, publisher, publish_date);
				System.out.println("\nAdding video to library");
				this.items.add(v);
				System.out.println(v.toString());
				break;
			case "magazine":
				Magazine m = new Magazine(title, publish_date);
				System.out.println("\n Adding magazine to library");
				this.items.add(m);
				System.out.println(m.toString());
				break;
			case "newspaper":
				Newspaper n = new Newspaper(title, publish_date, publisher);
				System.out.println("\n Adding newspaper to library");
				this.items.add(n);
				System.out.println(n.toString());				
				break;
			default:
				System.out.println("\n Invalid item type, must be book, video, newspaper, or magazine");
				break;
		}
	}
	public void deleteItem(String itemId) {
		boolean removed = false;
		for (int i =0 ; i < items.size(); i++) {
			if (items.get(i).getId().equals(itemId)) {
				items.remove(i);
				System.out.println(items.get(i).getTitle() + " removed.");
				removed = true;
			}
		}
		if(!removed) {
			System.out.println("Invalid item ID, nothing was removed.");
		}
	}
	public void viewAllItems() {
		if (items.size() > 0) {
			for (Item i : items) {
				i.display();
			}
		}
		else 
			System.out.println("No items to display");
	}
	public void viewCheckedOutItems() {
		ArrayList<Item> checkedOutItems = new ArrayList<Item>();
		for (Item i : items) {
			if (i.getStatus() == ItemStatus.CheckedOut) {
				checkedOutItems.add(i);
			}
		}
		if (checkedOutItems.isEmpty()) {
			System.out.println("No checked out items to display");
		}
		else {
			System.out.println("Checked out items:");
			for(Item i : checkedOutItems) {
				i.display();
			}
		}
	}
	public void viewLostItems() {
		ArrayList<Item> lostItems = new ArrayList<Item>();
		for (Item i : items) {
			if (i.getStatus() == ItemStatus.Lost) {
				lostItems.add(i);
			}
		}
		if (lostItems.isEmpty()) {
			System.out.println("No lost items to display");
		}
		else {
			System.out.println("Lost items:");
			for(Item i : lostItems) {
				i.display();
			}
		}
	}
	public void viewAvailableItems() {
		ArrayList<Item> availableItems = new ArrayList<Item>();
		for (Item i : items) {
			if (i.getStatus() == ItemStatus.Available) {
				availableItems.add(i);
			}
		}
		if (availableItems.isEmpty()) {
			System.out.println("No available items to display");
		}
		System.out.println("Availablet items:");
		for(Item i : availableItems) {
			i.display();
		}
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
