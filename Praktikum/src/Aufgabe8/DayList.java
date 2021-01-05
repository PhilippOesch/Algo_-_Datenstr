package Aufgabe8;


import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class DayList {

    public static void main(String[] args) {
        LinkedList<String> li= new LinkedList<String>();
        li.add("Montag");
        li.add("Dienstag");
        li.add("Mittwoch");
        li.add("Donnerstag");
        li.add("Freitag");
        li.add("Samstag");
        li.add("Sonntag");

        TreeSet<String> bb= new TreeSet<String>();
        HashSet<String> ht= new HashSet<String>();

        System.out.println("\n_____Liste:");
        for (String it: li){
            bb.add(it);
            ht.add(it);
            System.out.println(it);
        }

        System.out.println("\n_____Balancierter Baum:");
        for (String it: bb){
            System.out.println(it);
        }

        System.out.println("\n_____Hashtable:");
        for (String it: ht){
            System.out.println(it);
        }

        System.out.println("\n_____Liste jedes 2. Element:");
        for (Iterator it = li.iterator(); it.hasNext(); ){
            it.next();
            if (it.hasNext()){
                System.out.println(it.next());
            }
        }

        System.out.println("\n_____Balancierter Baum jedes 2. Element:");
        for (Iterator it = bb.iterator(); it.hasNext(); ){
            it.next();
            if (it.hasNext()){
                System.out.println(it.next());
            }
        }

        System.out.println("\n_____Hashtable jedes 2. Element:");
        for (Iterator it = ht.iterator(); it.hasNext(); ){
            it.next();
            if (it.hasNext()){
                System.out.println(it.next());
            }
        }
    }
}
