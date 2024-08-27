package theory.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindWords {

    char[][] boards = null;
    ArrayList<String> results = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words){
        TrieNode root = new TrieNode();
        for (String word : words){
            TrieNode node = root;
            for (Character c : word.toCharArray()){
                if (node.children.containsKey(c)){
                    node = node.children.get(c);
                }else {
                    TrieNode nNode = new TrieNode();
                    node.children.put(c, nNode);
                    node = nNode;
                }
            }
            node.word = word;
        }
        this.boards = board;

        //2. 回溯
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[row].length; col++){
                if (root.children.containsKey(board[row][col])){
                    backTracking(row, col, root);
                }
            }
        }
        return this.results;
    }

    private void backTracking(int row, int col, TrieNode root) {

        Character c = this.boards[row][col];
        TrieNode curNode = root.children.get(c);
        if (curNode.word != null){
            this.results.add(curNode.word);
            curNode.word = null;
        }
        this.boards[row][col] = '#';
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++){
            int nRow = row +rowOffset[i];
            int nCol = col + colOffset[i];
            if (nRow < 0 || nRow >= this.boards.length
                    || nCol < 0 || nCol >= this.boards[0].length){
                continue;
            }
            if (curNode.children.containsKey(this.boards[nRow][nCol])){
                backTracking(nRow, nCol, curNode);
            }
        }
        this.boards[row][col] = c;
        if (curNode.children.isEmpty()){
            root.children.remove(c);
        }
    }

    static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        String word = null;
        public TrieNode(){}
    }

    public static void main(String[] args) {

        String[][] board = new String[][]{
                {"o","a","a","n"},
                {"e","t","a","e"},
                {"i","h","k","r"},
                {"i","f","l","v"}
                };
        String[] words = new String[]{"oath","pea","eat","rain"};
//        System.out.println(findWords(board, words));

    }
}
