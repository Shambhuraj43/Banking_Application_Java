//Atm class
//Acts as the Atm for the user to access the accounts

import java.util.*;
import java.io.*;
import java.lang.*;

public class Atm {

	// arrayLists to store the user objects
	public  static ArrayList<User> array = new ArrayList<User>();
	public  static ArrayList<User> readArray = new ArrayList<User>();
	
	//Admin
	private Admin boss = new Admin();
	

	// creates initial list of users ith known account numbers and pin numbers. Users can be added through the program too (Admin >> add User).	
	public void createList() {
		
		User u1 = new User("1111", "1");
		User u2 = new User("2222", "2");
		User u3 = new User("3333" ,"3");
		User u4 = new User("4444", "4");
		User u5 = new User("5555", "5");
		
	
		readArray.add(u1);
		readArray.add(u2);
		readArray.add(u3);
		readArray.add(u4);
		readArray.add(u5);
		
	}
	
	//lists account numbers of the users 
	public void list(ArrayList<User> list) {
		
		System.out.println("Listing:");
		for(User i: list) {
			
			System.out.println(i.getAccountNumber());
		}
		
		serialize();
		
	}
	
	
	// serialize function
	@SuppressWarnings("resource")
	public void serialize() {
	
		
		//Serializes the ArrayList of user objects to the file listArray.ser
		try
		{
			FileOutputStream file_os = new FileOutputStream("listArray.ser");
			
			ObjectOutputStream obj_os = new ObjectOutputStream(file_os);
			
			obj_os.writeObject(this.readArray);
			
			file_os.close();
			obj_os.close();
		}
		catch(FileNotFoundException f) {
			System.out.println("Error: FileNotFoundEx - serialize method");
			return;
		}
		
		catch(IOException e) {
			System.out.println("Error: Ioex - serialize method");
			e.printStackTrace();
			return;
		}
	}

	
	// deserialize function
	@SuppressWarnings("unchecked")
	public void deserialize() {
		
		//Deserializes the file listArray.ser and stores the user objects in the readArray ArrayList

		try{
			FileInputStream file_is = new FileInputStream("listArray.ser");
			
			ObjectInputStream obj_is = new ObjectInputStream(file_is);
			
			
			readArray = (ArrayList<User>) obj_is.readObject();
			
			file_is.close();
			obj_is.close();
		}
		
		catch(IOException e) {
			System.out.println("Error: IOex - deserialize method");
			return;
		}
		catch(ClassNotFoundException c) {
			
			System.out.println("Error: ClassNotFound Ex - deserialize method");
			return;
		}
		
	}
	
	// getUser function
	public User getUser(String check1, String check2) {
		
		//Checks if the users exists and return null if does not
		String check = check1 + check2;
		int ctr = 0;
		
		for(User i: readArray) {
				
			if(check.compareToIgnoreCase(i.validate()) == 0) 
				return this.readArray.get(ctr);
			else
				ctr++;
		}
		
		return null;
	}
	
	
	// take input function
	public void takeInput() {
		
		Scanner read = new Scanner(System.in);
		String readString1;
		String readString2;
		String readString;
		int input;
		
		
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("1.Enter 1 to enter credentials");
		System.out.println("2.Enter 2 to exit");
		System.out.println("-------------------------------------------------------------------------");
		
		
		input = read.nextInt();
		
		if(input == 1) {
		

			System.out.println("*************************************************************************");
			System.out.println("Enter Account Number");
			System.out.println("-------------------------------------------------------------------------");
			readString1 = read.next();
			
			System.out.println("*************************************************************************");
			System.out.println("Enter pin");
			System.out.println("-------------------------------------------------------------------------");
			
			readString2 = read.next();
			System.out.println("*************************************************************************");
			
			readString =  readString1 + readString2;
			
			//Checks if the user exists or the user is Admin and redirects accordingly.

			User u = getUser(readString1, readString2);
			
			if(u != null) {
				u.menu();
			}
			else if((readString).compareToIgnoreCase(boss.validate()) == 0) {
				
				System.out.println("-----------------------Hello boss!-----------------------");
				boss.menu();
			}
			else{
				
				System.out.println("User does not exist");
				System.out.println("-------------------------------------------------------------------------");
				takeInput();
			}
		}
		else if(input == 2) {
			System.out.println("Exit");
			System.out.println("-------------------------------------------------------------------------");
			return;
		}
		else {
			System.out.println("Enter valid input");
			System.out.println("-------------------------------------------------------------------------");
			this.takeInput();
		}
	}
	
	
	// start function
	// This function reads the user objects from the existing files and stores them in the readArray ArrayList. After storing the users, it calls takeInput() to take input from the user to access the data. When the user exists, it serializes the ArrayList readArray and writes the user objects in it to the list.ser file to read from for the next run of the program.
	public void start() {

		deserialize();
		//list(Atm.readArray); uncomment this to see the account numbers and respective pins of the users
		takeInput();
		serialize();	
	}	

		
	// main function
	public static void main(String[] args) {
		
		Atm only = new Atm();
		
		/*To create listArray.ser file to deserialize in the start function

		*only.createList();
		*only.serialize();

		*/

		only.start();
		
		
	}
}
	


