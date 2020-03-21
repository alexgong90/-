package com.gc.tree;

public class TreeDemo {
    public static void main(String[] args) {
        //create some node
        BinaryTree binaryTree = new BinaryTree();
        HeroNode node = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        node.left = node2;
        node.right = node3;
        node3.right = node4;
        binaryTree.root = node;
        binaryTree.preOrder();
        binaryTree.infixOrder();
        binaryTree.postOrder();
        //面试题,如果node3.left = node5,请写出 三种遍历的输入?

        //顺序数组转存二叉树
        int[] arr = {1,2,3,4,5,6,7};
        HeroNode rootNode = new HeroNode(-1, "");

        dumpBinaryFromArr(arr,node);

    }

    private static void dumpBinaryFromArr(int[] arr, HeroNode node) {

    }
}

class BinaryTree {
    public HeroNode root;

    /**
     * 三种遍历
     */
    public void preOrder() {
        if (this.root == null) {
            System.out.println("null");
            return;
        }
        this.root.preOrder();
    }
    public void infixOrder() {
        if (this.root == null) {
            System.out.println("null");
            return;
        }
        this.root.infixOrder();
    }
    public void postOrder() {
        if (this.root == null) {
            System.out.println("null");
            return;
        }
        this.root.postOrder();
    }

    //前序查找
   /* public HeroNode preOrderSearch(int no) {
        if (root.no == no) {
            return root;
        }
        if (root.left != null) {

        }
    }*/
}


//创建节点
class HeroNode {
    public int no;
    public String name;
    public HeroNode left;
    public HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    //前序遍历, 父,左,右
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历, 左父右
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);

        if (this.right != null) {
            this.right.preOrder();
        }
    }
    //后序遍历, 左右父

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);

    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}