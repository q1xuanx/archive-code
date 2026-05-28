// LC 3093
class Solution {
    class TrieNode {
    	
    	TrieNode[] children;
    	int le = Integer.MAX_VALUE;
    	int ide = Integer.MAX_VALUE;
    	  	
    	public TrieNode() {
    		children = new TrieNode[26];
    	}
    	
    }
    
    class Trie { 
    	
    	TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

    	public void insert(String s, int index) {
    		int n = s.length();
    		TrieNode current = root;
    		for (int i = n - 1; i >= 0; i--) {
    			char c = s.charAt(i);
    			if (current.children[c - 'a'] == null) {
    				current.children[c - 'a'] = new TrieNode();
    			}
    			current = current.children[c - 'a'];
    			if (current.le > n) {
    				current.le = n;
    				current.ide = index;
    			} else if (current.le == n && current.ide > index) {
    				current.ide = index;
    			}
    		}
    	}
    	
    	public int search(String s, int small) {
    		int n = s.length();
    		TrieNode current = root;
    		int res = -1;
    		for (int i = n - 1; i >= 0; i--) {
    			char c = s.charAt(i);
    			if (current.children[c - 'a'] == null) {
    				break;
    			}
    			current = current.children[c - 'a'];
                res = current.ide;
    		}
    		return res == -1 ? small : res;
    	}
    	
    }
    
    int small = Integer.MAX_VALUE;
    int ide = -1;

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
    	int n = wordsQuery.length;
    	int m = wordsContainer.length;
        int[] res = new int[n];
        Trie trie = new Trie();
        for (int i = 0; i < m; i++) {
        	trie.insert(wordsContainer[i], i);
            if (small > wordsContainer[i].length()) {
                small = wordsContainer[i].length();
                ide = i;
            }
        }
        for (int i = 0; i < n; i++) {
        	res[i] = trie.search(wordsQuery[i], ide);
        }
        return res;
    }
}
