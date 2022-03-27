package com.uxunchina.taling.study.day5.linked;

public class Main {

    public static void main(String[] args) {
        LinkedListDemo linkedListDemo = new LinkedListDemo();
        linkedListDemo.add("root");
        linkedListDemo.add("a");
        linkedListDemo.add("b");
        linkedListDemo.add("c");
        linkedListDemo.add("d");
//        linkedListDemo.add(3,"chenfeng");

//        System.out.println(linkedListDemo.getSize());
//        System.out.println(linkedListDemo.get(3));
//        System.out.println(linkedListDemo.set(1,"dddd"));
        linkedListDemo.removeFirst();
        linkedListDemo.removeLast();
        linkedListDemo.removeObj("c");
        linkedListDemo.print();
//        System.out.println(linkedListDemo.contains("chenfeng"));
    }
}
