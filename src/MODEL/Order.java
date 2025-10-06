package MODEL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Order {

    private Client client;
    private int IdOrder;
    private ArrayList<Product> products = new ArrayList<>();//No se mete en el constructor porque se inicializa vacio aca
    private LocalDateTime buyDate;
    private PaymentMethot paymentMethod;

    public Order(int IdOrder, Client client, PaymentMethot paymentMethod) {
        this.IdOrder = IdOrder;
        this.client = client;
        this.buyDate = LocalDateTime.now();
        this.paymentMethod = paymentMethod;
    }

    public void proccessOrder() {
        System.out.println("Procesando orden de compra para el cliente: " + client.getName() + ", con ID de orden: " + IdOrder);
        paymentMethod.ProcessPayment();
    }

    public void addProduct(Product newProduct) {
        products.add(newProduct);
    }

    public double totalCost() {
        double totalCost = 0;
        for (int i = 0; i < products.size(); i++) {
            totalCost = totalCost + products.get(i).getCost();
        }
        return totalCost;
    }

    public String mostrarInfoOrder() {
        String checkoutMessage;
        System.out.println("Order ID: " + IdOrder);
        System.out.println("Products in Order: ");
        for (int i = 0; i < products.size(); i++) {
            products.get(i).mostrarInfoProduct();
        }
        checkoutMessage = ("Total cost: " + totalCost() + ", La fecha maxima de compra es: " + getBuyDate());
        return checkoutMessage;
    }

    public ArrayList<Product> getProduct() {
        return products;
    }

    public String getBuyDate() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM yyyy HH:mm:ss");
        return buyDate.format(formato);
    }

    public int getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(int idOrder) {
        IdOrder = idOrder;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setBuyDate(LocalDateTime buyDate) {
        this.buyDate = buyDate;
    }

    public PaymentMethot getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethot paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
    



    

