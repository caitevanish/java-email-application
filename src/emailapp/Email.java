package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;	//setting default mail capacity to 500
	private int defaultPasswordLength =10;
	private String alternateEmail;
	private String companySuffix = "anycompany.com";

	//Constructor to receive the first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
	
		//Call a method asking for the department - return the department
		this.department = setDepartment();
		System.out.println("Department: " + this.department);
	
		//Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("\nYour password is: " + this.password);
	
		//Combine elements to generate an email
		email =firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department +"." + companySuffix;
		System.out.println("Your email is: " + email);
	
		
	}
	
	//Ask for the department
	private String setDepartment() {
		System.out.println("\nDEPARTMENT CODES: \n[1] for Sales \n[2] for Development \n[3] for Accounting \n[0] for none\n\nEnter department code:" );
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) {return "sales";}
		else if (depChoice == 2) {return "dev";}
		else if (depChoice == 3) {return "acct";}
		else {return "";}
	}
	
	//generate a random password
	private String randomPassword(int length) {
		
		//generate pass within scope of string
		String passwordSetString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*";
		char[] password = new char[length];
		
		//take the char at the random number and pass into password array one at a time
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random() *passwordSetString.length());
			password[i] = passwordSetString.charAt(rand);
		}
		return new String(password);
	}
	
	//set the mailbox capacity;	this is encapsulation!
	public void setMailboxCapacity (int capacity) {
		this.mailboxCapacity = capacity; 
	}
	
	//set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	//getters
		//public methods that are going to access the properties by the get methods - also encapsulation
	public int getMailboxCapacity(){return mailboxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
}
