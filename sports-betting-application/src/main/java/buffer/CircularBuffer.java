//package buffer;
//
//import java.lang.reflect.Array;
//import java.sql.SQLOutput;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//
//import static sun.misc.Version.println;
//
//public class CircularBuffer<T> {
//
//    private Class clazz = null;
//    private int length;
//    private Object[] body;
//    private int tail;
//    private int head;
//
//    public Boolean isEmpty() {
//        return isEmpty;
//    }
//
//    private Boolean isEmpty;
//
//    public CircularBuffer(int length) {
//        this.length = length;
//        body = new Object[length];
//        tail = 0;
//        head = 0;
//        isEmpty = true;
//    }
//
//    public String  toString(){
//        return Arrays.asList(body).toString();
//    }
//
//    public void put(T t){
//        System.out.println("Attempt to Add: " + t);
//        if (!isEmpty && head == tail) {
//            System.out.println("Buffer is Full !");
//            System.out.println(Arrays.asList(body).toString());
//        }
//        else{
//            body[head] = t;
//            head = head + 1;
//            if (head == length) {head = 0;}
//            isEmpty = false;
//            System.out.println(Arrays.asList(body).toString());
//        }
//    }
//
//    public T get() {
//        if (isEmpty && head == tail) {throw new RuntimeException("Buffer is Empty!");}
//        else{
//        T item = (T) body[tail];
//        //body.remove(tail);
//        tail = tail + 1;
//        if (tail == length){
//            tail = 0;
//            if (tail == head){isEmpty = true;}
//        }
//        return item;
//        }
//    }
//
//   // public T[] toArray(){
//        //
//    //}
//
////   public T[] toObjectArray() {
////        List<T> list = new ArrayList<>(length);
////        for (Object e : body)
////            list.add(e);
////        return list.toArray();
////    }
////
////    public List<T> asList() {
////        List<T> list = new ArrayList<T>(length);
////        for (T e : body)
////            list.add(e);
////        return list;
////    }
//
//    public void addAll(List<? extends T> toAdd){
//        for(T t: toAdd){
//            put(t);
//        }
//    }
//
//    void sort(Comparator<? super T> comparator){
//        System.out.println("Before sort. head: " + head + "; tail:" + tail);
//        for (int i = 0; i < length - 1; i++) {
//            for (int j = i+1; j < length; j++) {
//                if ((comparator.compare(body[i], body[j])) == 1){
//                    T temp = body[i];
//                    body[i] = body[j];
//                    body[j] = temp;
//                    if (tail == i) {tail = j;} else { if (tail == j) { tail = i;}}
//                    if (head == i){head = j;}else{if (head == j){head = i;}}
//                    }
//            }
//        }
//
//
//
//        System.out.println("After sort. head: " + head + "; tail:" + tail);
//    }
//
//
//
//}
//
