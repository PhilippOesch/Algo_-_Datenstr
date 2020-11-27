package Aufgabe3;

public class Textanalyse {

    public static void main(String[] args) {
        int[] counterArray = new int[26];
        String abcLookup = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(args.length + " Argumente übergeben");

        //Wort Analyse
        for (int i = 0; i < args.length; i++) {
            System.out.println("Länge Argument " + i + ": " + args[i].length());

            // Buchtaben Analyse
            for (int y = 0; y < args[i].length(); y++) {
                char letter = Character.toUpperCase((args[i].charAt(y)));
                int index = abcLookup.indexOf(letter);
                ++counterArray[index];
            }
        }

        System.out.println("\nBuchstabenanzahlen: ");
        for (int i = 0; i < counterArray.length; i++) {
            if (counterArray[i] != 0) {
                System.out.println(abcLookup.charAt(i) + ": " + counterArray[i]);
            }
        }
    }
}
