package com.skv.corejava;

import java.util.*;
import java.lang.*;

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(80);
        list.add(2,50);
        list.set(3,50);

// 		list.remove(1);

        for(int x : list){
            System.out.println(x);
        }
// 		System.out.println(list.get(0));
// 		System.out.println(list.contains(5));


        //addition to this list isnt allowed only the elements can be replaced
        List<Integer> aslist = Arrays.asList(1, 2, 3, 4);
        //aslist.add(1); //add not allowed
        aslist.set(1,999); //replace 1st index from 2 to 999
        //aslist.remove(Integer.valueOf(3)); //remove not allowed
        System.out.println(aslist);

        //wrap with new ArrayList<> then everything will work with Arrays.asList
        List<Integer> modifyableList = new ArrayList<> (Arrays.asList(6, 7, 8, 9));
        modifyableList.add(2);
        modifyableList.remove(Integer.valueOf(7));
        System.out.println(modifyableList);


        //unmodifiable list neither add nor set allowed
        List<Integer> integers = List.of(1, 2, 3);
        System.out.println(integers);

//        Summary:
//
//        Arrays.asList(): Fixed size, can modify elements
//        List.of(): Completely immutable
//        new ArrayList<>(Arrays.asList(...)): Fully modifiable
//        Collections.unmodifiableList(): Makes any list immutable

    }
}

