#### Goal: 
1. Create an object of Atm class
2. Run Atm method **start()** to start the atm program
#### Input: 
-- User input is required as per the choices
#### Output:
-- Output will be shown as per the choices
***
***
# Atm Class:
#### Goal: 
1. Start the atm program with which user will be interacting
2. Have a method **start()** to start the atm program
#### Input: 
-- User input is required as per the choices
#### Output:
-- Output will be shown as per the choices
#### Methods:
##### 1.start():void
* Run the atm program using class methods
##### 2. createArray()
* Using deserialization, store the user objects in the array list
##### 2. deleteArray()
* Using serialization, write the user array list to the external file
* delete the array list
***
***
# Admin class:
#### Goal: 
1. There will be only one object of this class which will specific account number and pin number
2. It will have the access of the array list of users and will be able to modify it through different methods.
#### Input: 
-- User input is required as per the choices
#### Output:
-- Output will be shown as per the choices
#### Methods:
##### 1.addUser():void
* Take input from the user (account number)
* Validate the input by the account number using the list. If the user with the same account number exists, print *User already exists!* otherwise create an user and add it to the list
##### 2.deleteUser():void
* Take input from the user (account number)
* Find the user in the list by iterating through the list and delete it, otherwise, print *User not Found!*
##### 3.listUser():void
* List all the user by their account numbers
##### 4.applyInterest():void
* Take input from the user (interest rate)
* Iterate through the list and call **setInterest()** function of the user class
##### 5.menu():void
* Display the menu of 5 different options
* Take an input from the user and call the respective method
* End the loop until user enteres **5** to exit
***
***
# User class:
#### Goal: 
1. Like a normal user of the bank, this class will have all the general methods to give the user information about the account.
2. A menu will be displayed to the user and input will be taken to perform specific task, for example, if the user wants to check the checking balance, it will be displayed on the console after taking proper input from the user
3. This class will have two objects of the Savings and Checking class
#### Input: 
-- User input is required as per the choices
#### Output:
-- Output will be shown as per the choices
#### Methods:
##### 1.menu():void
* Display the menu of 7 different options
* Take an input from the user and call the respective method
* End the loop until user enteres **7** to exit
##### 2.setInterest(float rate):void
* It will apply the interest to the Savings account
***
***
# Account Class: abstract void 
#### Goal: 
1. This class will be an abstract class.
2. Savings and Checking classes will inherit this class and overwrite the methods of it.
3. It will have 3 float properties; totalAmount, checkingBalance, and savingsBalance
#### Input: 
-- None
#### Output:
-- None
#### Methods:
##### 1.getBalance():abstract void
##### 2.deposit():abstract void
##### 3.withdraw():abstarct void
***
***
# Savings Class extends Account class: void 
#### Goal: 
1. This class overwrite the methods of Account class.
2. It will have one more method other than Account class methods which will be **applyInterest()**.
#### Input: 
-- Methods **deposit()** and **withdraw()** have user input of float value.
#### Output:
-- None
#### Methods:
##### 1.getBalance():void
* return the balance of the savings account
##### 2.deposit():void
* deposits into the savings account by taking user input
##### 3.withdraw():void
* withdraws money from the savings account. If the user input is greater than the savings balance, withdraws from the checking account. If the user input is greater than the totalBalance of the account, prints *You are currently broke!*
##### 4.applyInterest(float rate):void
* Takes the interest rate and applies it to the savings balance and sets the savingsBalance.
***
***
# Checking Class extends Account class: void 
#### Goal: 
1. This class overwrite the methods of Account class.
#### Input: 
-- Methods **deposit()** and **withdraw()** have user input of float value.
#### Output:
-- None
#### Methods:
##### 1.getBalance():void
* return the balance of the checking account
##### 2.deposit():void
* deposits into the checking account by taking user input
##### 3.withdraw():void
* withdraws money from the checking account. If the user input is greater than the totalBalance of the account, prints *You are currently broke!*
***
