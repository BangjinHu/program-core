package ComRealQuestion.Baidu;

import java.util.*;

public class JumpGames {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            String str = sc.next();
            int[] arr = new int[n];
            char[] chars = str.toCharArray();
            for (int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(String.valueOf(chars[i]));
            }
            List<Integer> list = new ArrayList<>();
            list.add(arr[0]);
            int count = 0;
            for (int i = 1; i < arr.length; i++){
                if (arr[i] - arr[i-1] == 0){
                    count++;
                    if (count == 2){
                        list.add(arr[i]);
                    }
                }else {
                    count = 0;
                    list.add(arr[i]);
                }
            }
            arr = new int[list.size()];
            for (int i = 0; i < arr.length; i++){
                arr[i] = list.get(i);
            }
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++){
                List<Integer> l = map.getOrDefault(arr[i], new ArrayList<>());
                l.add(i);
                map.put(arr[i], l);
            }
            HashSet<Integer> visited = new HashSet<>();
            Queue<JumpNode> queue = new LinkedList<>();
            queue.offer(new JumpNode(arr[0], 0, 0));
            visited.add(0);
            while (!queue.isEmpty()){
                JumpNode jumpNode = queue.poll();
                if (jumpNode.index == arr.length -1){
                    System.out.println(jumpNode.cost);
                }else {
                    queue.addAll(expand(jumpNode, visited, arr, map));
                }
            }
            System.out.println(-1);
        }
    }

    private static List<JumpNode> expand(JumpNode node, HashSet<Integer> visited, int[] arr, HashMap<Integer, List<Integer>> map) {
        List<JumpNode> list = new ArrayList<>();
        if (node.index - 1 >= 0 && !visited.contains(node.index - 1)) {
            list.add(new JumpNode(arr[node.index - 1], node.index - 1, node.cost + 1));
        }
        if (node.index + 1 < arr.length && !visited.contains(node.index + 1)) {
            list.add(new JumpNode(arr[node.index + 1], node.index + 1, node.cost + 1));
        }
        List<Integer> sameValueIndex = map.get(node.value);
        sameValueIndex.forEach(i -> {
            if (!visited.contains(i))
                list.add(new JumpNode(node.value, i, node.cost + 1));
        });

        list.forEach(i -> {
            visited.add(i.index);
        });
        return list;
    }
}

class JumpNode {
    public int index;
    public int value;
    public int cost;

    public JumpNode(int value, int index, int cost) {
        this.value = value;
        this.index = index;
        this.cost = cost;
    }
}
