class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();       
        int[] last = new int[m];
        Arrays.fill(last, -1);
        for (int i = n - 1, j = m - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                last[j--] = i;
            }
        }
        int skip = 0;
        int j = 0;
        int[] res = new int[m];
        for (int i : last) {
            System.out.println(i);
        }
        for (int i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j) || (skip == 0 && (j == m - 1 || i < last[j + 1]))){
                res[j] = i;
                skip += (word1.charAt(i) != word2.charAt(j)) ? 1 : 0;
                //System.out.println(i + " : " + skip);
                j++;
            }
        }
        return j == m ? res : new int[0];
    }
}


// vbcca
// abc
// 
