/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.objects;

/**
 *
 * @author dragonyte
 */
public class Bill {
	private Integer id=null;    
	private String description=null;
	private Integer client_type=null;
	private Integer client_id=null;
        private Integer waiter_id=null;
	private Integer user_id=null;
	private Integer people=0;
	private Integer discount=0;
	private Integer tip=0;
	private boolean courtesy=false;
	private boolean internal=false;
	private Integer payment_method_id=null;
	private boolean housing=false;
	private boolean printed=false;
	private Integer total=null;
	private Integer total_real=null;
	private Integer event_id=0;
	private String created_at=null;

    public Bill(Integer id, String description, Integer client_type, Integer client_id,Integer waiter_id,Integer user_id, Integer people, Integer discount, Integer tip, boolean courtesy, boolean internal, Integer payment_method_id, boolean housing, boolean printed, Integer total, Integer total_real, Integer event_id, String created_at) {
        this.id = id;
        this.description = description;
        this.client_type = client_type;
        this.client_id = client_id;
        this.user_id = user_id;
        this.people = people;
        this.discount = discount;
        this.tip = tip;
        this.courtesy = courtesy;
        this.internal = internal;
        this.payment_method_id = payment_method_id;
        this.housing = housing;
        this.printed = printed;
        this.total = total;
        this.total_real = total_real;
        this.event_id = event_id;
        this.created_at = created_at;
        this.waiter_id = waiter_id;
        
    }

    public Bill() {
    }

    public Integer getWaiter_id() {
        return waiter_id;
    }

    public void setWaiter_id(Integer waiter_id) {
        this.waiter_id = waiter_id;
    }
    
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getClient_type() {
        return client_type;
    }

    public void setClient_type(Integer client_type) {
        this.client_type = client_type;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getTip() {
        return tip;
    }

    public void setTip(Integer tip) {
        this.tip = tip;
    }

    public boolean isCourtesy() {
        return courtesy;
    }

    public void setCourtesy(boolean courtesy) {
        this.courtesy = courtesy;
    }

    public boolean isInternal() {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    public Integer getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(Integer payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public boolean isHousing() {
        return housing;
    }

    public void setHousing(boolean housing) {
        this.housing = housing;
    }

    public boolean isPrinted() {
        return printed;
    }

    public void setPrinted(boolean printed) {
        this.printed = printed;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotal_real() {
        return total_real;
    }

    public void setTotal_real(Integer total_real) {
        this.total_real = total_real;
    }

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", description=" + description + ", client_type=" + client_type + ", client_id=" + client_id + ", user_id=" + user_id + ", people=" + people + ", discount=" + discount + ", tip=" + tip + ", courtesy=" + courtesy + ", internal=" + internal + ", payment_method_id=" + payment_method_id + ", housing=" + housing + ", printed=" + printed + ", total=" + total + ", total_real=" + total_real + ", event_id=" + event_id + ", created_at=" + created_at + '}';
    }
        
        
}
