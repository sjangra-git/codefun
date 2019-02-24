package codefun.leetcode;

public class SearchInsertPosition {

    public static void main(String[] args)
    {

        int[] arr = new int[]{1, 3, 5, 6};
        int out1 = searchInsert(arr, 7);

        assert out1 == 4;

        int out2 = searchInsert(arr, 2);
        assert  out2 == 1;
    }

    public static int searchInsert(int[] nums, int target) {

        int index = -1;
        for(int i=0;i<nums.length; i++)
        {
            if(index != -1) break;

            if(nums[i] == target) index = i;

            if(nums[i] > target) index = i;
        }

        return index == -1 ? nums.length : index;
    }
}
