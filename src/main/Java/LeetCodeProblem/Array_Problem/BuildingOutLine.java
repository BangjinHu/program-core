package LeetCodeProblem.Array_Problem;

import java.util.*;

//大楼轮廓线
public class BuildingOutLine {

    //描述高度变化的对象
    public class Node {
        public int x;//x轴上的值
        public boolean isAdd;//true是加入，false是删除
        public int n;//高度

        public Node(int x, boolean isAdd, int n) {
            this.x = x;
            this.isAdd = isAdd;
            this.n = n;
        }
    }

    //排序比较策略

    public class NodeComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.x != o2.x){
                return o1.x - o2.x;
            }

            if (o1.isAdd != o2.isAdd){
                return o1.isAdd ? -1 : 1;
            }
            return 0;
        }
    }

    //所有流程
    public List<List<Integer>> buildingOutLine(int[][] matrix){
        Node[] nodes = new Node[matrix.length * 2];

        //每个大楼轮廓数组产生两个描述高度变化的对象
        for (int i = 0; i < matrix.length; i++){
            nodes[i * 2] = new Node(matrix[i][0], true, matrix[i][2]);
            nodes[i * 2 + 1] = new Node(matrix[i][i], false, matrix[i][2]);
        }

        //将描述高度变化的对象数组按照规定的排序策略排序
        Arrays.sort(nodes, new NodeComparator());
        //TreeMap就是Java中红黑树结构，直接当做有序表来使用
        TreeMap<Integer, Integer> mapHeightTimes = new TreeMap<>();
        TreeMap<Integer, Integer> mapXvalueHeight = new TreeMap<>();

        for (int i = 0; i < nodes.length; i++){
            if (nodes[i].isAdd){//如果当前是加入操作
                //没有出现的的高度直接添加记录
                if (!mapHeightTimes.containsKey(nodes[i].n)){
                    mapHeightTimes.put(nodes[i].n, 1);
                }else {//之前出现的高度，次数加1即可
                    mapHeightTimes.put(nodes[i].n, mapHeightTimes.get(nodes[i].n) + 1);
                }
            }else {
                //当前是删除操作
                //如果当前的记录的数量是1的话，直接删除记录
                if (mapHeightTimes.get(nodes[i].n) == 1){
                    mapHeightTimes.remove(nodes[i].n);
                }else {//如果当前的高度出现次数大于1，次数减1即可
                    mapHeightTimes.put(nodes[i].n, mapHeightTimes.get(nodes[i].n) - 1);
                }
            }

            //根据mapHeightTimes中最大高度，设置mapXvalueHeight表
            if (mapHeightTimes.isEmpty()){
                mapXvalueHeight.put(nodes[i].x, 0);
            }else {
                mapXvalueHeight.put(nodes[i].x, mapHeightTimes.lastKey());
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        int preHeight = 0;
        for (Map.Entry<Integer, Integer> entry : mapXvalueHeight.entrySet()){
            //当前位置
            int curX = entry.getKey();
            //当前最大高度
            int curMaxHeight = entry.getValue();
            if (preHeight != curMaxHeight){
                //之前最大高度和当前最大高度不一致
                if (preHeight != 0){
                    result.add(new ArrayList<>(Arrays.asList(start, curX, preHeight)));
                }
                start = curX;
                preHeight = curMaxHeight;
            }
        }

        return result;
    }
}
