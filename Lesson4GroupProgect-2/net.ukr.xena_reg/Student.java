package net.ukr.xena_reg;

import java.time.LocalDate;

public class Student extends Human {

	private int stID;
	private int stRB;
	
	public Student(String lastName, String firstName, Sex sex, LocalDate lBirthday, int stID, int stRB) {
		super(lastName, firstName, sex, lBirthday);
		this.stID = stID;
		this.stRB = stRB;
	}

	public Student(String lastName, String firstName, Sex sex, LocalDate lBirthday) {
		super(lastName, firstName, sex, lBirthday);
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStID() {
		return stID;
	}

	public void setStID(int stID) {
		this.stID = stID;
	}

	public int getStRB() {
		return stRB;
	}

	public void setStRB(int stRB) {
		this.stRB = stRB;
	}
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj == this)
		    return true;

		    if(obj == null)
		    return false;

		    if(!(hashCode() == obj.hashCode()))
		    return false;
		    else
		    {
		      Student tmp = (Student)obj;
		      if(tmp.stID == this.stID)
		       return true;
		      else
		       return false;
		    }	
	}
	
	@Override
	public String toString() {
		
		return super.toString() + " stID= " + stID + ", stRB= " + stRB;
		
	}
}
