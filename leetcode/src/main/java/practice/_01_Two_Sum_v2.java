package practice;

import java.util.stream.IntStream;

public class _01_Two_Sum_v2 {

    public static void main(String[] args){
        int[] nums = {2,11, 7, 15};
        int[] out = twoSum(nums, 9);
        System.out.println(out[0] + ", " + out[1]);
    }

    public static int[] twoSum(int[] nums, int target){
        return IntStream.range(0, nums.length).boxed()
                .flatMap(i -> IntStream.range(i + 1, nums.length)
                        .filter(j -> nums[i] + nums[j] == target)
                        .mapToObj(j -> new int[]{i, j}))
                .findFirst().get();

    }
}
