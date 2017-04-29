/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.numberencoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ali
 */
public class Dictionary 
{
    private final Map<String, ArrayList<String>> dictionary;
    private final Mapper mapper;
    
    public Dictionary()
    {
        dictionary = new HashMap<>();
        mapper = new Mapper();
    }
    
    /**
     * Creates a hashMap where key is number which is created by word and value
     * is number. E.g from dictionary.txt file function receives word "mir".
     * Based on mapper a number will be created which will be "562". This number
     * will be key of hashMap where the word will be value.
     * @param word 
     */
    public void addWord(String word)
    {
        String correspondingNumber = "";
        ArrayList<String> wordList;
        String noSpecialCharInWord = word.replaceAll("[^A-Za-z]+", "").toLowerCase();
        int wordLen = noSpecialCharInWord.length();
        
        for(int i=0; i<wordLen; i++)
        {
            correspondingNumber += mapper.getMappedNumber(noSpecialCharInWord.charAt(i));
        }
        
        if(dictionary.get(correspondingNumber) != null)
        {
            wordList = dictionary.get(correspondingNumber);
        }
        else
        {
            wordList = new ArrayList<>();
            dictionary.put(correspondingNumber, wordList);
        }
        
        wordList.add(word);
    }
    
    //Based on hashMap created in function addWord, this function checks for
    //number(key) in hashMap and returns corressponding arrayList.
    
    public ArrayList<String> getWordListForNumber(String number)
    {
        if(dictionary == null)
            return null;
        
        ArrayList<String> wordsList = dictionary.get(number);
        
        if(wordsList == null || wordsList.isEmpty())
        {
            wordsList = new ArrayList<>();
            wordsList.add(number);
            return wordsList;
        }
        
        return wordsList;
    }
}
