/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.numberencoder;

/**
 *
 * @author Ali
 */
public class EncodingRules 
{    
    
    /**
     * checks for consecutive characters in encoded value
     * @param encodedValue
     * @return true if consecutive characters are not digits else false
     */
    public boolean subSequentCharRule(String encodedValue)
    {
        if(encodedValue == null || encodedValue.isEmpty())
            return false;
        
        //remove all spaces
        encodedValue = encodedValue.replaceAll(" ", "");
        
        boolean prevCharIsDigit = false;
        
        for(int i=0; i < encodedValue.length(); i++)
        {
            if(Character.isDigit(encodedValue.charAt(i)) && prevCharIsDigit)
            {
                return false;
            }
            else
            {
                prevCharIsDigit = false;
            }
            if(Character.isDigit(encodedValue.charAt(i)))
            {
                prevCharIsDigit = true;
            }
        }
        
        return true;
    }
    
    /**
     * length of number and encoded value must be same where number contains
     * digits only and encoded value contains alphabets and digits only
     * 
     * @param encodedValue
     * @param number number string containing only digits
     * @return true if lengths of both arguments are equal
     */
    public boolean compareLenghtsRule(String encodedValue, String number)
    {
        return encodedValue.replaceAll("[^A-Za-z0-9]+", "").length() == number.length();
    }
}
