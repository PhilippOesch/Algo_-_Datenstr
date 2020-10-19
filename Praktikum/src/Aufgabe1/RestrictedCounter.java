package Aufgabe1;

import Aufgabe1.Counter;

public class RestrictedCounter extends Counter {
    private int capacity;

    public RestrictedCounter(int capacity){
        super();
        this.capacity= capacity;
    }

    @Override
    public void increment(){
        if(capacity== x){
            System.out.println("Maximal Kapazität erreicht");
        } else {
            ++x;
        }
    }

    public int freeCapacity(){
        return capacity- x;
    }
}
