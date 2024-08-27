package theory.binarytrees;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeGenerateTrees {

    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }


    public List<Node> GenerateTrees(int n){
        return Generate(1, n);
    }

    public List<Node> Generate(int start, int end){
        List<Node> result = new LinkedList<>();
        if (start > end){
            result.add(null);
        }

        Node head = null;
        for (int i = start; i < end + 1; i++){
            head = new Node(i);
            //中序遍历的过程
            //递归生成所有左子树
            List<Node> lSubs = Generate(start, i-1);
            //递归生成所有右子树
            List<Node> rSubs = Generate(i+1, end);
            //1.遍历所有的子树
            for (Node l : lSubs){
                for (Node r : rSubs){
                    head.left = l;
                    head.right = r;
                    result.add(cloneTree(head));
                }
            }
        }
        return result;
    }

    public Node cloneTree(Node head){
        if (head == null){
            return null;
        }

        Node result = new Node(head.value);
        result.left = cloneTree(head.left);
        result.right = cloneTree(head.right);
        return result;
    }
}
