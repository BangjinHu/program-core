package LeetCodeProblem.IEEE;

import java.util.*;

public class Demo3 {
    Map<String, List<String>> graph = new HashMap<>();
    Map<String, List<String>> value = new HashMap<>();
    Map<String, List<String>> totalValue = new HashMap<>();

    //init
    public void initGraph(){
        graph.put("1", Arrays.asList("2", "3"));
        graph.put("2", Arrays.asList("4", "5"));
        graph.put("3", Arrays.asList("1"));
        graph.put("4", Arrays.asList("2"));
        graph.put("5", Arrays.asList("2"));
        graph.put("6", Arrays.asList("3", "7", "8", "9"));
        graph.put("7", Arrays.asList("6"));
        graph.put("8", Arrays.asList("6", "10"));
        graph.put("9", Arrays.asList("6", "11", "12"));
        graph.put("10", Arrays.asList("8"));
        graph.put("11", Arrays.asList("9"));
        graph.put("12", Arrays.asList("9"));

    }

    public void initValue(){
        value.put("1",Arrays.asList("3"));
        value.put("2", Arrays.asList("1"));
        value.put("3", Arrays.asList("2"));
        value.put("4", Arrays.asList("3"));
        value.put("5", Arrays.asList("5"));
        value.put("6", Arrays.asList("6"));
        value.put("7", Arrays.asList("7"));
        value.put("8", Arrays.asList("2"));
        value.put("9", Arrays.asList("2"));
        value.put("10", Arrays.asList("4"));
        value.put("11", Arrays.asList("10"));
        value.put("12", Arrays.asList("11"));
    }

    private Stack<String> stack = new Stack<>();
    private Map<String, Boolean> status = new HashMap<String, Boolean>();

    public void DFSSearch(String startPoint){
        stack.push(startPoint);
        status.put(startPoint, true);
        dfs();
        String tmp = stack.pop();
        List<String> vl = value.get(tmp);
        int result = 0;
        for (String v : vl){
            result += Integer.parseInt(v);
        }
        System.out.println(result);
    }

    private void dfs() {
        if(stack.empty()){
            return;
        }
        String stackTopPoint = stack.pop();
        List<String> neighborPoints = graph.get(stackTopPoint);
        for (String point : neighborPoints) {
            if (!status.getOrDefault(point, false)) {
                stack.push(point);
                status.put(point, true);
                dfs();
            }
        }
    }

    public static void main(String[] args) {
        Demo3 demo = new Demo3();
        demo.initGraph();
        demo.initValue();

        demo.DFSSearch("1");
    }

}
