class Solution {
public:
    int kthSmallest(vector<vector<int>>& mat, int k) {
  priority_queue<int, vector<int>, greater<int>> pq;
  int i,j,n=mat.size();
  for(i=0;i<n;i++)
    for(j=0;j<n;j++)
        pq.push(mat[i][j]);
  for(i=0;i<k-1;i++)
    pq.pop();
   return pq.top();
    }
};