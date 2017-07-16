package cs570;

import java.util.Iterator;

/*
  GROUP DETAILS
  =============
  GROUP MEMBERS	: PAROMITA DATTA & PARAS GARG
  GROUP SECTION	: CS 570-LA 
  LAB ASSIGNMENT 3 / WEEK 5 

*/


public class Wrapper {
    public static void main(String[] args) {
        MyVector<String> myVect = new MyVector<String>();

        myVect.push("First elem");
        myVect.push("Second elem");
        myVect.push("Third elem");
        myVect.push("Bad elem");
        System.out.println(myVect + " ---" + myVect.length);
        
        myVect.set(3, "Fourth Elem");
        System.out.println(myVect + " ---" + myVect.length);
        
        System.out.println(myVect.get(2));
        System.out.println(myVect + " ---" + myVect.length);
        
        System.out.println(myVect.pop());
        System.out.println(myVect + " ---" + myVect.length);
        
        myVect.insert(2, "Second-and-half elem");
        System.out.println(myVect + " ---" + myVect.length);

        Iterator it = myVect.itr;
        if(it.hasNext()) {
            it.remove();
        }
        System.out.println(myVect + " ---" + myVect.length);
        
        while(it.hasNext()) {
            String elem = (String)it.next();
            System.out.println(elem);
        }
    }
}

interface MyIterable<T> {
    T get(int number);
    void set(int number, T  value);
    void push(T value);
    T pop();
    void insert(int index, T value);    
    // remember to implement the iterable functionality
} 

class MyVector<T> implements MyIterable<T> {  

    private java.util.Vector<T> wrapped;
    public int length = 0;
    public Iterator itr = new Itr();
    
    public MyVector() {
        wrapped = new java.util.Vector<T>();
        length = wrapped.size();
    }

    @Override
    public T get(int number) {
        return wrapped.get(number);
    }

    @Override
    public void set(int number, T value) {
        wrapped.set(number, value);
        length = wrapped.size();
    }

    @Override
    public void push(T value) {
        wrapped.add(value);
        length = wrapped.size();
    }

    @Override
    public T pop() {
        length = wrapped.size() -1;
        return wrapped.remove(length);
    }

    @Override
    public void insert(int index, T value) {
        wrapped.add(index, value);
        length = wrapped.size();
    }
    
    public String toString() {
        StringBuilder strBld = new StringBuilder();
        for(T elem : wrapped) {
            strBld.append(elem).append("; ");
        }
        return  strBld.toString();
    }

    private class Itr implements Iterator {// our implementation of iterator
        int pos = -1;

        public T next() {	//returns the next element
            pos++;
            if (pos >= length)
                throw new RuntimeException("Reached the End");
            return wrapped.get(pos);
        }
        
        public boolean hasNext() {     //checks the existence of the following element      
            return (pos+1) < length;
        }

        public void remove() {// deletes the current position
            if (pos >= length)
                throw new RuntimeException("No Elements to Remove");
            wrapped.remove(pos + 1);
            length--;
        }
    }
}