/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.numberencoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Ali
 */
public class Encoder 
{
    private final Dictionary dictionary;
    private final EncodingRules rules;
    private static final int NUM_MAX_LEN = 18;
    
    public Encoder(Dictionary dictionary)
    {
        this.dictionary = dictionary;
        rules = new EncodingRules();
    }
    
    
    /**
     * encode number based on defined rules and provided dictionary
     * @param number
     * @return array list of encoded numbers
     */
    public ArrayList<String> encode(String number)
    {
        ArrayList<String> allEncodedValues = new ArrayList<>();
        number = number.replaceAll("[^0-9]", "");
        ArrayList<String> combinations = createCombinations(number);
        ArrayList<String> encodedValues;
        ArrayList<String> splittedEncodedValues;
        String[] splittedCombinations;
        
        //for every combination check if there exiist a encoded value
        for(String combination : combinations)
        {
            encodeCombination:
            {            
                splittedCombinations = combination.split(" ");
                encodedValues = new ArrayList<>();
                splittedEncodedValues = new ArrayList<>();

                for(String splittedValue : splittedCombinations)
                {
                    ArrayList<String> wordList = dictionary.getWordListForNumber(splittedValue);
                    if(wordList != null)
                    {
                        for(String word : wordList)
                        {
                            if(!rules.subSequentCharRule(word))
                            {
                                break encodeCombination;
                            }
                        }
                        if(!encodedValues.isEmpty())
                        {
                            for(String splittedEncodedValue : encodedValues)
                            {
                                for(String word : wordList)
                                {
                                    String encodedStr = splittedEncodedValue + " " + word;
                                    if(!rules.subSequentCharRule(encodedStr))
                                    {
                                        break encodeCombination;
                                    }
                                    splittedEncodedValues.add(encodedStr);
                                }
                            }
                        }
                        else
                        {
                            encodedValues.addAll(wordList);
                        }

                        if(!splittedEncodedValues.isEmpty())
                        {
                            encodedValues.clear();
                            for(String encodedValue : splittedEncodedValues)
                            {
                                encodedValues.add(encodedValue);
                            }
                        }
                    }
                }

                for(String encodedValue : encodedValues)
                {
                    if(rules.compareLenghtsRule(encodedValue, number))
                    {
                        allEncodedValues.add(encodedValue);
                    }
                }
            }
        }
        
        return allEncodedValues;
    }
    
    /**
     * creates all possible combinations of a given number. Combinations are
     * space separated.
     * @param number
     * @return array list of all combinations of given number
     */
    private ArrayList<String> createCombinations(String number)
    {
        ArrayList<String> combinations = new ArrayList<>();
        ArrayList<String> binaries = getSpacePositions(number.length());
        
        for(String binary : binaries)
        {
            String numCombination = number;
            int spaceIndex;
            int j = -1;
            for(int i=0; i<number.length(); i++)
            {
                if(binary.charAt(i) == '1')
                {
                    j++;
                    spaceIndex = i + j;
                    numCombination = numCombination.substring(0,spaceIndex) + " " + numCombination.substring(spaceIndex, numCombination.length());
                }
            }
            combinations.add(numCombination);
        }
        
        return combinations;
    }
    
    //Creates all possible binaries of lenghth n. We only require half number of
    //binaries for any given lenght.
    /**
     * Finds all possible space positions.
     * @param n length of number
     * @return array list of strings containing 1s and 0s where 1 indicates
     * position of a space character
     */
    private ArrayList<String> getSpacePositions(int n)
    {
        ArrayList<String> spacePositions = new ArrayList<>();
        if(n > NUM_MAX_LEN)
        {
            return spacePositions;
        }
        
        //2^n/2 max number of space positions
        double maxSpacePositions = 2<<(n-1);
        
        final long max = 1 << n;
        for (long i = 0; i < max; i++) 
        {
            long currentNumber = i;
            final char[] buffer = new char[n];
            int bufferPosition = buffer.length;
            
            while (bufferPosition > 0) 
            {
                buffer[--bufferPosition] = (char) (48 + (currentNumber & 1));
                currentNumber >>>= 1;
            }
            
            String spacePosition = Arrays.toString(buffer);
            spacePosition = spacePosition.replaceAll("[^0-9]", "");
            spacePositions.add(spacePosition);
            if(spacePositions.size() >= maxSpacePositions)
                break;
        }
        
        return spacePositions;
    }    
}