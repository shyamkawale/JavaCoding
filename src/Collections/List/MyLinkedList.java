package Collections.List;

import java.util.NoSuchElementException;

import Collections.Helpers.ListNode;

public class MyLinkedList<E>{
    ListNode<E> first;
    ListNode<E> last;

    int size = 0;

    public MyLinkedList(){
        first = null;
        last = null;
    }

    public int size(){
        return size;
    }

    public void add(int index, E elem){
        if(index < 0 || index > size) throw new IndexOutOfBoundsException();
        ListNode<E> node = new ListNode<E>(elem);

        if(index == 0){// addfirst
            if(first == null){
                first = last = node;
            }
            else{
                node.next = first;
                node.prev = null;
                first.prev = node;
                first = node;
            }
        }    
        else if(index == size){ // add Last
            if(last == null){
                first = last = node;
            }
            else {
                last.next = node;
                node.prev = last;
                node.next = null;
                last = node;
            }
        }
        else{
            ListNode<E> curr;
            if(index <= size/2){
                curr = first;
                for(int i=0; i<index; i++){
                    curr = curr.next;
                }
            }
            else{
                curr = last;
                for(int i=size; i>index; i--){
                    curr = curr.prev;
                }
            }
            ListNode<E> prev = curr.prev;
            node.next = curr;
            node.prev = prev;
            prev.next = node;
            curr.prev = node;
        }

        size++;
    }

    public void addLast(E elem){
        ListNode<E> l = last;
        ListNode<E> node = new ListNode<E>(elem, null, l);
        if(l == null){
            first = node;
        }
        else{
            l.next = node;
        }
        last = node;

        size++;
    }

    public void addFirst(E elem){
        ListNode<E> f = first;
        ListNode<E> node = new ListNode<E>(elem, f, null);

        if(f == null){
            last = node;
        }
        else{
            f.prev = node;
        }
        first = node;

        size++;
    }

    public E get(int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        ListNode<E> curr;
        if(index <= size/2){
            curr = first;
            for(int i=0; i<index; i++){
                curr = curr.next;
            }
        }
        else{
            curr = last;
            for(int i=size-1; i>index; i--){
                curr = curr.prev;
            }
        }
        return curr.val;
    }

    public E getFirst(){
        if(first == null) throw new NoSuchElementException();;
        return first.val;
    }

    public E getLast(){
        if(last == null) throw new NoSuchElementException();
        return last.val;
    }

    public void remove(int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        ListNode<E> nodeToRemove;
        if(index <= size/2){
            nodeToRemove = first;
            for(int i=0; i<index; i++){
                nodeToRemove = nodeToRemove.next;
            }
        }
        else{
            nodeToRemove = last;
            for(int i=size-1; i>index; i--){
                nodeToRemove = nodeToRemove.prev;
            }
        }

        ListNode<E> prevNode = nodeToRemove.prev;
        ListNode<E> nextNode = nodeToRemove.next;
        if(prevNode != null){
            prevNode.next = nextNode;
        }else{
            first = nextNode;
        }
        if(nextNode != null){
            nextNode.prev = prevNode;
        }
        else{
            last = prevNode;
        }
        nodeToRemove.prev = null;
        nodeToRemove.next = null;

        size--;
    }

    public void removeFirst(){
        if (first == null) throw new NoSuchElementException();
        if(first == last){
            first = last = null;
        }
        else{
            ListNode<E> node = first.next;
            first.next = null;
            node.prev = null;
            first = node;
        }
        size--;
    }

    public void removeLast(){
        if (last == null) throw new NoSuchElementException();
        if(first == last){
            first = last = null;
        }
        else{
            ListNode<E> node = last.prev;
            last.prev = null;
            node.next = null;
            last = node;
        }
        size--;
    }

    public boolean contains(E elem){
        ListNode<E> curr = first;
        while(curr != null){
            if(curr.val.equals(elem)) return true;
            curr = curr.next;
        }
        return false;
    }

    public void set(int index, E elem){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();
        ListNode<E> curr;
        if(index < size/2){
            curr = first;
            for(int i=0; i<index; i++){
                curr = curr.next;
            }
        }
        else{
            curr = last;
            for(int i=size-1; i>index; i--){
                curr = curr.prev;
            }
        }
        curr.val = elem;
    }

    public E peek(){
        return (first == null) ? null : first.val; 
    }

    //origin: Queue
    //usecase: Queue-like operations (FIFO)
    public E poll(){
        if(first == null) return null;
        E firstNode = first.val;
        removeFirst();
        return firstNode;
    }

    //origin: Deque(Stack)
    //usecase: Stack-like operations (LIFO)
    public E pop(){
        if(first == null) throw new NoSuchElementException();
        E firstNode = first.val;
        removeFirst();
        return firstNode;
    }

    public boolean offer(E elem){
        addLast(elem);
        return true;
    }

    public void push(E elem){  // - equivalent to addFirst(E e)
        addFirst(elem);
    }
}
