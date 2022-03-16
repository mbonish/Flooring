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
public class Prod {
    public Prod(String prodType){
        this.prodType = prodType;
    }
    
    
    String prodType;
    BigDecimal costPerSquareFoot;
    BigDecimal LaborCostPerSqaureFoot;

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String productType) {
        this.prodType = productType;
    }

    public BigDecimal getCostPerSquareFoot() {
        return costPerSquareFoot;
    }

    public void setCostPerSquareFoot(BigDecimal costPerSquareFoot) {
        this.costPerSquareFoot = costPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSqaureFoot() {
        return LaborCostPerSqaureFoot;
    }

    public void setLaborCostPerSqaureFoot(BigDecimal LaborCostPerSqaureFoot) {
        this.LaborCostPerSqaureFoot = LaborCostPerSqaureFoot;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.prodType);
        hash = 97 * hash + Objects.hashCode(this.costPerSquareFoot);
        hash = 97 * hash + Objects.hashCode(this.LaborCostPerSqaureFoot);
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
        final Prod other = (Prod) obj;
        if (!Objects.equals(this.prodType, other.prodType)) {
            return false;
        }
        if (!Objects.equals(this.costPerSquareFoot, other.costPerSquareFoot)) {
            return false;
        }
        if (!Objects.equals(this.LaborCostPerSqaureFoot, other.LaborCostPerSqaureFoot)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prod{" + "prodType=" + prodType + ", costPerSquareFoot=" + costPerSquareFoot + ", LaborCostPerSqaureFoot=" + LaborCostPerSqaureFoot + '}';
    }


    
    
}
