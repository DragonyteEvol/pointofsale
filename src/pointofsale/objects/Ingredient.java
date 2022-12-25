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
	private Long id;    
	private String name;
	private Long price;
	private Long unit_id;
        private String unit,categorie;
	private Long categorie_id;
        private Long quantity;
        private Long minimum;
	private String route_image;
	private String created_at;
        private boolean amenitie;

    public Ingredient(Long id, String name, Long price, Long unit_id, Long categorie_id,Long quantity,Long minimum ,String route_image, String created_at) {
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

    public Ingredient(Long id, String name, Long price, Long unit_id, Long categorie_id, String route_image, String created_at) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit_id = unit_id;
        this.categorie_id = categorie_id;
        this.route_image = route_image;
        this.created_at = created_at;
    }
    
    
    
    public Ingredient(){}

    public Long getId() {
        return id;
    }

    public boolean isAmenitie() {
        return amenitie;
    }

    public void setAmenitie(boolean amenitie) {
        this.amenitie = amenitie;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(Long unit_id) {
        this.unit_id = unit_id;
    }

    public Long getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(Long categorie_id) {
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getMinimum() {
        return minimum;
    }

    public void setMinimum(Long minimum) {
        this.minimum = minimum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    
    

    @Override
    public String toString() {
        return "Ingredient{" + "id=" + id + ", name=" + name + ", price=" + price + ", unit_id=" + unit_id + ", categorie_id=" + categorie_id + ", route_image=" + route_image + ", created_at=" + created_at + '}';
    }
        
        
}
