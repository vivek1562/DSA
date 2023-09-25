class Solution {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> targetMap = new HashMap<>();
        for(int i=0; i<target.length; i++)
            targetMap.put(target[i], i);
        
        List<Integer> lis = new ArrayList<>();
        //loop over arr and do LIS in nlogn using binary search
        for(int i=0; i<arr.length; i++) {
            if(targetMap.containsKey(arr[i])) {
                int lo = 0, hi = lis.size()-1, mid = 0, targetIdx = targetMap.get(arr[i]), lb = 0;
                if(lis.isEmpty() || targetIdx>lis.get(hi)) {
                    lis.add(targetIdx);
                    continue;
                }
                while(lo<=hi) {
                    mid = lo+(hi-lo)/2;
                    if(lis.get(mid)>=targetIdx) {
                        lb = mid;
                        hi = mid-1;
                    } else {
                        lo = mid+1;
                    }
                }
                lis.set(lb, targetIdx);
            }
        }

        return target.length - lis.size();
    }
}