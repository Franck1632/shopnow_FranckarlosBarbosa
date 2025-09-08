package MODEL;

public class Client {
    private String name;
    private String email;
    
    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void mostrarInfo() {
        System.out.println("Client information: " + name + ", client email: " + email);
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
