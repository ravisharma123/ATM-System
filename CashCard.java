
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
 * Creates the CashCard that contains a bank id card number expiration date and password
 */
public class CashCard {
    private String bankID;
    private int cardNum;
    private Calendar expDate;
    private String password;
    /**
     * Sets all of the cash card info
     * @param setBankID, the bank id
     * @param setCardNum the card number
     * @param setExpDate expiration date of card
     */
public CashCard(String setBankID,int setCardNum, Calendar setExpDate){
    bankID=setBankID;
    cardNum=setCardNum;
    expDate=setExpDate;
}
/**
 * Sets the bank id
 * @param bankIDLetter 
 */
public void setBankID(String bankIDLetter){
    bankID=bankIDLetter;
}
/**
 * Gets the Bank Id
 * @return 
 */
public String getBankID(){
   return bankID;
}
public void setCardNum(int setCardNumber){
cardNum=setCardNumber;
}
public int getCardNum(){
   return cardNum;
}
public void setPassword(String setpw){
    password=setpw;
}
public String getPassword(){
    return password;
}
public void setExpDate(Calendar setExpirationDate){
    expDate=setExpirationDate;
}
public Calendar getExpirationDate(){
   return expDate;
}
public String toString(){
    return "Bank ID "+bankID+"Card #: "+cardNum+" Exp Date: "+expDate.get(expDate.DATE)+"/"+expDate.get(1)+"/"+expDate.get(2)+" Password: "+password;
}

}
