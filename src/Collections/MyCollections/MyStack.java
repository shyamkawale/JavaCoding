package Collections.MyCollections;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack<E> extends Vector<E>{
    public MyStack(){} //no parametrized constructor

    public E peek(){
        int len = size(); //vector's method
        if (len == 0)
            throw new EmptyStackException();
        return elementAt(len - 1); //vector's method
    }

    public E push(E item){
        addElement(item); //vector's method => appends element in Object array(similar to add method of ArrayList)
        return item;
    }

    public E pop(){
        E elem = peek();

        int len = size(); //vector's method
        removeElementAt(len - 1); //vector's method

        return elem;
    }

    public boolean isEmpty(){
        int len = size(); //vector's method
        return len == 0;
    }
}
