java.util.*;

public class queue{
    private int[] data;
    int front = 0;
    int rear = 0;
    int size = 0;
    public queue(int cap){
        this.data = new int[cap];

    }

    public void add(int val){
        if(size == data.length -1){
            System.out.println("overflow");
            return -1;
        }
        else{
            data[size] = val;
            size++;
        }

    }

    public int remove(){
        if()

    }

    public int size(){
        return size;

    }

    public boolean isEmpty(){
        if(size() == 0){
            return false;
        }else{
            return true;
        }

    }

    public int peek(){
        return data[front];
    }

}

public class myQueue {
    
}
