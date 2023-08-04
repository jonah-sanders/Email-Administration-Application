package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int inboxCapacity = 500;
    private String alternativeEmail;
    private int defaultPasswordLength = 10;
    private String companySuffix = "randomcompany.com";

    //Constructor for receiving the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //Calls a method that asks for the department and returns it
        this.department = setDepartment();

        //Calls a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is as follows: " + this.password);

        //Combines the components of the email address
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }
    //Asking for department
    private String setDepartment() {
        System.out.print("New worker: " + firstName + " " + lastName + "\n" +
                "DEPARTMENT OPTIONS:\n" +
                "1 for Information Technology\n" +
                "2 for Sales\n" +
                "3 for Human Resources\n" +
                "4 for Development\n" +
                "5 for Accounting\n" +
                "6 for Marketing\n" +
                "0 for None\n" +
                "Indicate your department: ");
        Scanner input = new Scanner(System.in);
        int depNumber = input.nextInt();

        switch (depNumber) {
            case 1: return "it";
            case 2: return "sales";
            case 3: return "hr";
            case 4: return "dev";
            case 5: return "acct";
            case 6: return "marketing";
            default: return "";
        }

    }

    //Generating a random password
    private String randomPassword(int length) {
        String charSelection = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890?_-+*&$#@!";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * charSelection.length());
            password[i] = charSelection.charAt(rand);
        }
        return new String(password);
    }

    //Setting the mailbox capacity
    public void setInboxCapacity(int capacity) {
        this.inboxCapacity = capacity;
    }
    //Setting the alternate email
    public void setAlternativeEmail(String altEmail) {
        this.alternativeEmail = altEmail;
    }

    //Changing the password
    public void changePassword(String password) {
        this.password = password;
    }

    //Getters
    public String getPassword() {
        return password;
    }
    public int getInboxCapacity() {
        return inboxCapacity;
    }
    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    public String showPersonalInfo() {
        return "FULL NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nINBOX CAPACITY: " + inboxCapacity + "mb";
    }
}
