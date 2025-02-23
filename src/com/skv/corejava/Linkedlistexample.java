package com.skv.corejava;

import java.util.Arrays;
import java.util.LinkedList;

public class Linkedlistexample {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.get(2); // O(n) linkedlist is better than arraylist for insertions/deletions at middle
        //linkedlist is slower at random access as it has to traverse entire list O(n) and it takes more memory than arrayList
        linkedList.addLast(9); //O(1)
        linkedList.addFirst(9); //O(1)
        System.out.println(linkedList);
        linkedList.getFirst();
        linkedList.getLast();
        linkedList.removeIf(x->x%2==0);
        System.out.println(linkedList);

        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat", "Dog", "Elephant"));
        LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("Dog", "Lion"));
        animals.removeAll(animalsToRemove);
        System.out.println(animals);


    }
}
