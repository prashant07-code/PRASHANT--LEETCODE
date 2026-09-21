class Solution {
    public int subtractProductAndSum(int n) {
        int pd= 1;
        int sum =0;
        while(n>0){
            int d = n%10;
             pd*= d;
             sum+=d;
             n = n/10;
        }
        return pd-sum;
    }
}