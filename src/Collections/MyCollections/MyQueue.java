package Collections.MyCollections;

@SuppressWarnings("unchecked")
public class MyQueue<E> {
    Object[] arr;
    int start, end, maxSize, currSize;

    public MyQueue() {
        maxSize = 16;
        arr = new Object[maxSize];
        start = end = -1;
        currSize = 0;
    }

    public MyQueue(int size) {
        maxSize = size;
        arr = new Object[maxSize];
        start = end = -1;
        currSize = 0;
    }

    public boolean offer(E elem) throws Exception{
        if(currSize == maxSize){
            System.out.println("Queue is full\n Exiting");
            return false;
        }
        end = (end + 1)%maxSize;
        if(start == -1) start = 0;
        arr[end] = elem;
        currSize++;

        System.out.println("The element pushed is " + elem);
        return true;
    }

	public E peek(){
        if(start == -1){
            System.out.println("Queue is empty");
            return null;
        }
        return (E) arr[start];
    }

    public E poll(){
        if(currSize == 0){
            System.out.println("Queue is empty\n Exiting");
            return null;
        }
        Object peeked = arr[start];
        if(currSize == 1){
            start = end = -1;
        }
        else{
            start = (start + 1)%maxSize;
        }
        currSize--;
        return (E) peeked;
    }

}
