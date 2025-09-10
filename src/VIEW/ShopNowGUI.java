package VIEW;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import MODEL.Order;
import MODEL.Product;
import java.util.List;
import java.awt.BorderLayout;
import MODEL.ProductLoader;
import MODEL.Client;

public class ShopNowGUI extends JFrame {
    private JList<String> productList;
    private DefaultListModel<String> listModel;
    private JTextArea cartArea;
    private Order order;
    private List<Product> catalog;
    private Client client;
    
    public ShopNowGUI() {
        setTitle("ShopNow-Carrito de Compras");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Cargar productos
        catalog = ProductLoader.loadProducts("src/Catalogo.txt");
        client = new Client("Juan Perez", "juanperez@gmail.com");
        order = new Order(1, client); 

        //Panel de catalogo
        listModel = new DefaultListModel<>();
        for (Product p : catalog) {
            listModel.addElement(p.getNameProduct() + " - $" + p.getCost() + " (ID: " + p.getIdProduct() + ")");
        }
        productList = new JList<>(listModel);
        JScrollPane scrollCatalogo = new JScrollPane(productList);

    }
}
