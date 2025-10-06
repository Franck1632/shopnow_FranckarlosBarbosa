
import java.util.Scanner;
import MODEL.Client;
import MODEL.DigitalWallet;
import MODEL.Product;
import MODEL.Order;
import MODEL.PaymentMethot;

import java.util.List;
import MODEL.ProductLoader;

public class Main {

    public static void main(String[] args) {
        // Cargar catalogo
        List<Product> catalogo = ProductLoader.loadProducts("C:\\Visualstudio\\Programación_1\\JAVA\\PROYECTO\\src\\Catalogo.txt"); // Cargar catalogo
        System.out.println(catalogo);
        Scanner sc = new Scanner(System.in);
        // Crear client
        Client client = new Client("Juan Perez", "juanperez@gmail.com");
        PaymentMethot paymentMethod = new DigitalWallet(123456);
        PaymentMethot paymentMethot1 = new BanckTranferer(123456, "Banco de America");
        PaymentMethot paymentMethot2 = new Card(123, 123456789, null);

        System.out.println("--------------------------------------------------------------------------------");
        int option = 0;
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("--------------------------------------------------------------------------------");
        do {
            Order Order = new Order(1, client, paymentMethod);
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
            do {
                System.out.println("¿Quiere hacer otro pedido? 1. Si 0. No");
                option = sc.nextInt();
                if (option != 0 && option != 1) {
                    System.out.println("Opcion no valida, intente de nuevo.");
                }
            } while (option != 0 && option != 1);
        } while (option == 1);
        System.out.println("Gracias por su compra, vuelva pronto.");
        sc.close();
    }

}
