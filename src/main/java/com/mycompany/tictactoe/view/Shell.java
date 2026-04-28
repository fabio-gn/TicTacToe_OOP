/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tictactoe.view;

import com.mycompany.tictactoe.Game;
import com.mycompany.tictactoe.Player;
import com.mycompany.tictactoe.exceptions.InvalidNameException;
import com.mycompany.tictactoe.exceptions.InvalidPlayerException;
import com.mycompany.tictactoe.exceptions.InvalidSymbolException;
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
    public Shell(){
        this.game = new Game();
    }
    
    public void initialize(){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Inserisci il nome del giocatore 1: ");
            String name1 = sc.nextLine();
            Player player1 = new Player(name1, 'o');
            System.out.println("Inserisci il nome del giocatore 2: ");
            String name2 = sc.nextLine();
            Player player2 = new Player(name2, 'x');
            this.game.setPlayers(player1, player2);
            
        } catch (InvalidNameException ex) {
            System.out.println(ex);
        } catch (InvalidSymbolException ex) {
            Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidPlayerException ex) {
            Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        
    }
    public void inputReader(){
        Scanner sc = new Scanner(System.in);
        this.initialize();
        while(true){
            
            
        }
    }
}
