/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pointofsale.dao;

import pointofsale.objects.Event;

/**
 *
 * @author dragonyte
 */
public interface EventDao extends Dao<Event, Long>{
    Event selectActive();
}
