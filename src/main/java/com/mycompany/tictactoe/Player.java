/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tictactoe;
import com.mycompany.tictactoe.exceptions.InvalidNameException;
import com.mycompany.tictactoe.exceptions.InvalidSymbolException;
import java.util.List;

/**
 * Rappresenta un giocatore nel gioco con nome e simbolo associato.
 * @author Fabio
 */
public class Player {
    private String name;
    private char symbol;
    private static final List<Character> validSymbols = List.of('x', 'o');
    
    /**
     * 
     * @param name il nome del giocatore, di almeno 3 caratteri
     * @param symbol il simbolo associato al giocatore (come 'x' oppure 'o')
     * @throws InvalidNameException se il nome non e' lungo almeno 3 caratteri
     * @throws InvalidSymbolException se il simbolo non e' presente nella lista dei simboli consentiti
     */
    public Player(String name, char symbol) throws InvalidNameException, InvalidSymbolException{
        this.setName(name);
        this.setSymbol(symbol);
    }
    
    public String getName() {
        return name;
    }
    /**
     * Accetta in input una stringa di almeno 3 caratteri, altrimenti lancia un'eccezione.
     * @param name il nome del giocatore, deve avere almeno 3 caratteri
     * @throws InvalidNameException se il nome non e' lungo almeno 3 caratteri
     */
    public void setName(String name) throws InvalidNameException{
        if(name.length() < 3){
            throw new InvalidNameException("Name is too short");
        }
        this.name = name;
    }
    
    public char getSymbol() {
        return symbol;
    }
    /**
     * assegna un simbolo di gioco al giocatore accertandosi che il simbolo sia presente nella lista di simboli consentiti.
     * al momento la lista viene inizializzata direttamente a livello di proprieta', e consente esclusivamente i simboli 'x' e 'o'.
     * @param symbol il simbolo che si vuole assegnare al giocatore da inserire nelle caselle (come 'x' o 'o')
     * @throws InvalidSymbolException symbol non e' presente nella lista dei simboli consentiti.
     */
    public void setSymbol(char symbol) throws InvalidSymbolException {
        if(!Player.validSymbols.contains(symbol)){
            throw new InvalidSymbolException();
        }
        this.symbol = symbol;
    }
    
    
}
