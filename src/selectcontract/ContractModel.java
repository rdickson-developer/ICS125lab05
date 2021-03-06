/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectcontract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ryandickson
 */
public class ContractModel {
    
    private ArrayList<Contract> theContracts;
    private int contractCounter;
    
    public ContractModel() {
        contractCounter = 0;
        theContracts = new ArrayList<>();
        
         try {
            String filename = "src/selectcontract/contracts.txt";
            FileReader fileReader = new FileReader(filename);
            
            // Always wrap FileRader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            
            // While loop to read each line of the data file until end of file
            while((line = bufferedReader.readLine()) != null){
                
                // Split the line containing contract information into four 
                // elemnets in a String array named tokens
                String[] tokens = line.split(",", Contract.NUMBER_OF_CONTRACT_ATTRIBUTES);
                
                String contractID = tokens[Contract.INDEX_OF_CONTRACT_ID];
                String originCity = tokens[Contract.INDEX_OF_ORIGIN_CITY];
                String destCity = tokens[Contract.INDEX_OF_DEST_CITY];
                String orderItem = tokens[Contract.INDEX_OF_ORDER_ITEM];
                
                // Construc a new contract object with the token information
                Contract dataContract = new Contract(contractID
                , originCity
                , destCity
                , orderItem);
                
                // add this new contract object to the arraylist
                theContracts.add(dataContract); 
            }
            
            // Always close files.
            fileReader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    boolean foundContracts(){
        if (theContracts.size() > 0){
            return true;
        } else {
            return false;
        }    
    }
    
    public Contract getTheContract(){
        return theContracts.get(contractCounter);
    }
    
    public int getContractCount(){
        return theContracts.size();
    }
    
    public int getCurrentContractNum(){
        return contractCounter;
    }
    
    public void nextContract(){
        if(contractCounter < theContracts.size()){
            contractCounter++;
        }
    }
    public void prevContract(){
        if(contractCounter > 0){
            contractCounter--;
        }
    }
}
