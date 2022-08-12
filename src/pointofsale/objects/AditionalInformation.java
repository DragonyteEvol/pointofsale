/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class AditionalInformation {
	private Integer id;    
	private Integer nit;
	private String name;
        private String address ="";
        private Integer phone =null;
	private String logo_path;
	private Integer default_tip;
	private String created_at;

    public AditionalInformation(Integer id, Integer nit, String name, String logo_path, Integer default_tip, String created_at) {
        this.id = id;
        this.nit = nit;
        this.name = name;
        this.logo_path = logo_path;
        this.default_tip = default_tip;
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo_path() {
        return logo_path;
    }

    public void setLogo_path(String logo_path) {
        this.logo_path = logo_path;
    }

    public Integer getDefault_tip() {
        return default_tip;
    }

    public void setDefault_tip(Integer default_tip) {
        this.default_tip = default_tip;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "AditionalInformation{" + "id=" + id + ", nit=" + nit + ", name=" + name + ", logo_path=" + logo_path + ", default_tip=" + default_tip + ", created_at=" + created_at + '}';
    }
        
        
}
