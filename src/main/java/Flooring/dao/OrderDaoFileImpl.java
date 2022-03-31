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
        int orderId = getNextId(order.getDate());
        order.setOrderId(orderId);
        Orders.put(order.getOrderId(), order);
        writeOrders(order);
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
        writeOrders(order);
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
        

        Order OrderFromFile = new Order();
        
        OrderFromFile.setOrderId(Integer.parseInt(orderId));
        OrderFromFile.setCustomerName(OrderTokens[1]);
        OrderFromFile.setState(OrderTokens[2]);

        BigDecimal taxRate = new BigDecimal(OrderTokens[3]);
        OrderFromFile.setTaxRate(taxRate);
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

        String formattedDate = date.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        String nameOfFile = "Orders_" + formattedDate + ".txt";

        try {
            scanner
                    = new Scanner(
                            new BufferedReader(
                                    new FileReader(nameOfFile)));
        } catch (FileNotFoundException e) {
            //create a new file if there is not one
            Orders = new HashMap<>();
            return;
        }
        //read first line 
        scanner.nextLine();
        while (scanner.hasNextLine()) {
          String  currentLine = scanner.nextLine();
           Order currentOrder = unmarshallOrder(currentLine);
           Orders.put(currentOrder.getOrderId(), currentOrder);
        }
        scanner.close();
    }

    private String marshallOrder(Order anOrder) {
        String OrderAsText = anOrder.getOrderId() + DELIMITER;
        OrderAsText += anOrder.getCustomerName() + DELIMITER;
        OrderAsText += anOrder.getState() + DELIMITER;
        OrderAsText += anOrder.getTaxRate() + DELIMITER;
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

    private void writeOrders(Order order) throws FlooringPersistenceException {
        PrintWriter out;

//        Order orderForDate = Orders.get(1);
//        LocalDate orderDate = orderForDate.getDate();
        LocalDate orderDate = order.getDate();
        String formattedDate = orderDate.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        String nameOfFile = "Orders_" + formattedDate + ".txt";
        String header = "OrderNumber,CustomerName,State,TaxRate,ProductType,Area,"
                + "CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total";

        try {
            out = new PrintWriter(
                    new FileWriter(nameOfFile));
        } catch (IOException e) {
            throw new FlooringPersistenceException(
                    "Could not save order Data.", e);
        }

        out.println(header);
        for (Order currentOrder : Orders.values()) {
            String orderAsText = marshallOrder(currentOrder);
            out.println(orderAsText);
            out.flush();
        }
        out.close();

    }

    public int getNextId(LocalDate date) throws FlooringPersistenceException {
        int largestId = 0;
        List<Integer> ids = new ArrayList<Integer>(Orders.keySet());
        for (int currentId : ids) {
            if (largestId < currentId) {
                largestId = currentId;
            }
        }
        return largestId + 1;
    }

}
