package Aufgabe5;

public class Sortierungsbeispiel {
    public static void main(String[] args)
    {Integer[] a= {15, 3, 8, 9, 20, 70, 4, 6};
        Sortierung.mergesort(a);
        System.out.print("a: ");
        for (int i=0; i<a.length; ++i)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
