package com.yeils.implementation;

/**
 * A (infinite) generator which prints the received values to {@link System#out}
 * stream.
 *
 * 
 */
public class Printer extends Generator<Object> {
    @Override
    protected void run() throws Exception {
        while (true) {
            System.out.println(yield());
        }
    }
}
