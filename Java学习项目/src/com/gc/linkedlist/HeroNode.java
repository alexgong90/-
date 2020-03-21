package com.gc.linkedlist;

import java.util.Objects;

/**
 * 数据结构：链表节点，模拟水浒英雄卡
 */
public class HeroNode {

    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name,String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroNode heroNode = (HeroNode) o;
        return no == heroNode.no &&
                name.equals(heroNode.name) &&
                nickname.equals(heroNode.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name, nickname);
    }
}
