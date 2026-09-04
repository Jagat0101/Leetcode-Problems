class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0;
        int high = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int n = nums.length;


        while (high < n){
            sum = sum + nums[high];
            while(sum >= target){
                int len = high - low +1;
                result = Math.min(result , len);
                sum = sum - nums[low];
                low++;
            }
            high ++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}