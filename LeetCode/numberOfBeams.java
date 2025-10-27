class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length, m = bank[0].length(), result = 0;
        int [][] securities = new int[n][m];
        boolean [] hasSecurities = new boolean[n];
        int [] totalSec = new int[n];
        Arrays.fill(hasSecurities, false);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                securities[i][j] = bank[i].charAt(j) - '0';
                if (securities[i][j] == 1) { 
                    hasSecurities[i] = true;
                    totalSec[i] += 1;
                }
            }
        }
        for (int i = 0; i < n - 1; i++){ 
            result += totalSec[i] * totalSec[i + 1];
        }
        for (int i = 0; i < n - 2; i++) { 
            for (int j = i + 2; j < n; j++) {
                int tempIndex = j - 1; 
                boolean canNotProcess = false;
                while(tempIndex > i) {
                    if (hasSecurities[tempIndex]) {
                        canNotProcess = true;
                        break;
                    }
                    tempIndex--;
                }
                if (canNotProcess) { 
                    break;
                }
                result += (totalSec[i] * totalSec[j]);
            }
        }
        return result;
    }
}
