/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class User {
	private Long id;    
	private String name;
	private String mail;
	private String password;
	private boolean admin;
        private boolean waiter;
	private String created_at;

	public User(){

	}

    public User(Long id, String name, String mail, String password, boolean admin, boolean waiter,String created_at) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.admin = admin;
        this.created_at = created_at;
        this.waiter = waiter;
    }

    public boolean isWaiter() {
        return waiter;
    }

    public void setWaiter(boolean waiter) {
        this.waiter = waiter;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    
    @Override
    public String toString() {
        return name;
    }

}
