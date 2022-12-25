/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import java.util.List;

/**
 *
 * @author dragonyte
 */
public interface Dao<C,I> {
    
    Long insert(C a);
    
    void delete(C a);
    
    void modify(C a);
    
    List<C> selectAll();
    
    C selectById(I id);
}
