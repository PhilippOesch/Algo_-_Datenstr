package Aufgabe4;

public class PowerFunctions {
    private static Counter counterPower= new Counter();
    private static Counter counterfastPower= new Counter();

    public static double power( double x, int n ){
        double y=1;
        for (int i=1; i<=n; ++i) {
            y = y * x;
            counterPower.increment();
        }
        return y;
    }

    public static double fastPower( double x, int n ){
        double y=1;
        while (n>0) {
            if (n%2==1) {
                y *= x;
                counterfastPower.increment();
            }
            n = n/2;
            x = x*x;
            counterfastPower.increment();
        };
        return y;
    }

    public static void resetCounters(){
        counterPower.reset();
        counterfastPower.reset();
    }

    public static int getCountPower(){
        return counterPower.get();
    }

    public static int getCountFastPower(){
        return counterfastPower.get();
    }
}