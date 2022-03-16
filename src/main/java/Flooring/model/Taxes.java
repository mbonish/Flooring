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
public class Taxes {
    public Taxes(String stateId){
        this.stateId = stateId;
    }
    String stateId;
    String stateName;
    BigDecimal taxRate;

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.stateId);
        hash = 11 * hash + Objects.hashCode(this.stateName);
        hash = 11 * hash + Objects.hashCode(this.taxRate);
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
        final Taxes other = (Taxes) obj;
        if (!Objects.equals(this.stateId, other.stateId)) {
            return false;
        }
        if (!Objects.equals(this.stateName, other.stateName)) {
            return false;
        }
        return Objects.equals(this.taxRate, other.taxRate);
    }

    @Override
    public String toString() {
        return "Taxes{" + "stateId=" + stateId + ", stateName=" + stateName + ", taxRate=" + taxRate + '}';
    }


    
}
