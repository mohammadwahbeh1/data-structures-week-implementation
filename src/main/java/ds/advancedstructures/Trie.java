package ds.advancedstructures;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    // each node contains children and a flag if it's the end of a word
    private static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isWord;
    }

    private Node root;

    public Trie() {
        root = new Node(); // start with empty root
    }

    // add a word to the Trie
    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            // if child does not exist, create it
            node.children.putIfAbsent(c, new Node());
            node = node.children.get(c);
        }
        node.isWord = true; // mark end of word
    }

    // check if a full word exists
    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            if (node == null) return false; // missing character
        }
        return node.isWord;
    }

    // check if any word starts with the given prefix
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) return false; // prefix not found
        }
        return true;
    }
}
