/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flooring.UI;

import Flooring.model.Order;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author mariana.bonish
 */
public class FlooringView {

    private UserIO io;

    public FlooringView(UserIO io) {
        this.io = io;
    }

    public void menu() {
        io.print(
                " * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
                + "   * <<Flooring Program>>\n"
                + "   * 1. Display Orders\n"
                + "   * 2. Add an Order\n"
                + "   * 3. Edit an Order\n"
                + "   * 4. Remove an Order\n"
                + "   * 5. Export All Data\n"
                + "   * 6. Quit\n"
                + "   *\n"
                + "   * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

    }

    public int MenuSelection() {
        return io.readInt("Please select option 1-6");
    }

    public String getDateFromUser() {
        return io.readString("Please enter a date for the order.");
    }

    public void displayOrders(List<Order> orderList) {
        for (Order currentOrder : orderList) {
                    displayOrder(currentOrder);
        }
    }

    public String getCustomerName() {
        return io.readString("Please enter customer name?");
    }

    public String getState() {
        return io.readString("Please enter state. (ex OH, MN)");
    }

    public String getProductType() {
        return io.readString("Please enter the prodcut type");
    }

    public int getArea() {
        return io.readInt("Please enter an area.");
    }

    public void displayOrder(Order order) {
        if (order != null) {
            io.print("Order Number: "+ Integer.toString(order.getOrderId()));
            io.print("Customer Name: "+ order.getCustomerName());
            io.print("State: "+ order.getState());
            String taxRate = order.getTaxRate().toString();
            io.print("Tax Rate: "+ taxRate);
            io.print("Prodcut Type: "+ order.getProductType());
            String area = order.getArea().toString();
            io.print("Area: " + area);
            String costPerSqFt = order.getCostPerSquareFoot().toString();
            io.print("Cost Per SqFt: " +costPerSqFt);
            String laborCostPerSqFt = order.getLaborCostPerSquareFoot().toString();
            io.print("Labor Cost per SqFt: " +laborCostPerSqFt);
            String materialCost = order.getMaterialCost().toString();
            io.print("Material Cost" + materialCost);
            String laborCostTotal = order.getLaborCostTotal().toString();
            io.print("Labor Cost: "+ laborCostTotal);
            String tax = order.getTax().toString();
            io.print("Tax: "+tax);
            String total = order.getTotal().toString();
            io.print("toal: " + total);
        }
        else io.print("No such order");
    }

    public String confirmOrderDetails() {
        return io.readString("Are all the detials of this order correct. y/n");
    }
}
