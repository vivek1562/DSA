class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        int i=0, n=num.length();

        if(k>=n)
            return "0";

        while(i<n) {
            //we iterate from left to right when we getter a better choice i.e. lower number we remove the greater numbers in the stack
            while(k>0 && !s.isEmpty() && s.peek()>num.charAt(i)) {
                k--;
                s.pop();
            }
            s.push(num.charAt(i));
            if(s.size()==1 && s.peek()=='0')
                s.pop();
            i++;
        }

        while(k>0 && !s.isEmpty()) {
            k--;
            s.pop();
        }

        StringBuilder ans = new StringBuilder();
        while(!s.isEmpty()) {
            ans.append(s.pop());
        }

        if(ans.length()==0)
            return "0";

        return ans.reverse().toString();
    }
}