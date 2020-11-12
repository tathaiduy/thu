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
public class CakeErrorObject implements Serializable
{
    private String cakeIDError, cakeNameError, cakePictureError; 
    private String cakePriceError;

    public CakeErrorObject() {
    }

    public String getCakeIDError() {
        return cakeIDError;
    }

    public void setCakeIDError(String cakeIDError) {
        this.cakeIDError = cakeIDError;
    }

    public String getCakeNameError() {
        return cakeNameError;
    }

    public void setCakeNameError(String cakeNameError) {
        this.cakeNameError = cakeNameError;
    }

    public String getCakePictureError() {
        return cakePictureError;
    }

    public void setCakePictureError(String cakePictureError) {
        this.cakePictureError = cakePictureError;
    }

    public String getCakePriceError() {
        return cakePriceError;
    }

    public void setCakePriceError(String cakePriceError) {
        this.cakePriceError = cakePriceError;
    }
    
   
}
