/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyteevol
 */
public class Unit {
    private Integer id;
    private String name;
    private String prefix;
    private String created_at;

    public Unit(Integer id, String name, String prefix, String created_at) {
        this.id = id;
        this.name = name;
        this.prefix = prefix;
        this.created_at = created_at;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return "Unit{" + "name=" + name + ", prefix=" + prefix + ", id=" + id + ", created_at=" + created_at + '}';
    }
    
    
    
}
