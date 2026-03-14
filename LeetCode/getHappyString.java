class Solution {
    char[] c = new char[]{'a','b','c'};

    public void makeString(List<String> lst, StringBuilder happy, int n) {
        if (happy.length() == n) {
        	lst.add(happy.toString());
        	return;
        }
        for (int i = 0; i < c.length; i++) {
            if (happy.length() > 0 && happy.charAt(happy.length() - 1) == c[i]) {
                continue;
            }
        	happy.append(c[i]);
        	makeString(lst, happy, n);
        	happy.deleteCharAt(happy.length() - 1);
        }
    }

    public String getHappyString(int n, int k) {
        List<String> happyStrs = new ArrayList<>();    
        makeString(happyStrs, new StringBuilder(""), n);
        if (happyStrs.size() >= k) {
        	return happyStrs.get(k-1);
        }
        return "";
    }
}
