package day15;

import day01.MyArrayList;
import day06.MyHashMap;

import java.util.Timer;

//字符树
public class Trie {
    private static class TrieNode{
        // 当前节点出发，能通向哪些字符？
        // Key 存的是字母（比如 'a'），Value 存的是那个字母对应的下一个路口节点
        // 这种“自己套自己”的结构，正是树形结构的精髓
        MyHashMap<Character,TrieNode> children = new MyHashMap<>();
        // 标记：从根节点走到当前这个节点，是不是构成了一个完整的单词
        boolean isEnd = false;
    }
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode cur = root;
        for(char c:word.toCharArray()){
            if(!cur.children.containKey(c)){
                cur.children.put(c,new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isEnd = true;
    }
    private TrieNode findNode(String str){
        TrieNode cur = root;
        for(char c : str.toCharArray()){
            if(!cur.children.containKey(c)){
                return null;
            }
            cur = cur.children.get(c);
        }
        return cur;
    }
    public boolean search(String word){
        TrieNode node = findNode(word);
        if(node == null){
            return false;
        }
        //找到了路，但没找到完整的单词
        if (!node.isEnd) {
            return false;
        }
        return true;
    }
    public boolean startsWith(String prefix){
        if(findNode(prefix) == null){
            return false;
        }
        return true;
    }

    //搜索框自动补全
    public MyArrayList<String> getWordWithPrefix(String prefix){
        MyArrayList<String> result = new MyArrayList<>();
        TrieNode node = findNode(prefix);
        if(node == null){
            return result;
        }
        dfs(node,prefix,result);
        return result;
    }
    //  DFS 深度优先搜索
    private void dfs(TrieNode node,String currentWord,MyArrayList<String> result){
        if(node.isEnd){
            result.add(currentWord);
        }
        for(char c = 'a';c<='z';c++){
            if(node.children.containKey(c)){
                dfs(node.children.get(c),currentWord + c,result);
            }
        }
    }
}
