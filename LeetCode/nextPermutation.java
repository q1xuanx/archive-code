class Solution {

    public void nextPermutation(int[] nums) {
        // Find the decrese number from right 
        int i = nums.length - 1; 
        while (i > 0 && nums[i - 1] >= nums[i]) { 
            i--;
        }
        
        if (i == 0) {
            int start = 0; 
            int end = nums.length - 1;
            while (start < end) { 
                int temp = nums[start]; 
                nums[start] = nums[end]; 
                nums[end] = temp; 
                start++;
                end--;
            }
            return;
        }

        // Find the smallest from the decrese order to right greater than the first decreasing 
        int j = nums.length - 1;
        while(i <= j && nums[j] <= nums[i - 1]) {
            j--;
        }
        
        int temp = nums[i - 1];
        nums[i - 1] = nums[j];
        nums[j] = temp; 

        // Start reverse to find end result
        int start = i, end = nums.length - 1; 
        while (start < end) {
            int sampleNumber = nums[start]; 
            nums[start] = nums[end]; 
            nums[end] = sampleNumber; 
            start++;
            end--;            
        }
    }
}
