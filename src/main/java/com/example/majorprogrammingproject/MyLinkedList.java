package com.example.majorprogrammingproject;

public class MyLinkedList {
    MyNode head = null;

    public MyLinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        if(head == null) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        MyNode current = head;
        int size = 0;
        while(current != null) {
            if (head != null) {
                size++;
                current = current.next;
            } else {
                break;
            }
        }
        return size;
    }

    public void insert(Restaurant item) {
        MyNode newNode = new MyNode(item);
        MyNode current = head;
        MyNode temp = null;

        while(current != null && item.name.compareTo(current.item.name) >= 0) {
            temp = current;
            current = current.next;
        }

        if(temp == null) {
            head = newNode;
        } else {
            temp.next = newNode;
        }
        newNode.next = current;

    }

    public String remove(int i) throws MyLinkedListException{
        if (i < 0 || i > size()) {
            final String ERROR = "Error! Index out of bounds: ";
            throw new MyLinkedListException(ERROR, i);
        }
        MyNode current;
        current = head;

        if(i == 0 && head != null) {
            head = current.next;
        } else {
            for(int index = 1; index < i; index++)
            {
                current = current.next;
            }
            current.next = current.next.next;
        }

        return toString();
    }

    public void remove(Restaurant item) throws MyLinkedListException{
        remove(find(item));
    }

    public void removeAll() {
        head = null;
    }

    public Restaurant get(int i) throws MyLinkedListException{
        if(i < 0 && i >= size()) {
            throw new MyLinkedListException(i);
        }
        MyNode current = head;
        for (int index = 0; index < i; index++) {
            current = current.next;
        }
        return current.item;
    }

    public int find(Restaurant item) {
        int index = 0;
        MyNode current = head;
        while(current.next != null && item.name.compareTo(current.item.name) != 0) {
            index++;
            current = current.next;
        }
        if (current.next == null) {
            return -1;
        }
        return index;

    }

    public String toString() {
        if (head == null) {
            return "[null]";
        } else {
            String result = "[" + head.item;
            MyNode curr = head.next;

            while (curr != null) {
                result += " -> " + curr.item;
                curr = curr.next;
            }

            result += " -> null]";
            return result;
        }

    }


}

