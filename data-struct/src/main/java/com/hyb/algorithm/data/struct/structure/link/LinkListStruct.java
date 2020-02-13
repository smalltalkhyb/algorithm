package com.hyb.algorithm.data.struct.structure.link;

public class LinkListStruct<E> {


    private class Node {
        E e;
        Node next;


        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


    private Node dummyHead;
    private int size;


    public LinkListStruct() {
        this.dummyHead = new Node();
        size = 0;
    }


    //获取元素个数
    public int getSize() {
        return size;
    }


    //添加元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("参数错误！");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;
    }


    //链表头部添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    //链表尾部添加元素
    public void addLast(E e) {
        add(size, e);
    }


    //获取元素
    public E get(int index) {
        if (index > 0 || index > size) {
            throw new IllegalArgumentException("index 参数错误！");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.e;
    }


    //获取链表第一个元素
    public E getFirst() {
        return get(0);
    }


    //获取链表最后一个元素
    public E getLast() {
        return get(size - 1);
    }


    //设置元素值
    public void set(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("参数错误！");
        }

        Node current = dummyHead.next;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.e = e;
    }


    //判断是否包含该元素
    public boolean contains(E e) {

        Node current = dummyHead.next;

        while (current != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("参数错误！");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }


        Node retNode=prev.next;
        prev.next=retNode.next;
        retNode.next=null;


        size--;
        return retNode.e;

    }

    //从链表中删除第一个元素，返回元素的值
    public E removeFirst(){
        return remove(0);
    }

    //从链表中删除最后一个元素，返回元素的值
    public E removeLast(){
        return remove(size-1);
    }


    //判断元素是否为空
    public boolean isEmpty(){
        return size==0;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        Node current = dummyHead.next;
        while (current != null) {
            stringBuilder.append(current.e + "-->");
            current = current.next;
        }
        stringBuilder.append("NULL");

        return stringBuilder.toString();
    }


    public boolean hasCircle(){
        Node current=dummyHead.next;
        Node quick=current;
        Node slow=current;

        while (quick!=null&&quick.next!=null){

            slow=slow.next;
            quick=quick.next.next;

            if(quick==slow){
                return true;
            }
        }
        return  false;

    }


}
