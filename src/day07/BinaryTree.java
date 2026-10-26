package day07;

import day01.MyArrayList;
import day04.MyArrayStack;
import day05.MyLinkedQueue;


public class BinaryTree {
    private TreeNode root;


    public BinaryTree(){}
    public boolean isEmpty(){
        return root == null;
    }
    public void setRoot(TreeNode root){
        this.root = root;
    }
    //前序遍历
    private void preorder(TreeNode node, MyArrayList<Integer> out){
        if(node == null){
            return;
        }
        out.add(node.getVal());
        preorder(node.left,out);
        preorder(node.right,out);
    }
    public MyArrayList<Integer> preorder(){
        MyArrayList<Integer> out = new MyArrayList<>();
        preorder(root ,out);
        return out;
    }

    private void inorder(TreeNode node,MyArrayList<Integer>out){
        if(node == null){
            return;
        }
        inorder(node.left,out);
        out.add(node.getVal());
        inorder(node.right,out);
    }
    public MyArrayList<Integer>innorder(){
        MyArrayList<Integer> out = new MyArrayList<>();
        inorder(root,out);
        return out;
    }

    private void postorder(TreeNode node,MyArrayList<Integer>out){
        if(node == null) return;
        postorder(node.left,out);
        postorder(node.right,out);
        out.add(node.getVal());
    }
    public MyArrayList<Integer>postorder(){
        MyArrayList<Integer> out = new MyArrayList<>();
        postorder(root,out);
        return out;
    }
    public MyArrayList<Integer> preorderByStack(){
        MyArrayList<Integer> out = new MyArrayList<>();
        if(root == null){
            return out;
        }
        MyArrayStack<TreeNode> stack = new MyArrayStack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();//必须把整个节点（连同它的 val、left、right）一起弹出来。
            out.add(node.getVal());
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return out;
    }
    public MyArrayList<Integer> inorderByStack(){
        MyArrayList<Integer> out = new MyArrayList<>();
        MyArrayStack<TreeNode> stack = new MyArrayStack<>();

        TreeNode cur = root;
        while(cur != null|| !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            out.add(node.getVal());
            cur = node.right;
        }
        return out;
    }
    public MyArrayList<Integer>postorderBystack(){
        MyArrayList<Integer> out = new MyArrayList<>();
        if(root == null){
            return out;
        }

        MyArrayList<Integer> temp = new MyArrayList<>();

        MyArrayStack<TreeNode> stack = new MyArrayStack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();//必须把整个节点（连同它的 val、left、right）一起弹出来。
            temp.add(node.getVal());
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        for(int i = temp.size()-1;i>=0;i--){
            out.add(temp.get(i));
        }
        return out;
    }
    public MyArrayList<Integer>levelOrder(){
        MyArrayList<Integer> out = new MyArrayList<>();
        if(root == null){
            return out;
        }
        MyLinkedQueue<TreeNode> queue = new MyLinkedQueue<>();
        queue.enqueue(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.dequeue();
            out.add(node.getVal());
            if(node.left != null){
                queue.enqueue(node.left);
            }
            if(node.right != null){
                queue.enqueue(node.right);
            }
        }
        return out;
    }
}
