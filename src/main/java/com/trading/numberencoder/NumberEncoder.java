/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.numberencoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ali
 */
public class NumberEncoder 
{
    private static Dictionary dictionary;
    
    public static void main(String[] args) 
    {
        String dictionaryPath, numbersPath;
        if(args.length == 2)
        {
            dictionaryPath = args[0];
            numbersPath = args[1];
        }
        else
        {
            dictionaryPath = "src\\main\\java\\com\\trading\\inputfiles\\dictionary.txt";
            numbersPath = "src\\main\\java\\com\\trading\\inputfiles\\input.txt";
        }
        createDictionary(dictionaryPath);
        encodeNumbers(numbersPath);
        
    }
    
    private static void createDictionary(String path)
    {
        dictionary = new Dictionary();
        try(BufferedReader br = new BufferedReader(new FileReader(path))) 
        {
            for(String word; (word = br.readLine()) != null;) 
            {
                dictionary.addWord(word);
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
    
    private static void encodeNumbers(String path)
    {
        Encoder phoneNumberEncoder = new Encoder(dictionary);
        
        try(BufferedReader br = new BufferedReader(new FileReader(path))) 
        {
            for(String numberToBeEncoded; (numberToBeEncoded = br.readLine()) != null;) 
            {
                ArrayList<String> encodedNumbers = phoneNumberEncoder.encode(numberToBeEncoded);
                printEncodedNumbers(numberToBeEncoded, encodedNumbers);
            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
    
    private static void printEncodedNumbers(String number, ArrayList<String> encodedNumbers)
    {
        for (String encodedNumber : encodedNumbers) 
        {
            System.out.println(number+": " + encodedNumber);
        }
    }
}
