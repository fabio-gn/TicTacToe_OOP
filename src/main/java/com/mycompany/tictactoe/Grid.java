/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tictactoe;

import com.mycompany.tictactoe.exceptions.InvalidGridSizeException;

/**
 *
 * @author Fabio
 */
public class Grid {
    private static int[] gridSize = {3,3};
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
            boolean check = false;
            for(int j=1; j<this.grid[i].length; j++){
                if(this.grid[i][j] != '-' && this.grid[i][j] == this.grid[i][j-1]){
                    check = true;
                    continue;
                }
                check = false;
            }
            if(check == true){
                return this.grid[i][0];
            }
        }
        return '-';
    }
    private char checkColumn(){
        for(int j=0; j<this.grid.length; j++){
            boolean check = false;
            for(int i=1; i<grid[i].length; i++){
                if(this.grid[i][j] != '-' && this.grid[i][j] == this.grid[i-1][j]){
                    check = true;
                    continue;
                }
                check = false;
                
            }
            if(check == true){
                return grid[0][j];
            }
        }
        return '-';
    }
    private char checkDiagonal(){
        boolean check = false;
        for(int i=1; i<this.grid.length; i++){
            if(grid[i][i] != '-' && grid[i][i] == grid[i-1][i-1]){
                check = true;
                continue;
            }
            check = false;
        }
        if(check == true){
            return this.grid[0][0];
        }
        for(int i=1; i<this.grid.length; i++){
            int j = (this.grid.length - 1) - i;
            if(this.grid[i][j] != '-' && this.grid[i][j] == this.grid[i-1][j+1]){
                check = true;
                continue;
            }
            check = false;
        }
        if(check == true) {
            return this.grid[0][2];
        }
        

//        for(int i=0; i<this.grid.length -1; i++){
//            for(int j = this.grid[i].length -1; j>=0; j--){
//                if(this.grid[i][j] != '-' && this.grid[i][j] == this.grid[i+1][j-1]){
//                    check = true;
//                    continue;
//                }
//                check = false;
//                
//            }
//            if(check == true){
//                return this.grid[0][2];
//                
//            }
//        }

        return '-';
    }
    

    
    
}
