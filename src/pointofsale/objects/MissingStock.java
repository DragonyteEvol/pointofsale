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
	private Integer id;    
	private Integer ingredient_id;
	private String created_at;

    public MissingStock(Integer id, Integer ingredient_id, String created_at) {
        this.id = id;
        this.ingredient_id = ingredient_id;
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Integer ingredient_id) {
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
