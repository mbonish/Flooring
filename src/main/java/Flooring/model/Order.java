/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Flooring.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author mariana.bonish
 */
public class Order {
    
    int orderId;
    LocalDate date; 
    String customerName;
    BigDecimal area;
    BigDecimal materialCost;
    BigDecimal total;
    
    String state;
    BigDecimal tax;
    BigDecimal taxRate;

 
    String productType;
    BigDecimal costPerSquareFoot;
    BigDecimal laborCostPerSquareFoot;
    BigDecimal laborCostTotal;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public void setCostPerSquareFoot(BigDecimal costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    public void setLaborCostPerSquareFoot(BigDecimal laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    public BigDecimal getLaborCostTotal() {
        return laborCostTotal;
    }

    public void setLaborCostTotal(BigDecimal laborCostTotal) {
        this.laborCostTotal = laborCostTotal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.orderId;
        hash = 31 * hash + Objects.hashCode(this.date);
        hash = 31 * hash + Objects.hashCode(this.customerName);
        hash = 31 * hash + Objects.hashCode(this.area);
        hash = 31 * hash + Objects.hashCode(this.materialCost);
        hash = 31 * hash + Objects.hashCode(this.total);
        hash = 31 * hash + Objects.hashCode(this.state);
        hash = 31 * hash + Objects.hashCode(this.tax);
        hash = 31 * hash + Objects.hashCode(this.taxRate);
        hash = 31 * hash + Objects.hashCode(this.productType);
        hash = 31 * hash + Objects.hashCode(this.costPerSquareFoot);
        hash = 31 * hash + Objects.hashCode(this.laborCostPerSquareFoot);
        hash = 31 * hash + Objects.hashCode(this.laborCostTotal);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.orderId != other.orderId) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.productType, other.productType)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.materialCost, other.materialCost)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        if (!Objects.equals(this.tax, other.tax)) {
            return false;
        }
        if (!Objects.equals(this.taxRate, other.taxRate)) {
            return false;
        }
        if (!Objects.equals(this.costPerSquareFoot, other.costPerSquareFoot)) {
            return false;
        }
        if (!Objects.equals(this.laborCostPerSquareFoot, other.laborCostPerSquareFoot)) {
            return false;
        }
        return Objects.equals(this.laborCostTotal, other.laborCostTotal);
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", date=" + date + ", customerName=" + customerName + ", area=" + area + ", materialCost=" + materialCost + ", total=" + total + ", state=" + state + ", tax=" + tax + ", taxRate=" + taxRate + ", productType=" + productType + ", costPerSquareFoot=" + costPerSquareFoot + ", laborCostPerSquareFoot=" + laborCostPerSquareFoot + ", laborCostTotal=" + laborCostTotal + '}';
    }




    
    
    
    
}
