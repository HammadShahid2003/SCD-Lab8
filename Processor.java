/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.scd.lab9;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdul Ahad
 */
public class Processor implements Runnable{
    
    WordCounter counter;
    String chunk;
    Processor(WordCounter counter, String chunk){
        this.counter = counter;
        this.chunk = chunk;
    }
    
    @Override
    public void run(){
        
        String[] words = chunk.split("\\s+");
        counter.setLine(words);
        Thread myCounter = new Thread(counter);        
        myCounter.start();
        try {
            myCounter.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
