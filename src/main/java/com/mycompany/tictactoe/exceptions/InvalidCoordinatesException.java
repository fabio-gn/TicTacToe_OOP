/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.mycompany.tictactoe.exceptions;

/**
 *
 * @author Fabio
 */
public class InvalidCoordinatesException extends Exception {

    /**
     * Creates a new instance of <code>InvalidCoordinatesException</code>
     * without detail message.
     */
    public InvalidCoordinatesException() {
    }

    /**
     * Constructs an instance of <code>InvalidCoordinatesException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidCoordinatesException(String msg) {
        super(msg);
    }
}
