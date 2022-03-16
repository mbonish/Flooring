/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flooring.dao;

import Flooring.model.Prod;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author mariana.bonish
 */
public interface ProdDao {
     Prod addProd(Prod product)throws ProdException ;
     
     List<Prod> getAllProds()throws ProdException;
     
     Prod getProd(String prodType)throws ProdException;
     
     Prod removeProd(String prodType)throws ProdException;
     
     Prod editProd(String prodType)throws ProdException;
}

