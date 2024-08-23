package org.brunosalata.application;

import org.brunosalata.model.entity.Conta;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Bruno Salata Lima - 16/05/2023
 * github.com/Brunosalata
 * @version 2.0.3
 * @project mBioLabv3
 */
public class ContaTerminal {
    private static DecimalFormat decimal = new DecimalFormat("#.##");
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com os dados da conta:");
        System.out.print("Número da Agência: ");
        int agency = sc.nextInt();
        System.out.print("Número da Conta: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double initialBalance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();
        Conta acc = new Conta(agency, number, holder, initialBalance, withdrawLimit);

        System.out.print("\nEnter amount for deposit: ");
        double dAmount = sc.nextDouble();
        acc.deposit(dAmount);

        System.out.printf("New Balance: %.2f%n", acc.getBalance());

        System.out.print("\nEnter amount for withdraw: ");
        double wAmount = sc.nextDouble();

        try {
            acc.withdraw(wAmount);
            StringBuilder sb = new StringBuilder();
            sb.append("\nOlá, ")
                    .append(holder)
                    .append("! Obrigado por criar uma conta em nosso banco. Sua agência é ")
                    .append(agency)
                    .append(", conta ")
                    .append(number)
                    .append(" e seu saldo R$ ")
                    .append(decimal.format(initialBalance))
                    .append(" já está disponível para saque.")
                    .append("\nSeu saldo final será de R$ ")
                    .append(decimal.format(acc.getBalance()))
                    .append(".");
            System.out.println(sb);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        sc.close();

    }
}