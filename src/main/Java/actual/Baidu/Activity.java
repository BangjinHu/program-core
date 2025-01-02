package actual.Baidu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Activity {

    public static void main(String[] args) {
//        int[] nums = new int[]{3, -2, 4, -3, 2};
        int[] nums = new int[]{3, -5, 6, -7, 4, -4};
        List<Integer> ansList = calculatePath(nums);

        ansList.stream().forEach(i -> System.out.print(i + " "));
    }

    private static List<Integer> calculatePath(int[] nums) {
        LinkedList<Integer> ansList = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            boolean flag = false;
            while (!stack.isEmpty() && num < 0 && stack.peek() > 0) {
                int topNum = stack.pop();
                if (topNum > -num) {
                    stack.push(topNum);
                    flag = true;
                    break;
                } else if (topNum == -num) {
                    flag = true;
                    break;
                } else {
                    continue;
                }
            }
            if (!flag) {
                stack.push(num);
            }
//            if (num > 0) {
//                stack.push(num);
//            } else {
//                while (!stack.isEmpty() && stack.peek() > 0) {
//                    int curNum = stack.pop();
//                    if (-curNum > num) {
//                        break;
//                    } else if (-curNum < num) {
//                        continue;
//                    } else {
//                        break;
//                    }
//                }
//                if (num < 0) {
//                    stack.push(num);
//                }
//            }
        }

        while (!stack.isEmpty()) {
            ansList.add(0, stack.pop());
//            System.out.print(stack.pop() + " ");
        }

//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0 || (nums[i] < 0 && stack.contains(nums[i]))) {
//                System.out.print(nums[i] + " ");
//            }
//        }

//        StringBuilder sb = new StringBuilder();
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (nums[i] > 0) {
//                sb.append(nums[i]).append(" ");
//            } else if (!stack.isEmpty() && stack.pop() < 0) {
//                sb.append(-nums[i]).append(" ");
//            }
//        }
//        System.out.println(sb.toString().trim());

        return ansList;
    }

//    private static List<Integer> calculatePath(int[] nums) {
//        LinkedList<Integer> ansList = new LinkedList<>();
//        if (nums == null || nums.length == 0) {
//            return new ArrayList<>();
//        }
//        for (int num : nums) {
//            int curNum = Math.abs(num);
//            if (num > 0) {
//                ansList.addLast(curNum);
//            } else {
//                boolean flag = false;
//                while (!ansList.isEmpty() && ansList.getLast() < curNum) {
//                    ansList.removeLast();
//                    flag = true;
//                }
//                if (!ansList.isEmpty() && ansList.getLast() == curNum) {
//                    ansList.removeLast();
//                    flag = true;
//                }
//                if (!flag) {
//                    ansList.addLast(curNum);
//                }
//            }
//        }
//        return ansList;
//    }
}
