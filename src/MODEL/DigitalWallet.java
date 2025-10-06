package MODEL;

public class DigitalWallet extends  PaymentMethot {
    private int walletID;

    public DigitalWallet(int walletID) {
        this.walletID = walletID;
        super.PaymentMethot("Digital Wallet", 0);
    }

    public void ProcessPayment() {
        System.out.println("Procesando pago con billetera digital: " + walletID);
    }

    public int getWalletID() {
        return walletID;
    }

    public void setWalletID(int walletID) {
        this.walletID = walletID;
    }
}
