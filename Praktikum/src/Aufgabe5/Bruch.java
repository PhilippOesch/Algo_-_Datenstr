package Aufgabe5;

public class Bruch implements Comparable<Bruch> {
    private int zaehler;
    private int nenner;

    public Bruch(int zaehler, int nenner) {
        this.zaehler = zaehler;
        this.nenner = nenner;
    }

    public static Bruch e(int n){
        Bruch bruch= new Bruch(1, 1);
        if(n== 0) {
            return bruch;
        }
        int factor= 1;
        for(int i = 1; i<= n; i++){
            factor*= i;
            bruch.add(new Bruch(1, factor));
        }

        return bruch;
    }

    public static int ggt(int a, int b) {
        if (b > a)
            return (ggt(b, a));
        else
            return ((b == 0) ? a : ggt(b, a % b));
    }

    public int compareTo(Bruch o){
        double a= (double) this.zaehler/ this.nenner;
        double b= (double) o.zaehler/ o.nenner;
        if(a> b){
            return 1;
        }
        if(b> a){
            return -1;
        }
        return 0;
    }

    public void add(Bruch bruch){
       int ggn= this.nenner* bruch.nenner;
       int bruchZaehler= bruch.zaehler* this.nenner;
       this.zaehler*= bruch.nenner;
       this.zaehler+= bruchZaehler;
       this.nenner= ggn;

       int ggt = Bruch.ggt(this.zaehler, this.nenner);
       this.zaehler /= ggt;
       this.nenner /= ggt;
    }

    public String get() {
        return zaehler + "/" + nenner;
    }

}
