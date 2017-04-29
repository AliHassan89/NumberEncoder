/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.numberencoder;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ali
 */
public class Mapper 
{
    private final Map<Character, Character> mappings;
    
    public Mapper()
    {
        mappings = new HashMap<>();
        initializeMappings();
    }
    
    public char getMappedNumber(char alphabet)
    {
        return mappings.get(alphabet);
    }
    
    private void initializeMappings()
    {
        mappings.put('e', '0');
        
        mappings.put('j', '1');
        mappings.put('n', '1');
        mappings.put('q', '1');
        
        mappings.put('r', '2');
        mappings.put('w', '2');
        mappings.put('x', '2');
        
        mappings.put('d', '3');
        mappings.put('s', '3');
        mappings.put('y', '3');
        
        mappings.put('f', '4');
        mappings.put('t', '4');
        
        mappings.put('a', '5');
        mappings.put('m', '5');
        
        mappings.put('c', '6');
        mappings.put('i', '6');
        mappings.put('v', '6');
        
        mappings.put('b', '7');
        mappings.put('k', '7');
        mappings.put('u', '7');
        
        mappings.put('l', '8');
        mappings.put('o', '8');
        mappings.put('p', '8');
        
        mappings.put('g', '9');
        mappings.put('h', '9');
        mappings.put('z', '9');
    }
}
