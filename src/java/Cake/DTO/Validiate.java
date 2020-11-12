/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.DTO;

import java.io.Serializable;

/**
 *
 * @author DuyTT
 */
public class Validiate {
    
    public boolean ValidiateNumber(String number) throws Exception
    {
        try
        {
            Integer.parseInt(number);
            return true;
            
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
}
