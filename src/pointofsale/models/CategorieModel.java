/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale.models;

import pointofsale.objects.Categorie;

/**
 *
 * @author dragonyte
 */
public class CategorieModel extends Model{
    public void insert(Categorie categorie){
        this.dao.getCategorieDao().insert(categorie);
    }
}
