class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] indexMap = new List[26];

        for(int i=0; i<26; i++) {
            indexMap[i] = new ArrayList<>();
        }

        for(int i=0; i<s.length(); i++) {
            indexMap[s.charAt(i)-'a'].add(i);
        }  
        int ans = 0;

        for(String w : words) {
            int flag = 1, prev = -1;
            for(char c : w.toCharArray()) {
                int lo=0, hi=indexMap[c-'a'].size()-1;
                while(lo<=hi) {             //find upper bound for character i in indexMap of that character such that it is greater then the previous pos
                    int mid = lo+(hi-lo)/2;
                    if(indexMap[c-'a'].get(mid)>prev) {
                        hi = mid-1;
                    }
                    else {
                        lo = mid+1;
                    }
                }
                if(lo==indexMap[c-'a'].size()) {
                    flag=0;
                    break; 
                }
                prev = indexMap[c-'a'].get(lo);
            }
            if(flag==1){
                ans++;
            }
        }

        return ans;
    }
}