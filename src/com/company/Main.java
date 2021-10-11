package com.company;

public class Main {

    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        System.out.println(list);
        System.out.println(list.findHalfSize());
    }
}
