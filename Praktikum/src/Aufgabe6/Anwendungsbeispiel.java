package Aufgabe6;

import java.util.ArrayList;

public class Anwendungsbeispiel {
    public static void main(String[] args) {
        Zahlungsmittel geld[] = {new USD_Muenze(0.10), new USD_Schein(20), new SFR_Schein(5),
                new SFR_Muenze(0.50), new USD_Muenze(0.50), new EUR_Schein(50),
                new USD_Schein(100), new USD_Muenze(0.2), new USD_Muenze(0.25),
                new EUR_Muenze(0.01), new SFR_Schein(200), new USD_Schein(100),
                new EUR_Muenze(2), new EUR_Schein(5), new USD_Muenze(0.25),
                new SFR_Muenze(0.10), new SFR_Muenze(0.01), new USD_Muenze(0.50),
                new USD_Schein(100), new USD_Schein(100), new USD_Muenze(0.2),
                new USD_Muenze(0.01), new SFR_Schein(20), new SFR_Muenze(0.50),
                new USD_Muenze(0.50), new EUR_Schein(50), new USD_Schein(5),
                new EUR_Muenze(0.50), new EUR_Muenze(0.01), new SFR_Schein(10),
                new SFR_Schein(20), new SFR_Muenze(0.50), new SFR_Muenze(0.02)};

        ArrayList<Zahlungsmittel> gültigeZahlungmittel = new ArrayList<Zahlungsmittel>();
        for (int i = 0; i < geld.length; i++) {
            if (geld[i].wertIstGueltig()) {
                gültigeZahlungmittel.add(geld[i]);
            }
        }
        Zahlungsmittel [] arrayGültigeZahlungsmittel= new Zahlungsmittel[gültigeZahlungmittel.size()];
        arrayGültigeZahlungsmittel= gültigeZahlungmittel.toArray(arrayGültigeZahlungsmittel);
        Sortierung.mergesort(arrayGültigeZahlungsmittel);

        int anzUngültigeZahlungmittel = geld.length - arrayGültigeZahlungsmittel.length;
        double wertEUR = 0;
        double wertUSD = 0;
        double wertSFR = 0;
        double gesamtGewichtMünzen = 0;
        double gesamtFlächeBanknoten = 0;
        double höheMünzenstapel= 0;


        for (int i = 0; i < arrayGültigeZahlungsmittel.length; i++) {
            Zahlungsmittel value = arrayGültigeZahlungsmittel[i];
            System.out.println( value.toString());
            String waehrung = value.getWaehrung();

            //Gesamtwertberechnung
            switch (waehrung) {
                case "EUR":
                    wertEUR += value.getWert();
                    break;
                case "SFR":
                    wertSFR += value.getWert();
                    break;
                case "USD":
                    wertUSD += value.getWert();
            }

            //Fläche/ Gewichtberechnung
            if (value instanceof Muenze) {
                Muenze muenze = (Muenze) value;
                gesamtGewichtMünzen += muenze.getGewicht();
                höheMünzenstapel+= muenze.getDicke()/10;
            } else {
                Schein schein = (Schein) value;
                gesamtFlächeBanknoten += (schein.getBreite() * schein.getLaenge()) / 100;
            }
        }

        //Ausgabe
        System.out.println("--------------------------------------------------------------");
        System.out.println("Anzahl ungültiger Zahlungmittel: " + anzUngültigeZahlungmittel);
        System.out.println("--------------------------------------------------------------");
        System.out.println("EUR Gesamtwert: " + wertEUR);
        System.out.println("USD Gesamtwert: " + wertUSD);
        System.out.println("SFR Gesamtwert: " + wertSFR);
        System.out.println("--------------------------------------------------------------");
        System.out.println("Gesamtgewicht Münzen in Gramm: " + gesamtGewichtMünzen);
        System.out.println("Gesamtfläche Banknoten in Quadratzentimeter: " + gesamtFlächeBanknoten);
        System.out.println("--------------------------------------------------------------");
        System.out.println("Gesamthöhe Münzenstapel in Zentimeter: " + höheMünzenstapel);
        System.out.println("--------------------------------------------------------------");

    }
}
