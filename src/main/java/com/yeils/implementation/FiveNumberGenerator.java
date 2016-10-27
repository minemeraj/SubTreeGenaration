package com.yeils.implementation;


public class FiveNumberGenerator extends Generator<Integer> {
    @Override
    protected void run() throws Exception {
        for (int i = 0; i < 5; i++) {
            yield(i);
        }
    };
}
