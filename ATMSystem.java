    import java.util.ArrayList;
    import java.util.Calendar;
    import java.util.Date;
    import java.util.Scanner;

    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

    /**
     *
     * @author Ravi Sharma
     */
    /**
     * 
     * The ATMSystem Class is responsible for initializing all of the objects involved in the ATM System and this class is the
     * main class which interacts with the user so they can input their cash card into the atm and withdraw money from the account that they have.
     */
    public class ATMSystem {
        /*
        These variables are used to initialize the two different banks and each banks components such as bank computers and atms.
        
        */
       private static ArrayList<Customer> bankACustomers = new ArrayList<Customer>();
        private static ArrayList<Customer> bankBCustomers= new ArrayList<Customer>();
        private static BankComputer bankCompA;
        private static BankComputer bankCompB;
        private static ATM atmA1 = new ATM("A","ATM_A1",500.0,700.0,10.0,1500.0);
        private static ATM atmA2 = new ATM("A","ATM_A2",250.0,500.0,15.0,5000.0);
        private static ATM atmB1 = new ATM("B","ATM_B1",175.0,400.0,5.0,450.0);
        private static ATM atmB2 = new ATM("B","ATM_B2",200.0,450.0,20.0,2750.0);
        private static Customer currentUser;
        private static int inputedCardNumber;
        private static String ATMChoice;
        private static boolean continueWithdraw =true;
        private static boolean repeatForAtmA= true;
            private static boolean repeatForAtmB= true;
        private static CashCard insertedCashCard=null;
        private static boolean proceedToVerification = false;
        private static Scanner inputReader = new Scanner(System.in);
    public static void main (String[]args){
       bankCompA= new BankComputer(atmA1,atmA2,"Bank A");
       bankCompB = new BankComputer(atmB1,atmB2,"Bank B");
       Bank bankA =new Bank(bankCompA);
       Bank bankB= new Bank(bankCompB);
       Accounts getAccounts = new Accounts();
       getAccounts.setUpAccounts();
       bankACustomers=getAccounts.getBankACustomers();
       bankA.setCustomerAccounts(bankACustomers);
       bankBCustomers=getAccounts.getBankBCustomers();
       bankB.setCustomerAccounts(bankBCustomers);
       boolean proceedToTransactionforATMA=false;
       boolean proceedToTransactionforATMB=false;
       //print initial state of each bank with their customers, each bank computer, and each atm.
       bankA.printBankRecordsInfo();
       bankB.printBankRecordsInfo();
       System.out.println(bankCompA.toString());
        System.out.println(bankCompB.toString());
       System.out.println(atmA1.toString());   
       System.out.println(atmA2.toString());   
       System.out.println(atmB1.toString());   
       System.out.println(atmB2.toString());   
       /*
       Program begins by asking user for which atm they want to use and gives them a list of option to choose
       from. Then after user inputs which atm they want to use they enter their card number and the atm then checks the validty of card.
       If card is expired it is returned. If card is valid then user inputs their password and if they get it wrong three times card is kept by bank.
       Once password is verified then the user enters the amount to withdraw and atm handles the cases where withdrawal amount is invalid.
       If withdrawal is successful then it is logged to the card number and at the end the log is printed.
       */
       System.out.println("Enter your choice of ATM (Choices are 'atma1', 'atma2', 'atmb1', and 'atmb2') :\n");
       ATMChoice = inputReader.next();
       checkValidity();
       while(repeatForAtmA==true){
           if(ATMChoice.contains("atma")&&insertedCashCard.getBankID()=="A"){
               if(ATMChoice.equalsIgnoreCase("atma1")){
                 if(atmA1.checkIfExp(insertedCashCard)==true){
                     System.out.println("Your card is expired please renew it. Please Enter a new Card.");
                     proceedToVerification=false;
                     checkValidity();
                 }
                 else{
                     proceedToTransactionforATMA=true;
                     currentUser=bankCompA.getCustomerRecord(bankA,inputedCardNumber);
                     currentUser.getTransactionLog().addCardValidatedLog(currentUser); 
                     repeatForAtmA=false;
                 }
               }
               else if(ATMChoice.equalsIgnoreCase("atma2")){
                  if(atmA2.checkIfExp(insertedCashCard)==true){
                      System.out.println("Your card is expired please renew it");
                      proceedToVerification=false;
                      checkValidity();
                  }
                  else{
                      proceedToTransactionforATMA=true;
                       currentUser=bankCompA.getCustomerRecord(bankA,inputedCardNumber);
                     currentUser.getTransactionLog().addCardValidatedLog(currentUser);   
                     repeatForAtmA=false;
                  }
               }
                 if(proceedToTransactionforATMA==true){
                     System.out.println("Enter your password");
                     String usersInputedPW = inputReader.next();
                     if(bankCompA.verifyAccountPassword(bankA, inputedCardNumber, usersInputedPW)==true){
                        if(ATMChoice.equals("atma1")){
                          performWithdraw(atmA1,"atma1","atma2");

                        }
                        else{
                            performWithdraw(atmA2, "atma1", "atma2");
                        }

                     }
                     else{
                         int numberOfAttempts=1;
                         boolean verified=bankCompA.verifyAccountPassword(bankA, inputedCardNumber, usersInputedPW);
                         while(verified==false&&numberOfAttempts<3){
                             System.out.println("Please enter correct password");
                             usersInputedPW=inputReader.next();
                             verified=bankCompA.verifyAccountPassword(bankA, inputedCardNumber, usersInputedPW);
                             if(verified==false){
                             numberOfAttempts++;
                             }
                             else{
                                 if(ATMChoice.equals("atma1")){
                          performWithdraw(atmA1,"atma1","atma2");

                        }
                        else{
                            performWithdraw(atmA2, "atma1", "atma2");
                        }

                             }
                         }
                         if(numberOfAttempts>=3){
                         System.out.println("Please contact bank for your card too many attempts to enter password (CARD IS KEPT). Please a new enter card number.");
                         proceedToVerification=false;
                         checkValidity();
                         repeatForAtmA=true;

                         }
                     }
                 }
                 }
           if(ATMChoice.contains("atmb")){
               repeatForAtmA=false;
           }
       }
       while(repeatForAtmB==true){
           if(ATMChoice.contains("atmb")&&insertedCashCard.getBankID()=="B"){
                  if(ATMChoice.equalsIgnoreCase("atmb1")){
                     if(atmB1.checkIfExp(insertedCashCard)==true){
                     System.out.println("Your card is expired please renew it. Please Enter a new Card");
                     proceedToVerification=false;
                     checkValidity();
                 }
                 else{
                     proceedToTransactionforATMB=true;
                     currentUser=bankCompB.getCustomerRecord(bankB,inputedCardNumber);
                     currentUser.getTransactionLog().addCardValidatedLog(currentUser); 
                     repeatForAtmB=false;
                 }
                  }
               else if(ATMChoice.equalsIgnoreCase("atmb2")){
                    if(atmB2.checkIfExp(insertedCashCard)==true){
                      System.out.println("Your card is expired please renew it. Please Enter a new Card");
                     proceedToVerification=false;
                     checkValidity();
                  }
                  else{
                      proceedToTransactionforATMB=true;
                      currentUser=bankCompB.getCustomerRecord(bankB,inputedCardNumber);
                     currentUser.getTransactionLog().addCardValidatedLog(currentUser);
                     repeatForAtmB=false;
                  }
               }
                  if(proceedToTransactionforATMB==true){
                     System.out.println("Enter your password");
                     String usersInputedPW = inputReader.next();
                     if(bankCompB.verifyAccountPassword(bankB, inputedCardNumber, usersInputedPW)==true){
                         if(ATMChoice.equals("atmb1")){
                          performWithdraw(atmB1,"atmb1","atmb2");

                        }
                        else{
                            performWithdraw(atmB2, "atmb1", "atmb2");
                        }

                     }
                     else{
                         int numberOfAttempts=1;
                         boolean verified=bankCompB.verifyAccountPassword(bankB, inputedCardNumber, usersInputedPW);
                         while(verified==false&&numberOfAttempts<3){
                             System.out.println("Please enter correct password");
                             usersInputedPW=inputReader.next();
                             verified=bankCompB.verifyAccountPassword(bankB, inputedCardNumber, usersInputedPW);
                             if(verified==false){
                             numberOfAttempts++;
                             }
                             else{
                                         if(ATMChoice.equals("atmb1")){
                          performWithdraw(atmB1,"atmb1","atmb2");

                        }
                        else{
                            performWithdraw(atmB2, "atmb1", "atmb2");
                        }
                             }
                         }
                         if(numberOfAttempts>=3){
                         System.out.println("Please contact bank for your card too many attempts to enter password. Please enter a new card.");
                         proceedToVerification=false;
                         checkValidity();
                         repeatForAtmB=true;
                         }
                     }
                 }

                  }
           if(ATMChoice.contains("atma")){
               repeatForAtmB=false;
           }
    }




     }
    /**
     * This method is used to perform the withdrawal it makes a call to the withdraw function in the atm class. This is a helper method
     * @param atm the atm to withdraw the money from
     * @param atmOne the choice atma1
     * @param atmTwo the choice of atm2
     * precondition: the atms initial state and customers bank accounts initial state, post condition: amount will be reduced from atm and customers bank account
     */
    public static void performWithdraw(ATM atm, String atmOne, String atmTwo){
        while(continueWithdraw==true){
             System.out.println("Enter the amount you want to withdraw: ");
                        double amountToWithdraw = inputReader.nextDouble();
                        if(currentUser.getCheckings()!=null&&currentUser.getSavings()!=null){
                            System.out.println("Enter 'Checkings' to withdraw from checkings account or 'Savings' to withdraw from savings account");
                            String whichAccount = inputReader.next();
                            if(whichAccount.equalsIgnoreCase("checkings")){
                                if(ATMChoice.equalsIgnoreCase(atmOne)){
                                    atm.withdraw(currentUser.getCheckings(), amountToWithdraw);
                                    if(atm.withdrawlComplete()==true){
                                       System.out.println("Enter -1 to quit or enter 1 to continue.");
                                       currentUser.getTransactionLog().addWithdrawlTransactionLog(amountToWithdraw, "checkings", currentUser);
                                        double input = inputReader.nextDouble();
                                        if(input<0){
                                            currentUser.getTransactionLog().printTransactions();
                                            System.out.println("Thank You for your business");
                                            continueWithdraw=false;
                                        }


                                    }
                                     else if(atm.isAtmEmpty()==true){
                                            continueWithdraw=false;
                                        }
                                }
                                else if(ATMChoice.equalsIgnoreCase(atmTwo)){
                                    atm.withdraw(currentUser.getCheckings(), amountToWithdraw);
                                    if(atm.withdrawlComplete()==true){
                                        System.out.println("Enter -1 to quit or enter 1 to continue.");
                                        currentUser.getTransactionLog().addWithdrawlTransactionLog(amountToWithdraw, "checkings", currentUser);
                                        double input = inputReader.nextDouble();
                                        if(input<0){
                                            currentUser.getTransactionLog().printTransactions();
                                            System.out.println("Thank You for your business");
                                            continueWithdraw=false;
                                        }

                                    }
                                      else if(atm.isAtmEmpty()==true){
                                            continueWithdraw=false;
                                        }
                                }
                            }
                            else if(whichAccount.equalsIgnoreCase("savings")){
                                if(ATMChoice.equalsIgnoreCase(atmOne)){
                                    atm.withdraw(currentUser.getSavings(), amountToWithdraw);
                                    if(atm.withdrawlComplete()==true){
                                         System.out.println("Enter -1 to quit or enter 1 to continue.");
                                        currentUser.getTransactionLog().addWithdrawlTransactionLog(amountToWithdraw, "savings", currentUser);
                                         double input = inputReader.nextDouble();
                                        if(input<0){
                                            currentUser.getTransactionLog().printTransactions();
                                            System.out.println("Thank You for your business");
                                            continueWithdraw=false;
                                        }

                                    }
                                     else if(atm.isAtmEmpty()==true){
                                            continueWithdraw=false;
                                        }
                                }
                                else{
                                    atm.withdraw(currentUser.getSavings(), amountToWithdraw);
                                    if(atm.withdrawlComplete()==true){
                                         System.out.println("Enter -1 to quit or enter 1 to continue.");
                                        currentUser.getTransactionLog().addWithdrawlTransactionLog(amountToWithdraw, "savings", currentUser);
                                     double input = inputReader.nextDouble();
                                        if(input<0){
                                            currentUser.getTransactionLog().printTransactions();
                                            System.out.println("Thank You for your business");
                                            continueWithdraw=false;
                                        }

                                    }
                                     else if(atm.isAtmEmpty()==true){
                                            continueWithdraw=false;
                                        }
                                }
                            }
                        }
                        else if(currentUser.getCheckings()!=null&&currentUser.getSavings()==null){
                            if(ATMChoice.equalsIgnoreCase(atmOne)){
                                atm.withdraw(currentUser.getCheckings(), amountToWithdraw);
                                if(atm.withdrawlComplete()==true){
                                        System.out.println("Enter -1 to quit or enter 1 to continue.");
                                        currentUser.getTransactionLog().addWithdrawlTransactionLog(amountToWithdraw, "checkings", currentUser);
                                        double input = inputReader.nextDouble();
                                        if(input<0){
                                            currentUser.getTransactionLog().printTransactions();
                                            System.out.println("Thank You for your business");
                                            continueWithdraw=false;
                                        }

                                }
                                else if(atm.isAtmEmpty()==true){
                                            continueWithdraw=false;
                                        }
                            }
                            else{
                                    atm.withdraw(currentUser.getCheckings(), amountToWithdraw);
                                    if(atm.withdrawlComplete()==true){
                                          System.out.println("Enter -1 to quit or enter 1 to continue.");
                                        currentUser.getTransactionLog().addWithdrawlTransactionLog(amountToWithdraw, "checkings", currentUser);
                                         double input = inputReader.nextDouble();
                                        if(input<0){
                                            currentUser.getTransactionLog().printTransactions();
                                            System.out.println("Thank You for your business");
                                            continueWithdraw=false;
                                        }

                                    }
                                     else if(atm.isAtmEmpty()==true){
                                            continueWithdraw=false;
                                        }
                                }

                        }
                         else if(currentUser.getCheckings()==null&&currentUser.getSavings()!=null){
                            if(ATMChoice.equalsIgnoreCase(atmOne)){
                                atm.withdraw(currentUser.getSavings(), amountToWithdraw);
                                if(atm.withdrawlComplete()==true){
                                         System.out.println("Enter -1 to quit or enter 1 to continue.");
                                        currentUser.getTransactionLog().addWithdrawlTransactionLog(amountToWithdraw, "savings", currentUser);
                                        double input = inputReader.nextDouble();
                                        if(input<0){
                                            currentUser.getTransactionLog().printTransactions();
                                            System.out.println("Thank You for your business");
                                            continueWithdraw=false;
                                        }

                                    }
                                 else if(atm.isAtmEmpty()==true){
                                            continueWithdraw=false;
                                        }
                            }
                            else{
                                    atm.withdraw(currentUser.getSavings(), amountToWithdraw);
                                    if(atm.withdrawlComplete()==true){
                                        System.out.println("Enter -1 to quit or enter 1 to continue.");
                                        currentUser.getTransactionLog().addWithdrawlTransactionLog(amountToWithdraw, "savings", currentUser);
                                           double input = inputReader.nextDouble();
                                        if(input<0){
                                            currentUser.getTransactionLog().printTransactions();
                                            System.out.println("Thank You for your business");
                                            continueWithdraw=false;
                                        }

                                    }
                                     else if(atm.isAtmEmpty()==true){
                                            continueWithdraw=false;
                                        }
                                }

                        }
        }
    }
    /**
     * This method is used to check the validity of the card number that the user inputs. It checks if the inputed card belongs to bank a or bank b or neither
     */
    public static void checkValidity(){
            System.out.println("Enter your Card Number");
        inputedCardNumber = inputReader.nextInt();
       while(proceedToVerification==false){
       for(int i=0;i<bankACustomers.size();i++){
           if(bankACustomers.get(i).getCustomerCashCard().getCardNum()==inputedCardNumber){
               insertedCashCard=bankACustomers.get(i).getCustomerCashCard();
           }
       }
       for(int i=0;i<bankBCustomers.size();i++){
           if(bankBCustomers.get(i).getCustomerCashCard().getCardNum()==inputedCardNumber){
               insertedCashCard=bankBCustomers.get(i).getCustomerCashCard();
           }
       }
       if(insertedCashCard==null){
           System.out.println("Card does not exist. Please enter a valid card number");
           inputedCardNumber=inputReader.nextInt();
       }
       else if(ATMChoice.contains("atma")&&insertedCashCard.getBankID()=="B"){
            System.out.println("Card does not belong to this bank. Please enter a valid card number");
           inputedCardNumber=inputReader.nextInt();
       }
       else if(ATMChoice.contains("atmb")&&insertedCashCard.getBankID()=="A"){
            System.out.println("Card does not belong to this bank. Please enter a valid card number");
           inputedCardNumber=inputReader.nextInt();
       }
       else{
           proceedToVerification=true;
       }
       }

    }
    }

