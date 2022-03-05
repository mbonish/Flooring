/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flooring.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author mariana.bonish
 */
public class Orders {
    String customerName;
    BigDecimal area;
    BigDecimal materialCost;
    BigDecimal total;
    

    BigDecimal tax;
    BigDecimal taxRate;

 
    String productType;
    BigDecimal costPerSquareFoot;
    BigDecimal laborCostPerSquareFoot;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.orderNumber;
        hash = 67 * hash + Objects.hashCode(this.customerName);
        hash = 67 * hash + Objects.hashCode(this.area);
        hash = 67 * hash + Objects.hashCode(this.materialCost);
        hash = 67 * hash + Objects.hashCode(this.total);
        hash = 67 * hash + Objects.hashCode(this.tax);
        hash = 67 * hash + Objects.hashCode(this.taxRate);
        hash = 67 * hash + Objects.hashCode(this.productType);
        hash = 67 * hash + Objects.hashCode(this.costPerSquareFoot);
        hash = 67 * hash + Objects.hashCode(this.laborCostPerSquareFoot);
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
        final Orders other = (Orders) obj;
        if (this.orderNumber != other.orderNumber) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.productType, other.productType)) {
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
        return true;
    }
    int orderNumber;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
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

    @Override
    public String toString() {
        return "Orders{" + "customerName=" + customerName + ", area=" + area + ", materialCost=" + materialCost + ", total=" + total + ", tax=" + tax + ", taxRate=" + taxRate + ", productType=" + productType + ", costPerSquareFoot=" + costPerSquareFoot + ", laborCostPerSquareFoot=" + laborCostPerSquareFoot + ", orderNumber=" + orderNumber + '}';
    }
    
}
