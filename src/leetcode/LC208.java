package leetcode;

/**
 *
 *@author JH-Wang
 *@since 2024/7/24 22:12
 */
public class LC208 {
}

class Trie {

    PreTree root;

    public Trie() {
        root = new PreTree();
    }

    public void insert(String word) {
        PreTree node = root;
        for (final char ch : word.toCharArray()) {
            if (node.next[ch - 'a'] == null) {
                node.next[ch - 'a'] = new PreTree();
            }
            node = node.next[ch - 'a'];
        }
        node.exist = true;
    }

    public boolean search(String word) {
        PreTree node = root;
        for (final char ch : word.toCharArray()) {
            if (node.next[ch - 'a'] == null) {
                return false;
            }
            node = node.next[ch - 'a'];
        }
        return node.exist;
    }

    public boolean startsWith(String prefix) {
        PreTree node = root;
        for (final char ch : prefix.toCharArray()) {
            if (node.next[ch - 'a'] == null) {
                return false;
            }
            node = node.next[ch - 'a'];
        }
        return true;
    }

    static class PreTree {
        boolean exist;

        PreTree[] next = new PreTree[26];

        PreTree() {
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */