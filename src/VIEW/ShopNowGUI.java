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
import MODEL.PaymentMethot;
import MODEL.Product;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.lang.reflect.Method;

import MODEL.ProductLoader;
import MODEL.Client;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import MODEL.Card;
import MODEL.DigitalWallet;
import MODEL.BanckTranferer;

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

        // Cargar productos
        catalog = ProductLoader
                .loadProducts("C:\\\\Visualstudio\\\\Programación_1\\\\JAVA\\\\PROYECTO\\\\src\\\\Catalogo.txt");
        client = new Client("Juan Perez", "juanperez@gmail.com");
        order = new Order(1, client, null);

        // Panel de catalogo
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
        leftPanel.add(new JLabel("catalogo de Productos"), BorderLayout.NORTH);
        leftPanel.add(scrollCatalogo, BorderLayout.CENTER);
        leftPanel.add(addButton, BorderLayout.SOUTH);

        // Panel de carrito
        cartArea = new JTextArea();
        cartArea.setEditable(false);
        JScrollPane scrollCarrito = new JScrollPane(cartArea);

        JPanel rightJPanel = new JPanel(new BorderLayout());
        rightJPanel.add(new JLabel("carrito de compras"), BorderLayout.NORTH);
        rightJPanel.add(scrollCarrito, BorderLayout.CENTER);

        JButton checkoutButton = new JButton("Finalizar Compra");
        // Cambio para pago
        checkoutButton.addActionListener((ActionEvent e) -> {
            int opcion = 0;
            while (true) {
                try {
                    String input = JOptionPane.showInputDialog(
                            this,
                            "Seleccione un método de pago:\n" +
                                    "1. Tarjeta\n" +
                                    "2. Transferencia Bancaria\n" +
                                    "3. Billetera Digital",
                            "Método de Pago",
                            JOptionPane.QUESTION_MESSAGE);

                    if (input == null) { // si cancela
                        JOptionPane.showMessageDialog(this, "Compra cancelada.");
                        return;
                    }

                    opcion = Integer.parseInt(input);

                    if (opcion >= 1 && opcion <= 3)
                        break; // opción válida
                    else
                        JOptionPane.showMessageDialog(this, "Por favor ingrese un número entre 1 y 3.");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Debe ingresar un número válido.");
                }
            }
            // crear el objeto PaymentMethod correspondiente
            PaymentMethot paymentMethod = null;
            try {
                switch (opcion) {
                    case 1: // Card
                        short cvv = Short.parseShort(JOptionPane.showInputDialog("Ingrese el CVV:"));
                        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de tarjeta:"));
                        paymentMethod = new Card(cvv, numero, null);
                        break;

                    case 2: // Bank Transfer
                        int cuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de cuenta:"));
                        String banco = JOptionPane.showInputDialog("Ingrese el nombre del banco:");
                        paymentMethod = new BanckTranferer(cuenta, banco);
                        break;

                    case 3: // Digital Wallet
                        int idBilletera = Integer
                                .parseInt(JOptionPane.showInputDialog("Ingrese el ID de la billetera:"));
                        paymentMethod = new DigitalWallet(idBilletera);
                        break;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: entrada numérica no válida.");
                return;
            }
            // Asignar el método de pago
            order.setPaymentMethod(paymentMethod);
            // Mostrar resumen de la compra
            cartArea.append("\n=== COMPRA FINALIZADA ===\n");
            cartArea.append(order.mostrarInfoOrder());
            // Mostrar resumen de la compra
            double total = order.totalCost();
            JOptionPane.showMessageDialog(
                    this,
                    " Compra completada.\n" +
                            "Método de pago: " + opcion + "\n" +
                            "Total: $" + total,
                    "Resumen de Pago",
                    JOptionPane.INFORMATION_MESSAGE);

        });
        rightJPanel.add(checkoutButton, BorderLayout.SOUTH);

        // Dividir paneles
        add(leftPanel, BorderLayout.WEST);
        add(rightJPanel, BorderLayout.CENTER);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new ShopNowGUI().setVisible(true);
        });
    }
}