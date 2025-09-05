import MODEL.Client;
import MODEL.Product;
import MODEL.Order;
public class Main {
    public static void main(String[] args) {
        //Crear client
        Client client = new Client("Juan Perez", "juanperez@gmail.com");
        //Crear productos
        Product product1 = new Product("Laptop", 1000.0, 123459);
        Product product2 = new Product("Mouse", 50.0, 123456);
        Product product3 = new Product("Monitor", 1500.0, 123457);
        Product product4 = new Product("Mouse", 50.0, 123458);
        Product product5 = new Product("Monitor", 200.0, 123459);
        //Mostrar información de cliente
        client.mostrarInfo();
        //Crear orden
        Order Order = new Order(1, client ); // Creamos un objeto Order
        //Agregar productos a la orden
        System.out.println("Adding products to the order...");
        
        Order.addProduct(product1);
        Order.addProduct(product2);
        Order.addProduct(product3);
        Order.addProduct(product4);
        Order.addProduct(product5);
        //Mostrar información de orden
        Order.mostrarInfoOrder();
    }
}
 