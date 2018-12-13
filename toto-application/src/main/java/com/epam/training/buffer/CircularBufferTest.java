//package com.epam.training.buffer;
//
//import java.lang.reflect.Array;
//import java.util.*;
//
//public class CircularBufferTest {
//    public static void main(String[] args) {
//
//        CircularBuffer<Integer> com.epam.training.buffer = new CircularBuffer<>(2);
//        //CircularBuffer<Integer> com.epam.training.buffer = new CircularBuffer(2);
//        System.out.println("Is com.epam.training.buffer empty: " + com.epam.training.buffer.isEmpty());
//
//        com.epam.training.buffer.put(25);
//        System.out.println("Is com.epam.training.buffer empty: " + com.epam.training.buffer.isEmpty());
//        com.epam.training.buffer.put(30);
//        System.out.print("get from com.epam.training.buffer: ");
//        System.out.println(com.epam.training.buffer.get());
//        System.out.print("get from com.epam.training.buffer: ");
//        System.out.println(com.epam.training.buffer.get());
//        try {
//            System.out.print("get from com.epam.training.buffer: ");
//            System.out.println(com.epam.training.buffer.get());
//        }
//        catch (RuntimeException r){
//            System.out.println(r.getMessage());
//        }
//        System.out.println("Is com.epam.training.buffer empty: " + com.epam.training.buffer.isEmpty());
//       // Integer[] arInt = com.epam.training.buffer.toArray();
//       // Arrays.stream(arInt).forEach(x -> System.out.format("%s, ", x));
//        //Object[] arObj = com.epam.training.buffer.toObjectArray();
//        //Arrays.stream(arObj).forEach(x -> System.out.format("%s, ", x));
//       // List<Integer> list = com.epam.training.buffer.asList();
//        //System.out.println("list:" + list);
//        List<Integer> toAdd = Arrays.asList(1,2,5);
//        System.out.println("Attempt to add list: " + toAdd);
//        com.epam.training.buffer.addAll(toAdd);
//
//        class CompareInteger implements Comparator<Integer> {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return -1*o1.compareTo(o2);
//            }
//        }
//        System.out.print("get from com.epam.training.buffer: ");
//        System.out.println(com.epam.training.buffer.get());
//        com.epam.training.buffer.sort(new CompareInteger());
//        System.out.println("Sorted com.epam.training.buffer:" + com.epam.training.buffer);
//    }
//
//}
//
//
//
//
