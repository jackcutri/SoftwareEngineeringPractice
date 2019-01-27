package edu.ithaca.dragon.bank;

import java.math.BigDecimal;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email) && isAmountValid(startingBalance)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address or balance is incorrect");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance.
     * Will throw IllegalArgumentException otherwise.
     */
    public void withdraw (double amount)  {
        if(isAmountValid(amount) && amount<balance){
            balance-=amount;
        }else{
            throw new IllegalArgumentException("The amount must be positive, have no more than two decimal points, and be less than the balance.");
        }
    }

    /**
     * @post returns false if the email address is invalid, true if it is valid.
     * For an address to be valid, it must have a valid prefix (at least one letter, number,
     * underscore, period, or dash.  Underscores, periods, and dashes must be followed by at
     * least one number of letter) followed by an @, and then a valid domain (at least one
     * letter, number or dash followed by a . and at least two letters).
     */

    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1 || email.indexOf('@') == 0 || email.indexOf('@') == email.length()-1 ||
                email.equals('@') ||email == null || email.contains(".@") || email.lastIndexOf('.') == email.length()-1 ||
        email.lastIndexOf('.') == email.length()-2){
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * @post returns true if double given is positive and has less than three decimal points.
     * Returns false otherwise.
     */

    public static boolean isAmountValid(double amount){
        BigDecimal a = new BigDecimal(amount);
        if(amount>0 && a.scale() <3){
            return true;
        }else{
            return false;
        }
    }
}
