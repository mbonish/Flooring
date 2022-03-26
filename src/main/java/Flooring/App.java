package Flooring;


import Flooring.controller.FlooringController;
import Flooring.dao.FlooringPersistenceException;
import Flooring.service.FlooringValidationException;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mariana.bonish
 */
public class App {
    public static void main(String[] Args) throws FlooringValidationException, FlooringPersistenceException{
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringController controller = 
           ctx.getBean("controller", FlooringController.class);
        controller.run();
    }
}
