class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        long res=0;
        long cost=0;
        Deque<int[]> deq=new ArrayDeque<>();
        for(int i=nums.length-1,j=nums.length-1;i>=0;i--){
            int num=nums[i];
            int count=1;
            while(!deq.isEmpty() && deq.peekLast()[0]<num){
                int[] back=deq.pollLast();
                count+=back[1];
                cost+=(long) (num-back[0])*back[1];
            }
            deq.offer(new int[]{num,count});
            while(cost>k){
                int[] front=deq.pollFirst();
                cost-=(long) (front[0]-nums[j]);
                j--;
                if(front[1]>1)
                    deq.offerFirst(new int[]{front[0],front[1]-1});
            }
            res+=(j-i)+1;
        }
        return res;
    }
}