class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length, x = n/3;
        List<Integer> ans = new ArrayList<>();
        Integer m1=null, m2=null;
        int c1=0, c2=0;
        for(int i=0; i<n; i++) {
            if(m1==null) {
                c1++;
                m1 = nums[i];
            } else if(nums[i]!=m1 && m2==null) {
                c2++;
                m2 = nums[i];
            } else if(m1==nums[i]) {
                c1++;
            } else if(m2==nums[i]) {
                c2++;
            } else if(c1==0) {
                m1 = nums[i];
                c1++;
            } else if(c2==0) {
                m2 = nums[i];
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        c1=x;
        c2=x;
        for(int num : nums) {
            if(m1!=null && num==m1)
                c1--;
            if(m2!=null && num==m2)
                c2--;
        }
        if(c1<0)
            ans.add(m1);
        if(c2<0)
            ans.add(m2);
        return ans;
    }
}