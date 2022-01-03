//Checking class: serves as the checking account for the user

import java.util.Scanner;

public class Checking extends Account {

	public float checkingAmount;
	
	//Every user is given 100 dollars as Checking account balance
	Checking(){
		
		this.checkingAmount = 100f;
		
	
	}
	
	//getter fro checking balance
	public float getBalance() {
		
		
		return this.checkingAmount;
	}
	

	//deposits the amount into checking account
	@Override
	public void deposit(float value) {
		
		checkingAmount = checkingAmount + value;		
	}
	
	//withdraws from the checking account
	@Override
	public float withdraw(float value, float from) {
		
		return (from - value);
			
	}

}

