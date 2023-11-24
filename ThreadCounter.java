/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.scd.lab9;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 *
 * @author Abdul Ahad
 */



public class ThreadCounter {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        Path p = Path.of("sample.txt");
        String s = Files.readString(p);
        String[] array = s.split("\n");
        
        ArrayList<String> fileChunks = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            array[i] = array[i].trim();
            if (array[i].length() > 0){
                fileChunks.add(array[i]);
            }
        }
        
        Thread[] threads = new Thread[fileChunks.size()];
        WordCounter counter = new WordCounter();
        
        for (int i = 0; i < fileChunks.size(); i++){
            threads[i] = new Thread(new Processor(counter, fileChunks.get(i)));
            threads[i].start();
            threads[i].join();
        }
        

        
        counter.getWordCount().forEach((word, count) ->
                System.out.println(word + ": " + count));
    }
    
}
