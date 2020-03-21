package com.gc.linkedlist;

public class DoubleLinkedLIst {
    public HeroNode2 head = new HeroNode2(0, "", "");

    /**
     * 遍历
     */
    public void list() {
        HeroNode2 pointer = head;
        if (pointer.next == null) {
            System.out.println("linkedList is null");
            return;
        }
        while (pointer.next != null) {
            pointer = pointer.next;
            System.out.println(pointer);
        }
    }


    public DoubleLinkedLIst add(HeroNode2 node) {
        //遍历找到尾节点
        HeroNode2 pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        //此时pointer是尾节点
        pointer.next = node;
        node.pre = pointer;
        return this;
    }


    public void updateNode2(HeroNode2 node) {
        HeroNode2 pointer = head;
        if (pointer.next == null) {
            System.out.println("链表为null");
            return;
        }
        while (pointer.next != null) {

            pointer = pointer.next;
            if (pointer.no == node.no) {
                pointer.name = node.name;
                pointer.nickname = node.nickname;
                break;
            }
        }
    }

    public void remove(HeroNode2 node) {
        HeroNode2 pointer = head;
        if (pointer.next == null) {
            System.out.println("链表为null");
            return;
        }
        while (pointer != null) {
            if (pointer.equals(node) ) {
                pointer.pre.next = pointer.next;
                if (pointer.next != null) {
                    pointer.next.pre = pointer.pre;
                }
                break;
            }
            pointer = pointer.next;
        }
    }
}

