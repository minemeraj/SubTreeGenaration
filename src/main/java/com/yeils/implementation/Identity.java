package com.yeils.implementation;

/**
 * A (infinite) generator which returns back the sent value.
 *
 *
 */
public class Identity extends Generator<Object> {
    @Override
    protected void run() throws Exception {
        while (true)
            yield(yield());
    }
}
