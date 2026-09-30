class Solution {
    public int[] shuffle(int[] nums, int n) {
        int arr[] = new int[2*n];
        int x= 0;
        int y = n;
        for(int i=0; i<2*n; i+=2){
            arr[i] = nums[x];
            arr[i+1] = nums[y];
            x++;
            y++;
        }
        return arr;
    }
}