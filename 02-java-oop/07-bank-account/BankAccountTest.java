class BankAccountTest{
    public static void main(String[] args){
        BankAccount bank = new BankAccount();
            bank.createBankAccount();
            bank.makeDeposit(521.23, "checking");
            bank.makeDeposit(521.23, "savings");
            bank.makeWithdrawal(700, "checking");
            bank.makeWithdrawal(105, "savings");
            bank.checkBalance();
            bank.totalBalance();
    }
}