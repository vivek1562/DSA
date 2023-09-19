class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] groups = new int[n];                  //Array containing current pair. O(1) to get which member is it currently paired with
        for(int i=0; i<pairs.length; i++) {
            groups[pairs[i][0]] = pairs[i][1];
            groups[pairs[i][1]] = pairs[i][0];
        }

        Map<Integer, Integer>[] pref = new Map[n];  //Map to check for what is the priority value of j with respect to i
        for(int i=0; i<n; i++) {
            for(int j=0; j<n-1; j++) {
                if(pref[i] == null)
                    pref[i] = new HashMap<>();
                pref[i].put(preferences[i][j], j);
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j : preferences[i]) {              //Traverse all members of preferences i
                if((pref[i].get(j) < pref[i].get(groups[i])) && (pref[j].get(i) < pref[j].get(groups[j]))) { //since 0 is the best priority
                    ans++; 
                    break;
                }
            } 
        }

        return ans;
    }
}