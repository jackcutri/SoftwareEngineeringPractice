package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance());

        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(200));
        assertThrows(IllegalArgumentException.class, ()->bankAccount.withdraw(-100));
        assertThrows(IllegalArgumentException.class, ()->bankAccount.withdraw(0));
        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(200.555));
    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertFalse(BankAccount.isEmailValid(""));
        assertTrue(BankAccount.isEmailValid("a.b@b.com"));
        assertFalse(BankAccount.isEmailValid("a.bb.com"));
        assertFalse(BankAccount.isEmailValid("@b.com"));
        assertFalse(BankAccount.isEmailValid("a.b@"));
        assertFalse(BankAccount.isEmailValid(".@b.com"));
        assertFalse(BankAccount.isEmailValid("a.b@b.c"));
        assertFalse(BankAccount.isEmailValid("@"));
        assertFalse(BankAccount.isEmailValid(" "));

    }

    @Test
    void isAmountValidTest(){
        assertTrue(BankAccount.isAmountValid(50));
        assertFalse(BankAccount.isAmountValid(50.333));
        assertFalse(BankAccount.isAmountValid(0));
        assertFalse(BankAccount.isAmountValid(-10.3));
        assertFalse(BankAccount.isAmountValid(-10.333));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", 100.555));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", -2));
    }

}