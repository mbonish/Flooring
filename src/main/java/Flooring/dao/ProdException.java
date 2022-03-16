/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Flooring.dao;

/**
 *
 * @author mariana.bonish
 */
public class ProdException extends Exception {
    public ProdException(String message){
        super(message);
    }
    
    public ProdException(String message, Throwable cause){
        super(message, cause);
    }
    
}
