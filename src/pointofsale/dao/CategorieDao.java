/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import java.util.List;

import pointofsale.objects.Categorie;

/**
 *
 * @author dragonyte
 */
public interface CategorieDao extends Dao<Categorie, Long>{
	List<Categorie> selectWhere(String where);    
}
