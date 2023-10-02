class Solution {
    public int minFlipsMonoIncr(String s) {
        int ones=0, flips=0;
        for(char c : s.toCharArray()) {
            if(c=='1')
                ones++;
            else
                flips++;
            flips = Math.min(ones, flips);
        }
        return flips;
    }
}