/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.scd.lab9;

import java.util.HashMap;

/**
 *
 * @author Abdul Ahad
 */
public class WordCounter implements Runnable{
    
    HashMap<String, Integer> wordCount;
    String[] words;
    
    WordCounter(){
        wordCount = new HashMap<>();
    }
    public void setLine(String[] words){
        this.words = words;
    }
    
    @Override
    public void run(){
        
        for (int i = 0; i < words.length; i++){
            if (!(words[i].charAt(words[i].length() - 1) >= 65 && words[i].charAt(words[i].length() - 1) <= 90) &&
                    !(words[i].charAt(words[i].length() - 1) >= 97 && words[i].charAt(words[i].length() - 1) <= 122)){
                
                words[i] = words[i].substring(0, words[i].length() - 1);
            
                
            }
            if (wordCount.containsKey(words[i])){
                int value = wordCount.get(words[i]);
                wordCount.put(words[i], value + 1);
            }
            else{
                wordCount.put(words[i], 1);
            }
        }
    } 
    
    public HashMap<String, Integer> getWordCount(){
        return wordCount;
    }
}
