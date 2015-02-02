import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ravi Sharma
 * This Bank Class is responsible to create a bank object that holds all the customers accounts and a bank computer
 */
public class Bank {
private BankComputer bankComputer;
private ArrayList<Customer> customerAccounts = new ArrayList<Customer>();
/*
The constructor sets/assigns a bank computer to the bank
*/
public Bank(BankComputer setBC){
 bankComputer = setBC;
}
/**
 * This method sets the customers of the bank
 * @param setCustomerAccounts the customers of the bank 
 * precondition: the bank has no customers, post condition: the bank will consist of customers
 */
    public void setCustomerAccounts(ArrayList<Customer> setCustomerAccounts){
    customerAccounts=setCustomerAccounts;
}
    /**
     * This method return an array list of the customers that belong to the bank
     * @return the customer accounts are returned 
     */
    public ArrayList<Customer> getCustomerAccounts(){
    return customerAccounts;
}
    /**
     * This method prints the records of the customer that belong to the bank.
     */
    public void printBankRecordsInfo(){
        for(int i=0;i<customerAccounts.size();i++){
                            System.out.println(customerAccounts.get(i).toString());
            }
        }
    

}

