
import java.util.Calendar;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ravi Sharma
 * This class is the atm class which is responsible for withdrawing and interacting with the customer and bank computer.
 */
public class ATM {
  private CashCard inputedCard;
  private String bankID;
  private String whichAtm;
  private double maxAmountPerDay;
  private double maxAmountPerTransaction;
  private double minAmountForTransaction;
  private double totalInitialFunds;
  private boolean atmEmpty;
  private boolean withdrawalSuccessful;
  /**
   * 
   * @param setbankID
   * @param setATMName
   * @param setmaxAmountperTrans
   * @param setMaxAmountPerDay
   * @param setMinAmountPerTans
   * @param setInitialFunds 
   */
public ATM(String setbankID,String setATMName,double setmaxAmountperTrans,double setMaxAmountPerDay,double setMinAmountPerTans,double setInitialFunds){
    inputedCard=null;
    bankID=setbankID;
    whichAtm=setATMName;
    maxAmountPerTransaction=setmaxAmountperTrans;
    maxAmountPerDay=setMaxAmountPerDay;
    minAmountForTransaction=setMinAmountPerTans;
    totalInitialFunds=setInitialFunds;
    withdrawalSuccessful=false;
    atmEmpty=false;
   
}
/**
 * checks if card is expired
 * @param card
 * @return if card is expired or not
 */
public boolean checkIfExp(CashCard card){
    boolean isExpired;
    Calendar checkIfExpVar = Calendar.getInstance();
    isExpired=card.getExpirationDate().before(checkIfExpVar);
    if(isExpired==true){
        return true;
    }
    else{
        return false;
    }
}
public void insertCashCard(CashCard insertedCashCard){
    inputedCard=insertedCashCard;
}
/**
 * checks if correct card was inserted
 * @return true or false
 */
public boolean checkIfCorrectCard(){
    if(inputedCard.getBankID().equals(bankID)){
        return true;
}
    else {
        return false;
    }
}
/**
 * Responsible for withdrawing from the bank account and dispensing money
 * @param accountToWithdrawFrom 
 * @param amountToWithdraw 
 */
 public void withdraw(BankAccount accountToWithdrawFrom,double amountToWithdraw){
     if(amountToWithdraw<=accountToWithdrawFrom.getBalance()&&amountToWithdraw<maxAmountPerTransaction&&amountToWithdraw<totalInitialFunds&&amountToWithdraw>minAmountForTransaction&&amountToWithdraw<maxAmountPerDay){
accountToWithdrawFrom.setBalance(accountToWithdrawFrom.getBalance()-amountToWithdraw);
totalInitialFunds=totalInitialFunds-amountToWithdraw;
withdrawalSuccessful=true;
System.out.println("Transaction Complete: Please take your cash of amount "+amountToWithdraw+" your remaining balance is "+accountToWithdrawFrom.getBalance());
 }
     else if(amountToWithdraw>accountToWithdrawFrom.getBalance()){
         System.out.println("The amount you entered is greater than the amount of funds you have in your bank account please enter lower amount");
         withdrawalSuccessful=false;
     }
     else if(amountToWithdraw>maxAmountPerDay){
         System.out.println("Your amount entered is higher than the max amount of withdrawl per day");  
                  withdrawalSuccessful=false;

     }
     else if(amountToWithdraw>=maxAmountPerTransaction){
         System.out.println("Your amount entered is higher than the max amount of withdrawl per transaction for this atm");  
                  withdrawalSuccessful=false;

     }
     else if(amountToWithdraw<minAmountForTransaction){
         System.out.println("Your amount entered is lower than the minimum amount of withdrawl for this atm");
                  withdrawalSuccessful=false;

     }
     else if(amountToWithdraw>totalInitialFunds){
                  System.out.println("There is no more money in this atm to be dispensed");
                  withdrawalSuccessful=false;
                  atmEmpty=true;

     }
     
 }
 /**
  * Returns if the withdrawal was successful
  * @return 
  */
 public boolean withdrawlComplete(){
     return withdrawalSuccessful;
 }
 public String toString(){
     return ("Bank ID: "+bankID+" "+whichAtm+" Max Amount Per Transaction: "+maxAmountPerTransaction+"Min amount per Transaction: "+minAmountForTransaction+" Max Amount Per Day: "+maxAmountPerDay+" Total Initial Funds"+totalInitialFunds);
 }
 public boolean isAtmEmpty(){
     return atmEmpty;
 }
}
