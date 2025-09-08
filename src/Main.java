
import java.util.Scanner;
import MODEL.Client;
import MODEL.Product;
import MODEL.Order;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Crear client
        Client client = new Client("Juan Perez", "juanperez@gmail.com");

        // Crear productos
        ArrayList<Product> catalogo = new ArrayList<>();
        catalogo.add(new Product("Producto 1", 100.0, 123459));
        catalogo.add(new Product("Producto 2", 200.0, 123456));
        catalogo.add(new Product("Producto 3", 3000.2, 123457));
        catalogo.add(new Product("Producto 4", 400.1, 123458));
        catalogo.add(new Product("Producto 5", 50.9, 123450));
        catalogo.add(new Product("Producto 6", 60.0, 123460));
        catalogo.add(new Product("Producto 7", 70.0, 123461));
        catalogo.add(new Product("Producto 8", 80.0, 123462));
        catalogo.add(new Product("Producto 9", 50.5, 123463));
        catalogo.add(new Product("Producto 10", 100.3, 123464));
        int option = 0;
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("--------------------------------------------------------------------------------");
        do {
            Order Order = new Order(1, client);
            System.out.println("Bienvenido a la tienda");
            System.out.println("A continuación se le mostrata la lista de productos que tiene la tienda:");
            for (Product p : catalogo) {
                p.mostrarInfoProduct();
            }
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Ingrese el numero de productos que quiere agregar a su orden: ");
            int numProductos = sc.nextInt();
            for (int i = 1; i <= numProductos; i++) {
                System.out.println("Ingrese el ID del producto que quiere agregar a su orden: ");
                int IdProduct = sc.nextInt();

                Product productSelect = null;
                for (Product p : catalogo) {
                    if (p.getIdProduct() == IdProduct) {
                        productSelect = p;
                        break;
                    }
                }
                if (productSelect != null) {
                    Order.addProduct(productSelect);
                    System.out.println("Producto agregado a la orden.");
                } else {
                    System.out.println("Producto no encontrado.");
                    i--;
                }
            }
            System.out.println("Su orden actual es: ");
            Order.mostrarInfoOrder();
            System.out.println("¿Quiere hacer otro pedido? 1. Si 0. No");
            option = sc.nextInt();

        } while (option == 1);
        System.out.println("Gracias por su compra, vuelva pronto.");
        sc.close();
    }

}
