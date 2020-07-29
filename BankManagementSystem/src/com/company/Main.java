package com.company;


import java.util.Scanner;

public class Main {
    static Account account = new Account();
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
	// write your code here
        int choice;
        do{
            System.out.println("*********************************");
            System.out.println("*  Choose your Option:(1-to-6)  *");
            System.out.println("*    1.Create an account        *");
            System.out.println("*    2.Deposit money to account *");
            System.out.println("*    3.Withdraw from Account    *");
            System.out.println("*    4.Check account Balance    *");
            System.out.println("*    5.See account information  *");
            System.out.println("*    6.To exit                  *");
            System.out.println("*********************************");
            choice = scan.nextInt();
            switch (choice) {
                case 1://create account
                    account.createAccount();
                    break;
                case 2://deposit
                    account.deposti();
                    break;
                case 3://withdraw
                    account.withdraw();
                    break;
                case 4://check account balance
                    account.showBalance();
                    break;
                case 5://See acount information
                    account.showUserInformation();
                    break;
                default:
                    System.out.println("Please select valid information");
                    break;
            }
        }while (choice!=6);{
            System.out.println("Closed");
        }




    }


    public static class Account {
           static Scanner scan = new Scanner(System.in);
        private static String ownerName;
        private static int accountBalance;
        private static String accountType;
        private static String password ;

        public Account(String accountName, int accountBalance, String accountType, String password) {
            this.ownerName = accountName;
            this.accountBalance = accountBalance;
            this.accountType = accountType;
            this.password = password;
        }

        public Account() {

        }
        public String getPassword() {
            return password;
        }

        public String getAccountName() {
            return ownerName;
        }

        public static int getAccountBalance() {
            return accountBalance;
        }

        public String getAccountType() {
            return accountType;
        }


        public static void setAccountName(String accountName) {
            Account.ownerName = accountName;
        }

        public static   void setAccountBalance(int accountBalance) {
            Account.accountBalance = accountBalance;
        }

        public static   void setAccountType(String accountType) {
            Account.accountType = accountType;
        }

        public void setPassword(String password) {
            String regex = "^(?=.*[0-9])"
                    + "(?=.*[a-z])(?=.*[A-Z])"
                    + "(?=.*[@#$%^&+=])"
                    + "(?=\\S+$).{8,20}$";
            if(!password.matches(regex)){
                do{
                    System.out.println("Please Enter valid Password");
                    password = scan.next();
                }while (!password.matches(regex));{
                    System.out.println("Password Set");
                    this.password = password;
                }
            }else {
                this.password = password;
            }
        }

        /*creating account*/
        public  void createAccount(){
            String name, pass; int balance,type;
            System.out.println("Enter owner name");
            name=scan.nextLine();
            setAccountName(name);
            System.out.println("Enter opening balance");
            balance=scan.nextInt();
            setAccountBalance(balance);
            System.out.println("Enter \n1 : Current Account \n2 : Saving Account ");
            type=scan.nextInt();
            if(type ==1 ){
                setAccountType("Saving Account");
            }if(type ==2 ){
                setAccountType("Current Account");
            }
            System.out.println("Enter password");
            pass = scan.next();
            setPassword(pass);
        }

        /*depositing money in to account after creating*/
        public static void deposti(){
            int depo;
            System.out.println("Enter amount to deposit");
            depo = scan.nextInt();
            setAccountBalance((depo + accountBalance));
            System.out.println("Added Successfully");
        }


        public static void withdraw() {

            int with; String testPass;
            System.out.println("Please Enter your Account Password");
            testPass = scan.nextLine();
            if(testPass.matches(password)){
                System.out.println("Enter amount to withdraw");
                with = scan.nextInt();
                setAccountBalance((accountBalance-with));
                System.out.println("Withdraw Successful");
            }else {
                do{
                    System.out.println("Please Enter Correct Password");
                    testPass = scan.nextLine();
                }while (!testPass.matches(password));{
                    System.out.println("Enter amount to withdraw");
                    with = scan.nextInt();
                    setAccountBalance((accountBalance-with));
                    System.out.println("Withdraw Successful");
                }
            }
        }

        public static void showBalance(){
            String testPass;
            System.out.println("Please Enter your Account Password");
            testPass = scan.nextLine();
            if(testPass.matches(password)){
                System.out.println("Your Account Balance is :"+getAccountBalance());
            }else {
                do{
                    System.out.println("Please Enter Correct Password");
                    testPass = scan.nextLine();
                }while (!testPass.matches(password));{
                    System.out.println("Your Account Balance is :"+getAccountBalance());
                }
            }
        }

        void showUserInformation(){
            String testPass;
            System.out.println("Please Enter your Account Password");
            testPass =scan.next();
            if(testPass.matches(password)){
                System.out.println("Your name is :"+getAccountName());
                System.out.println("You have a  :"+getAccountType());
                System.out.println("Your Account Balance is :"+ getAccountBalance());
            }else {
                do{
                    System.out.println("Please Enter Correct Password");
                    testPass = scan.nextLine();
                }while (!testPass.matches(password));{
                    System.out.println("Your name is :"+getAccountName());
                    System.out.println("You have a  :"+getAccountType());
                    System.out.println("Your Account Balance is :"+ getAccountBalance());
                }
            }
        }
    }
}


