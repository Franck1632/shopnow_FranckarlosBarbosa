package MODEL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;

public class ProductLoader {
    public static List<Product> loadProducts(String pathFile) {
        List<Product> products = new ArrayList<>();

        try (BufferedReader bufferReader = new BufferedReader(new FileReader(pathFile))) {
            String line;
            while ((line = bufferReader.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                String name = values[1];
                double cost = Double.parseDouble(values[2]);
                products.add(new Product(name, cost, id));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo: " + pathFile);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }catch (Exception e){
            System.out.println("Error General");
        }finally {
            System.out.println("Cierra el programa.");
        }
        return products;
    }
}