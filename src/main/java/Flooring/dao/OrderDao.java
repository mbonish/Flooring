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

    public Order addOrder(Order order) throws FlooringPersistenceException;

    public Order getOrder(Order order) throws FlooringPersistenceException;

    public List<Order> getAllOrders(LocalDate date) throws FlooringPersistenceException;

    public Order removeOrder(Order order) throws FlooringPersistenceException;

    public Order editOrder(Order order) throws FlooringPersistenceException;

    public int getNextId(LocalDate date) throws FlooringPersistenceException;

}
