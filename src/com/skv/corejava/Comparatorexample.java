package com.skv.corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

class Student{
    private  String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.gpa = gpa;
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "com.skv.corejava.Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
public class Comparatorexample {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Dlice",3.5));
        students.add(new Student("Bob",3.7));
        students.add(new Student("Charlie",3.5));
        students.add(new Student("Akshit",3.8));

        // bare metal way of writing own comparator using lambda expression
        students.sort((a,b)->{
            /*
            doing this because gpa is in double and if we directly do (int) (a.getGpa()-b.getGpa())
             it will not correctly subtract and after typecasting it to int it will give same result and ignore decimals so it wont be sorted correctly
            */
            if(a.getGpa()-b.getGpa()>0) return 1;
            else if(a.getGpa()-b.getGpa()<0) return -1;
            else return 0;

        });
        System.out.println(students);

        /*
        after java8 method referencing(com.skv.corejava.Student::getGpa) was introduced so we dont have to write our own
        comparator from scratch
        */
        Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);
        students.sort(comparator);
        System.out.println(students);

        //using collections
        Collections.sort(students,comparator);
        System.out.println(students);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);

        list.sort((a,b)->b-a); // asc = ((a,b)->a-b), desc = ((a,b)->b-a)

        System.out.println(list);

        List<String> words = new ArrayList<> (List.of("shiva","sakshi","don","Aamenaa"));
        words.sort((a,b)->a.length()-b.length());
        System.out.println(words);
    }
}