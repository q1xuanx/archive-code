class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, result = 0; 
        StringBuilder sb = new StringBuilder();
        while (left < s.length() && right < s.length()) {
            if (sb.indexOf(String.valueOf(s.charAt(right))) >= 0) {
                sb.deleteCharAt(0);
                left++;
            }else {
                sb.append(s.charAt(right));
                if (sb.length() > result) {
                    result = sb.length();
                }
                right++;
            }
        }
        return result;
    }
}
