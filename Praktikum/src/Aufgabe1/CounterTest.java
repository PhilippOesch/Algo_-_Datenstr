package Aufgabe1;

import Aufgabe1.Counter;

public class CounterTest {
    public static void main(String[] args)
    {
        Counter a= new Counter(); // Erzeugen eines Z¨ahlers a

        a.restore();
        for (int i= 0; i<10; i++){
            if(i== 5){
                System.out.println("Wert wurde gespeichert");
                a.save();
            } else {
                a.increment();
                System.out.println("i= " + i + "; x= " + a.get());
            }
        }
        a.reset();
        System.out.println("After Reset: "+ a.get());
        for (int i= 0; i<10; i++){
            if(i== 5){
                System.out.println("Wert wurde geladen");
                a.restore();
                System.out.println("i= "+i+ "; x= "+ a.get());
            } else {
                a.decrement();
                System.out.println("i= " + i + "; x= " + a.get());
            }
        }
    }
}
