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
    
    public Grid(){
        
    }

    public char[][] getGrid() {
        return grid;
    }

    protected void setGrid(int[] size) throws InvalidGridSizeException{
        if(size.length != 2){
           throw new InvalidGridSizeException();
        }
        this.grid = grid;
    }
    
    
}
