package org.chenfeng.taling.study.day5.linked;

import org.apache.commons.lang3.StringUtils;

public class LinkedListDemo {

    private Node first; //根节点
    private Node last; //尾节点
    private int size = 0; //链表长度20010

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

    public boolean removeFirst(){
        if(this.first != null){
            removeNode(this.first);
            return true;
        }
        return false;
    }

    public boolean removeLast(){
        if(this.last != null){
            removeNode(this.last);
            return true;
        }
        return false;
    }

    public boolean removeObj(String obj){
        if(StringUtils.isNotBlank(obj) && this.size > 0){
            Node node = this.first;
            for (int i = 0; i < this.size; i++) {
                if(obj.equals(node.item)){
                    removeNode(node);
                    return true;
                }
                node = node.next;
            }

        }
        return false;
    }

    /**
     * node prev next
     * 删除的节点如果是根节点
     * 1、node.prev == null && node.next != null
     * node.next.prev ==  null , root = node.next;
     * 删除的链表只有一个节点
     * 2、node.prev == null && node.next == null
     * root = null, last =null;
     * 删除的几点为中间节点
     * 3、node.prev != null && node.next != null
     * node.prev.next = node.next node.next.prev = node.prev
     * 删除的节点为尾节点
     * 4、node.prev != null && node.next == null
     * node.prev.next = null last = node.prev
     *
     * 总结：
     * if(node.prev == null){
     *  root = node.next;
     * }else{
     * node.prev.next = node.next
     * }
     * if(node.next == null){
     * last = node.prev
     * }else{
     * node.next.prev = node.prev
     * }
     * @param node
     */
    private void removeNode(Node node){
        if(node.prev == null){
            first = node.next;
        }else{
            node.prev.next = node.next;
        }
        if(node.next == null){
            last = node.prev;
        }else{
            node.next.prev = node.prev;
        }
        this.size -- ;
        node = null;
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
