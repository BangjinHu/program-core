package theory.dict_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWords {

    //全局变量
    static char[][] boards = null;
    static ArrayList<String> results = new ArrayList<>();

    public static void main(String[] args) {

        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};

        List<String> ansList = findWords(board, words);
        ansList.forEach(System.out::println);

        List<String> resList = findWords(words, board);
        System.out.println("current exist words:");
        resList.forEach(str -> System.out.print(str + " "));

    }

    private static List<String> findWords(String[] words, char[][] boards) {
        ArrayList<String> resList = new ArrayList<>();
        // 1. 构造前缀树
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (Character c : word.toCharArray()) {
                if (node.children != null) {
                    if (node.children.containsKey(c)) {
                        node = node.children.get(c);
                    } else {
                        TrieNode nNode = new TrieNode();
                        nNode.children.put(c, nNode);
                        node = nNode;
                    }
                }
            }
            node.word = word;
        }

        // 2. 搜索Trie树
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[0].length; j++) {
                backTrace(boards, i, j, root, resList);
            }
        }

        return resList;
    }

    private static void backTrace(char[][] boards, int row, int col, TrieNode root, ArrayList<String> resList) {

        char c = boards[row][col];
        if (root.children == null) {
            return;
        }
        TrieNode node = root.children.get(c);
        if (node == null) {
            return;
        }
        if (node.word != null) {
            resList.add(node.word);
            node.word = null;
        }
        boards[row][col] = '#';
        int[][] dirctions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirctions) {
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            if (nRow < 0 || nRow >= boards.length || nCol < 0 || nCol >= boards[0].length) {
                continue;
            }
            if (node.children.containsKey(boards[nRow][nCol])) {
                backTrace(boards, nRow, nCol, node, resList);
            }
        }
        boards[row][col] = c;
        if (node.children.isEmpty()) {
            root.children.remove(c);
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {
        if (words == null || board == null) {
            return new ArrayList<>();
        }
        //1. 构造前缀树
        TrieNode root = new TrieNode();
        for (String word : words) {//字典里面的单词数
            TrieNode node = root;
            for (Character c : word.toCharArray()) {
                if (node.children == null) {
                    break;
                }
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                } else {
                    TrieNode nNode = new TrieNode();
                    node.children.put(c, nNode);//集合保存每个单词字符，然后单词对应一个前缀树节点
                    node = nNode;
                }
            }
            node.word = word;
        }
        boards = board;

        //2. 回溯
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (root.children == null) {
                    break;
                }
                if (root.children.containsKey(board[row][col])) {
                    backTracking(row, col, root);
                }
            }
        }
        return results;
    }

    //回溯方法
    private static void backTracking(int row, int col, TrieNode root) {

        Character c = boards[row][col];
        if (!root.children.containsKey(c)) {
            return;
        }
        TrieNode curNode = root.children.get(c);
        if (curNode == null) {
            return;
        }
        if (curNode.word != null) {
            results.add(curNode.word);
            curNode.word = null;
        }
        boards[row][col] = '#';
        int[] rowOffset = {-1, 0, 1, 0};//四个方向
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nRow = row + rowOffset[i];
            int nCol = col + colOffset[i];
            if (nRow < 0 || nRow >= boards.length
                    || nCol < 0 || nCol >= boards[0].length) {
                continue;
            }
            if (curNode.children.containsKey(boards[nRow][nCol])) {
                backTracking(nRow, nCol, curNode);
            }
        }
        boards[row][col] = c;
        if (curNode.children.isEmpty()) {
            root.children.remove(c);
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;

        public TrieNode() {
        }
    }
}
