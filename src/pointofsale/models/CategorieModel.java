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
public class CategorieModel extends Model{

    public void insert(Categorie categorie){
        this.dao.getCategorieDao().insert(categorie);
		this.saveChanges();
    }

	public List<Categorie> selectAll(){
		List<Categorie> categories = this.dao.getCategorieDao().selectAll();
		this.closeConnection();
		return categories;
	}

	public List<Categorie> selectCategoriesIngredients(){
		List<Categorie> categories = this.dao.getCategorieDao().selectWhere("target = 0");
		this.closeConnection();
		return categories;
	}

}
