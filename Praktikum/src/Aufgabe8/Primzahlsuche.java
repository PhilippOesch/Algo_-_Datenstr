package Aufgabe8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Primzahlsuche {

    public static void main(String[] args) {
        TreeSet<Integer> elemente= new TreeSet<Integer>();
        int n= 1000;
        for (int i = 2; i <= n; i++) {
            elemente.add(i);
        }

        ArrayList<Integer> primzahlen= new ArrayList<Integer>();

        while(!elemente.isEmpty()){
            int primzahl= elemente.first();
            System.out.println(primzahl);
            primzahlen.add(primzahl);
            elemente.remove(primzahl);
            int value= primzahl;
            for(int i= 1; value<n; i++){
                value= primzahl*i;
                elemente.remove(value);
            }
        }

        System.out.println("\nAnzahl Primzahlen zwischen 2 und "+n+": "+ primzahlen.size());

        System.out.println("\nPrimzahlzwillinge:");
        int value= -1;
        for (Iterator it= primzahlen.iterator(); it.hasNext(); ){
            if(value== -1){
                value= (int)it.next();
            }
            if(it.hasNext()){
                int next= (int)it.next();
                if((next- value)<= 2){
                    System.out.println("("+ value+ ", "+ next +")");
                }
                value= next;
            }
        }
    }
}
