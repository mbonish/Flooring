/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Flooring.service;

import Flooring.dao.FlooringAuditDao;
import Flooring.dao.FlooringPersistenceException;
import Flooring.dao.OrderDao;
import Flooring.dao.ProdDao;
import Flooring.model.Order;
import Flooring.model.Prod;
import Flooring.model.Taxes;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import Flooring.dao.TaxDao;
import java.util.ArrayList;

/**
 *
 * @author mariana.bonish
 */
public class FlooringServiceImpl implements FlooringService {

    private OrderDao orderDao;
    private ProdDao prodDao;
    private TaxDao taxDao;
    private FlooringAuditDao auditDao;

    public FlooringServiceImpl(OrderDao orderDao, ProdDao prodDao, TaxDao taxDao, FlooringAuditDao auditDao) {
        this.orderDao = orderDao;
        this.prodDao = prodDao;
        this.taxDao = taxDao;
        this.auditDao = auditDao;
    }

//    public void validateCustomerName(Order order) throws FlooringValidationException {
//        if (order.getCustomerName() == null
//                || order.getCustomerName().trim().length() == 0
//                || !order.getCustomerName().matches("^[A-Za-z\\\\s,.`]+$"));
//        throw new FlooringValidationException(""
//                + "ERROR: Customer name may only contain alphanumeric charaters, periods or comas."
//        );
//    }

    public void validateArea(int area) throws FlooringValidationException {
        if (area >= 100) {
            return;
        } else {
            throw new FlooringValidationException("Area must be greater than"
                    + "100ft.");
        }

    }

//validate the date on the order
    public LocalDate validateDate(String dateFromUser) throws FlooringValidationException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate localDate = LocalDate.parse(dateFromUser, formatter);
        //check for format 
        if (!dateFromUser.matches("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$")) {
            throw new FlooringValidationException(
                    "ERROR: Invalid date format-- date must be MM/dd/yyyy.");
        
        } else if (localDate.isBefore(localDate)
                || localDate == LocalDate.now()) {
            throw new FlooringValidationException(""
                    + "ERROR this is not a date in the future.");
        }else return localDate;

    }

    public void validateState(String state) throws FlooringPersistenceException, FlooringValidationException {
        List<Taxes> taxes = taxDao.getAllTaxes();
        for (Taxes tax : taxes) {
            if (tax.getStateId().equals(state)) {
                return;
            }
        }
        throw new FlooringValidationException(
                "No state matching in file.");

    }

    public void validateProd(String prodType) throws FlooringPersistenceException, FlooringValidationException {
        List<Prod> prods = prodDao.getAllProds();
        for (Prod prod1 : prods) {
            if (prod1.getProdType().equals(prodType)) {
                return;
            }
        }
        throw new FlooringValidationException(
                "No prod matching in file");

    }

    public Order validateOrder(Order order) throws FlooringValidationException, FlooringPersistenceException {
//        //*** Might need to be changed check date
//        validateDate(order.getDate());

        // validate customer name 
//        validateCustomerName(order);


        //validate State
        validateState(order.getState());

        //validate that area is greater than 100ft
        validateArea(order.getArea().intValue());
        //validate a valid product type
        validateProd(order.getProductType());
        return order;
    }


    public Order calculateOrder(Order order) throws FlooringPersistenceException {
         
        //Get the tax rate  
        Taxes theRate = taxDao.getTax(order.getState());
        BigDecimal taxRate = theRate.getTaxRate();

        //Get the prodcut
        Prod theProd = prodDao.getProd(order.getProductType());
        BigDecimal costPerSquareFoot = theProd.getCostPerSquareFoot();
        BigDecimal laborCostPerSquareFoot = theProd.getLaborCostPerSqaureFoot();

        //Set tax rate, cost per square foot, labor cost per sqft
        order.setTaxRate(taxRate);
        order.setCostPerSquareFoot(costPerSquareFoot);
        order.setLaborCostPerSquareFoot(laborCostPerSquareFoot);
        //Calculate material cost, labor cost, taxes and total cost

        //material cost = (area * cost per sqFt)
        BigDecimal materialCost = order.getArea().multiply(costPerSquareFoot);

        //laborCost = (area * laborCost per sqFt)
        BigDecimal laborCost = order.getArea().multiply(laborCostPerSquareFoot);

        //taxTotal = (material + labor) * (taxRate/100)
        BigDecimal materialAndLabor = materialCost.add(laborCost);
        BigDecimal oneHundred = new BigDecimal(100);
        BigDecimal tax = order.getTaxRate().multiply(oneHundred);

        BigDecimal taxTotal = materialAndLabor.multiply(taxRate);

        //total = (material cost + labor cost +tax total)
        BigDecimal total = materialCost.add(laborCost).add(taxTotal);

        //Set material cost, labor cost, taxes and total cost
        order.setMaterialCost(materialCost);
        order.setLaborCostTotal(laborCost);
        order.setTax(tax);
        order.setTotal(total);

        return order;

    }

    public void createOrder(Order order) throws FlooringValidationException, FlooringPersistenceException {

        validateOrder(order);
        Order orderBefore = new Order();
        orderBefore.setDate(order.getDate());
        orderBefore.setCustomerName(order.getCustomerName());
        orderBefore.setState(order.getState());
        orderBefore.setArea(order.getArea());

    }
    

//edit order method - where you can have the option to change
//submit order method
//get single order method
//remove order method 
    @Override
    public Order addOrder(Order order) throws FlooringPersistenceException {
        return orderDao.addOrder(order);
        
    }

    @Override
    public Order getOrder(Order order) throws FlooringPersistenceException {
        return orderDao.getOrder(order);

    }

    @Override
    public List<Order> getAllOrders(LocalDate date) throws FlooringPersistenceException {
        return orderDao.getAllOrders(date);

    }

    @Override
    public Order removeOrder(Order order) throws FlooringPersistenceException {
        return orderDao.removeOrder(order);
    }

    @Override
    public Order editOrder(Order order) throws FlooringPersistenceException {
        return orderDao.editOrder(order);
    }
}
