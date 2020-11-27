package Aufgabe4;

public class Counter {
    protected int x; // Z¨ahlerstand
    protected int savedX; //Speicherwert
    protected boolean wasSavedBefore;

    public Counter() {
        x = 0;
        wasSavedBefore= false;
    } // Konstruktor

    public void increment() {
        ++x;
    } // Hochz¨ahlen

    public int get() {
        return x;
    } // Auslesen

    public void save() {
        if(!wasSavedBefore){
            wasSavedBefore= true;
        }
        savedX= x;
    }

    public void restore() {
        if(!wasSavedBefore) {
            System.out.println("Kein Wert wurde gespeichert!");
        } else {
            x= savedX;
        }
    }

    public void reset() {
        x = 0;
    } // Zur¨ucksetzen

    public void decrement(){
        --x;
    }
}
