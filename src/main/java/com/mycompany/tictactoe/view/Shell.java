/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tictactoe.view;

import com.mycompany.tictactoe.Game;
import com.mycompany.tictactoe.Player;
import com.mycompany.tictactoe.exceptions.IdenticalPlayerNamesException;
import com.mycompany.tictactoe.exceptions.InvalidNameException;
import com.mycompany.tictactoe.exceptions.InvalidPlayerException;
import com.mycompany.tictactoe.exceptions.InvalidSymbolException;
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
    public Shell(){
        this.commands = new ArrayList<>();
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
        Scanner sc = new Scanner(System.in);
        while(this.game.getPlayers().contains(null)){
            try {
                this.initialize();
            } catch (InvalidPlayerException ex) {
                System.out.println(ex);
                System.out.println("riprova");
            } catch (IdenticalPlayerNamesException ex) {
                System.out.println("i giocatori non possono avere lo stesso nome, riprova. ");
            }
            Scanner reader = new Scanner(System.in);
            String userInput = null;
        }
        
        Scanner reader = new Scanner(System.in);
        String userInput = null;
        
        do{
            Player currentPlayer = game.getTurn();
            System.out.println("TicTacToe/" + currentPlayer.getName() + ">");
            userInput = reader.nextLine();
            //TODO: serve una funzione per che converta A1, B2 e coordinate simili in indici di array multidimensionale
            //il prompt che viene chiesto all'utente e' proprio quello.
            
            switch(userInput){
                case "o":
                    game.makeMove(currentPlayer, 0, 0); // qui insieriamo gli indici x array multidimensionale
                break;
                case "x":
                break;
                       
            }
            
            
        } while(!userInput.toLowerCase().strip().equals("exit"));
    }
}
