package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> ,Iterable<T>{
    private class Node {
        private T item;
        private Node next;
        private Node prev;
        public Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    private Node sentinel;
    private int size;


    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

    }

    @Override
    public void addfirst(T item){
        Node prefirstnode = sentinel.next;
        Node newfirstnode = new Node(item, prefirstnode, sentinel);
        prefirstnode.prev = newfirstnode;
        sentinel.next = newfirstnode;
        size++;
    }
    @Override
    public void addlast(T item){
        Node prelastnode = sentinel.prev;
        Node newlastnode = new Node(item, prelastnode, sentinel);
        prelastnode.next = newlastnode;
        sentinel.prev = newlastnode;
        size++;

    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void printdeque(){
        Node p=sentinel.next;
        while(p!=sentinel){
            System.out.print(p.item+" ");
            p=p.next;
        }
        System.out.println();
    }
    private Node getfisrstnode(){
        return sentinel.next;
    }

    @Override
    public T removefirst(){
        Node prefirstnode = getfisrstnode();
        if(prefirstnode==sentinel){
            return null;
        }
        Node newfirstnode = prefirstnode.next;
        T item = prefirstnode.item;
        sentinel.next=newfirstnode;
        size--;
        return item;

    }

    private Node getlastnode(){
        return sentinel.prev;
    }

    @Override
    public T removelast(){
        Node prelastnode = getlastnode();
        if(prelastnode==sentinel){
            return null;

        }
        Node newlastnode = prelastnode.prev;
        T item = prelastnode.item;
        sentinel.prev=newlastnode;
        size--;
        return item;

    }

    @Override
    public T get(int index){
        Node p=getfisrstnode();
        while(p!=sentinel){
            if(index==0){
                return p.item;

            }
            index--;
            p=p.next;
        }
        return null;
    }
    private T getrecursivehelper(int index,Node p){
        if(p==sentinel){
            return null;

        }
        if(index==0){
            return p.item;
        }
        return getrecursivehelper(index-1,p);
    }

    public T getrecursive(int index){
        return getrecursivehelper(index,sentinel);
    }

    public Iterator<T> iterator(){
        return new LinkedListDeque();
    }
    private class LinkedListDequeIterator implements Iterator<T>{
        private Node iternode;
        public LinkedListDequeIterator(){
            iternode = sentinel.next;
        }
        public boolean hasNext(){
            return iternode!=sentinel;
        }
        public T next(){
            T returnitem = iternode.item;
            iternode = iternode.next;
            return returnitem;
        }

    }

    @Override
    public boolean equals(Object o){
        if(o==this){
            return true;
        }
        if(o==null){
            return false;
        }
        if(!(o instanceof Deque)){
            return false;
        }
        Deque<T> deque = (Deque<T>) o;
        if(size()!=other.size()){
            return false;
        }
        for(int i=0;i<size();i++){
            T item = get(i);
            T item2 = other.get(i);
            if(!item.equals(item2)){
                return false;
            }
        }
        return true;
    }
}
