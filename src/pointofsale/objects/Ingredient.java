/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class Ingredient {
	private Integer id;    
	private String name;
	private Double price;
	private Integer unit_id;
	private Integer categorie_id;
        private Double quantity;
        private Double minimum;
	private String route_image;
	private String created_at;

    public Ingredient(Integer id, String name, Double price, Integer unit_id, Integer categorie_id,Double quantity,Double minimum ,String route_image, String created_at) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit_id = unit_id;
        this.categorie_id = categorie_id;
        this.quantity = quantity;
        this.minimum = minimum;
        this.route_image = route_image;
        this.created_at = created_at;
    }

    public Ingredient(Integer id, String name, Double price, Integer unit_id, Integer categorie_id, String route_image, String created_at) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit_id = unit_id;
        this.categorie_id = categorie_id;
        this.route_image = route_image;
        this.created_at = created_at;
    }
    
    
    
    public Ingredient(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(Integer unit_id) {
        this.unit_id = unit_id;
    }

    public Integer getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(Integer categorie_id) {
        this.categorie_id = categorie_id;
    }

    public String getRoute_image() {
        return route_image;
    }

    public void setRoute_image(String route_image) {
        this.route_image = route_image;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getMinimum() {
        return minimum;
    }

    public void setMinimum(Double minimum) {
        this.minimum = minimum;
    }
    
    

    @Override
    public String toString() {
        return "Ingredient{" + "id=" + id + ", name=" + name + ", price=" + price + ", unit_id=" + unit_id + ", categorie_id=" + categorie_id + ", route_image=" + route_image + ", created_at=" + created_at + '}';
    }
        
        
}
