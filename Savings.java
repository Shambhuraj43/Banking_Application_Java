//Savings class: serves as the savings account for the user

import java.util.Scanner;

public class Savings extends Account {

	public  float savingsAmount;
	
	//Initial savings balance is set to 0
	Savings(){
		
		this.savingsAmount = 0;
	}
	
	//getter for teh savings class
	public float getBalance() {
		
		return this.savingsAmount;
	}
	
	//Interest function which applies the interest on the savings balance
	public void interest(float rate, int time) {
		
		this.savingsAmount = this.savingsAmount + (this.savingsAmount * rate * time);
	}
	
	//deposits into the savings account
	@Override
	public void deposit(float value) {
		savingsAmount = savingsAmount + value;
		
	}

	//withdraws from the savings account
	@Override
	public float withdraw(float value, float from) {
		return (from - value);
	}
}

