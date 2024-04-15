package model;

public class Phone {

    private int id;
    private String model;
    private String so;
    private int price;
    private String camara;

    public Phone() {

    }

    public Phone(int id, String model, String so, int price, String camara) {
        this.id = id;
        this.model = model;
        this.so = so;
        this.price = price;
        this.camara = camara;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", model='" + model + '\'' +
                ", so='" + so + '\'' +
                ", price=" + price +
                ", camara='" + camara + '\'' ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCamara() {
        return camara;
    }

    public void setCamara(String camara) {
        this.camara = camara;
    }
}
