/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tictactoe;

import com.mycompany.tictactoe.exceptions.InvalidGridSizeException;
import com.mycompany.tictactoe.exceptions.InvalidPositionException;
import com.mycompany.tictactoe.exceptions.SquareAlreadyOccupiedException;

/**
 *  Rappresenta la griglia di gioco in cui vengono inseriti i simboli.
 *  la griglia viene rappresentata da una array multi-dimensionale di char.
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
    /**
     * Imposta la griglia nella quale verra' giocata la partita definendone le dimensioni.
     * @param size e' un'array di massimo due interi che rappresentano la dimensione della griglia, in questo caso [3,3] per una griglia 3x3
     * @throws InvalidGridSizeException se si prova a dare piu' di due dimensioni alla griglia (per esempio [3,3,3]) o se si prova a creare una griglia inferiore a 3x3 (2x2 non e' valida, per esempio).
     */
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
    
    /**
     * Esegue controlli su tutta la griglia per verificare se un giocatore ha vinto.
     * @return il simbolo del vincitore ('x' o 'o'), oppure '-' se non ha vinto nessuno
     */
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
            for(int i=1; i<grid[0].length; i++){
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
    /**
     * Restituisce il valore della casella nella griglia di gioco che corrisponde alle coordinate passate come parametri.
     * @param x l'indice delle ascisse nella griglia di gioco(parte da 0)
     * @param y l'indice delle ordinate nella griglia di gioco (parte da 0)
     * @return il valore contenuto nel quadrato della griglia corrispondente alle coordinate inserite.
     * @throws InvalidPositionException se il valore di {@code x} o di {@code y} e' inferiore a 0 o maggiore delle dimensioni della griglia.
     */
    public char getSquare(int x, int y) throws InvalidPositionException{
        this.validatePosition(x,y);
        return this.grid[x][y];
    }
    /**
     * Inserisce un simbolo nella casella della griglia corrispondente alle coordinate passate (x e y)
     * @param x l'indice delle ascisse nella griglia di gioco(parte da 0)
     * @param y l'indice delle ordinate nella griglia di gioco (parte da 0)
     * @param symbol il simbolo da assegnare alla casella corrispondente alle coordinate {@code x} e {@code y}
     * @throws InvalidPositionException se il valore di {@code x} o di {@code y} e' inferiore a 0 o maggiore delle dimensioni della griglia.
     * @throws SquareAlreadyOccupiedException se la casella che si intende riempire e' gia' occupata (quindi contiene un valore diverso da '-')
     */
    public void setSquare(int x, int y, char symbol) throws InvalidPositionException, SquareAlreadyOccupiedException{
        if(this.getSquare(x, y) != '-'){
            throw new SquareAlreadyOccupiedException();
        }
        this.grid[x][y] = symbol;
    }
    

    
    
}
