package day08;

import day01.MyArrayList;
import day04.MyArrayStack;

public class MyBST <E extends Comparable<E>>{
    private static class Node<E>{
        E value;
        Node<E> left;
        Node<E> right;

        Node(E value){
            this.value = value;
        }
    }
    private Node<E> root;
    private int size;

    public MyBST(){
        this.root = null;
        this.size = 0;
    }


    public boolean search(E value){
        if(root == null){
            return false;
        }
        Node<E> cur = root;
        while(cur != null){
            int cmp = value.compareTo(cur.value);
            if(cmp >  0){
                cur = cur.right;
            } else if (cmp == 0) {
                return true;
            }else{
                cur = cur.left;
            }
        }
        return false;
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
        if(cmp == 0){
        } else if (cmp < 0) {
            node.left = insert(node.left, value);
        }else {
            node.right = insert(node.right, value);
        }
        return node;
    }
    public MyArrayList<E> inorderByStack(){
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
    public void delete(E value){
        root = delete(root,value);
    }
    private Node<E> delete(Node<E> node,E value){
        if(node == null){
            return null;
        }
        int cmp = value.compareTo(node.value);
        if(cmp < 0){
            node.left = delete(node.left, value);
        }else if(cmp > 0){
            node.right = delete(node.right, value);
        }else{
            if(node.left == null && node.right == null){
                size --;
                return null;
            }else if(node.left == null && node.right !=null){
                size--;
                return node.right;
            }else if(node.left != null && node.right == null){
                size--;
                return node.left;
            }else{
                // 1. 找到右子树的最小节点（后继）
                Node<E>successor = findMin(node.right);
                // 2. 把后继的值赋给当前节点
                node.value = successor.value;
                // 3. 去右子树把那个后继节点删掉
                node.right = delete(node.right,successor.value);
            }
        }
        return node;
    }
    private Node<E> findMin(Node<E> node){
        while(node.left != null){
           node = node.left;
        }
        return node;
    }
}
