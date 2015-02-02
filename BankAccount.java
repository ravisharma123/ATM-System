/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ravi Sharma
 * This class is responsible for creating a bank account it could be a checkings or savings. The bank account contains a balance and a bank account number
 */
public class BankAccount {
private double balance; 
private double bankAccountNum;
   /**
    * The constructor sets the balance of the bank account and the bank account #
    * @param setbalance
    * @param setBankAccountNum 
    */
    public BankAccount(double setbalance,int setBankAccountNum){
        balance=setbalance;
        bankAccountNum=setBankAccountNum;
    }
    /**
     * Gets the balance of the account
     * @return balance 
     */
    public double getBalance(){
        return balance;
    }
    /**
     * Sets the balance of the account
     * @param setBalance the amount to set
     */
    public void setBalance(double setBalance){
        balance=setBalance;
    }
    /**
     * Prints the information of the bank account
     * @return the string format of the bank account
     */
   public String toString(){
       return "Balance: "+balance+" Account #: "+bankAccountNum;
   }
}
