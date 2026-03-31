class Solution {
    String gen(int m) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++)
            sb.append('a');
        return sb.toString();
    }

    public String generateString(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        if (n == 1) {
            return str1.charAt(0) == 'F' ? gen(m) : str2;
        }
        char[] res = new char[n + m - 1];
        Arrays.fill(res, '?');
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int pos = i + j;
                    if (res[pos] == '?' || res[pos] == str2.charAt(j)) {
                        res[pos] = str2.charAt(j);
                    } else {
                        return "";
                    }
                }
            }
        }
        char[] oldAns = res.clone();
        for (int i = 0; i < n + m - 1; i++) {
            if (res[i] == '?')
                res[i] = 'a';
        }
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != 'F') {
                continue;
            }
            if (!new String(res, i, m).equals(str2)) {
                continue;
            }
            boolean ok = false; 
            for (int j = i + m - 1; j >= i; j--) {
                if (oldAns[j] == '?') {
                    res[j] = 'b';
                    ok = true;
                    break;
                }
            }
            if (!ok) return "";
        }
        return new String(res);
    }
}
