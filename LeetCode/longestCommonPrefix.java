
class Solution {

    class TrieNode { 
        TrieNode[] child;
        
        public TrieNode() { 
            // 0 -> 9
            child = new TrieNode[10];
        }
    }

    class Trie { 
        TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String num) { 
            TrieNode current = root;
            for (int i = 0; i < num.length(); i++) {
                char ch = num.charAt(i);
                if (current.child[ch - '0'] == null) {
                    current.child[ch - '0'] = new TrieNode();
                }
                current = current.child[ch - '0'];
            }
        }

        public int lcs (String num) {
            TrieNode current = root; 
            int res = 0;
            for (int i = 0; i < num.length(); i++) {
                char ch = num.charAt(i);
                if (current.child[ch - '0'] == null) break;
                current = current.child[ch - '0'];
                res++;
            }
            return res;
        }
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        int res = Integer.MIN_VALUE;e
        for (int i = 0; i < arr1.length; i++) trie.insert(String.valueOf(arr1[i]));
        for (int i = 0; i < arr2.length; i++) res = Math.max(res, trie.lcs(String.valueOf(arr2[i])));
        return res;
    }
}
