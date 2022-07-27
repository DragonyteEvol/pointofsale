/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointofsale;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author dragonyte
 */
public class MoneyConverter {
    public static String convertDouble(Integer value){
        Locale region = Locale.getDefault();
        NumberFormat formatMoney = NumberFormat.getCurrencyInstance(region);
        return (formatMoney.format(value));
    }
}
