class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c!='*') {
                st.push(c);
            } else {
                st.pop();
            }
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}