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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



/**
 *
 * @author mariana.bonish
 */
public class OrderDaoFileImpl implements OrderDao {
    
    @Override
    public Order addOrder(Order order) throws OrderException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Order getOrder(Order order) throws OrderException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Order> getAllOrders() throws OrderException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Order removeOrder(int orderId) throws OrderException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Order editOrder(int orderId) throws OrderException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    final static String DELIMITER = ",";
    private File orderFile;
    
   private final Map<Integer, Order> Orders = new HashMap<>();

    
    private Order unmarshallOrder(String OrderAsText){
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
    
    private void loadOrders(File file) throws OrderException{
        Scanner scanner;
        
        try{
            scanner = 
                new Scanner(
                    new BufferedReader(
                        new FileReader(file)));
        }catch(FileNotFoundException e){
            throw new OrderException
                    ("Could not load Order into memoery",e);
        }
        String currentLine;
        Order currentOrder;
        
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            
            currentOrder = unmarshallOrder(currentLine);
            
            Orders.put(currentOrder.getOrderId(), currentOrder);
        }
    }
    
    private String marshallOrder(Order anOrder){
        String OrderAsText = anOrder.getOrderId() + DELIMITER;
        OrderAsText += anOrder.getCustomerName() + DELIMITER;
        OrderAsText += anOrder.getState()+ DELIMITER;
        OrderAsText += anOrder.getTax()+ DELIMITER;
        OrderAsText += anOrder.getProductType() + DELIMITER;
        OrderAsText += anOrder.getArea() + DELIMITER;
        OrderAsText += anOrder.getCostPerSquareFoot() + DELIMITER;
        OrderAsText += anOrder.getLaborCostPerSquareFoot() + DELIMITER;
        OrderAsText += anOrder.getMaterialCost() + DELIMITER;
        OrderAsText += anOrder.getLaborCostTotal()+ DELIMITER;
        OrderAsText += anOrder.getTax()+ DELIMITER;
        OrderAsText += anOrder.getTotal();
        
        return OrderAsText;
                
    }
    
    private void writeOrders(File file) throws OrderException{
        PrintWriter out;
        
        try{
            out = new PrintWriter(
                    new FileWriter(file));
        }catch(IOException e){
            throw new OrderException(
            "Could not save order Data.", e);
        }
        
        String orderAsText;
        List<Order> orderList =this.getAllOrders();
        for(Order currentOrder: orderList){
            orderAsText = marshallOrder(currentOrder);
            out.println(orderAsText);
            out.flush();
        }
        out.close();
        
    }
}
