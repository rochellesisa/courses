package practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _04_Median_Sorted_ArraysTest {

    private _04_Median_Sorted_Arrays solution = new _04_Median_Sorted_Arrays();

    @Test
    public void emptyMergedArray_returnZero(){
        int[] nums1 = {}, nums2 = {};
        assertEquals(0, solution.findMedianSortedArrays(nums1, nums2));
    }

//    @Test
//    public void onlyFirstArrayHasElement_returnMedian(){
//        int[] nums1 = {4}, nums2 = {};
//        assertEquals(4, solution.findMedianSortedArrays(nums1, nums2));
//    }
//
//    @Test
//    public void onlySecondArrayHasElement_returnMedian(){
//        int[] nums1 = {}, nums2 = {5};
//        assertEquals(5, solution.findMedianSortedArrays(nums1, nums2));
//    }

    @Test
    public void oneElementInMergedArray_returnElement(){
        int[] nums1 = {}, nums2 = {5};
        assertEquals(5, solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void twoElementsInMergedArray_returnMedian(){
        int[] nums1 = {9}, nums2 = {5};
        double median = (5+9)/2;
        assertEquals(median, solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void oddSizeInMergedArray_returnMiddleElement(){
        int[] nums1 = {1,3,7,10}, nums2 = {4,6,7};
        //1,3,4,6,7,7,10
        assertEquals(6, solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void sumOfLowerMiddleAndUpperMiddleIsEven_returnHalf(){
        int[] nums1 = {1,3,7}, nums2 = {4,6,7};
        //1,3,4,6,7,7
        assertEquals(5, solution.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void sumOfLowerMiddleAndUpperMiddleIsOdd_returnHalf(){
        int[] nums1 = {1,3,7}, nums2 = {4,9,7};
        //1,3,4,7,7,9
        assertEquals(5.5, solution.findMedianSortedArrays(nums1, nums2));
    }

}
