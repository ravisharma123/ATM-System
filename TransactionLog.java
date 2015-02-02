
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ravi Sharma
 * This class is responsible for logging the history of the transaction using an array list of all the transactions
 */
public class TransactionLog {
private ArrayList<String> log = new ArrayList<String>();
public TransactionLog(){
    
}
/**
 * This method logs the customers card when they get their card validated
 * @param customer 
 */
        public void addCardValidatedLog(Customer customer){
            log.add("The card # "+customer.getCustomerCashCard().getCardNum()+" was inputed into an atm and was validated");
}
        /**
         * This method logs the withdrawal transaction when it is successful
         * @param amount amount to withdraw
         * @param account account from which it was withdrawn
         * @param customer the customer who did the withdrawing
         */
        public void addWithdrawlTransactionLog(double amount,String account,Customer customer){
            log.add("The amount of "+amount+" was withdrawn from the "+account+" with cash card number "+customer.getCustomerCashCard().getCardNum());
}
        /**
         * Returns the arraylist that consists of all events in the log history
         * @return log the log containing all events of atm use
         */
        public ArrayList<String> getTransactions(){
            return log;
        }
        /**
         * This method prints the log
         */
        public void printTransactions(){
            for(int i=0;i<log.size();i++){
                System.out.println(log.get(i));
            }
        }
}
