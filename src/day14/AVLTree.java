package day14;

import day01.MyArrayList;
import day04.MyArrayStack;

public class AVLTree <E extends Comparable<E>>{
    private static class  Node<E>{
        E value;
        Node<E> left;
        Node<E> right;
        int height;

        Node(E value){
            this.value = value;
            this.height = 1;
        }
    }
    private Node<E> root;
    private int size;

    public AVLTree(){
        this.root = null;
        this.size = 0;
    }

    //day08的bst里面写过
    public boolean search(E value) {
        if(root == null) return false;
        Node<E> cur = root;
        while(cur != null){
            int cmp = value.compareTo(cur.value);
            if(cmp > 0) cur = cur.right;
            else if (cmp == 0) return true;
            else cur = cur.left;
        }
        return false;
    }

    public MyArrayList<E> inorderByStack() {
        MyArrayList<E> out = new MyArrayList<>();
        MyArrayStack<Node<E>> stack = new MyArrayStack<>();
        Node<E> cur = root;
        while(cur != null|| !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            Node<E> node = stack.pop();
            out.add(node.value);
            cur = node.right;
        }
        return out;
    }

    public int getTreeHeight() {
        return getHeight(root);
    }


    private int getHeight(Node<E> node){
        if(node == null){
            return 0;
        }else {
            return node.height;
        }
    }
    private void updateHeight(Node<E> node){
        if(node == null){
            return;
        }
        node.height = Math.max(getHeight(node.left),getHeight(node.right))+1;
    }
    // 计算平衡因子（左子树高度 - 右子树高度）
    private int getBalanceFactor(Node<E> node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }
    // 右旋（处理 LL 型）
    private Node<E> rotateRight(Node<E> y){
        Node<E> x = y.left;
        Node<E> T2  = x.right;
        y.left = T2;
        x.right = y;
        updateHeight(y);
        updateHeight(x);
        return x;
    }
    // 左旋（处理 RR 型）
    private Node<E> rotateLeft(Node<E> x){
        Node<E> y = x.right;
        Node<E> T2 = y.left;
        x.right = T2;
        y.left = x;
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    public boolean checkBalance(){
        return isBalanced(root);
    }
    private boolean isBalanced(Node<E> node){
        if(node == null) return true;
        int bf = getBalanceFactor(node);
        if(Math.abs(bf)>1){
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }





    public void insert(E value){
        root = insert(root,value);
    }
    private Node<E> insert(Node<E> node,E value){
        if(node == null){
            size++;
            return new Node<>(value);
        }
        int cmp = value.compareTo(node.value);
        if(cmp < 0){
            node.left = insert(node.left,value);
        }else if(cmp > 0){
            node.right = insert(node.right,value);
        }else {
            return node;
        }

        updateHeight(node);
        int balance = getBalanceFactor(node);
        // 1. LL 型：左高，且插入的值比左孩子小（右旋）
        if (balance > 1 && value.compareTo(node.left.value) < 0) {
            return rotateRight(node);
        }
        // 2. RR 型：右高，且插入的值比右孩子大（左旋）
        if (balance < -1 && value.compareTo(node.right.value) > 0) {
            return rotateLeft(node);
        }
        // 3. LR 型：左高，但插入的值比左孩子大（先左旋左孩子，再右旋自己）
        if (balance > 1 && value.compareTo(node.left.value) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        // 4. RL 型：右高，但插入的值比右孩子小（先右旋右孩子，再左旋自己）
        if (balance < -1 && value.compareTo(node.right.value) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }
}
