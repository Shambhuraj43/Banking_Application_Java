//Admin class
//This is the class for the only Admin who can access as well as modify the information of the users.

import java.util.*;
import java.io.Serializable;
import java.lang.*;



public class Admin implements Serializable  {

	//Admin has fixed account number and pin
	private String baccountNumber = "0000";
	private String bpinNumber = "1234"; 
	private float rate;
	private static int time;
	
	public Admin(){
		
		time = 0;
	}
	
	//Validate function which cancatinates the account number and pin which is used to identify the user as the admin.
	public String validate() {
		
		return this.baccountNumber + this.bpinNumber; 
	}
	
	//add new user
	public void addUser() {
		
		int input;
		Scanner read = new Scanner(System.in);
		
		System.out.println("Enter 1 to add a user or 2 to go back\n");
		
		input = read.nextInt();
		
		
		while(true) {
			if(input == 1) {
			
				String readString1;
				String readString2;
				String readString;
				
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("Enter account number");
				readString1 = read.next();
		
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("Enter pin number");
				readString2 = read.next();
				
				readString = readString1 + readString2;
				
				//checks if the user already exists or not, otherwise creates a new one.
				for(User i: Atm.readArray) {
				
					if(readString.compareToIgnoreCase(i.validate()) == 0) {
						System.out.println("-------------------------------------------------------------------------");
						System.out.println("User already exists!");
						System.out.println("-------------------------------------------------------------------------");
					
						this.menu();
						return;
					}
					else {
				
						User u = new User(readString1,readString2);
				
						Atm.readArray.add(u);
						System.out.println("-------------------------------------------------------------------------");
						System.out.println("User has been added!");
						System.out.println("-------------------------------------------------------------------------");
						return;
					}
				
				}
			
			}
			else if(input == 2) {
				
				//calls menu function which prints the options a user can choose
				this.menu();
				return;
			
			}
			else {
			
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("Enter valid input");
				System.out.println("-------------------------------------------------------------------------");
				return;
			}
			
		}		
		
		
	}
	
	//deletes existing user
	public void deleteUser() {
		
		int input, ctr = 0;
		Scanner read = new Scanner(System.in);

		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Enter 1 to delete a user or 2 to go back");
		System.out.println("-------------------------------------------------------------------------");

		input = read.nextInt();

			
		String readString;
			
			
		if(input == 1) {
			
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Enter account number\n");
			readString = read.next();
			
			for(User i: Atm.readArray) {
				
				if(readString.compareTo(i.getAccountNumber()) == 0) {
					
					System.out.println("-------------------------------------------------------------------------");
					System.out.println("User has been deleted!");
					Atm.readArray.remove(i);	
					return;
				}
				
				ctr ++;
				
				//if user not found, prints user not founs and ends the function
				if(ctr == Atm.readArray.size()) {
					System.out.println("-------------------------------------------------------------------------");
					System.out.println("User not found\n");
					System.out.println("-------------------------------------------------------------------------");
					return;
				}
				
			}
		}
		else if(input == 2){
				
				this.menu();
				return;
		}
		else {
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Enter valid input!");
			System.out.println("-------------------------------------------------------------------------");
			read.close();
			this.menu();
			return;
		}
		
	}
		
	//lists all users by the account numbers
	public void listUser() {
		
		for(User i: Atm.readArray) {
			
			System.out.println(i.getAccountNumber());	
		}
	}
	
	//takes an input from the user for the rate value and applies that interest to all users 
	public void applyInterest() {
		
		Scanner read = new Scanner(System.in);
		String readString;
		float r;
		
		//increaments the time in the interest formula by 1 every time the function is called
		this.time = this.time + 1;
		
		r = read.nextFloat();
		readString = Float.toString(r);
		
		System.out.println(this.time);
		
		for(User i: Atm.readArray) {
			
			i.setRate(r, this.time); //calling the setRate method of every user
			
		}
	}
	
	

	//Prints the menu
	public int printMenu() {
		
		System.out.println("*************************************************************************");
		System.out.println("1.Add user");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("2.Delete user");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("3.List users");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("4.Apply interest");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("5.Exit");
		System.out.println("*************************************************************************");
		
		
		System.out.println("Enter option");
		System.out.println("-------------------------------------------------------------------------");
		
		Scanner read = new Scanner(System.in);
		int input = read.nextInt();
		
		return input;
		
	}
	
	// takes an input according the printed menu and calls the respective function
	public void menu() {
			
		int input;
		
		do{
		
			input = this.printMenu();
			if(input == 1) {
				this.addUser();
			}else if(input == 2) {
				this.deleteUser();
			}else if(input == 3) {
				this.listUser();
			}else if(input == 4) {
				this.applyInterest();
			}else if(input == 5){
				
				System.out.println("Exiting.....");
				System.out.println("-------------------------------------------------------------------------");
				return;
			}
			else {
				System.out.println("Enter valid input");
				System.out.println("-------------------------------------------------------------------------");
			}
			
		}while(true);
		
	}
}



