/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tictactoe.view;

import com.mycompany.tictactoe.Game;
import com.mycompany.tictactoe.Grid;
import com.mycompany.tictactoe.Player;
import com.mycompany.tictactoe.exceptions.IdenticalPlayerNamesException;
import com.mycompany.tictactoe.exceptions.InvalidCoordinatesException;
import com.mycompany.tictactoe.exceptions.InvalidNameException;
import com.mycompany.tictactoe.exceptions.InvalidPlayerException;
import com.mycompany.tictactoe.exceptions.InvalidPositionException;
import com.mycompany.tictactoe.exceptions.InvalidSymbolException;
import com.mycompany.tictactoe.exceptions.SquareAlreadyOccupiedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabio
 */
public class Shell {
    private Game game;
    private String prompt = "TicTacToe>";
    private HashMap<String, String> errors;
    private List<String> commands;
    private List<String> validCoordinates;
    private String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    
    public Shell(){
        this.commands = new ArrayList<>();
        this.validCoordinates = new ArrayList<>();
        this.generateValidCoordinates();
        this.errors = new HashMap<>();
        this.game = new Game();
    }
    
    public void initialize() throws InvalidNameException, InvalidPlayerException, InvalidSymbolException, IdenticalPlayerNamesException {
        Scanner sc = new Scanner(System.in);

            System.out.println("Inserisci il nome del giocatore 1: ");
            String name1 = sc.nextLine();
            Player player1 = new Player(name1, 'o');
            System.out.println("Inserisci il nome del giocatore 2: ");
            String name2 = sc.nextLine();
            Player player2 = new Player(name2, 'x');
            this.game.setPlayers(player1, player2);
            

              
        
    }
    public void inputReader(){
        while(this.game.getPlayers().isEmpty()){
            try {
                this.initialize();
            } catch (InvalidPlayerException ex) {
                System.out.println(ex);
                System.out.println("riprova");
            } catch (IdenticalPlayerNamesException ex) {
                System.out.println("i giocatori non possono avere lo stesso nome, riprova. ");
            }
        }
        
        Scanner reader = new Scanner(System.in);
        String userInput = null;
        
        while(!userInput.toLowerCase().strip().equals("exit")){
            Player currentPlayer = game.getTurn();
            System.out.println("TicTacToe/" + currentPlayer.getName() + ">");
            userInput = reader.nextLine();
            //TODO: serve una funzione per che converta A1, B2 e coordinate simili in indici di array multidimensionale
            //il prompt che viene chiesto all'utente e' proprio quello.
            
            if(!this.validCoordinates.contains(userInput.toUpperCase())){
                System.out.println("mossa non valida: riprova.");
                continue;
            }
            
            try {
                int[] coordinates = this.convertCoordinateToIndex(userInput);
                game.makeMove(currentPlayer, coordinates[0], coordinates[1]);
            } catch (InvalidCoordinatesException ex) {
                System.out.println("mossa non valida: riprova.");
                continue;
            } catch (InvalidPositionException ex) {
                System.out.println("mossa non valida: riprova.");
            } catch (SquareAlreadyOccupiedException ex) {
                System.out.println("quadrato gia' occupato, riprova.");
                continue;
            }
        } 
    }
    private int[] convertCoordinateToIndex(String coordinate) throws InvalidCoordinatesException{
        
        int[] retvalue = new int[2];
        if(!this.validCoordinates.contains(coordinate.toUpperCase())){
            throw new InvalidCoordinatesException();
        }
        retvalue[0] = this.letters.indexOf(coordinate.toUpperCase().charAt(0));
        retvalue[1] = Character.getNumericValue(coordinate.charAt(1)) - 1;
        return retvalue;
        
    }
    private void generateValidCoordinates(){
        char[][] grid = this.game.getGrid().getGrid();
        for (int i = 0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                this.validCoordinates.add("" + this.letters.charAt(i) + (j+1));
            }
        }
    }
}
