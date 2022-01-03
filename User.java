//User class
//Creates a virtual user with a checking and a savings account

import java.util.*;
import java.lang.*;
import java.io.*;

public class User implements Serializable {

	private String acNumber;
	private String pin;
	private Savings sAccount = new Savings();
	private Checking cAccount = new Checking();
	private float modBalance;
	
	//default constructor
	User(){
		
		//modBalance is the total balance which is just the sum of he savings balance and checking balance	
		modBalance = cAccount.getBalance() + sAccount.getBalance();
		System.out.println("The mod balance is:" + this.modBalance);
	}
	
	//overloaded constructor which is to create the user with account number and pin 
	User(String readString1, String readString2){
		
		this.acNumber = readString1;
		this.pin = readString2;
		modBalance = cAccount.getBalance() + sAccount.getBalance();
		
		
	}
	
	
	//gets the rate from the admin class and passes it to the savings account class method
	public void setRate(float rate, int time) {
		
		sAccount.interest(rate, time);
		this.updateModBalance();
	}
	
	//getter for the account number and the pin
	public String validate() {
		
		return this.acNumber + this.pin; 
	}
	
	//getter for the account number
	public String getAccountNumber() {
		
		return this.acNumber;
	}
	
	
	//prints the menu for the user
	public int printMenu() {
		
		System.out.println("*************************************************************************");
		System.out.println("0.Get Mod balance\n");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("1.Get checking balance\n");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("2.Deposit in checking\n");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("3.Withdraw from checking\n");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("4.Get Savings balance\n");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("5.Deposit in Savings\n");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("6.Withdraw from Savings\n");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("7.Get Summary\n");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("8.Exit");
		System.out.println("*************************************************************************");
		
		System.out.println("Enter option\n");
		System.out.println("-------------------------------------------------------------------------");
		
		Scanner read = new Scanner(System.in);
		int input = read.nextInt();
		
		return input; 
	}
	
	//getter for the mod balance
	public float getModBalance(){
		
		return modBalance;
	}

	//updates the mod balance everytime savings balance and checking balance changes	
	public void updateModBalance(){
		
		modBalance = cAccount.getBalance() + sAccount.getBalance();
	}
	
	//Prints the balances for individual account
	public void summary(){
		
		System.out.println("*************************************************************************");
		System.out.printf("Checking Balance: %.2f\n", cAccount.checkingAmount);
		System.out.println("-------------------------------------------------------------------------");
		System.out.printf("Savings Balance: %.2f\n", sAccount.savingsAmount);
		System.out.println("-------------------------------------------------------------------------");
		System.out.printf("Mod Balance: %.2f\n", this.modBalance);
		System.out.println("*************************************************************************");
	}
	
	//menu for the user
	//calls the respective function and takes input from the user
	public void menu() {
			
		Scanner read = new Scanner(System.in);
		String readString;
		float f;
		
		int input;
		
		do{
			
			input = this.printMenu();
			
			if(input == 0) {
				System.out.println(this.getModBalance());
			}
			else if(input == 1) {
				
				System.out.println(cAccount.getBalance());
				this.updateModBalance();
	
			}
			else if(input == 2) {
				
				f = read.nextFloat();
				cAccount.deposit(f);
				this.updateModBalance();
				this.summary();
				
			}
			else if(input == 3) {
				
				//If the input is greater than the total balance, does nothing to the checking balance
				System.out.println("Enter value to deposit");
				System.out.println("-------------------------------------------------------------------------");
				
				
				f = read.nextFloat();
				if(f > this.getModBalance()) {
					System.out.println("-------------------------------------------------------------------------");
					System.out.println("You do not have enough money!");
					System.out.println("-------------------------------------------------------------------------");
					this.summary();
					
				}
				else if(f > cAccount.checkingAmount) { //If the input is greater than the checking amount, withdraws from the total balance
					
					cAccount.checkingAmount = 0f;
					cAccount.withdraw(f,this.modBalance);
					this.updateModBalance();
					this.summary();
				}
				else {
					//If neither, withdraws from the cheking account	
					cAccount.checkingAmount = cAccount.withdraw(f,cAccount.checkingAmount);
					this.updateModBalance();
					this.summary();
				}
				
				
			}
			else if(input == 4) {
				
				sAccount.getBalance();
				
			}
			else if(input == 5) {
				
				f = read.nextFloat();
				sAccount.deposit(f);
				this.updateModBalance();
				this.summary();
				
			}
			else if(input == 6) {
				
				System.out.println("Enter value to deposit");
				System.out.println("-------------------------------------------------------------------------");
					
				f = read.nextFloat();
				if(f > this.modBalance) {
					System.out.println("-------------------------------------------------------------------------");
					System.out.println("You do not have enough money!");
					System.out.println("-------------------------------------------------------------------------");
					this.summary();
				}
				else if(f > sAccount.savingsAmount) {
					
					f= f - sAccount.savingsAmount;
					sAccount.savingsAmount = 0f;
					
					cAccount.checkingAmount = cAccount.withdraw(f,cAccount.checkingAmount);
					
					this.updateModBalance();
					this.summary();
				}
				else {
					
					sAccount.savingsAmount = sAccount.withdraw(f,sAccount.savingsAmount);
					this.updateModBalance();
					this.summary();
				}
			}	
			else if(input == 7) {
					
					this.summary();
				}
			else if(input == 8){
				
				System.out.println("Exiting");
				System.out.println("-------------------------------------------------------------------------");
				return;
			}
			else {
				
				System.out.println("Enter valid input");
				System.out.println("-------------------------------------------------------------------------");
				return;
			}
			
			
		}while(true);
		
	}
	
}


