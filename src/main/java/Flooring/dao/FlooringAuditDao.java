/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Flooring.dao;

/**
 *
 * @author mariana.bonish
 */
public interface FlooringAuditDao {
    public void writeauditEntry(String entry) throws FlooringPersistenceException ;
}
