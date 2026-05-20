// LC 2657
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length; 
        int[] res = new int[n]; 
        int[] freq = new int[n + 1];
        int currentVal = 0;
        for (int i = 0; i < n; i++) { 
        	freq[A[i]]++;
            if (freq[A[i]] >= 2) {
        		currentVal++;
        	}
            freq[B[i]]++;
            if (freq[B[i]] >= 2) {
        		currentVal++;
        	}
            res[i] = currentVal;
        }
        return res;
    }
}
