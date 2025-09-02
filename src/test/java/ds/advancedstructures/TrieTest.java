package ds.advancedstructures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    @Test
    void testTrieBasic() {
        Trie trie = new Trie();

        // add some words
        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");

        // check search
        assertTrue(trie.search("apple"));    // exact word
        assertTrue(trie.search("app"));
        assertFalse(trie.search("ap"));      // not a full word
        assertFalse(trie.search("ban"));

        // check prefix search
        assertTrue(trie.startsWith("ap"));   // prefix exists
        assertTrue(trie.startsWith("ban"));
        assertFalse(trie.startsWith("bat")); // prefix not exists
    }
}
