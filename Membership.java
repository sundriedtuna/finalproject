package domain;

import java.util.Date;

import etc.MembershipStatus;
import etc.Role;

public class Membership {
	private MembershipStatus status;
	private String name;
	private Date startDate;
	private Role role;
	private Date expireDate;
	
	public Membership(String name, Role r, Date ed) {
		this.name = name;
		role = r;
		startDate = new Date();
		expireDate = ed;
		status = MembershipStatus.Active;
	}
	public MembershipStatus getStatus() {
		return status;
	}
	public void setStatus(MembershipStatus status) {
		this.status = status;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		String result = "Name: " + this.name;
		result += "\tRole: " + (this.role == Role.Employee ? "Employee" : "User");
		result += "\tStatus: ";
		switch(this.status) {
		case Active:
			result += "Active";
			break;
		case Expired:
			result += "Expired";
			break;
		case Cancelled:
			result += "Cancelled";
			break;
		}
		result += "\nStart date: " + this.startDate.toString();
		result += "\nExpire date: " + this.expireDate.toString();
		return result;
	}
}
