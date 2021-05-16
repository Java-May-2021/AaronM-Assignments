import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays;

public class BankAccount{
    protected String accountNo;
    private double checking;
    private double savings;
    public static int accounts =0;

    private static String createAccountNo() {
        String chars = "1234567890";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++){
            int index = rnd.nextInt(chars.length());
            char randomChar = chars.charAt(index);
            sb.append(randomChar);
        }
        String accountNo = sb.toString();
        return accountNo;
    }

    public void createBankAccount(){
        this.accountNo = BankAccount.createAccountNo();
        this.checking = 0.00;
        this.savings = 0.00;
        accounts++;
        System.out.println (accountNo);
    }

    public void makeDeposit(double amount, String account) {
        if(account.equals("checking")){
            this.checking += amount;
            System.out.println("$"+ amount +" deposited into checking account.");
            System.out.println("Current balance in checking account: $" + checking);
        }else if(account.equals("savings")){
            this.savings += amount;
            System.out.println("$"+ amount +" deposited into savings account.");
            System.out.println("Current balance in savings account: $" + savings);
        }
    }

    public void makeWithdrawal(double amount, String account) {
        if(account.equals("checking")){
            if (this.checking < amount){
                System.out.println("Insufficent Funds");
            }
            else{
            this.checking -= amount;
            System.out.println("$"+ amount +" withdrawn from checking account.");
            System.out.printf("Current balance in checking account: $%.2f\n", checking);
            }
        }else if(account.equals("savings")){
            if (this.savings < amount){
                System.out.println("Insufficent Funds");
            }
            else{
            this.savings -= amount;
            System.out.println("$"+ amount +" withdrawn from savings account.");
            System.out.printf("Current balance in savings account: $%.2f\n", savings);
            }
        }
    }
    public void totalBalance(){
        double total = this.savings+this.checking;
        System.out.printf("Total Balance is: $%.2f", total);
    }
    
    public void checkBalance(){
        System.out.println("Account: " + accountNo);
        System.out.printf("Checking: $%.2f\n", checking);
        System.out.printf("Savings: $%.2f\n", savings);
    }
}