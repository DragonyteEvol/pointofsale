/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;
import pointofsale.objects.Bill;
import pointofsale.objects.BillRoomProductTmp;
import pointofsale.objects.BillRoomTmp;
import pointofsale.objects.BillTableProductTmp;
import pointofsale.objects.BillTableTmp;
import pointofsale.objects.Product;
import pointofsale.objects.Room;
import pointofsale.objects.Table;

/**
 *
 * @author dragonyte
 */
public class BillModel extends Model {

    public void insert(Bill bill) {
        this.dao.getBillDao().insert(bill);
        this.saveChanges();
    }

    public List<Bill> selectAll() {
        List<Bill> bills = this.dao.getBillDao().selectAll();
        this.closeConnection();
        return bills;
    }

    public void update(Bill bill) {
        this.dao.getBillDao().modify(bill);
        this.saveChanges();
    }

    public void insertRoomOrder(Room room, List<Product> listProduct) {
        BillRoomTmp billRoomTmp = this.dao.getBillRoomTmpDao().selectByRoomId(room.getId());
        Integer price=0;
        if (billRoomTmp == null) {
            for (Product product : listProduct) {
                price += (product.getPrice() * product.getQuantity());
            }
            billRoomTmp = new BillRoomTmp(null, room.getId(), price, null);
            Integer id = this.dao.getBillRoomTmpDao().insert(billRoomTmp);
            for (Product product : listProduct) {
                Integer price_product = product.getPrice() * product.getQuantity();
                BillRoomProductTmp billRoomProductTmp = new BillRoomProductTmp(null, id, product.getId(), product.getQuantity(), price_product, null);
                this.dao.getBillRoomProductTmpDao().insert(billRoomProductTmp);
            }
        } else {
            ///////////////////////////
            for (Product product : listProduct) {
                price += (product.getPrice() * product.getQuantity());
                Integer price_product = product.getPrice() * product.getQuantity();
                BillRoomProductTmp billRoomProductTmp = new BillRoomProductTmp(null, billRoomTmp.getId(), product.getId(), product.getQuantity(), price_product, null);
                this.dao.getBillRoomProductTmpDao().insert(billRoomProductTmp);
            }
            billRoomTmp.setTotal(billRoomTmp.getTotal() + price);
            this.dao.getBillRoomTmpDao().modify(billRoomTmp);
            /////////////////////
        }
        this.saveChanges();
    }

    public void insertTableOrder(Table table, List<Product> listProduct) {
        BillTableTmp billTableTmp = this.dao.getBillTableTmpDao().selectByTableId(table.getId());
        Integer price=0;
        if (billTableTmp == null) {
            for (Product product : listProduct) {
                price += (product.getPrice() * product.getQuantity());
            }
            billTableTmp = new BillTableTmp(null, table.getId(), price, null);
            Integer id = this.dao.getBillTableTmpDao().insert(billTableTmp);
            for (Product product : listProduct) {
                Integer price_product = product.getPrice() * product.getQuantity();
                BillTableProductTmp billTableProductTmp = new BillTableProductTmp(null, id, product.getId(), product.getQuantity(), price_product, null);
                this.dao.getBillTableProductTmpDao().insert(billTableProductTmp);
            }
        } else {
            ///////////////////////////
            for (Product product : listProduct) {
                price += (product.getPrice() * product.getQuantity());
                Integer price_product = product.getPrice() * product.getQuantity();
                BillTableProductTmp billTableProductTmp = new BillTableProductTmp(null, billTableTmp.getId(), product.getId(), product.getQuantity(), price_product, null);
                this.dao.getBillTableProductTmpDao().insert(billTableProductTmp);
            }
            billTableTmp.setTotal(billTableTmp.getTotal() + price);
            this.dao.getBillTableTmpDao().modify(billTableTmp);
            /////////////////////
        }
        this.saveChanges();
    }

    public BillRoomTmp checkBillRoomTmp(Integer id) {
        BillRoomTmp billRoomTmp= this.dao.getBillRoomTmpDao().selectByRoomId(id);
        this.closeConnection();
        return billRoomTmp;
    }

    public BillTableTmp checkBillTableTmp(Integer id) {
        BillTableTmp billTableTmp = this.dao.getBillTableTmpDao().selectByTableId(id);
        this.closeConnection();
        return billTableTmp;
    }
}
