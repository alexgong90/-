package com.gc.linkedlist;

/**
 * 一般含有的几个元素：
 * ###头节点
 * ###添加（尾部）
 * ###遍历
 * ###
 * <p>
 * tip 1： 头节点不要动，动了，整个链表就变化了
 * tip 2: 你只能指一个node，但是可以被很多node指
 * tip 3: 查找方向只能是一个， 且不能用待删除节点自我删除，删除节点需要辅助节点
 */
public class SingleLinkedList {
    /**
     * 头节点的作用：
     */
    public HeroNode head = new HeroNode(0, "", "");

    public SingleLinkedList add(HeroNode node) {
        //遍历找到尾节点
        HeroNode pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        //此时pointer是尾节点
        pointer.next = node;
        return this;
    }

    /**
     * 按照NO来进行添加，如果此No已经存在，则返回打印添加失败
     *
     * @param node
     * @return
     */
    public SingleLinkedList addOrderByNo(HeroNode node) {
        HeroNode pointer = head;
        if (pointer.next == null) {
            pointer.next = node;
            return this;
        }
        while (true) {
            pointer = pointer.next;
            if (node.no == pointer.no) {
                System.out.println("已经存在此排名，无法添加");
                return this;
            }
            if (pointer.next == null) {
                pointer.next = node;
                return this;

            } else if (node.no > pointer.no && (node.no < pointer.next.no)) {
                node.next = pointer.next;
                pointer.next = node;
                return this;
            }
        }
    }

    /**
     * 这个关键在于，如果想修改一个节点，遍历用的pointer必须提前一个来做替换操作，而不能已经位于该节点在进行操作
     * 否则将无法获取该节点的句柄
     */
    public void updateNode(HeroNode node) {
        HeroNode pointer = head;
        if (pointer.next == null) {
            System.out.println("链表为null");
            return;
        }
        while (pointer.next != null) {
            if (pointer.next.no == node.no) {
                node.next = pointer.next.next;
                pointer.next = node;
                break;
            }
            pointer = pointer.next;
        }
    }

    public void updateNode2(HeroNode node) {
        HeroNode pointer = head;
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

    public void remove(HeroNode node) {
        HeroNode pointer = head;
        if (pointer.next == null) {
            System.out.println("链表为null");
            return;
        }
        while (pointer.next != null) {
            if (pointer.next.equals(node) ) {
                pointer.next = pointer.next.next;
                break;
            }
            pointer = pointer.next;
        }
    }

    public void remove2(HeroNode node) {
        HeroNode pointer = head;
        boolean flag = false;
        while (true) {
            if (pointer.next == null) {
                System.out.println("is null");
                break;
            }
            if (pointer.next.no == node.no) {
                flag = true;
                break;
            }
            pointer = pointer.next;
        }
        if (flag) {
            pointer.next = pointer.next.next;
        } else {
            System.out.println("no is not exist");
        }
    }

    /**
     * 遍历
     */
    public void list() {
        HeroNode pointer = head;
        if (pointer.next == null) {
            System.out.println("linkedList is null");
            return;
        }
        while (pointer.next != null) {
            pointer = pointer.next;
            System.out.println(pointer);
        }
    }
}
