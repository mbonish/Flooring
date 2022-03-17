/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flooring.dao;

import Flooring.model.Order;
import java.time.LocalDate;
import java.util.List;


/**
 *
 * @author mariana.bonish
 */
public interface OrderDao {
    public Order addOrder(Order order)throws OrderException;
   
    public Order getOrder(Order order)throws OrderException;
    
    public List<Order> getAllOrders(LocalDate date)throws OrderException; 
  
    public Order removeOrder(Order order) throws OrderException;
    
    public Order editOrder(int orderId) throws OrderException;

    
}
