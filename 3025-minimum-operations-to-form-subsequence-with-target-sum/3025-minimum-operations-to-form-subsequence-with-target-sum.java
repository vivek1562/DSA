class Solution {
    public int minOperations(List<Integer> nums, int target) {
        int[] count = new int[32];
        int n = nums.size(), ans = 0;
        for(int num : nums) {
            int i=0;
            while(num>1) {
                num = num/2;
                i++;
            }
            count[i]++;
        }

        int carry=0;
        for(int i=0; i<32; i++) {

            //check if ith bit is set
            if((1&(target>>i)) == 0) {
                carry += count[i]*Math.pow(2, i);
                //count[i] = 0;                         // not needed as we never check past counts
                continue;
            }

            if(count[i]>0) {      
                count[i]--;
                carry += count[i]*Math.pow(2, i);
                //count[i] = 0;
            } else if(carry>=Math.pow(2, i)) {
                carry -= Math.pow(2, i);
            } else {
                int j=i+1;
                while(j<32 && count[j]==0) {
                    j++;
                }
                if(j==32)
                    return -1;
                while(j>i) {
                    ans++;
                    count[j]--;
                    count[j-1]+=2;
                    j--;
                }
                i--;
            }
        }

        return ans;
    }
}