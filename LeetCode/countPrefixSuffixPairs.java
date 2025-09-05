class Solution {
    public class TrieNode { 
        TrieNode [] children; 
        int countNode; 
        public TrieNode () {
            children = new TrieNode[26];
            countNode = 0;
        }
    }
    public int countPrefixSuffixPairs(String[] words) {
        TrieNode root = new TrieNode(); 
        int res = 0; 
        for (String s : words){
            char [] chars = s.toCharArray(); 
            int n = s.length();
            TrieNode current = root;
            for (int i = 0; i < n; i++) {
                if (current.children[chars[i] - 'a'] == null) {
                    TrieNode newNode = new TrieNode();
                    current.children[chars[i] - 'a'] = newNode; 
                }
                current = current.children[chars[i] - 'a'];

                if (current.children[chars[n - 1 - i] - 'a'] == null) {
                    TrieNode newNode = new TrieNode();
                    current.children[chars[n - 1 - i] - 'a'] = newNode; 
                }
                current = current.children[chars[n - 1 - i] - 'a'];
                res += current.countNode;
            }
            current.countNode += 1;
        }
        return res;
    }
}
