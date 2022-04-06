class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int temp, correct;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0) {
                correct = nums[i] - 1;
                if (correct < nums.length && nums[i] != nums[correct]) {
                    temp = nums[correct];
                    nums[correct] = nums[i];
                    nums[i] = temp;
                }
                else {
                    i++;
                }
            }
            else {
                i++;
            }
        }
        
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return nums.length + 1;
    }
}