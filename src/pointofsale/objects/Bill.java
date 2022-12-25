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
	private Long id=null;    
	private String description=null;
	private Long client_type=null;
	private Long client_id=null;
        private Long waiter_id=null;
	private Long user_id=null;
	private Long people=Long.valueOf(0);
	private Long discount=Long.valueOf(0);
	private Long tip=Long.valueOf(0);
	private boolean courtesy=false;
	private boolean internal=false;
	private Long payment_method_id=null;
	private boolean housing=false;
	private boolean printed=false;
	private Long total=null;
	private Long total_real=null;
	private Long event_id=Long.valueOf(0);
	private String created_at=null;

    public Bill(Long id, String description, Long client_type, Long client_id,Long waiter_id,Long user_id, Long people, Long discount, Long tip, boolean courtesy, boolean internal, Long payment_method_id, boolean housing, boolean printed, Long total, Long total_real, Long event_id, String created_at) {
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

    public Long getWaiter_id() {
        return waiter_id;
    }

    public void setWaiter_id(Long waiter_id) {
        this.waiter_id = waiter_id;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getClient_type() {
        return client_type;
    }

    public void setClient_type(Long client_type) {
        this.client_type = client_type;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getPeople() {
        return people;
    }

    public void setPeople(Long people) {
        this.people = people;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Long getTip() {
        return tip;
    }

    public void setTip(Long tip) {
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

    public Long getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(Long payment_method_id) {
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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotal_real() {
        return total_real;
    }

    public void setTotal_real(Long total_real) {
        this.total_real = total_real;
    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
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
