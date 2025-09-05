package about_coding_algo;

public class TrieImplement {
	
	public class TrieNode { 
		TrieNode [] children; 
		boolean isEndOfWord; 
		
		public TrieNode () {
			isEndOfWord = false;
			children = new TrieNode[26];
		}
		
		public void insert (TrieNode root, String key) {
			TrieNode curr = root; 
			for (char c : key.toCharArray()) {
				if (curr.children[c - 'a'] == null) {
					TrieNode newNode = new TrieNode();
					curr.children[c - 'a'] = newNode;
				}
				curr = curr.children[c - 'a'];
			}
			curr.isEndOfWord = true;
		}
		
		public boolean search (TrieNode root, String key) {
			TrieNode curr = root; 
			for (char c : key.toCharArray()) {
				if (curr.children[c - 'a'] == null) {
					return false;
				}
				curr = curr.children[c - 'a'];
			}
			return curr.isEndOfWord;
		}
		
		public boolean isPrefix (TrieNode root, String key) {
			TrieNode curr = root; 
			for (char c : key.toCharArray()) {
				if (curr.children[c - 'a'] == null) {
					return false;
				}
				curr = curr.children[c - 'a'];
			}
			return true;
		}
	}
}
