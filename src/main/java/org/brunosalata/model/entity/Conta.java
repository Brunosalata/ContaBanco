package org.brunosalata.model.entity;

/**
 * @author Bruno Salata Lima - 16/05/2023
 * github.com/Brunosalata
 * @version 2.0.3
 * @project mBioLabv3
 */
public class Conta {

    private int agency;
    private int number;
    private String holder;
    private double balance;
    private double withdrawLimit;

    public Conta(int agency, int number, String holder, double balance, double withdrawLimit) {
        this.agency = agency;
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public int getAgency() {
        return agency;
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        validateWithdraw(amount);
        balance -= amount;

    }

    private void validateWithdraw(double amount) throws Exception {
        if (amount>getWithdrawLimit()) {
            throw new Exception("Withdraw error: The amount overrises the withdraw limit");
        }
        if (amount > getBalance()) {
            throw new Exception("Withdraw error: Insuficient balance");
        }
    }

}
