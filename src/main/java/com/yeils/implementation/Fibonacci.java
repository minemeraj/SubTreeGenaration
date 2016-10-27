package com.yeils.implementation;


public class Fibonacci extends Generator<Integer> {


    /**
     * Override the default constructor to set the timeout parameters.
     */
    public Fibonacci() {
        super(1,5);
    }

    @Override
    protected void run() throws Exception {
        yield(0);
        int i = 0;
        int j = 1;
        while (true) {
            yield(j);
            int current = i + j;
            i = j;
            j = current;
        }
    }
}

