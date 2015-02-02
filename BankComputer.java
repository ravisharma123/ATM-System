
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ravi Sharma
 * This class is used to create a bank object whose instances are two atms and a bank id. It also verifys the password.
 */
public class BankComputer {
private ATM atmOne;
private ATM atmTwo;
private Customer customersRecord;
private String bankID;
/*
The constructor sets the atms and bank id
*/
    public BankComputer(ATM a, ATM b, String setbankID){
        atmOne=a;
        atmTwo=b;
        bankID=setbankID;
    }
    /**
     * 
     * @param bank the bank who the customer belongs to 
     * @param CashCardNumOfCustomer the card number of the user who is using atm and inputing their password
     * @param inputedPassword the password inputed by the user
     * @return passwordCorrect which is boolean that tells if the user typed in password correct or incorrect
     */
    public boolean verifyAccountPassword(Bank bank,int CashCardNumOfCustomer, String inputedPassword){
        ArrayList<Customer> accounts = bank.getCustomerAccounts();
        boolean passwordCorrect=false;
        for(int i =0;i<accounts.size();i++){
            if(accounts.get(i).getCustomerCashCard().getCardNum()==CashCardNumOfCustomer&&accounts.get(i).getCustomerCashCard().getPassword().equals(inputedPassword)){
                   passwordCorrect=true;
            }
        }
            return passwordCorrect;
        }
    /**
     * 
     * @param bank the bank that the user belongs to 
     * @param cardNumberToLookUp the card number that is to be looked up
     * @return customerRecord the record of the customer in the bank
     */
    public Customer getCustomerRecord(Bank bank,int cardNumberToLookUp){
      ArrayList<Customer> accounts = bank.getCustomerAccounts();
       for(int i=0;i<accounts.size();i++){
           if(accounts.get(i).getCustomerCashCard().getCardNum()==cardNumberToLookUp){
               customersRecord=accounts.get(i);
           }
       }
       return customersRecord;
    }
/**
 * Returns the state of the bank computer that says to which bank the bank computer belongs to 
 * @return 
 */
  public String toString(){
      return "Bank Computer of "+bankID;
  }
         
}
