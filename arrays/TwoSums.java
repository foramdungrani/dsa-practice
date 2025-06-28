import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        twoSum(arr, 9);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for( int i = 0; i < nums.length; i++ ){
            int targetIndex = map.getOrDefault(target - nums[i], -1);
            if (targetIndex == -1) {
                map.put(nums[i], i);
            } else {
                result[0] = targetIndex;
                result[1] = i;
            }
        }
        return result;
    }
}
