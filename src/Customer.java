public class Customer {
    private String name;
    private int pin;
    private Account account;

    public Customer (String name, int pin){
        this.name = name;
        this.pin = pin;
        this.account = new Account (0.00, 0.00);
    }

    public Account getAccount() {
        return account;
    }

    public String getName(){
        return name;
    }
    public int getPin(){
        return pin;
    }
    public void setPin(int newPin){
        pin = newPin;
        account.setTransactionNumber();
        account.setRecentAction("Checking Balance: $" + account.getCheckingBal() + "\n" + "Saving Balance: $" + account.getSavingBal() + "\n" + "Transaction ID: " + account.getTransactionNumber() + "\n" + "Changed Pin");
    }
}
