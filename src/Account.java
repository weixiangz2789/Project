public class Account {
    private final int acc1 = 1;
    private final int acc2 = 2;
    private double checkingBal;
    private double savingBal;

    public Account (double checkingBal, double savingBal){
        this.checkingBal = checkingBal;
        this.savingBal = savingBal;
    }
    public double getCheckingBal(){
        return checkingBal;
    }
    public double getSavingBal(){
        return savingBal;
    }

    public void withdraw(int accNumber, double amount){
        if (accNumber == 1){
            checkingBal -= amount;
        }
        else{
            savingBal -= amount;
        }
    }

    public void deposit(int accNumber, double amount){
        if (accNumber == 1){
            checkingBal += amount;
        }
        else{
            savingBal += amount;
        }
    }

    public void transfer(int accNumber, double amount){
        if (accNumber == 1){
            checkingBal -= amount;
            savingBal += amount;
        }
        else{
            savingBal -= amount;
            checkingBal += amount;
        }
    }
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
