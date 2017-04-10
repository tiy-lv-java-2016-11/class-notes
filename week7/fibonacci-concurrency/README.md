# The Curse of Fibonacci

## Description

The fibonacci sequence is one of the more bizarre naturally occurring sequences.  It can be found all over nature and is the basis for the golden ratio.  The problem is that recursive algorithms, while very simple, are extremely slow and inefficient.  Here is where we move towards a producer and consumer model with multi threading to make the repeated task a bit more efficient.

## Tasks
* Make `Fibonacci` an executable task by implementing `Runnable`. 
	* Add a constructor that sets a class property for the number desired. This is required since run cannot take arguments.
	* Have the run method print out the number and the result at the end 
* Create an `ExecutorService` using a fixed thread pool of 100.  This **should** prevent your computer from exploding.
* Using a thread (producer) read in the included file of numbers.  These represent the nth numbers in the fibonacci sequence you need to find.
* `put` the numbers on to a BlockingQueue that allows no more than 1000 items at a time.
* Using another thread (consumer) pull the items off the queue and submit new fibonacci tasks to the executor (step 2) to run in parallel.

## Hard Mode
* Change `Fibonacci` to be a callable.
* Submit the tasks as above but keep a list of futures
* Get the results of all futures and write them in order to a file
* Make the fib recursive more efficient 
	* Create a static hashmap (use the concurrent one) to store the fib number (key) and the result (value).
	* Change the `fib` method to first check and see if the number has already been inserted
	* If it has then return the cached number
	* If not then use the recursion. 

## Resources
* [Github Repo](https://github.com/tiy-lv-java-2016-11/concurrent-fibonacci)
* [ExecutorService Docs](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html)
* [Java Concurrency Tutorial](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html)
