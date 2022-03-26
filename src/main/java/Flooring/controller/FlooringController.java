/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flooring.controller;

import Flooring.UI.FlooringView;
import Flooring.dao.FlooringPersistenceException;
import Flooring.model.Order;
import Flooring.service.FlooringService;
import Flooring.service.FlooringValidationException;
import java.time.LocalDate;
import java.util.List;


/**
 *
 * @author mariana.bonish
 */
public class FlooringController {

    FlooringView view;
    FlooringService service;

    public FlooringController(FlooringView view, FlooringService service) {
        this.view = view;
        this.service = service;
    }
    int menuSelection = 0;
    boolean keepGoing = true;

    public void run() throws FlooringValidationException, FlooringPersistenceException {

        while (keepGoing) {
            view.menu();
            menuSelection = view.MenuSelection();

            switch (menuSelection) {
                case 1:
                    viewAllOrders();
                    break;
                case 2:
                    addOrder();
                case 3:
                    editOrder();
                case 4:
                    removeOrder();
                case 5:
                    exportData();
                case 6:
                    //quit
            }
        }

    }
    //will need to return a list 
    private void viewAllOrders() throws FlooringValidationException, FlooringPersistenceException{
        String userDate = view.getDateFromUser();
        LocalDate date = service.validateDate(userDate);
        //ask the users for a date- then display orders on the date
        List<Order> orders = service.getAllOrders(date);
        view.displayOrders(orders);
    }
    
    private void addOrder() throws FlooringValidationException{
        String userDate = view.getDateFromUser();
        String customerName = view.getCustomerName();
        String state = view.getState();
        String prodType = view.getProductType();
        int area = view.getArea();
        LocalDate date = service.validateDate(userDate);
        Order priorOrder = new Order(date);
        
        
        
       service
    }
    
    private void editOrder(){
        //ask for date
        //can change name, state,product type and area
    }
    
    private void removeOrder(){
        //ask for date
        //display order information
        //ask for confirmation
    }
    
    private void exportData(){
        
    }
}
