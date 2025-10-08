package MODEL;

public class BanckTranferer extends PaymentMethot {
    private int accountNumber;
    private String banckName;

    public BanckTranferer(int accountNumber, String banckName) {
        this.accountNumber = accountNumber;
        this.banckName = banckName;
        super.PaymentMethot("Banck", 0);
    }

    @Override
    public void ProcessPayment() {
        System.out.println("Procesando pago con banco: " + banckName + " ,con numero de cuenta: " + accountNumber);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBanckName() {
        return banckName;
    }

    public void setBanckName(String banckName) {
        this.banckName = banckName;
    }   
    



}