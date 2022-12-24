/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;
import pointofsale.UserGlobal;
import pointofsale.objects.Bill;
import pointofsale.objects.BillProduct;
import pointofsale.objects.BillRestock;
import pointofsale.objects.BillRoomProductTmp;
import pointofsale.objects.BillRoomTmp;
import pointofsale.objects.BillTableProductTmp;
import pointofsale.objects.BillTableTmp;
import pointofsale.objects.Event;
import pointofsale.objects.Ingredient;
import pointofsale.objects.Inventory;
import pointofsale.objects.MissingStock;
import pointofsale.objects.MovementInventory;
import pointofsale.objects.PaymentMethod;
import pointofsale.objects.Product;
import pointofsale.objects.ProductIngredient;
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
        Integer price = 0;
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
        Integer price = 0;
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
        BillRoomTmp billRoomTmp = this.dao.getBillRoomTmpDao().selectByRoomId(id);
        this.closeConnection();
        return billRoomTmp;
    }

    public BillTableTmp checkBillTableTmp(Integer id) {
        BillTableTmp billTableTmp = this.dao.getBillTableTmpDao().selectByTableId(id);
        this.closeConnection();
        return billTableTmp;
    }

    public List<Product> selectProductsTableTmp(Integer id) {
        List<Product> products = this.dao.getBillTableTmpDao().selectProducts(id);
        this.closeConnection();
        return products;
    }

    public List<Product> selectProductsRoomTmp(Integer id) {
        List<Product> products = this.dao.getBillRoomTmpDao().selectProducts(id);
        this.closeConnection();
        return products;
    }

    public void sellProductTable(List<Product> products, Bill bill, BillTableTmp billTableTmp) {
        Integer bill_id = this.dao.getBillDao().insert(bill);
        bill.setId(bill_id);
        this.dao.getBillCurrentDao().insert(bill);
        for (Product product : products) {
            BillProduct billProduct = new BillProduct();
            billProduct.setBill_id(bill_id);
            billProduct.setProduct_id(product.getId());
            billProduct.setQuantity(product.getQuantity());
            billProduct.setSubvalue(product.getPrice());
            this.dao.getBillProductDao().insert(billProduct);
            List<ProductIngredient> productIngredients = this.dao.getProductIngredientDao().selectWhere("product_id=" + String.valueOf(product.getId()));
            decrementInventory(productIngredients, product);
        }
        this.dao.getBillTableTmpDao().delete(billTableTmp);
        this.dao.getBillTableProductTmpDao().deleteBill(billTableTmp.getId());
        createWarning();
        saveChanges();
    }

    public void sellProductRoom(List<Product> products, Bill bill, BillRoomTmp billRoomTmp) {
        Integer bill_id = this.dao.getBillDao().insert(bill);
        bill.setId(bill_id);
        this.dao.getBillCurrentDao().insert(bill);
        for (Product product : products) {
            BillProduct billProduct = new BillProduct();
            billProduct.setBill_id(bill_id);
            billProduct.setProduct_id(product.getId());
            billProduct.setQuantity(product.getQuantity());
            billProduct.setSubvalue(product.getPrice());
            this.dao.getBillProductDao().insert(billProduct);
        }
        this.dao.getBillRoomTmpDao().delete(billRoomTmp);
        this.dao.getBillRoomProductTmpDao().deleteBill(billRoomTmp.getId());
        createWarning();
        saveChanges();
    }

    private void createWarning() {
        List<Ingredient> ingredients = this.dao.getIngredientDao().selectMissing();
        for (Ingredient ingredient : ingredients) {
            System.out.println("entro");
            MissingStock missingStock = this.dao.getMissingStockDao().selectWhereIngredient(ingredient.getId());
            if (missingStock == null) {
                missingStock = new MissingStock(null, ingredient.getId(), false, null);
                this.dao.getMissingStockDao().insert(missingStock);
            }
        }
    }

    private void decrementInventory(List<ProductIngredient> productIngredients, Product product) {
        for (ProductIngredient productIngredient : productIngredients) {
            MovementInventory movementInventory = new MovementInventory();
            movementInventory.setAddition(false);
            movementInventory.setIngredient_id(productIngredient.getIngredient_id());
            movementInventory.setQuantity(productIngredient.getQuantity() * product.getQuantity());
            movementInventory.setSubstraction(true);
            this.dao.getMovementInventoryDao().insert(movementInventory);

            Inventory inventory = this.dao.getInventoryDao().selectWhereIngredient("ingredient_id=" + String.valueOf(productIngredient.getIngredient_id()));
            Integer quantity = inventory.getQuantity() - (productIngredient.getQuantity() * product.getQuantity());
            inventory.setQuantity(quantity);
            this.dao.getInventoryDao().modify(inventory);
        }
    }

    public List<Product> selectProductsByBill(Bill bill) {
        List<Product> products = this.dao.getBillProductDao().selectProductsByBillId(bill.getId());
        this.closeConnection();
        return products;
    }

    public List<Bill> selectByEvent(Event event) {
        List<Bill> bills = this.dao.getBillDao().selectByEvent(event.getId());
        this.closeConnection();
        return bills;
    }

    public Bill selectCollectEvent(Event event) {
        Bill bill = this.dao.getBillDao().selectCollectEvent(event.getId());
        this.closeConnection();
        return bill;
    }

    public void insertEvent(Event event, PaymentMethod paymentMethod, Integer total, Integer realTotal) {
        Bill bill = new Bill();
        bill.setClient_type(3);
        bill.setClient_id(event.getId());
        bill.setUser_id(UserGlobal.getUser().getId());
        bill.setDescription("event");
        bill.setPayment_method_id(paymentMethod.getId());
        bill.setHousing(false);
        bill.setEvent_id(event.getId());
        bill.setTotal(total);
        bill.setTotal_real(realTotal);

        this.dao.getBillDao().insert(bill);

        saveChanges();
    }

    public List<Bill> generateY() {
        List<Bill> bills = this.dao.getBillCurrentDao().selectAll();
        this.closeConnection();
        return bills;
    }

    public void generateX() {
        this.dao.getBillCurrentDao().delete(null);
        this.closeConnection();
    }

    public BillRestock getLostDay() {
        BillRestock billRestock = this.dao.getBillRestockCurrentDao().getLostDay();
        this.closeConnection();
        return billRestock;
    }

    public void deleteCurrentDay() {
        this.dao.getBillRestockCurrentDao().delete(null);
        this.dao.getBillCurrentDao().delete(null);
        saveChanges();
    }
}
