class Solution {
    public String removeOccurrences(String str, String part) {
        Stack<Character> s = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int n = str.length(), i=0;

        while(i<=n) {
            int j = part.length()-1;
            String tempPopped = "";
            while(j>=0 && !s.isEmpty() && s.peek()==part.charAt(j)) {
                tempPopped += s.pop();
                j--;
            }
            if(tempPopped.length()!=part.length()) {
                for(j = tempPopped.length()-1; j>=0; j--) {
                    s.push(tempPopped.charAt(j));
                }
            }
            if(i<n)
                s.push(str.charAt(i));
            i++;
        }
        while(!s.isEmpty()) {
            ans.append(s.pop());
        }

        return ans.reverse().toString();
    }
}