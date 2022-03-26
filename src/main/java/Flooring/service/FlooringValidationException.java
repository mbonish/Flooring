/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Flooring.service;

/**
 *
 * @author mariana.bonish
 */
public class FlooringValidationException extends Exception {
    
    public FlooringValidationException(String message){
        super(message);
    }
    
    public FlooringValidationException(String message, Throwable cause){
        super(message, cause);
    }
    
}
