package deque;

public  interface Deque <T>{
    void addfirst(T item);
    void addlast(T item);
    default boolean isempty(){
        return size()==0;

    }
    int size();
    void printdeque();
    T removefirst();
    T removelast();
    T get(int index);

}