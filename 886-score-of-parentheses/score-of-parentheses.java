class Solution {
    public int scoreOfParentheses(String s) {
       Stack<Integer> st=new Stack<>();
       st.push(0);
       for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        if(ch=='(') st.push(0);
        else{
            int x=st.pop();
            int score=0;
            if(x==0) score=1;
            else{
                score=2*x;
            }
            st.push(score+st.pop());
        }
       }
       return st.peek();
    }
}