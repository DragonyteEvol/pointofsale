/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class MissingStock {
	private Long id;    
	private Long ingredient_id;
        private boolean showed;
        private String name;
        private String unit;
        private Long quantity;
	private String created_at;

    public MissingStock(Long id, Long ingredient_id,boolean showed ,String created_at) {
        this.id = id;
        this.ingredient_id = ingredient_id;
        this.showed = showed;
        this.created_at = created_at;
    }

    public boolean isShowed() {
        return showed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    
    
    public void setShowed(boolean showed) {
        this.showed = showed;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "MissingStock{" + "id=" + id + ", ingredient_id=" + ingredient_id + ", created_at=" + created_at + '}';
    }
        
        
}
