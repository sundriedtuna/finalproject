package domain;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import etc.ItemStatus;

public class Video extends Item {
	private String produced_by;
	private Date release_date;
	public Video(String title, String produced_by, Date release_date) {
		super(title);
		this.produced_by = produced_by;
		this.release_date = release_date;
	}
	public String getProduced_by() {
		return produced_by;
	}
	public void setProduced_by(String produced_by) {
		this.produced_by = produced_by;
	}
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	@SuppressWarnings("deprecation")
	public String toString() {
		String result = super.toString();
		result += "\tProduced by: " + this.produced_by;
		result += "\tRelease date: " + this.release_date.toString();
		return result;
	}
	@Override
	public void updateItem() {
		System.out.println("Choose attribute to update: ");
		Scanner sc = new Scanner(System.in);
		String attribute = sc.next();
		while (!attribute.equalsIgnoreCase("title") && !attribute.equalsIgnoreCase("status") && !attribute.equalsIgnoreCase("produced by") && !attribute.equalsIgnoreCase("release date")) {
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
		else if (attribute.equalsIgnoreCase("produced by")) {
			attributeIndex = 3;
		}
		else if (attribute.equalsIgnoreCase("release date")) {
			attributeIndex = 4;
		}
		switch(attributeIndex) {
		case 1:
			System.out.println("Enter new title: ");
			this.setTitle(sc.next());
			break;
		case 2: {
			System.out.println("Enter new status: ");
			String status = sc.next();
			while (!status.equalsIgnoreCase("available") && !status.equalsIgnoreCase("checkedout") && !status.equalsIgnoreCase("lost")) {
				System.out.println("Invalid input: ");
				status = sc.next();
			}
			if (status.equalsIgnoreCase("available")) {
				this.setStatus(ItemStatus.Available);
			}
				
			else  if (status.equalsIgnoreCase("checkedout")) {
				this.setStatus(ItemStatus.CheckedOut);
			}
			else if (status.equalsIgnoreCase("lost")) {
				this.setStatus(ItemStatus.Lost);
			}
			break;
		}
		case 3:
			System.out.println("Enter new value for produced by: ");
			this.setProduced_by(sc.next());
			break;
		case 4:
			System.out.println("Enter month (1-12): ");
			this.release_date.setMonth(Integer.parseInt(sc.next()));
			System.out.println("Enter date: (1-31): ");
			this.release_date.setDate(Integer.parseInt(sc.next()));
			System.out.println("Enter year (YYYY): ");
			this.release_date.setYear(Integer.parseInt(sc.next()));
			break;
		}
	}
}
