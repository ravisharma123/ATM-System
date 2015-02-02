
import java.util.ArrayList;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ravi Sharma
 * This class initiates all the accounts which were manually created. Five customers were created and cash cards were created and assigned to them
 * Bank Accounts were created and assigned to them as well. And a log was assigned to each customer as well
 */
public class Accounts {
   private ArrayList<Customer> customersOfBankA  = new ArrayList<Customer>();
   private ArrayList<Customer> customersOfBankB = new ArrayList<Customer>();

public Accounts(){
    
}
public void setUpAccounts(){
    Calendar expDateofCardOne = Calendar.getInstance();
    Calendar expDateofCardTwo= Calendar.getInstance();
    Calendar expDateofCardThree= Calendar.getInstance();
    Calendar expDateofCardFour= Calendar.getInstance();
    Calendar expDateofCardFive= Calendar.getInstance();
    BankAccount checkingForCustomerOne = new BankAccount(450.00,1234);
    BankAccount savingsForCustomerOne = new BankAccount(100.34,6789);
    BankAccount savingsForCustomerTwo = new BankAccount(5003.34,6319);
    BankAccount checkingsForCustomerThree = new BankAccount(1893.34,8239);
    BankAccount savingsForCustomerFour = new BankAccount(2389.44,8749);
    BankAccount checkingsForCustomerFive = new BankAccount(350.50,8749);
    expDateofCardOne.set(2015, 6, 13);
    expDateofCardTwo.set(2017, 3, 23);
    expDateofCardThree.set(2013, 8, 22);
    expDateofCardFour.set(2019, 9, 21);
    expDateofCardFive.set(2018, 4, 22);
   CashCard customerOnesCard = new CashCard("A",4917,expDateofCardOne);
   Customer customerOneA = new Customer("Ravi",customerOnesCard);
   customerOneA.setCheckingsAccount(checkingForCustomerOne);
   customerOneA.setSavingsAccount(savingsForCustomerOne);
   CashCard customerTwosCard = new CashCard("B",3696,expDateofCardTwo);
   Customer customerTwoB = new Customer("Rahul",customerTwosCard);
   customerTwoB.setSavingsAccount(savingsForCustomerTwo);
   CashCard customerThreesCard = new CashCard("A",2834,expDateofCardThree);
   Customer customerThreeA= new Customer("Sumit",customerThreesCard);
   customerThreeA.setCheckingsAccount(checkingsForCustomerThree);
   CashCard customerFoursCard = new CashCard("B",9812,expDateofCardFour);
   Customer customerFourB= new Customer("Aakash",customerFoursCard);
   customerFourB.setSavingsAccount(savingsForCustomerFour);
   CashCard customerFivesCard = new CashCard("A",1479,expDateofCardFive);
   Customer customerFiveA= new Customer("John",customerFivesCard);
   customerFiveA.setCheckingsAccount(checkingsForCustomerFive);
   customerOnesCard.setPassword("customerOnesPw");
   customerTwosCard.setPassword("customerTwosPw");
   customerThreesCard.setPassword("customerThreesPw");
   customerFoursCard.setPassword("customerFoursPw");
   customerFivesCard.setPassword("customerFivesPw");
   TransactionLog logOfCustomerOne= new TransactionLog();
   TransactionLog logOfCustomerTwo= new TransactionLog();
   TransactionLog logOfCustomerThree= new TransactionLog();
   TransactionLog logOfCustomerFour= new TransactionLog();
   TransactionLog logOfCustomerFive= new TransactionLog();

   customerOneA.setTransactionLog(logOfCustomerOne);
   customerTwoB.setTransactionLog(logOfCustomerTwo);
   customerThreeA.setTransactionLog(logOfCustomerThree);
   customerFourB.setTransactionLog(logOfCustomerFour);
   customerFiveA.setTransactionLog(logOfCustomerFive);
   customersOfBankA.add(customerOneA);
   customersOfBankA.add(customerThreeA);
   customersOfBankA.add(customerFiveA);
   customersOfBankB.add(customerTwoB);
   customersOfBankB.add(customerFourB);
}
/**
 * Returns the bank a customers
 * @return customersOfBankA
 */
public ArrayList<Customer> getBankACustomers(){
    return customersOfBankA;
}
/**
 * Returns the customers of Bank B 
 * @return customersOfBankB
 */
public ArrayList<Customer> getBankBCustomers(){
    return customersOfBankB;
}

}
