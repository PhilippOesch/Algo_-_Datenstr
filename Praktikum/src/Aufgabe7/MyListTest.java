package Aufgabe7;

public class MyListTest {
    public static void main(String[] args) {
        MyList l= new MyList();
        for (int i=1; i<=10; ++i)
            l.add(8*i);
        l.remove(3);
        for (int i=l.size()-1; i>=0; --i)
            System.out.print(" " + l.get(i));
        System.out.println();


        //Test mit Brüchen
        MyList bruchListe= new MyList();
        int factor=2;
        for (int i= 1; i<=10; i++){
            bruchListe.add(new Bruch(1, (int) Math.pow(factor, i)));
        }
        bruchListe.remove(4);

        for (int i= 0; i<9; i++){
            Bruch value= (Bruch) bruchListe.get(i);
            System.out.print(" " + value.get());
        }
    }

}
