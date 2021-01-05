package Aufgabe5;

import java.util.Arrays;

public class Sortierung {

    public static void mergesort(Comparable[] x){
        if(x.length>1){
            //Aufteilung
            int m = x.length/2;
            Comparable [] left = Arrays.copyOfRange(x, 0, m);
            Comparable [] right = Arrays.copyOfRange(x, m, x.length);
            Sortierung.mergesort(left);
            Sortierung.mergesort(right);

            //Zusammenfügen
            int leftIndex= 0;
            int rightIndex= 0;
            for(int i= 0; i< x.length; i++){
                if(leftIndex > left.length-1 && !(rightIndex> right.length-1)){
                    x[i]= right[rightIndex];
                    rightIndex++;
                } else if(rightIndex> right.length-1 && !(leftIndex > left.length-1)){
                    x[i]= left[leftIndex];
                    leftIndex++;
                } else if(right[rightIndex].compareTo(left[leftIndex])<= 0){
                    x[i]= right[rightIndex];
                    rightIndex++;
                } else {
                    x[i]= left[leftIndex];
                    leftIndex++;
                }
            }
        }
    }
}
