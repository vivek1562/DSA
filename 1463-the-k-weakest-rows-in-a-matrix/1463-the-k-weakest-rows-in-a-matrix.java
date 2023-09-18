class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length, c=0;
        List<List<Integer>> count = new ArrayList<>();
        for(int i=0; i<m; i++) {
            count.add(new ArrayList<>());
            count.get(i).add(0);
            count.get(i).add(i);
            for(int j=0; j<n; j++) {
                if(mat[i][j]==1) {
                    count.get(i).set(0, count.get(i).get(0)+1);
                }
            }
        }
        Collections.sort(count, (a, b) -> a.get(0)!=b.get(0)?a.get(0)-b.get(0):a.get(1)-b.get(1));
        int[] res = new int[k];
        for(int i=0; i<k; i++)
            res[i] = count.get(i).get(1);

        return res;
    }
}