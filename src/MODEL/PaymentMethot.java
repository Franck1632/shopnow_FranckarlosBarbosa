package MODEL;

public class PaymentMethot {

    private String ownerName;
    private double amount;

    public void PaymentMethot(String ownerName, double amount) {
        this.ownerName = ownerName;
        this.amount = amount;
    }

    public void ProcessPayment() {

    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    


}