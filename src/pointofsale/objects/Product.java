/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class Product {
	private Long id;    
	private String name;
	private Long price;
	private Long time;
	private String route_image;
	private Long categorie_id;
	private String created_at;
        private Long quantity=null;

    public Product() {
    }

        
        
    public Product(Long id, String name, Long price, Long time, String route_image, Long categorie_id, String created_at) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.time = time;
        this.route_image = route_image;
        this.categorie_id = categorie_id;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getRoute_image() {
        return route_image;
    }

    public void setRoute_image(String route_image) {
        this.route_image = route_image;
    }

    public Long getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(Long categorie_id) {
        this.categorie_id = categorie_id;
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
    
    

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + ", time=" + time + ", route_image=" + route_image + ", categorie_id=" + categorie_id + ", created_at=" + created_at + '}';
    }
        
        
}
