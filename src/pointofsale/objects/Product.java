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
	private Integer id;    
	private String name;
	private Double price;
	private Integer time;
	private String route_image;
	private Integer categorie_id;
	private String created_at;

    public Product() {
    }

        
        
    public Product(Integer id, String name, Double price, Integer time, String route_image, Integer categorie_id, String created_at) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.time = time;
        this.route_image = route_image;
        this.categorie_id = categorie_id;
        this.created_at = created_at;
    }

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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getRoute_image() {
        return route_image;
    }

    public void setRoute_image(String route_image) {
        this.route_image = route_image;
    }

    public Integer getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(Integer categorie_id) {
        this.categorie_id = categorie_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + ", time=" + time + ", route_image=" + route_image + ", categorie_id=" + categorie_id + ", created_at=" + created_at + '}';
    }
        
        
}
