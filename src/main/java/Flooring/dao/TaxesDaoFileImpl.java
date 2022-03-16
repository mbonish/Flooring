/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Flooring.dao;

import Flooring.model.Taxes;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
public class TaxesDaoFileImpl implements TaxesDao{
private final String TAXES_FILE;

    public TaxesDaoFileImpl(){
        TAXES_FILE = "taxes.txt";
    }
     public TaxesDaoFileImpl(String taxesTextFile){
        TAXES_FILE = taxesTextFile;
    }

    public static final String DELIMITER = ",";
    
    private final Map<String, Taxes> TaxesMap = new HashMap<>();
    
    @Override
    public Taxes getTax(String stateId) throws TaxesException {
        loadTaxes();
        return TaxesMap.get(stateId);
    }

    @Override
    public List<Taxes> getAllTaxes() throws TaxesException {
        loadTaxes();
        return new ArrayList<Taxes>(TaxesMap.values());
        
    }
    
    private Taxes unmarshallTaxes(String TaxesAsText){
        String[] TaxesTokens = TaxesAsText.split(DELIMITER);
        String stateId = TaxesTokens[0];
        
        Taxes TaxesFromFile = new Taxes(stateId);
        TaxesFromFile.setStateName(TaxesTokens[1]);
        
        BigDecimal taxRate = new BigDecimal(TaxesTokens[2]);
        TaxesFromFile.setTaxRate(taxRate);
        
        return TaxesFromFile;
    }
    private void loadTaxes()throws TaxesException{   
        Scanner scanner;
        
        try{
            scanner = 
                new Scanner(
                    new BufferedReader(
                        new FileReader(TAXES_FILE)));
            }catch (FileNotFoundException e){
                throw new TaxesException(
                "Could not load taxes into memory.",e);
            }
        String currentLine;
        Taxes currentTaxes;
        
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            
            currentTaxes = unmarshallTaxes(currentLine);
            
            TaxesMap.put(currentTaxes.getStateId(), currentTaxes);
        }      
        
    }
    
}
