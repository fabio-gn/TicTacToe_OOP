/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tictactoe;

import com.mycompany.tictactoe.exceptions.InvalidGridSizeException;
import com.mycompany.tictactoe.exceptions.InvalidPositionException;
import com.mycompany.tictactoe.exceptions.SquareAlreadyOccupiedException;
import java.util.ArrayList;

/**
 *
 * @author Fabio
 */
public class Grid {
    protected static int[] gridSize = {3,3};
    private char[][] grid;
    
    public Grid() throws InvalidGridSizeException{
        this.setGrid(Grid.gridSize);
    }
    public Grid(int[]size) throws InvalidGridSizeException{
        this.setGrid(size);
    }

    public char[][] getGrid() {
        return this.grid;
    }

    protected void setGrid(int[] size) throws InvalidGridSizeException{
        if(size.length != 2){
           throw new InvalidGridSizeException("la griglia deve avere due dimensioni, altezza e larghezza");
        }
        if(size[0] < 3 || size[1] < 3 ){
            throw new InvalidGridSizeException("la griglia deve essere almeno 3x3");
        }
        this.grid = new char[size[0]][size[1]];
        for(int i=0; i<size[0]; i++){
            for(int j=0; j<size[1]; j++){
                
                this.grid[i][j] = '-';
            }
        }
    }
    
    protected char checkGrid(){

        char result = this.checkRow();
        if(result != '-'){
            return result;
        }
        result = this.checkColumn();
        if(result != '-'){
            return result;
        }
        return this.checkDiagonal();
    }
    
    
    private char checkRow(){
        for(int i=0; i<this.grid.length; i++){
            boolean[] check = new boolean[this.grid[i].length];
            for(int j=1; j<this.grid[i].length; j++){
                if(this.grid[i][j] != '-' && this.grid[i][j] == this.grid[i][j-1]){
                   check[j-1] = true;
                   check[j] = true;
                    continue;
                }
            }
            if(this.checkForTrues(check)){
                return this.grid[i][0];
            }
        }
        return '-';
    }
    private boolean checkForTrues(boolean[] bools){
        for(int i=0; i<bools.length; i++){
            if(!bools[i]){
                return false;
            }
        }
        return true;
    }
    private char checkColumn(){
        for(int i=0; i<this.grid.length; i++){
            boolean[] checks = new boolean[this.grid[i].length];
            for(int j=1; j<grid[0].length; j++){
                if(this.grid[j][i] != '-' && this.grid[j][i] == this.grid[j-1][i]){
                   checks[i-1] = true;
                   checks[i] = true;
                    
                }

                
            }
            if(this.checkForTrues(checks)){
                return grid[0][i];
            }
        }
        return '-';
    }
    private char checkDiagonal(){
        boolean[] checks = new boolean[3];
        for(int i=1; i<this.grid.length; i++){
            if(grid[i][i] != '-' && grid[i][i] == grid[i-1][i-1]){
                checks[i-1] = true;
                checks[i] = true;
            }

        }
        if(this.checkForTrues(checks)){
            return this.grid[0][0];
        }
        
        checks = new boolean[3];
        for(int i=1; i<this.grid.length; i++){
            int j = (this.grid.length - 1) - i;
            if(this.grid[i][j] != '-' && this.grid[i][j] == this.grid[i-1][j+1]){
                checks[i-1] = true;
                checks[i] = true;
            }

        }
        if(this.checkForTrues(checks)) {
            return this.grid[0][2];
        }


        return '-';
    }
    
    private void validatePosition(int x, int y) throws InvalidPositionException{
        if(x < 0 || x >= this.grid.length){
            throw new InvalidPositionException("valore x troppo grande o troppo piccolo");
        }
        if(y < 0 || y >= this.grid[0].length){
            throw new InvalidPositionException("valore y troppo grande o troppo piccolo");
        }
    }
    public char getSquare(int x, int y) throws InvalidPositionException{
        this.validatePosition(x,y);
        return this.grid[x][y];
    }
    
    public void setSquare(int x, int y, char symbol) throws InvalidPositionException, SquareAlreadyOccupiedException{
        if(this.getSquare(x, y) != '-'){
            throw new SquareAlreadyOccupiedException();
        }
        this.grid[x][y] = symbol;
    }
    

    
    
}
