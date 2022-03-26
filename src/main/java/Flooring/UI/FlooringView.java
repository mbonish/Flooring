/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flooring.UI;

import Flooring.model.Order;
import java.util.List;

/**
 *
 * @author mariana.bonish
 */
public class FlooringView {
    private UserIO io;
    public FlooringView(UserIO io){
        this.io = io;
    }
    public void menu(){
        io.print(
" * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n" +
"   * <<Flooring Program>>\n" +
"   * 1. Display Orders\n" +
"   * 2. Add an Order\n" +
"   * 3. Edit an Order\n" +
"   * 4. Remove an Order\n" +
"   * 5. Export All Data\n" +
"   * 6. Quit\n" +
"   *\n" +
"   * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        
    }
    
    public int MenuSelection(){
        return io.readInt("Please select option 1-6");
    }
    
    public String getDateFromUser(){
        return io.readString("Please enter a date for the order.");
    }
    
   public void displayOrders(List<Order> orderList){
       for(Order currentOrder: orderList){
           io.print(currentOrder.getOrderId()+ ": " +
                   currentOrder.getCustomerName()+ ": " +
                   currentOrder.getState()+ ": " +
                   currentOrder.getTaxRate()+ ": " +
                   currentOrder.getProductType()+ ": " +
                   currentOrder.getArea()+ ": "+
                   currentOrder.getCostPerSquareFoot()+ ": "+
                   currentOrder.getLaborCostPerSquareFoot()+ ": "+
                   currentOrder.getMaterialCost()+ ": " +
                   currentOrder.getLaborCostTotal()+ ": "+
                   currentOrder.getTax()+ ": "+
                   currentOrder.getTotal());
       }
   }

   public String getCustomerName(){
       return io.readString("Please enter customer name?");
   }
   public String getState(){
       return io.readString("Please enter state. (ex OH, MN)");
   }
   public String getProductType(){
       return io.readString("Please enter the prodcut type");
   }
   public int getArea(){
       return io.readInt("Please enter an area.");
   }
}

