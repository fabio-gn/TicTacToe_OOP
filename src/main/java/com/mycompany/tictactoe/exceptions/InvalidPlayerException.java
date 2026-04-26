/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.mycompany.tictactoe.exceptions;

/**
 *
 * @author Fabio
 */
public class InvalidPlayerException extends Exception {

    /**
     * Creates a new instance of <code>InvalidPlayerException</code> without
     * detail message.
     */
    public InvalidPlayerException() {
    }

    /**
     * Constructs an instance of <code>InvalidPlayerException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidPlayerException(String msg) {
        super(msg);
    }
}
