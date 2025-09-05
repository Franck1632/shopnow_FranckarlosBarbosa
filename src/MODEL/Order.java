package MODEL;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Order {
    private int IdOrder;
    private ArrayList<Product> products = new ArrayList<>();//No se mete en el constructor porque se inicializa vacio aca
    private LocalDateTime buyDate;


    public Order(int IdOrder, Client client) {
        this.IdOrder = IdOrder;
        this.buyDate = LocalDateTime.now();
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
    public void mostrarInfoOrder() {
        System.out.println("Order ID: " + IdOrder);
        System.out.println("Buy date: " + buyDate);
        System.out.println("Products in Order: ");
        for (int i = 0; i < products.size(); i++) {
            products.get(i).mostrarInfoProduct();
        }
        System.out.println("Total cost: " + totalCost() + "La fecha maxima de compra es: " + buyDate.plusHours(24));
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
}
    



    

