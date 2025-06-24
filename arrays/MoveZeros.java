import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroHelper(nums);
        System.out.println(Arrays.toString(nums));
    }

    //Time complexity is O(n) and space complexity is O(1)
    public static void moveZeroHelper(int[] nums) {
        int n = nums.length;
        for(int i = 0, j = 0; i < n && j < n;){
            if(nums[i] != 0) {
                i++;
            }
            if(nums[j] == 0){
                j++;
            }
            if(i < n && j < n && nums[i] == 0 && nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}


