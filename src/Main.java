import MODEL.Client;
import MODEL.Product;
import MODEL.Order;
public class Main {
    public static void main(String[] args) {
        Client client = new Client("Juan Perez", "juanperez@gmail.com");
        Product product1 = new Product("Laptop", 1000.0, 123459);
        Product product2 = new Product("Mouse", 50.0, 123456);
        Product product3 = new Product("Monitor", 1500.0, 123457);
        Product product4 = new Product("Mouse", 50.0, 123458);
        Product product5 = new Product("Monitor", 200.0, 123459);

        client.mostrarInfo();
        Order Order = new Order(1, client); // Creamos un objeto Order
        Order.addProduct(product1);
        Order.addProduct(product2);
        Order.addProduct(product3);
        Order.addProduct(product4);
        Order.addProduct(product5);
        System.out.println("Total cost: " + Order.totalCost());
    }
}
