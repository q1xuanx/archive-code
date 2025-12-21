class Solution {
    public int minDeletionSize(String[] strs) {
        int res = 0, n = strs.length, m = strs[0].length();  
        boolean [] sorted = new boolean[strs.length - 1]; 

        for (int col = 0; col < m; col++) { 
            boolean needDelete = false; 

            for (int row = 0; row < n - 1; row++) { 
                if (!sorted[row] && strs[row].charAt(col) > strs[row+1].charAt(col)) {
                    needDelete = true;
                    break; 
                }
            }

            if (needDelete) { 
                res++; 
                continue; 
            }

            for (int row = 0; row < n - 1; row++) { 
                if (!sorted[row] && strs[row].charAt(col) < strs[row+1].charAt(col)) sorted[row] = true; 
            }
        }
    
        return res;
    }
}
