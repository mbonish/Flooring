/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flooring.controller;

import Flooring.UI.FlooringView;
import java.util.List;
import org.springframework.core.annotation.Order;

/**
 *
 * @author mariana.bonish
 */
public class FlooringController {

    FlooringView view;

    public FlooringController(FlooringView view) {
        this.view = view;
    }
    int menuSelection = 0;
    boolean keepGoing = true;

    public void run() {

        while (keepGoing) {
            view.menu();
            menuSelection = view.MenuSelection();

            switch (menuSelection) {
                case 1:
                    viewAllOrders();
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
    private void viewAllOrders(){
        //ask the users for a date- then display orders on the date
    }
    
    private void addOrder(){
        //need to ask the user for the following information
        //orderdate--future
        //name--must not be blank -a-z 09 . and coma's
        //state
        //product type-show a list
        //area- postive decimal with at leat 100sqft
        
        //all the other fields will be calculated 
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
