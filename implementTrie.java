class TrieNode {
    // Initialize your data structure here.
    public HashMap<Character, TrieNode> children;
    public boolean flag;
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        flag = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        char[] c = word.toCharArray();
        int i;
        for(i = 0; i < c.length; i++) {
            if(curr.children.containsKey(c[i])) {
                TrieNode child = curr.children.get(c[i]);
                curr = child;
            }else break;
        }
        if(i == c.length) {
            curr.flag = true;
        }
        for(; i < c.length; i++) {
            TrieNode next = new TrieNode();
            curr.children.put(c[i], next);
            curr = next;
        }
        curr.flag = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = root;
        char[] c = word.toCharArray();
        int i;
        for(i = 0; i < c.length; i++) {
            if(curr.children.containsKey(c[i])) {
                TrieNode child = curr.children.get(c[i]);
                curr = child;
            }else return false;
        }
        if(i == c.length && curr.flag == true)
            return true;
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        char[] c = prefix.toCharArray();
        int i;
        for(i = 0; i < c.length; i++) {
            if(curr.children.containsKey(c[i])) {
                TrieNode child = curr.children.get(c[i]);
                curr = child;
            }else{
                return false;
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");