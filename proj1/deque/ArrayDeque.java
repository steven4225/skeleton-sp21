package deque;
import java.util.Iterator;
public class ArrayDeque<T> implements Deque<T> , Iterable<T> {


    private T[] items;
    private int size;
    private int nextfirst;
    private int nextlast;
    private void resetindex(int newNexfirst, int newNexlast) {
        this.nextfirst = newNexfirst;
        this.nextlast = newNexlast;
    }
    public ArrayDeque() {
        this.items = (T[]) new Object[8];
        this.size = 0;
        resetindex(4, 5);

    }
    private int getfirstindex(){

    }
}
