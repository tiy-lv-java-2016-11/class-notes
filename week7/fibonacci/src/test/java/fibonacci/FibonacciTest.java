package fibonacci;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jeff on 6/28/16.
 */
public class FibonacciTest {

    @Test
    public void whenFibZeroThenReturnZero(){
        Fibonacci fib = new Fibonacci();
        assertEquals(0, fib.fib(0));
    }

    @Test
    public void whenFibOneThenReturnOne(){
        Fibonacci fib = new Fibonacci();
        assertEquals(1, fib.fib(1));
    }

    @Test
    public void whenFibThreeThenReturn2(){
        Fibonacci fib = new Fibonacci();
        assertEquals(2, fib.fib(3));
    }

    @Test
    public void whenFibSevenThenReturn13(){
        Fibonacci fib = new Fibonacci();
        assertEquals(13, fib.fib(7));
    }

}
