package Aufgabe7;

public class Chain<E> {
    private E o;
    private Chain next;

    public Chain() {
        o = null;
        next = null;
    }

    public void setO(E x){
        this.o= x;
    }

    public void setNext(Chain c){
        this.next= c;
    }

    public E getO(){
        return o;
    }

    public Chain getNext(){
        return next;
    }
}
