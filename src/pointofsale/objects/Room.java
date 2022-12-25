/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class Room {
	private Long id;    
	private String route_image;
	private Long capacity;
	private String description;
	private Long price;
	private Long categorie_id;
	private String created_at;
        private boolean allocatted;
        private String categorie;

    public Room(Long id, String route_image, Long capacity, String description, Long price, Long categorie_id,boolean allocatted, String created_at) {
        this.id = id;
        this.route_image = route_image;
        this.capacity = capacity;
        this.description = description;
        this.price = price;
        this.categorie_id = categorie_id;
        this.created_at = created_at;
        this.allocatted = allocatted;
    }

    public Room() {
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoute_image() {
        return route_image;
    }

    public void setRoute_image(String route_image) {
        this.route_image = route_image;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
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

    public boolean isAllocatted() {
        return allocatted;
    }

    public void setAllocatted(boolean allocatted) {
        this.allocatted = allocatted;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    
    
    

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", route_image=" + route_image + ", capacity=" + capacity + ", description=" + description + ", price=" + price + ", categorie_id=" + categorie_id + ", created_at=" + created_at + '}';
    }
        
        
}
