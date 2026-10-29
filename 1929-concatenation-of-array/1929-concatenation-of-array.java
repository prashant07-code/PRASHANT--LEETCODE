class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int ans [] = new int[2*n];
        int j =0;
        for(int i=0; i<ans.length; i++){
            if(i>n-1){
                ans[i] = nums[i-n];
            }
            else{
            ans[i] = nums[j];
            j++;
            }
        
        }
        return ans;

    }
}