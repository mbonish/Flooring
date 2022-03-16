/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Flooring.dao;

/**
 *
 * @author mariana.bonish
 */
public class OrderException extends Exception {
    public OrderException (String message){
        super(message);
    }
    
    public OrderException(String message, Throwable cause){
        super(message, cause);
    }
}
