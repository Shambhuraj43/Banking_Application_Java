//This is an abstract class which is inherited by the Checking and Savings class

import java.util.*;
import java.io.*;

public abstract class Account implements Serializable {

	protected  float totalAmount;
	
	
	
	
	abstract public float getBalance();
	

	public void deposit(float value) {}

	public float withdraw(float value, float from) {return 0f;}
			
}

