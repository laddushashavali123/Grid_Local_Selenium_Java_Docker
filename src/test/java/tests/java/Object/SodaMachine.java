package tests.java.Object;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SodaMachine {
    private String machineName;
    private int balance = 0;

    public SodaMachine(String machineName){
        this.machineName = machineName;
    }

    public void showSodaMachineName() {
        System.out.println("This machine name is " + machineName);
    }

    public void insertCoin(int valueInDollar){
        balance += valueInDollar;
        System.out.println("Current balance is " + balance + " $");
    }

    public void buySoda(){
        System.out.println("Current balance is " + balance + ", each soda cost 2 $");
        int tempBalance = balance;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of bottle you want: ");
        try {
            int i = Integer.parseInt(br.readLine());
            if (i < 0) {
                System.err.println("Invalid Number!");
            }
            tempBalance -= i * 2;
            if (tempBalance < 0) {
                System.err.println("You do not have enough balance!");
            } else {
                balance = tempBalance;
                System.out.println("Thanks for your purchase");
                System.out.println("Current balance is " + balance + " $");
            }
        } catch (IOException e) {
            System.err.println("Invalid Format!");
            e.printStackTrace();
        }
    }
}
