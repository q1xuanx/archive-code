class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); 
        int [] res = new int[spells.length]; 
        for (int i = 0; i < spells.length; i++) {
            int idx = bs(potions, spells[i], success); 
            if (idx != -1) {
                res[i] = potions.length - idx;
            }
        }
        return res; 
    }

    int bs (int[]potions, long strength, long success) { 
        int l = 0, r = potions.length - 1, idx = -1; 
        while (l <= r) { 
            int mid = l + (r - l) / 2;
            System.out.println(mid + " " + strength);
            if (potions[mid] * strength >= success) { 
                idx = mid; 
                r = mid - 1;
            }else { 
                l = mid + 1;
            }
        }
        return idx; 
    }
}
