class Solution {
    public int numTilePossibilities(String tiles) {
        int [] count = new int[26];
        for(int i = 0; i < tiles.length(); i++) {
            count[tiles.charAt(i) - 'A']++;
        }
        return dfs(count);
    }

    public int dfs(int [] count) {
        int res = 0; 
        for (int i = 0; i < count.length; i++){
            if (count[i] == 0) continue;
            res++; 
            count[i]--;
            res += dfs(count);
            count[i]++;
        }
        return res;
    }
}
