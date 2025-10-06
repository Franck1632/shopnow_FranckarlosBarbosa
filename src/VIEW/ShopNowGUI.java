package VIEW;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import MODEL.Order;
import MODEL.Product;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import MODEL.ProductLoader;
import MODEL.Client;
import javax.swing.SwingUtilities;

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
        catalog = ProductLoader.loadProducts("C:\\\\Visualstudio\\\\Programación_1\\\\JAVA\\\\PROYECTO\\\\src\\\\Catalogo.txt");
        client = new Client("Juan Perez", "juanperez@gmail.com");
        order = new Order(1, client); 

        //Panel de catalogo
        listModel = new DefaultListModel<>();
        for (Product p : catalog) {
            listModel.addElement(p.getNameProduct() + " - $" + p.getCost() + " (ID: " + p.getIdProduct() + ")");
        }
        productList = new JList<>(listModel);
        JScrollPane scrollCatalogo = new JScrollPane(productList);
        JButton addButton = new JButton("Agregar al Carrito");

        addButton.addActionListener((ActionEvent e) -> {
            int selectProduct = productList.getSelectedIndex();
            if (selectProduct != -1) {
                Product product = catalog.get(selectProduct);
                order.addProduct(product);
                cartArea.append(product.getNameProduct() + " - $" + product.getCost() + "/n");
            }
        });

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(new JLabel ("catalogo de Productos"), BorderLayout.NORTH);
        leftPanel.add(scrollCatalogo, BorderLayout.CENTER);
        leftPanel.add(addButton, BorderLayout.SOUTH);
        
        //Panel de carrito
        cartArea = new JTextArea();
        cartArea.setEditable(false);
        JScrollPane scrollCarrito = new JScrollPane(cartArea);

        JPanel rightJPanel = new JPanel(new BorderLayout());
        rightJPanel.add(new JLabel ("carrito de compras"), BorderLayout.NORTH);
        rightJPanel.add(scrollCarrito, BorderLayout.CENTER);

        JButton checkoutButton = new JButton("Finalizar Compra");
        checkoutButton.addActionListener((ActionEvent e) -> {
            cartArea.append(order.mostrarInfoOrder());
        });
        rightJPanel.add(checkoutButton, BorderLayout.SOUTH);

        //Dividir paneles
        add(leftPanel, BorderLayout.WEST);
        add(rightJPanel, BorderLayout.CENTER);

    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new ShopNowGUI().setVisible(true);
        });
    }
}      