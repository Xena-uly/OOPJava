package net.ukr.xena_reg;

//import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;


public class Human {

	private String lastName;
	private String firstName;

	public enum Sex {
		MALE, FEMALE, INTERSEX
	}
    private LocalDate lBirthday;
	private Sex sex;
	//SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");

public Human(String lastName, String firstName, Sex sex, LocalDate lBirthday) {
	super();
	this.lastName = lastName;
	this.firstName = firstName;
	this.sex = sex;
	this.lBirthday = lBirthday;
}

public Human() {
	super();
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

public Sex getSex() {
	return sex;
}

public void setSex(Sex sex) {
	this.sex = sex;
}

public LocalDate getlBirthday() {
	return lBirthday;
}

public void setlBirthday(LocalDate lBirthday) {
	this.lBirthday = lBirthday;
}

public int getAge() {
		
		LocalDate curDate = LocalDate.now();
		return Period.between(lBirthday, curDate).getYears();
	}

@Override
public String toString() {
		
	return lastName + " " + firstName + " " + sex + " " + lBirthday;
}

}
