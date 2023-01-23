public class Account {
    private double checkingBal;
    private double savingBal;
    private int transactionNumber;
    private String recentAction;

    public Account (double checkingBal, double savingBal){
        this.checkingBal = checkingBal;
        this.savingBal = savingBal;
        transactionNumber = 10001;

    }
    public double getCheckingBal(){
        return checkingBal;
    }
    public double getSavingBal(){
        return savingBal;
    }
    public String getRecentTransaction(){
        return recentAction;
    }
    public int getTransactionNumber(){
        return transactionNumber;
    }
    public void setTransactionNumber(){
        transactionNumber ++;
    }
    public void setRecentAction(String s){
        recentAction = s;
    }

    public void withdraw(int accNumber, double amount){
        if (accNumber == 1){
            checkingBal -= amount;
            recentAction = "Checking Balance: $" + checkingBal + "\n" + "Saving Balance: $" + savingBal + "\n" + "Transaction ID: " + transactionNumber + "\n" + "Withdrew $" + amount + " from account " + accNumber;
        }
        else{
            savingBal -= amount;
            recentAction = "Checking Balance: $" + checkingBal + "\n" + "Saving Balance: $" + savingBal + "\n" + "Transaction ID: " + transactionNumber + "\n" + "Withdrew $" + amount + " from account " + accNumber;

        }
        transactionNumber ++;
    }

    public void deposit(int accNumber, double amount){
        if (accNumber == 1){
            checkingBal += amount;
            recentAction = "Checking Balance: $" + checkingBal + "\n" + "Saving Balance: $" + savingBal + "\n" + "Transaction ID: " + transactionNumber + "\n" + "Deposited $" + amount + " to account " + accNumber;
        }
        else{
            savingBal += amount;
            recentAction = "Checking Balance: $" + checkingBal + "\n" + "Saving Balance: $" + savingBal + "\n" + "Transaction ID: " + transactionNumber + "\n" + "Deposited $" + amount + " to account " + accNumber;
        }
        transactionNumber ++;
    }

    public void transfer(int accNumber, double amount){
        if (accNumber == 1){
            checkingBal -= amount;
            savingBal += amount;
            recentAction = "Checking Balance: $" + checkingBal + "\n" + "Saving Balance: $" + savingBal + "\n" + "Transaction ID: " + transactionNumber + "\n" + "Transferred $" + amount + " from account 1 to 2";

        }
        else{
            savingBal -= amount;
            checkingBal += amount;
            recentAction = "Checking Balance: $" + checkingBal + "\n" + "Saving Balance: $" + savingBal + "\n" + "Transaction ID: " + transactionNumber + "\n" + "Transferred $" + amount + " from account 2 to 1";
        }
        transactionNumber ++;
    }

    // Checks if the acc number you're trying to transfer from has sufficient funds
    public boolean transferable(int accNumber, double amount){
        if (accNumber == 1){
            if (amount > checkingBal){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            if (amount > savingBal){
                return false;
            }
            else {
                return true;
            }
        }
    }
}
