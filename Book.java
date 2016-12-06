package domain;

import java.util.Scanner;

import etc.ItemStatus;

public class Book extends Item {
	private String author;
	private int edition; 
 	public Book(String title, int edition, String author) {
 		super(title); 
 		this.edition = edition;
 		this.author = author;
 	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	@Override
	public void updateItem() {
		System.out.println("Choose attribute to update: ");
		Scanner sc = new Scanner(System.in);
		String attribute = sc.next().trim();
		while (!attribute.equalsIgnoreCase("title") && !attribute.equalsIgnoreCase("status") && !attribute.equalsIgnoreCase("author") && !attribute.equalsIgnoreCase("edition")) {
			System.out.println("Invalid input: ");
			attribute = sc.next();
		}
		int attributeIndex = 0;
		if (attribute.equalsIgnoreCase("title")) {
			attributeIndex = 1;
		}
		else if (attribute.equalsIgnoreCase("status")) {
			attributeIndex = 2;
		}
		else if (attribute.equalsIgnoreCase("author")) {
			attributeIndex = 3;
		}
		else if (attribute.equalsIgnoreCase("edition")) {
			attributeIndex = 4;
		}
		switch(attributeIndex) {
		case 1:
			System.out.println("Enter new title: ");
			this.setTitle(sc.next());
			break;
		case 2: {
			System.out.println("Enter new status: ");
			String status = sc.next().trim();
			while (!status.equalsIgnoreCase("available") && !status.equalsIgnoreCase("checkedout") && !status.equalsIgnoreCase("lost")) {
				System.out.println("Invalid input: ");
				status = sc.next();
			}
			if (status.equalsIgnoreCase("available")) {
				this.setStatus(ItemStatus.Available);
				System.out.println("Status changed to available.");
			}
				
			else  if (status.equalsIgnoreCase("checkedout")) {
				this.setStatus(ItemStatus.CheckedOut);
				System.out.println("Status changed to checked out.");
			}
			else if (status.equalsIgnoreCase("lost")) {
				this.setStatus(ItemStatus.Lost);
				System.out.println("Status changed to lost.");
			}
			break;
		}
		case 3:
			System.out.println("Enter new value for author: ");
			this.setAuthor(sc.next());
			break;
		case 4:
			System.out.println("Enter edition: ");
			this.setEdition(Integer.parseInt(sc.next()));
		}
	}
	public String toString() {
		String result = super.toString();
		result += "\tAuthor: " + this.author;
		return result;
	}
 	
}
