/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.mycompany.tictactoe.exceptions;

/**
 *
 * @author Fabio
 */
public class IdenticalPlayerNamesException extends Exception {

    /**
     * Creates a new instance of <code>IdenticalPlayerNamesException</code>
     * without detail message.
     */
    public IdenticalPlayerNamesException() {
    }

    /**
     * Constructs an instance of <code>IdenticalPlayerNamesException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public IdenticalPlayerNamesException(String msg) {
        super(msg);
    }
}
