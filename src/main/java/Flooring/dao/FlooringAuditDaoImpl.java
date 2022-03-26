/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Flooring.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author mariana.bonish
 */
public class FlooringAuditDaoImpl implements FlooringAuditDao {
    public static final String AUDIT_FILE = "audit.txt";

    @Override
    public void writeauditEntry(String entry) throws FlooringPersistenceException {
     PrintWriter out;
     
     try{
         out = new PrintWriter(
                   new FileWriter(AUDIT_FILE,true));
     }catch(IOException e){
         throw new FlooringPersistenceException("Could not persist Audit information.");
     }
     LocalDateTime timestamp = LocalDateTime.now();
     out.println(timestamp.toString()+ ":" + entry);
     out.flush();
    }
    
    
    
}
