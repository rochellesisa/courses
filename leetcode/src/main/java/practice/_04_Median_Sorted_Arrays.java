package practice;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class _04_Median_Sorted_Arrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        double[] merged = DoubleStream.concat(Arrays.stream(nums1).asDoubleStream(), Arrays.stream(nums2).asDoubleStream()).toArray();
        Arrays.sort(merged);

        if (merged.length == 0)
            return result;

        boolean hasMiddleElement = merged.length % 2 != 0;
        int half = merged.length / 2;
        if (hasMiddleElement){
            result = merged[half];
        } else {
            result = (merged[half] + merged[half-1]) / 2;
        }

        return result;
    }

//    private static int[] arr(String s){
//        return Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
//    }
}
