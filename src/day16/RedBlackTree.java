package day16;

public class RedBlackTree <E extends Comparable<E>>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private static class Node<E>{
        E value;
        Node<E> left;
        Node<E> right;
        Node<E> parent;
        boolean color;

        Node(E value){
            this.value = value;
            this.color = RED;// 新插入的节点默认是红色（为了不破坏黑高平衡）
            this.parent = null;
        }
    }

    private Node<E> root;

    public RedBlackTree(){
        this.root = null;
    }
    private boolean getColor(Node<E> node){
        if(node == null){
            return BLACK;
        }
        return node.color;
    }
    // 右旋（处理 LL 型）
    private void rotateRight(Node<E> y){
        Node<E> x = y.left;
        Node<E> T2 = x.right;
        y.left = T2;
        if(T2 != null){
            T2.parent = y;
        }
        x.parent = y.parent;
        if(y.parent == null){
            root = x;
        }else if(y == y.parent.left){
            y.parent.left = x;
        }else {
            y.parent.right = x;
        }
        x.right = y;
        y.parent = x;
    }
    // 左旋（处理 RR 型）
    private void rotateLeft(Node<E> x){
        Node<E> y = x.right;
        Node<E> T2 = y.left;
        x.right = T2;
        if(T2 != null){
            T2.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == null){
            root = y;
        }else if(x == x.parent.left){
            x.parent.left = y;
        }else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    public void insert(E value){
        Node<E> newNode = new Node<>(value);
        if(root == null){
            root = newNode;
            root.color = BLACK;// 根节点必须是黑色
            return;
        }
        Node<E> cur = root;
        Node<E> parent = null;

        //  寻找插入位置
        while(cur != null){
            parent = cur;
            int cmp = value.compareTo(cur.value);
            if(cmp < 0){
                cur = cur.left;
            }else if(cmp > 0){
                cur = cur.right;
            }else {
                return;
            }
        }
        newNode.parent = parent;
        if(value.compareTo(parent.value) < 0){
            parent.left = newNode;
        }else{
            parent.right = newNode;
        }
        fixInsert(newNode);
    }
    private void fixInsert(Node<E> node){
        while (node != root && getColor(node.parent) == RED){
            Node<E> parent = node.parent;
            Node<E> grandParent = parent.parent;

            if(parent == grandParent.left){
                Node<E> uncle = grandParent.right;
                if(getColor(uncle) == RED){
                    flipColor(parent,uncle,grandParent);
                    node = grandParent;
                }else {
                    handleLeftCase(node,parent,grandParent);
                    break;
                }
            }else {
                Node<E> uncle = grandParent.left;
                if(getColor(uncle) == RED){
                    flipColor(parent,uncle,grandParent);
                    node = grandParent;
                }else {
                    handleRightCase(node,parent,grandParent);
                    break;
                }
            }
        }
        root.color = BLACK;
    }



    // 辅助动作 1：三人变色，当叔叔节点是红色时
    private void flipColor(Node<E> parent,Node<E> uncle,Node<E> grandParent){
        parent.color = BLACK;
        uncle.color = BLACK;
        grandParent.color = RED;
    }
    // 辅助动作 2：处理左边的情况（爹是爷爷的左孩子），叔叔是黑色（或空）
    private void handleLeftCase(Node<E> node,Node<E>parent,Node<E>grandParent){
        // 判断是不是 LR 型
        if(node == parent.right){
            node = parent;
            rotateLeft(node);
            parent = node.parent;
        }
        //现在的形态一定是 LL 型
        parent.color = BLACK;
        grandParent.color = RED;
        rotateRight(grandParent);
    }
    // 辅助动作 3：处理右边的情况（爹是爷爷的右孩子）,叔叔是黑色（或空）
    private void handleRightCase(Node<E> node,Node<E> parent,Node<E>grandParent){
        //判断是不是 RL 型
        if(node == parent.left){
            node = parent;
            rotateRight(node);
            parent = node.parent;
        }
        //现在的形态一定是 RR 型
        parent.color = BLACK;
        grandParent.color =RED;
        rotateLeft(grandParent);
    }
    // 验证红黑树规则
    public boolean checkVaild(){
        if(root == null){
            return true;
        }
        if(root.color == RED){
            return false;
        }
        return checkRedRed(root);
    }
    private boolean checkRedRed(Node<E> node){
        if(node == null){
            return true;
        }
        if(node.color == RED){
            if(getColor(node.left) == RED || getColor(node.right) == RED){
                return false;
            }
        }
        return checkRedRed(node.left) && checkRedRed(node.right);
    }
}
