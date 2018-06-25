package InterviewProblems;
import java.util.*;

/**
 * Created by ARPIT JOHRI on 17-03-2017.
 * https://leetcode.com/problems/single-element-in-a-sorted-array/#/description
 */
public class SingleElementInSortedArray {


    public static void main(String[] args) {

//        Scanner scan = new Scanner(System.in);
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.flush();
        System.out.close();
    }

    public static int singleNonDuplicate(int[] nums) {

        int right,left;

        for( right = 1; right < nums.length-1; right += 2){

            left = right - 1;

            if(nums[right]!=nums[left]){
                return nums[left];
            }

        }

        return nums[nums.length-1];

    }

}
