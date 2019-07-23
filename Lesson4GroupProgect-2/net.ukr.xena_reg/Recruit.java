package net.ukr.xena_reg;

import java.util.Arrays;

import net.ukr.xena_reg.Human.Sex;

public class Recruit implements Voencom {
	private Group gr=new Group();
	private int count;
	
	public Recruit(Group gr) {
		super();
		this.gr = gr;
	}

	public Recruit() {
		super();
	}


	public Group getGr() {
		return gr;
	}

	public void setGr(Group gr) {
		this.gr = gr;
	}
	
	
	@Override
	public Student [] youInTheArmyNow() {
		this.count = 0;
		for (int i = 0; i < gr.getStud().length; i++) {
			if (gr.getStud()[i] != null) {
				if ((gr.getStud()[i].getAge() >= 18) && (gr.getStud()[i].getSex() == Sex.MALE)) {
					count++;
				}
			}
		}
		Student [] armyGuys = new Student[count];
		int point = 0;
		for (int i = 0; i < gr.getStud().length; i++) {
			if (gr.getStud()[i] != null) {
				if ((gr.getStud()[i].getAge() >= 18) && (gr.getStud()[i].getSex() == Sex.MALE)) {
					armyGuys[point] = gr.getStud()[i];
					point++;
				}
			}
		}
		return armyGuys;

	}
	@Override
	public String toString() {
		String[] sortString = new String[youInTheArmyNow().length];
		for (int i = 0; i < sortString.length; i++) {
		sortString[i] = this.youInTheArmyNow()[i].toString(); 
		}
		return String.join("\n", sortString);
	}
	

}
