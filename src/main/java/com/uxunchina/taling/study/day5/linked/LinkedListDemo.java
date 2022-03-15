package com.uxunchina.taling.study.day5.linked;

import org.apache.commons.lang3.StringUtils;

public class LinkedListDemo {

    private Node first; //根节点
    private Node last; //尾节点
    private int size = 0; //链表长度

    public int getSize() {
        return this.size;
    }

    public boolean add(String item) {
        if (StringUtils.isNotBlank(item)) {
            Node node = new Node(item, null, this.last);
            this.size++;
            if (first == null) {
                this.first = node;
            } else {
                this.last.next = node;
            }
            this.last = node;
            return true;
        }
        return false;
    }

    public boolean add(int index, String obj) {
        //1、找到下标位置节点
        //2、下标位置节点的父节点的下一个节点 设置为新节点
        //3、新节点的下一个节点设置为下标位置节点
        if (checkIndex(index) && StringUtils.isNotBlank(obj)) {
            Node node = this.first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            //System.out.println(node.item);

            Node newNode = new Node(obj, node, node.prev);
            this.size++;
            node.prev.next = newNode;
            return true;
        }
        return false;
    }

    private boolean checkIndex(int index) {
        return (index >= 0 && index < this.size);
    }

    public void print() {
        if (this.size > 0) {
            Node node = this.first;
            for (int i = 0; i < this.size; i++) {
                System.out.println("item：" + node.item +
                        " prev：" + (node.prev == null ? "null" : node.prev.item) +
                        " next：" + (node.next == null ? "null" : node.next.item));
                node = node.next;
            }
        }
    }

    public String getFirst() {
        return this.first.item;
    }

    public String getLast() {
        return this.last.item;
    }

    public String get(int index) {
        if (checkIndex(index)) {
            Node node = this.first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.item;
        }
        return null;
    }

    public boolean set(int index, String obj) {
        if (checkIndex(index)) {
            Node node = this.first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.item = obj;
            return true;
        }
        return false;
    }

    public boolean contains(String obj) {
        if (StringUtils.isNotBlank(obj) && this.size > 0) {
            Node node = this.first;
            for (int i = 0; i < this.size; i++) {
                if(node.item.equals(obj)){
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    //TODO 删除方法待整理
    public boolean removeFirst(){
        if(this.first != null){
            //1、找到下一个节点设置为
            this.first.prev = null;
            this.first = this.first.next;
            this.size --;
            return true;
        }
        return false;
    }

    //TODO 删除方法待整理
    public boolean removeLast(){
        if(this.last != null){
            this.last.prev.next = null;
            this.last = this.last.prev;
            this.size --;
            return true;
        }
        return false;
    }

    //TODO 删除方法待整理
    public boolean removeObj(String obj){
        return false;
    }


    private static class Node {
        String item;
        Node next;
        Node prev;

        public Node(String item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
