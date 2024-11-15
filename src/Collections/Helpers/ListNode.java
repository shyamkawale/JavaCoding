package Collections.Helpers;

public class ListNode<E> {
    public E val;
    public ListNode<E> next;
    public ListNode<E> prev;
    
    public ListNode(E val) { 
        this.val = val; 
    }
    public ListNode(E val, ListNode<E> next, ListNode<E> prev) { 
        this.val = val; 
        this.next = next; 
        this.prev = prev;
    }
}
