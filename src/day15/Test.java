package day15;

import day01.MyArrayList;

public class Test {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apply");
        trie.insert("banana");

        System.out.println("存在 'app' 吗？ " + trie.search("app")); // true
        System.out.println("存在 'ap' 吗？ " + trie.search("ap"));   // false (只是前缀)
        System.out.println("存在 'banana' 吗？ " + trie.search("banana")); // true

        System.out.println("有 'app' 前缀吗？ " + trie.startsWith("app")); // true
        System.out.println("有 'cat' 前缀吗？ " + trie.startsWith("cat")); // false

        System.out.println("以 'app' 开头的单词有：");
        MyArrayList<String> results = trie.getWordWithPrefix("app"); // 注意你方法名少了个s
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}