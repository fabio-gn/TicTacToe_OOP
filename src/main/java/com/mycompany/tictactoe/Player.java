/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tictactoe;
import com.mycompany.tictactoe.exceptions.InvalidNameException;
import com.mycompany.tictactoe.exceptions.InvalidSymbolException;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class Player {
    private String name;
    private char symbol;
    private static final List<Character> validSymbols = List.of('x', 'o', 'p');

    public Player(String name, char symbol) throws InvalidNameException, InvalidSymbolException{
        this.setName(name);
        this.setSymbol(symbol);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidNameException{
        if(name.length() < 3){
            throw new InvalidNameException("Name is too short");
        }
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) throws InvalidSymbolException {
        if(!Player.validSymbols.contains(symbol)){
            throw new InvalidSymbolException();
        }
        this.symbol = symbol;
    }
    
    
}
