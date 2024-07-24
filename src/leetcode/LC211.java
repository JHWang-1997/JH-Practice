package leetcode;

/**
 *
 *@author JH-Wang
 *@since 2024/7/24 22:35
 */
public class LC211 {
}

class WordDictionary {

    PTree root;

    public WordDictionary() {
        root = new PTree();
    }

    public void addWord(String word) {
        PTree node = root;
        for (final char ch : word.toCharArray()) {
            if (node.next[ch - 'a'] == null) {
                node.next[ch - 'a'] = new PTree();
            }
            node = node.next[ch - 'a'];
        }
        node.exist = true;
    }

    public boolean search(String word) {
        return searchHelp(root, word);
    }

    private boolean searchHelp(PTree node, String word) {
        if ("".equals(word)) {
            return node.exist;
        }
        String str = word.substring(1);
        if (word.charAt(0) == '.') {
            for (PTree tree : node.next) {
                if (tree != null && searchHelp(tree, str)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.next[word.charAt(0) - 'a'] == null) {
                return false;
            }
            return searchHelp(node.next[word.charAt(0) - 'a'], str);
        }
    }

    static class PTree {
        boolean exist;
        PTree[] next = new PTree[26];
    }
}
