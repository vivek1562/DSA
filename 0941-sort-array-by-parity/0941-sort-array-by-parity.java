class Solution {
    public int[] sortArrayByParity(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (a,b) -> a%2==0?-1:(b%2!=0?-1:1));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
        return nums;
    }
}