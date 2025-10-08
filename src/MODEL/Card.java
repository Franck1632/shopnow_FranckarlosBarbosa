package MODEL;

import java.time.LocalDate;

public class Card extends PaymentMethot {
    private short CVV;
    private int CardNumber;
    private int lastFourDigits;
    private LocalDate expirationDate;

    public Card(short CVV, int CardNumber, LocalDate expirationDate) {
        this.CVV = CVV;
        this.CardNumber = CardNumber;
        this.expirationDate = expirationDate;
        this.lastFourDigits = CardNumber % 10000;
        super.PaymentMethot("Card", 0);
    }
    @Override
    public void ProcessPayment() {
        System.out.println("Procesando pago con targeta terminada en: " + lastFourDigits ) ;
    }


    public short getCVV() {
        return CVV;
    }
    public void setCVV(short cVV) {
        CVV = cVV;
    }
    public int getCardNumber() {
        return CardNumber;
    }
    public void setCardNumber(int cardNumber) {
        CardNumber = cardNumber;
    }
    public int getLastFourDigits() {
        return lastFourDigits;
    }
    public void setLastFourDigits(int lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
