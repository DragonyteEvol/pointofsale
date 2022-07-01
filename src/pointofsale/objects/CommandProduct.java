/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class CommandProduct {
   private Integer id; 
   private Integer command_id;
   private Integer product_id;
   private Integer quantity;
   private String created_at;

    public CommandProduct(Integer id, Integer command_id, Integer product_id, Integer quantity, String created_at) {
        this.id = id;
        this.command_id = command_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommand_id() {
        return command_id;
    }

    public void setCommand_id(Integer command_id) {
        this.command_id = command_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "CommandProduct{" + "id=" + id + ", command_id=" + command_id + ", product_id=" + product_id + ", quantity=" + quantity + ", created_at=" + created_at + '}';
    }
   
   
}
