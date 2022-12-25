/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import java.util.List;

import pointofsale.objects.Categorie;

/**
 *
 * @author dragonyte
 */
public class CategorieModel extends Model {

    public void insert(Categorie categorie) {
        this.dao.getCategorieDao().insert(categorie);
        this.saveChanges();
    }
    
    public void update(Categorie categorie){
        this.dao.getCategorieDao().modify(categorie);
        this.saveChanges();
    }
    
    public void delete(Categorie categorie){
        this.dao.getCategorieDao().delete(categorie);
        this.saveChanges();
    }
    
    public Categorie selectById(Long id){
        Categorie categorie = this.dao.getCategorieDao().selectById(Long.parseLong(String.valueOf(id)));
        this.closeConnection();
        return categorie;
    }

    public List<Categorie> selectAll() {
        List<Categorie> categories = this.dao.getCategorieDao().selectAll();
        this.closeConnection();
        return categories;
    }

    public List<Categorie> selectCategoriesIngredients() {
        List<Categorie> categories = this.dao.getCategorieDao().selectWhere("target = 0");
        this.closeConnection();
        return categories;
    }

    public List<Categorie> selectCategoriesProducts() {
        List<Categorie> categories = this.dao.getCategorieDao().selectWhere("target = 1");
        this.closeConnection();
        return categories;
    }
    
    public List<Categorie> selectCategoriesRooms() {
        List<Categorie> categories = this.dao.getCategorieDao().selectWhere("target = 2");
        this.closeConnection();
        return categories;
    }

    public List<Categorie> search(String search) {
        List<Categorie> categories = this.dao.getCategorieDao().search(search);
        this.closeConnection();
        return categories;
    }
}
