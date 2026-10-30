class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans =0;
        int count =0;
        for(int i=0; i<nums.length; i++){
            ans = nums[i];
            if(ans == k){
                count++;
            }
            for(int j=i+1; j<nums.length; j++){
                int end = j;
                ans+= nums[end];
                if(ans==k){
                    count++;
                }
            }
            ans =0;

        }
        return count;
    }
}