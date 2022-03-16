/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flooring.dao;

import Flooring.model.Taxes;
import java.util.List;

/**
 *
 * @author mariana.bonish
 */
public interface TaxesDao {
    
   public Taxes getTax(String stateId)throws TaxesException;      
   
   public List<Taxes> getAllTaxes()throws TaxesException;
    
}
