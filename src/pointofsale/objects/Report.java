/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class Report {
    private Long id,subvalue,value,quantity;
    private String name,created_at;

    public Report() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubvalue() {
        return subvalue;
    }

    public void setSubvalue(Long subvalue) {
        this.subvalue = subvalue;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Report{" + "id=" + id + ", subvalue=" + subvalue + ", value=" + value + ", name=" + name + ", created_at=" + created_at + '}';
    }
    
    
}
