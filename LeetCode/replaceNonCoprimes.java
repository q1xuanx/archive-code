class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        for (int num : nums) { 
            while(true) {
                int last = res.isEmpty() ? 1 : res.getLast();
                int x = gcd(last, num);
                if (x == 1) break;
                num *= res.removeLast() / x;
            }
            res.add(num);
        }
        return res;
    }

    public int gcd (int a, int b) { 
        return b > 0 ? gcd(b, a % b) : a;
    }
}
