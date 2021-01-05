package Aufgabe9;

import Aufgabe5.Sortierung;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

public class TextAnalyse {
    private static boolean isLetter(char c) {
        return ((('a' <= c) && (c <= 'z')) ||
                (('A' <= c) && (c <= 'Z')) ||
                (c == 'ß') ||
                (c == 'ä') || (c == 'ö') || (c == 'ü') ||
                (c == 'Ä') || (c == 'Ö') || (c == 'Ü')
        );
    }

    private static boolean isNewLine(char c) {
        return (c == '\n');
    }

    private static String readWord(BufferedReader f) throws IOException {
        String s = new String();
        char c;
        int ci;
        // wait for next letter
        do {
            ci = f.read();
            c = (char) ci;
        } while (!isLetter(c) && (ci != -1));
        // wait for end of word

        while (isLetter(c)) {
            s += c;
            ci = f.read();
            c = (char) ci;
        }
        if (s.length() == 0)
            return null;
        else
            return s;
    }

    public static void main(String[] args) {
        try {
            BufferedReader f = new BufferedReader(new FileReader("src/Aufgabe9/TextAnalyse.java"));

//            BufferedReader f = new BufferedReader(new FileReader("src/Aufgabe9/Beispieltext.txt"));
            String s;
            HashMap<String, Integer> wörterbuch = new HashMap<String, Integer>();
            HashMap<String, ArrayList<Integer>> zeilenListe = new HashMap<String, ArrayList<Integer>>();

            //Wort-/ Zeilen Analyse
            int line_idx = 1;
            String lineString;
            while((lineString=f.readLine()) != null){
                BufferedReader lineReader= new BufferedReader(new StringReader(lineString));
                while((s = TextAnalyse.readWord(lineReader)) != null){
                    System.out.println("Gelesenes Wort:" + s);
                    String wort = s.toLowerCase();
                    if (wörterbuch.containsKey(wort)) {
                        int counter = wörterbuch.get(wort);
                        counter++;
                        ArrayList<Integer> wortZeilenListe = zeilenListe.get(wort);
                        if (!wortZeilenListe.contains(line_idx)) {
                            wortZeilenListe.add(line_idx);
                        }
                        wörterbuch.replace(wort, counter);
                        zeilenListe.replace(wort, wortZeilenListe);
                    } else {
                        wörterbuch.put(wort, 1);
                        ArrayList<Integer> wortZeilenListe = new ArrayList<Integer>();
                        wortZeilenListe.add(line_idx);
                        zeilenListe.put(wort, wortZeilenListe);
                    }
                }
                line_idx++;
            }


            //Array mit Wörtern erstellen und sortieren
            String[] sortedArray = new String[wörterbuch.size()];
            int idx = 0;
            for (String it : wörterbuch.keySet()) {
                sortedArray[idx] = it;
                idx++;
            }
            Arrays.sort(sortedArray);

            //Ausgabe
            System.out.println("\n\n-----------------------------");
            System.out.println("Wörterbuch");
            System.out.println("-----------------------------");

            int i= 0;
            for (String it : sortedArray) {
                System.out.println(i+ ": "+ it + " ; Anzahl= " + wörterbuch.get(it) + "; Zeilen= " + zeilenListe.get(it));
                i++;
            }

        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei:" + e.getMessage());
        }
    }
}