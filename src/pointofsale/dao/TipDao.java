/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import java.util.List;
import pointofsale.objects.Tip;

/**
 *
 * @author dragonyte
 */
public interface TipDao extends Dao<Tip, Long>{
    List<Tip> selectTipUser();
}
