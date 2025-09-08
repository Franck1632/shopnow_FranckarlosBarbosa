package MODEL;

public class Product {
    private String nameProduct;
    private double cost;
    private int IdProduct;
    
    public Product(String nameProduct, double cost, int IdProduct) {
        this.nameProduct = nameProduct;
        this.cost = cost;
        this.IdProduct = IdProduct;
    }

    public void mostrarInfoProduct() {
        System.out.println( "- " + nameProduct + ", cost: " + cost + " and Product ID: " + IdProduct);
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(int idProduct) {
        IdProduct = idProduct;
    }
}
