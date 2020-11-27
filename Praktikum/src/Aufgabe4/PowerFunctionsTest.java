package Aufgabe4;

public class PowerFunctionsTest {
    public static void main(String[] args) {
        int iterations= 10000;
        int max= 1000;

        int sumN= 0;
        for(int i=0; i< iterations; i++){
            double randX= Math.random();
            int randN= (int) ((Math.random()*(max+1)));
            sumN+= randN;

            PowerFunctions.power(randX, randN);
            PowerFunctions.fastPower(randX, randN);
        }

        double averageN= (double)sumN /iterations;
        double averagePower= (double)PowerFunctions.getCountPower()/ iterations;
        double averageFastPower= (double)PowerFunctions.getCountFastPower()/ iterations;

        System.out.println("Auswertung:");
        System.out.println("________________________________________________________________________________________");
        System.out.println("Durchschnittlicher Exponent n: "+ averageN);
        System.out.println("Durchschnittliche Anzahl an Multiplikationen- Power: "+ averagePower);
        System.out.println("Durchschnittliche Anzahl an Multiplikationen- FastPower: "+ averageFastPower);
        System.out.println("________________________________________________________________________________________");

    }
}
