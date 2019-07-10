package net.ukr.xena_reg;

public class MyCat {
	private String name;
	private String coatColor;
	private String breed;
	private String sex;
	private int age;
	private short chipNumber;

	public MyCat(String name, String coatColor, String breed, String sex, int age, short chipNumber) {
		super();
		this.name = name;
		this.coatColor = coatColor;
		this.breed = breed;
		this.sex = sex;
		this.age = age;
		this.chipNumber = chipNumber;
	}

	public MyCat(String name, String coatColor, String sex, int age) {
		super();
		this.name = name;
		this.coatColor = coatColor;
		this.sex = sex;
		this.age = age;
	}

	public MyCat() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoatColor() {
		return coatColor;
	}

	public void setCoatColor(String coatColor) {
		this.coatColor = coatColor;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public short getChipNumber() {
		return chipNumber;
	}

	public void setChipNumber(short chipNumber) {
		this.chipNumber = chipNumber;
	}

	public void getVoice() {
		System.out.println("Myau-myau");
	}

	public void play() {
		System.out.println("Run and play");
	}

	public void eat() {
		System.out.println("Ask for food all the time");
	}

	public void sleep() {
		System.out.println("Get some sleep with pleaser");
	}

	@Override
	public String toString() {
		return "MyCat [name=" + name + ", coatColor=" + coatColor + ", sex=" + sex + ", age=" + age	+ "]";
	}

}
