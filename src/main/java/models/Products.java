package models;

public class Products {

    private int id;
    private String name;
    private String description;
    private double price;
    private int category_id;

    public Products(){}

    //Used for POST requests

    public Products(String name, String description, double price, int category_id) {
       setName(name);
       setDescription(description);
       setCategory_id(category_id);
       setPrice(price);
    }

    //Used for PUT requests
    
    public Products(int id, String name, String description, double price, int category_id) {
        setName(name);
        setDescription(description);
        setCategory_id(category_id);
        setPrice(price);
        setId(id);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
