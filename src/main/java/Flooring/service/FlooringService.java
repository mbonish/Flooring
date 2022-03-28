/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flooring.service;

import Flooring.dao.FlooringPersistenceException;
import Flooring.model.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author mariana.bonish
 */
public interface FlooringService {

    public Order addOrder(Order order) throws FlooringPersistenceException;

    public Order getOrder(Order order) throws FlooringPersistenceException;

    public List<Order> getAllOrders(LocalDate date)
            throws FlooringPersistenceException;

    public Order removeOrder(Order order) throws FlooringPersistenceException;

    public Order editOrder(Order order) throws FlooringPersistenceException;

    public LocalDate validateDate(String dateFromUser)
            throws FlooringValidationException;

    public Order validateOrder(Order order)
            throws FlooringValidationException, FlooringPersistenceException;

    public Order calculateOrder(Order order)
            throws FlooringPersistenceException;

    public void createOrder(Order order)
            throws FlooringValidationException, FlooringPersistenceException;


}
