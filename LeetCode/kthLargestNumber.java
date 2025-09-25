class Solution {

    PriorityQueue<String> pq = new PriorityQueue<>(
        (a,b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            return b.compareTo(a);
        }
    );

    public String kthLargestNumber(String[] nums, int k) {
        for (String s : nums) {
            pq.add(s);
        }
        StringBuilder res = new StringBuilder();
        while (k > 0) {
            res.setLength(0);
            res.append(pq.poll());
            k--;
        }
        return res.toString();
    }
}
