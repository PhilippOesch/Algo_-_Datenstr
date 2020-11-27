package Aufgabe5;

public class BruchSortTest {
    public static void main(String[] args) {
        Bruch [] bruchArray = {new Bruch(1,2),
                new Bruch(3, 4),
                new Bruch(1, 8),
                new Bruch(3, 16),
                new Bruch(5, 11),
                new Bruch(2, 3)};
        Sortierung.mergesort(bruchArray);
        System.out.print("Array: ");
        for(int i= 0; i< bruchArray.length; i++){
            System.out.print(bruchArray[i].get()+" ");
        }
    }
}
