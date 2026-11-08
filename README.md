# DS · 手写数据结构与算法（Java）

从零手写常用数据结构，一天一个，循序渐进。所有实现均为 Java 原生代码，不依赖任何第三方库，便于理解底层原理。

## 目录

- [学习清单](#学习清单)
- [目录结构](#目录结构)
- [复杂度速查表](#复杂度速查表)
- [如何运行](#如何运行)

## 学习清单

| 天数 | 内容 | 核心文件 | 关键技巧 / 知识点 |
| ---- | ---- | -------- | ----------------- |
| day01 | 动态数组 | `MyArrayList` | `add/get/set/remove`、自动扩容 |
| day02 | 单链表 | `MyLinkedList` | 头插 / 尾插、链表反转 |
| day03 | 双链表 & 循环链表 | `MyLinkedList` / `MyCircularLinkedList` | 虚拟头节点（dummy head）、双向指针维护 |
| day04 | 顺序栈 | `MyArrayStack` | 基于数组的栈，LIFO |
| day05 | 队列 | `MyCircularQueue` / `MyLinkedQueue` | 循环队列下标回绕、链式队列 FIFO |
| day06 | 哈希表 & 哈希集合 | `MyHashMap` / `MyHashSet` | 拉链法、负载因子、扩容 rehash |
| day07 | 二叉树 | `TreeNode` / `BinaryTree` | 递归、迭代、层序遍历 |
| day08 | 二叉搜索树 BST | `MyBST` | `insert/search/delete`、删除的三种情况 |
| day09 | 最小堆 | `MyMinHeap` | 上浮（siftUp）、下沉（siftDown） |
| day10 | 优先队列 | `MyPriorityQueue` | 基于堆，支持 `Comparator` 自定义优先级 |
| day11 | 并查集 | `UnionFind` | 路径压缩 + 按秩合并 |
| day12 | 图 | `Graph` | 邻接表实现、DFS、BFS |
| day13 | 最短路 & 拓扑排序 | `WeightedGraph` / `Dijkstra` / `TopoSort` | 优先队列优化 Dijkstra、Kahn 算法 |
| day14 | AVL 树 | `AVLTree` | 高度维护、四种旋转（LL/LR/RR/RL）、平衡校验 |
| day15 | 字典树 Trie | `Trie` | 前缀搜索、自动补全 |
| day16 | 红黑树 | `RedBlackTree` | 左旋、右旋、颜色翻转、插入修复 |

## 目录结构

```
DS
├── src
│   ├── Main.java              # 入口
│   ├── day01/MyArrayList.java
│   ├── day02/MyLinkedList.java
│   ├── day03/MyCircularLinkedList.java
│   ├── day04/MyArrayStack.java
│   ├── day05/MyCircularQueue.java / MyLinkedQueue.java
│   ├── day06/MyHashMap.java / MyHashSet.java
│   ├── day07/BinaryTree.java / TreeNode.java
│   ├── day08/MyBST.java
│   ├── day09/MyMinHeap.java
│   ├── day10/MyPriorityQueue.java
│   ├── day11/UnionFind.java
│   ├── day12/Graph.java
│   ├── day13/Dijkstra.java / TopoSort.java / WeightedGraph.java
│   ├── day14/AVLTree.java
│   ├── day15/Trie.java
│   └── day16/RedBlackTree.java
└── out                      # 编译产物
```

每个 `dayXX` 目录下通常附带一个 `Test` / `test` 类，用于验证该数据结构的正确性。

## 复杂度速查表

| 数据结构 | 查找 | 插入 | 删除 | 备注 |
| -------- | ---- | ---- | ---- | ---- |
| 动态数组 | O(1) 随机访问 | O(1) 均摊（尾部） | O(n)（中间） | 扩容均摊 O(1) |
| 单/双链表 | O(n) | O(1)（头部） | O(1)（已知节点） | |
| 栈 / 队列 | — | O(1) | O(1) | |
| 哈希表 | O(1) 平均 | O(1) 平均 | O(1) 平均 | 最坏 O(n) |
| 二叉搜索树 | O(log n) 平均 | O(log n) 平均 | O(log n) 平均 | 最坏退化为 O(n) |
| 堆 / 优先队列 | O(1) 取最值 | O(log n) | O(log n) | |
| 并查集 | O(α(n)) ≈ O(1) 均摊 | O(α(n)) | — | 路径压缩 + 按秩合并 |
| 图遍历 DFS/BFS | — | — | — | O(V + E) |
| Dijkstra | — | — | — | O((V + E) log V)（堆优化） |
| 拓扑排序 | — | — | — | O(V + E) |
| AVL 树 | O(log n) | O(log n) | O(log n) | 严格平衡 |
| 红黑树 | O(log n) | O(log n) | O(log n) | 近似平衡 |
| Trie | O(L) | O(L) | O(L) | L 为单词长度 |

## 如何运行

本项目是一个 IntelliJ IDEA 工程，推荐直接用 IDEA 打开后运行 `src/Main.java`。

也可以在项目根目录手动编译运行：

```bash
# 编译所有源码到 out 目录
javac -encoding UTF-8 -d out $(find src -name '*.java')

# 运行入口
java -cp out Main
```

> 说明：源码采用默认包（无 `package` 声明），各 `dayXX` 目录按天拆分，方便逐天学习。
