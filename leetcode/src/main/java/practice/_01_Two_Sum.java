package practice;

public class _01_Two_Sum {

    public static void main(String[] args){
        int[] nums = {2,11,7, 15};
        int[] twoSum = twoSum(nums, 9);
        System.out.println(twoSum[0] + ", " + twoSum[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] nos = new int[2];
        for (int i = 0; i < nums.length-1; i++){
            int first = nums[i];
            for (int j=i+1; j < nums.length; j++){
                int second = nums[j];
                int sum = first + second;
                if (sum == target){
                    nos[0] = i;
                    nos[1] = j;
                }
            }
        }

        return nos;
    }
}
