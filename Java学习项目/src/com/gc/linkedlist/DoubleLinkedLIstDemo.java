package com.gc.linkedlist;

public class DoubleLinkedLIstDemo {
    private static Object lock = new Object() ;
    public static void main(String[] args) {
        DoubleLinkedLIst list = new DoubleLinkedLIst();
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        HeroNode2 hero5 = new HeroNode2(5, "公孙胜", "入云龙");
        list.add(hero1)
                .add(hero2)
                .add(hero3)
                .add(hero4)
                .add(hero5);
        hero1.pre = hero5;
        hero5.next = hero1;
        System.out.println(isCircle(list.head));
    }

    /**
     * 约瑟夫问题
     */
    private HeroNode2 Josephu(HeroNode2 node2) {
        int step = 2;
        HeroNode2 pointer = new HeroNode2(-1, "", "");
        pointer.next = node2.next;

        return null;
    }

    /**
     * 判断是否有环
     */
    private static boolean isCircle(HeroNode2 node2) {
        if (node2 == null || node2.next == null || node2.next.next == null) {
            return false;
        }
        HeroNode2 slow = new HeroNode2(-1, "", "");
        HeroNode2 fast = new HeroNode2(-2, "", "");
        slow.next = node2.next;
         fast.next = node2.next;
        boolean flag = false;
        while (fast != null) {
            synchronized (lock) {
                System.out.println("s:   "+slow);
                System.out.println("f:   "+fast);
                slow = slow.next;
                fast = fast.next.next;
                if (slow.equals(fast)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}
