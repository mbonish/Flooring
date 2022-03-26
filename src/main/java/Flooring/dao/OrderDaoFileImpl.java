/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Flooring.dao;

import Flooring.model.Order;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author mariana.bonish
 */
public class OrderDaoFileImpl implements OrderDao {

    final static String DELIMITER = ",";
    private File orderFile;

    private Map<Integer, Order> Orders = new HashMap<>();

    @Override
    public Order addOrder(Order order) throws FlooringPersistenceException {
        loadOrders(order.getDate());
        Orders.put(order.getOrderId(), order);
        writeOrders();
        return order;
    }

    @Override
    public Order getOrder(Order order) throws FlooringPersistenceException {
        loadOrders(order.getDate());
        return order;
    }

    @Override
    public List<Order> getAllOrders(LocalDate date) throws FlooringPersistenceException {
        loadOrders(date);
        return new ArrayList(Orders.values());
    }

    @Override
    public Order removeOrder(Order order) throws FlooringPersistenceException {
        loadOrders(order.getDate());
        Order removedOrder = Orders.remove(order.getOrderId());
        writeOrders();
        return removedOrder;
        
        
    }

    @Override
    public Order editOrder(Order order) throws FlooringPersistenceException {
        getOrder(order);
        removeOrder(order);
        return order;
    }
    

    private Order unmarshallOrder(String OrderAsText) {
        String[] OrderTokens = OrderAsText.split(DELIMITER);

        String orderId = OrderTokens[0];

        Order OrderFromFile = new Order(parseInt(orderId));

        OrderFromFile.setCustomerName(OrderTokens[1]);
        OrderFromFile.setState(OrderTokens[2]);

        BigDecimal taxRate = new BigDecimal(OrderTokens[3]);
        OrderFromFile.setTax(taxRate);
        OrderFromFile.setProductType(OrderTokens[4]);

        BigDecimal area = new BigDecimal(OrderTokens[5]);
        OrderFromFile.setArea(area);

        BigDecimal costPerSqFt = new BigDecimal(OrderTokens[6]);
        OrderFromFile.setCostPerSquareFoot(costPerSqFt);

        BigDecimal laborCostPerSqFt = new BigDecimal(OrderTokens[7]);
        OrderFromFile.setLaborCostPerSquareFoot(laborCostPerSqFt);

        BigDecimal materialCost = new BigDecimal(OrderTokens[8]); 
        OrderFromFile.setMaterialCost(materialCost);

        BigDecimal laborCost = new BigDecimal(OrderTokens[9]);
        OrderFromFile.setLaborCostTotal(laborCost);

        BigDecimal taxTotal = new BigDecimal(OrderTokens[10]);
        OrderFromFile.setTax(taxTotal);

        BigDecimal total = new BigDecimal(OrderTokens[11]);
        OrderFromFile.setTotal(total);

        return OrderFromFile;

    }
    

    private void loadOrders(LocalDate date) throws FlooringPersistenceException {
        Scanner scanner;
        
        String formattedDate = date.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        String nameOfFile = "Orders_" + formattedDate+ ".txt";

        try {
            scanner
                    = new Scanner(
                            new BufferedReader(
                                    new FileReader(nameOfFile)));
        } catch (FileNotFoundException e) {
            Orders = new HashMap<>();
            return;
        }
        String currentLine;
        Order currentOrder;
        
        boolean firstLine = true;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            if(firstLine){
                firstLine =false;
                continue;
            }

            currentOrder = unmarshallOrder(currentLine);

            Orders.put(currentOrder.getOrderId(), currentOrder);
        }
        scanner.close();
    }

    private String marshallOrder(Order anOrder) {
        String OrderAsText = anOrder.getOrderId() + DELIMITER;
        OrderAsText += anOrder.getCustomerName() + DELIMITER;
        OrderAsText += anOrder.getState() + DELIMITER;
        OrderAsText += anOrder.getTax() + DELIMITER;
        OrderAsText += anOrder.getProductType() + DELIMITER;
        OrderAsText += anOrder.getArea() + DELIMITER;
        OrderAsText += anOrder.getCostPerSquareFoot() + DELIMITER;
        OrderAsText += anOrder.getLaborCostPerSquareFoot() + DELIMITER;
        OrderAsText += anOrder.getMaterialCost() + DELIMITER;
        OrderAsText += anOrder.getLaborCostTotal() + DELIMITER;
        OrderAsText += anOrder.getTax() + DELIMITER;
        OrderAsText += anOrder.getTotal();

        return OrderAsText;

    }

    private void writeOrders() throws FlooringPersistenceException {
        PrintWriter out;
        Order orderForDate = Orders.get(0);
        LocalDate orderDate = orderForDate.getDate();
        String formattedDate = orderDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nameOfFile = "Order_" + formattedDate + ".txt";
      
            try {
                out = new PrintWriter(
                        new FileWriter(nameOfFile));
            } catch (IOException e) {
                throw new FlooringPersistenceException(
                        "Could not save order Data.", e);
            }
            List<Order> orderList = this.getAllOrders(orderDate);
             String orderAsText;
            for (Order currentOrder : orderList) {
                orderAsText = marshallOrder(currentOrder);
                out.println(orderAsText);
                out.flush();
            }
            out.close();

    }
    
}
