/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author coding_java 
 */
public class Threads {
    public static void main(String[] args) {
        Runnable target = () -> {
            String tName = Thread.currentThread().getName();
            System.out.println("New thread "+ tName);
        };
        target.run();
        
        Thread t = new Thread(target);
        t.start();
        
        System.out.println("Done");
    }
}

/* 
Hi devs, 
Today I am learning about threads in Java.
there are a number of available models to launch tasks in 
another thread in Java. For instance we can use the model Callable  
or Runnable. Here I am using Runnable and have introduced 
it before starting a new thread. In Runnable I have specify the runnable target.
(line 17).
Runnable is an interface used to execute code on a thread.
A simple constructor is Thread(Runnable target) - line 23.
*/