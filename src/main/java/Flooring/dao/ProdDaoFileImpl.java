/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Flooring.dao;

import Flooring.model.Prod;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author mariana.bonish
 */
public class ProdDaoFileImpl implements ProdDao {

    private final String PROD_FILE;

    public ProdDaoFileImpl() {
        PROD_FILE = "Products.txt";

    }

    public ProdDaoFileImpl(String prodFileText) {
        PROD_FILE = prodFileText;
    }
    public static final String DELIMITER = ",";

    private final Map<String, Prod> Prods = new HashMap<>();

    @Override
    public List<Prod> getAllProds() throws FlooringPersistenceException {
        loadProds();
        return new ArrayList<Prod>(Prods.values());

    }

    @Override
    public Prod getProd(String prodType) throws FlooringPersistenceException {
        loadProds();
        return Prods.get(prodType);
    }

    private Prod unmarshallProd(String prodAsText) {
        //split the values into token/pieces
        String[] prodTokens = prodAsText.split(DELIMITER);

        String prodType = prodTokens[0];

        //create a new prod object
        Prod prodFromFile = new Prod(prodType);

        BigDecimal costPerSqFt = new BigDecimal(prodTokens[1]);
        prodFromFile.setCostPerSquareFoot(costPerSqFt);

        BigDecimal laborCostPerSqFt = new BigDecimal(prodTokens[2]);
        prodFromFile.setLaborCostPerSqaureFoot(laborCostPerSqFt);

        return prodFromFile;
    }

    private void loadProds() throws FlooringPersistenceException {
        Scanner scanner;

        try {
            scanner
                    = new Scanner(
                            new BufferedReader(
                                    new FileReader(PROD_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException(
                    "Could not load Product Data", e);
        }

        //need a String for current line and a new prod object
        String currentLine;
        Prod currentProd;

        boolean firstLine = true;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            if (firstLine) {
                firstLine = false;
                continue;
            }
            currentProd = unmarshallProd(currentLine);

            Prods.put(currentProd.getProdType(), currentProd);
        }

    }
}
