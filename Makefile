run: Atm.class
	java Atm

default: Atm.class
	

Atm.class: Atm.java User.class Admin.class 
	javac Atm.java

Account.class: Account.java
	javac Account.java

Checking.class: Checking.java 
	javac Checking.java

Savings.class: Savings.java
	javac Savings.java

User.class: User.java Checking.class Savings.class
	javac User.java

Admin.class: Admin.java
	javac Admin.java
clean:
	rm *.class


	

