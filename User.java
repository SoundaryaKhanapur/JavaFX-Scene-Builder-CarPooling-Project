package com.carpooling;

public class User {
	
	public String username;
	public String password;
	public String fname;
	public String lname;
	public String mobile;
	public String route;
	public String stpt;
	private int seats;
	private String op;
	private String tslot;
	public int getSeats() {
		return seats;					//only public saved in file
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getTslot() {
		return tslot;
	}
	public void setTslot(String tslot) {
		this.tslot = tslot;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	@Override
	public boolean equals(Object o) {									//equals method override
		if(null!=o&&o.getClass().equals(this.getClass())) {				//ob1==ob2 
			User tmp =(User)o;							//user type class
			if(this.username.equals(tmp.username))
				return true;
		}						//to check if user name valid
		return false;
		
	}
}
