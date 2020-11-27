package Aufgabe7;

public class MyList<E> {
    private Chain c;

    public MyList() {
        c = null;
    }

    public void add(E o){
        Chain temp = new Chain<E>();
        temp.setO(o);
        temp.setNext(c);
        c= temp;
    }

    public int size(){
        int size= 0;
        Chain currentPos= c;
        if(currentPos== null){
            return size;
        } else {
            size++;
        }

        while(currentPos.getNext()!= null){
            size++;
            currentPos= currentPos.getNext();
        }
        return size;
    }

    public E get (int index) throws IndexOutOfBoundsException{
        if(index< 0){
            throw new IndexOutOfBoundsException();
        }

        int currentIndex= this.size()-1;
        if(index> currentIndex){
            throw new IndexOutOfBoundsException();
        }

        Chain currentPos= c;
        while(index!= currentIndex){
            currentIndex--;
            currentPos= currentPos.getNext();
        }
        return (E)currentPos.getO();
    }

    public E remove(int index){
        if(index< 0){
            throw new IndexOutOfBoundsException();
        }

        int currentIndex= this.size()-1;
        if(index> currentIndex){
            throw new IndexOutOfBoundsException();
        }

        Chain beforePos= null;
        Chain currentPos= c;
        while(currentIndex!= index){
            beforePos= currentPos;
            currentPos= currentPos.getNext();
            currentIndex--;
        }

        E value = (E)currentPos.getO();
        Chain nextPos= currentPos.getNext();
        beforePos.setNext(nextPos);

        return (E)value;
    }
}
