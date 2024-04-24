import java.util.Arrays;

public class Solution {
    public int removeElement(int[] nums, int val) {
        
        
        int count = 0;
        
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == val){
                count++;
                
                for(int j = i+1; j < nums.length - 1; j++){
                    nums[i] = nums[j];
                    nums[i + 1] = nums[j + 1];            
                }
            }

        }
        
        System.out.println(Arrays.toString(nums));
        return nums.length - count;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        Solution mySolution = new Solution();
        System.out.println(mySolution.removeElement(nums, val));
    }


}
