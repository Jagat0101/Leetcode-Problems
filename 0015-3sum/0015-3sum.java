class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length-1 ; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length -1;
            int sum = -1 * nums[i];

            while(left < right){
                int val = nums[left] + nums[right];
                if(val == sum){
                    answer.add(Arrays.asList(
                        nums[i],
                        nums[left],
                        nums[right]
                    ));
                    left++;
                    right --;

                    while (left < nums.length -1 && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while(right >=0 && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
                else if (val < sum){
                    left ++;
                }
                else{
                    right--;
                }
            }
        }
        return answer;
    }
}