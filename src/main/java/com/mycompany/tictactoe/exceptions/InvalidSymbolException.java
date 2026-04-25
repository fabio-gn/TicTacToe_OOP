/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.mycompany.tictactoe.exceptions;

/**
 *
 * @author Fabio
 */
public class InvalidSymbolException extends Exception {

    /**
     * Creates a new instance of <code>InvalidSymbolException</code> without
     * detail message.
     */
    public InvalidSymbolException() {
    }

    /**
     * Constructs an instance of <code>InvalidSymbolException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidSymbolException(String msg) {
        super(msg);
    }
}
