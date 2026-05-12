/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tictactoe;

import com.mycompany.tictactoe.exceptions.IdenticalPlayerNamesException;
import com.mycompany.tictactoe.exceptions.InvalidGridSizeException;
import com.mycompany.tictactoe.exceptions.InvalidNameException;
import com.mycompany.tictactoe.exceptions.InvalidSymbolException;
import com.mycompany.tictactoe.exceptions.InvalidPlayerException;
import com.mycompany.tictactoe.exceptions.InvalidPositionException;
import com.mycompany.tictactoe.exceptions.SquareAlreadyOccupiedException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class Game {
    private int playersNumber = 2;
    private List<Player> players;
    private Grid grid;
    private Player turn;
    public int playedMoves;
    
    //prova
    
    
    
    
    public Game(){
        this.players = new ArrayList<>();
    }
    public Game(Player player1, Player player2) throws InvalidPlayerException, IdenticalPlayerNamesException, InvalidGridSizeException{
        this.players = new ArrayList<>();
        this.setPlayers(player1, player2);
        this.playedMoves = 0;
        this.setTurn();
        this.setGrid();
    }
       



    public void setPlayers(Player player1, Player player2) throws InvalidPlayerException, IdenticalPlayerNamesException{
        //TODO: gestire il caso in cui vengono inseriti due nomi giocatore identici.
        
        if(player1 == null || player2 == null){
            throw new InvalidPlayerException("almeno uno dei giocatori e' null");
        }
        if (player1.getName().equals(player2.getName())){
            throw new IdenticalPlayerNamesException();
        }
        this.players.add(player1);
        this.players.add(player2);
        
    }

    public List<Player> getPlayers() {
        return players;
    }
    

    public Grid getGrid() {
        return grid;
    }

    public void setGrid() throws InvalidGridSizeException{
        this.grid = new Grid(Grid.gridSize);
    }
    public void setGrid(int x, int y) throws InvalidGridSizeException{
        int[] size = {x, y}; 
        this.grid = new Grid(size);
    }

    public Player getTurn() {
        return turn;
    }

    public void setTurn() throws InvalidPlayerException{
        if(this.players.size() < 2 || this.players.size() > 2){
            throw new InvalidPlayerException("Invalid number of players");
        }
        if(this.turn == null){
            this.turn = this.players.get(0);
        }
        
        if(this.players.indexOf(turn)%2 > 0){
            this.turn = this.players.get(0);
        }
        else{
            this.turn = this.players.get(1);
        }

    }
    public Player makeMove(Player p, int x, int y) throws InvalidPositionException, SquareAlreadyOccupiedException, InvalidPlayerException{
        
        Player retvalue = null;

        this.grid.setSquare(x, y, p.getSymbol());
        if(this.grid.checkGrid() != '-'){
            retvalue = this.getTurn();
            return retvalue;
        }
        this.playedMoves++;
        if(this.playedMoves == this.grid.getGrid().length * this.grid.getGrid()[0].length){
            return new Player("pareggio", 'p');
        }
        
        
        this.setTurn();
        return retvalue;
        

    }
    
}

