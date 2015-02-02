/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ravi Sharma
 * This class creates the customer object that contains their name their cashcard, bank accounts, and a transaction log.
 */
public class Customer {
    private String customerName;
    private CashCard customerCashCard;
    private BankAccount customerCheckingsAccount;
    private BankAccount customersSavingsAccount;
    private TransactionLog customerLog;
/*
    The constructor assigns the values to the instance variables of their name, card, and bank accounts
    */
 public Customer(String name, CashCard cashcard){
           customerName=name;
           customerCashCard=cashcard;
           customerCheckingsAccount=null;
           customersSavingsAccount=null;
            }
 /**
  * Sets the customers name
  * @param name 
  */
public void setName(String name){
    customerName=name;
}
/**
 * Returns the customers name
 * @return customerName the name of customer
 */
public String getName(){
    return customerName;
}
/**
 * Sets/assigns the cashcard of the customer.
 * @param card 
 */
public void setCustomerCashCard(CashCard card){
    customerCashCard=card;
}
/**
 * Returns the cash card that belongs to customer
 * @return customerCashCard the card
 */
public CashCard getCustomerCashCard(){
    return customerCashCard;
}
/**
 * Sets the checkings account of the customer
 * @param setCheckings the checkings account 
 */
public void setCheckingsAccount(BankAccount setCheckings){
    customerCheckingsAccount=setCheckings;
}
/**
 * Sets the savings account of the customer
 * @param setSavings the savings account
 */
public void setSavingsAccount(BankAccount setSavings){
    customersSavingsAccount=setSavings;
}
/**
 * Returns their checkings account if they dont have a checkings it returns null
 * @return customerCheckingsAccount
 */
public BankAccount getCheckings(){
    if(customerCheckingsAccount==null){
        return null;
    }
    else{
        return customerCheckingsAccount;
    }
}
/**
 * Returns the savings account if they dont have one then null is returned
 * @return customerSavingsAccount
 */
public BankAccount getSavings(){
     if(customersSavingsAccount==null){
        return null;
    }
    else{
        return customersSavingsAccount;
    }
}

/**
 * Sets the customers transaction history or log
 * @param setLog the transaction log
 */
public void setTransactionLog(TransactionLog setLog){
    customerLog=setLog;
}
/**
 * returns the customers log
 * @return customerLog
 */
    public TransactionLog getTransactionLog(){
        return customerLog;
}
    /**
     * Prints out all the customers information
     * @return the info of the customer in string
     */
public String toString(){
    if(customerCheckingsAccount!=null&&customersSavingsAccount==null){
    return "Customer: "+customerName+", Customer Cash Card Info: "+customerCashCard+" Customer Checkings Account Info: "+customerCheckingsAccount.toString();
}
      if(customerCheckingsAccount==null&&customersSavingsAccount!=null){
    return "Customer: "+customerName+", Customer Cash Card Info: "+customerCashCard+" Customer Savings Account Info: "+customersSavingsAccount.toString();
}
      else{    return "Customer: "+customerName+", Customer Cash Card Info: "+customerCashCard+" Customer Checkings Account Info: "+customerCheckingsAccount.toString()+" Customers Savings Account Info "+customersSavingsAccount.toString();
}
}
}
