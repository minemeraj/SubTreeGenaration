package com.yeils.implementation;

public class Main {
    
	public static void main(final String[] args) {
        // Use get method to get the values yielded by the generator.
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 5; i++) {
            System.out.println(fibonacci.get());
        }
        fibonacci.stop();

        // Generator which generate values (and not only consume values)
        // can be iterated directly.
        Fibonacci fibonacciIter = new Fibonacci();
        int j = 0;
        for (Integer integer : fibonacciIter) {
            System.out.println(integer);
            if (j++ > 10) break;
        }
        fibonacciIter.stop();

        // Use send method to send the value to the generator.
        Printer printer = new Printer();
        for (int i = 1; i <= 5; i++) {
            printer.send(i);
        }
        printer.stop();

        // Use both send and get methods together. Their counterparts (yield()
        // and yield(Object) must be called in the same order as these are
        // called here. Otherwise it will result in a deadlock.
        Identity identity = new Identity();
        for (int i = 0; i < 5; i++) {
            identity.send(i);
            System.out.println(identity.get());
        }
        identity.stop();

        // Non infinite generators do not need to be stopped at the end of
        // iteration. They stop automatically.
        FiveNumberGenerator fiveNumberGenerator = new FiveNumberGenerator();
        for (Integer integer : fiveNumberGenerator) {
            System.out.println(integer);
        }
    }
}

