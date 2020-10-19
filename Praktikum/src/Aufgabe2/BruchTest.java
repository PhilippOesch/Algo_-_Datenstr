package Aufgabe2;

public class BruchTest {

    public static void main(String[] args) {

        //Aufgabe 2
        int n1 = 2;
        int n2 = 3;
        int n3 = 4;

        System.out.println("Aufgabe 2:");
        Bruch bruch1 = new Bruch(1,1);
        for (int i= 2; i<=n1; i++){
            bruch1.add(new Bruch(1, i));
        }
        System.out.println("Ergebnis n=2: " +bruch1.get());

        Bruch bruch2 = new Bruch(1,1);
        for (int i= 2; i<=n2; i++){
            bruch2.add(new Bruch(1, i));
        }
        System.out.println("Ergebnis n=3: " +bruch2.get());

        Bruch bruch3 = new Bruch(1,1);
        for (int i= 2; i<=n3; i++){
            bruch3.add(new Bruch(1, i));
        }
        System.out.println("Ergebnis n=4: "+bruch3.get());
        Bruch eulerNaeherungle= Bruch.e(6);
        System.out.println("Aufgabe 3:");
        System.out.println("Annaeherung Eulersche Zahl, 6 Schitte: "+ eulerNaeherungle.get());
    }
}
