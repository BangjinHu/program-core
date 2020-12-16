//package LeetCodeProblem.Array_Problem;
//
//public class NSum {
//
//    //n数之和
//    public int[] nSum(int[] nums, int n, int start, int target){
//        int size = nums.length;
//        int[] res = new int[2];
//        if (n < 2 || size < n){
//            return res;
//        }
//        if (n == 2){
//            //双指针求解两数之和
//            int l = start, h = size - 1;
//            while (l < h){
//                int sum = nums[l] + nums[h];
//                int left = nums[l], right = nums[h];
//                if (sum < target){
//                    while (l < h && nums[l] == left){
//                        l++;
//                    }
//                }else if (sum > target){
//                    while (l < h && nums[h] == right){
//                        h--;
//                    }
//                }else {
//                    res = new int[]{left, right};
//                    while (l < h && nums[l] == left) l++;
//                    while (l < h && nums[h] == right) h--;
//                }
//            }
//        }else {
//            //n>2时，递归调用(n-1)Sum结果
//            for (int i = start; i < size; i++){
//                int[] sub = nSum(nums, n - 1, i + 1, target - nums[i]);
//                for (int arr : sub){
//
//                }
//            }
//        }
//    }
//}
