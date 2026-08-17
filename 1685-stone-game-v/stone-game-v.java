class Solution {
    int[][] memo;
    public int f(int i,int j,int[] prefix,int[] stones){
        if(i==j){
            return 0;
        }
        if(memo[i][j]!=0){
            return memo[i][j];
        }
        int maxValue=Integer.MIN_VALUE;
        for(int k=i;k<j;k++){
            int p1=prefix[k]-prefix[i]+stones[k];
            int p2=prefix[j]-prefix[k+1]+stones[j];
            if(p1<=p2){
                maxValue=Math.max(maxValue,p1+f(i,k,prefix,stones));
            }
            if(p1>=p2){
                maxValue=Math.max(maxValue,p2+f(k+1,j,prefix,stones));
            }
        }
        return memo[i][j]=maxValue;
    }
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        int[] prefix=new int[n];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+stoneValue[i-1];
        }
        memo=new int[n+1][n+1];
        return f(0,n-1,prefix,stoneValue);
    }
}