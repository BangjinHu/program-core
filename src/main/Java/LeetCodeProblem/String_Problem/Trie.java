package LeetCodeProblem.String_Problem;

import java.util.HashMap;

public class Trie {

    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word){
        if (null == word || "".equals(word)){
            return;
        }
        TrieNode node = root;//当前节点是头节点
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (!node.next.containsKey(c)) {
                node.next.put(c, new TrieNode());
            }
            node = node.next.get(c);
            node.path++;
        }
        node.end++;
    }

    public boolean search(String word){
        if (null == word || "".equals(word)){
            return false;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (!node.next.containsKey(c)){
                return false;
            }
            node = node.next.get(c);
        }
        if (node.end == 0){
            return false;
        }
        return true;
    }

    public boolean startsWith(String word){
        if (null == word || "".equals(word)){
            return false;
        }
        TrieNode node = root;
        for (int i= 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (!node.next.containsKey(c)){
                return false;
            }
            node = node.next.get(c);
        }
        return true;
    }

    public void delete(String word){
        if (null == word || "".equals(word) || !search(word)){
            return;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (--node.next.get(c).path == 0){
                node.next.remove(c);
                return;
            }
            node = node.next.get(c);
        }
        node.end--;
    }

    class TrieNode {
        int path;//表示当前节点所能链接到其它节点的个数
        int end;//表示以当前节点为结尾的单词的个数
        HashMap<Character, TrieNode> next;//表示当前节点能链接到的所有节点
        public TrieNode() {
            path = 0;
            end = 0;
            next = new HashMap<>();
        }
    }

}


