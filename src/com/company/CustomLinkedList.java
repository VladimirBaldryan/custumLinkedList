package com.company;

import java.util.Objects;

public class CustomLinkedList<T> implements LinkedList<T> {
    Node first;
    Node last;
    int size;

    public CustomLinkedList() {
    }

    @Override
    public void add(T obj) {
        Node node = new Node((Integer) obj);
        if (first == null) {
            first = node;
            last = node;
            first.prev = null;
        } else {
            last.next = node;
            node.prev = last;
            last = last.next;
        }
        last.next = null;
        size++;
    }

    @Override
    public void removeFirst() {
        if (size == 1) {
            first = last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        size--;
    }

    @Override
    public void removeLast() {
        if (size == 1) {
            first = last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        size--;
    }

    public void removeAll() {
        while (last != null) {
            removeFirst();
        }
    }

    public void removeElement(T obj) {
        if (Objects.equals(obj, first.value)) {
            removeFirst();
        } else if (Objects.equals(obj, last.value)) {
            removeLast();
        } else {
            Node node2;
            Node node = first;
            for (int i = 0; i < size - 1; i++) {
                if (Objects.equals(obj, node.value)) {
                    node2 = node.prev;
                    node2.next = node.next;
                    node.next.prev = node2;
                }
                node = node.next;
            }
            size--;
        }
    }

    @Override
    public void swap2Elements(int obj1, int obj2) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(obj1)) {
                node.value = obj2;
            } else if (node.value.equals(obj2)) {
                node.value = obj1;
            }
            node = node.next;
        }
    }

    public void replaceElement(T obj, int index) {
        Node node = first;
        Node node2 = new Node((Integer) obj);
        for (int i = 0; i < size; i++) {
            if (i == index) {
                node2.value = node.value;
                break;
            }
            node = node.next;
        }
        swap2Elements((Integer) obj, node2.value);
    }

    public int[] toArray() {
        int[] convertList = new int[size];
        Node node = first;
        for (int i = 0; i < size; i++) {
            convertList[i] = node.value;
            node = node.next;
        }
        return convertList;
    }

    public int findHalfSize() {
        int half = 0;
        Node node1 = first;
        Node node2 = last;
        while (node1.next != null) {
            if (node1.value.equals(node2.value)) {
                half++;
                break;
            }
            node1 = node1.next;
            if (node1.value.equals(node2.value)) {
                half++;
                break;
            }
            node2 = node2.prev;
            half++;
        }

        return half;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = first;
        for (int i = 0; i < size; i++) {
            result.append(current.value);
            if (i < size - 1) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }
}
