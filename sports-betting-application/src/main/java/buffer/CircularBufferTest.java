package buffer;

import java.lang.reflect.Array;
import java.util.*;

public class CircularBufferTest {
    public static void main(String[] args) {

        CircularBuffer<Integer> buffer = new CircularBuffer(Integer.class, 2);
        //CircularBuffer<Integer> buffer = new CircularBuffer(2);
        System.out.println("Is buffer empty: " + buffer.isEmpty());

        buffer.put(25);
        System.out.println("Is buffer empty: " + buffer.isEmpty());
        buffer.put(30);
        System.out.print("get from buffer: ");
        System.out.println(buffer.get());
        System.out.print("get from buffer: ");
        System.out.println(buffer.get());
        try {
            System.out.print("get from buffer: ");
            System.out.println(buffer.get());
        }
        catch (RuntimeException r){
            System.out.println(r.getMessage());
        }
        System.out.println("Is buffer empty: " + buffer.isEmpty());
        Integer[] arInt = buffer.toArray();
        Arrays.stream(arInt).forEach(x -> System.out.format("%s, ", x));
        Object[] arObj = buffer.toObjectArray();
        Arrays.stream(arObj).forEach(x -> System.out.format("%s, ", x));
        List<Integer> list = buffer.asList();
        System.out.println("list:" + list);
        List<Integer> toAdd = Arrays.asList(1,2,5);
        System.out.println("Attempt to add list: " + toAdd);
        buffer.addAll(toAdd);

        class CompareInteger implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1*o1.compareTo(o2);
            }
        }
        System.out.print("get from buffer: ");
        System.out.println(buffer.get());
        buffer.sort(new CompareInteger());
        System.out.println("Sorted buffer:" + buffer);
    }

}




