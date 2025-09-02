package ds.trees;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    @Test
    void testInsertAndContains() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(12);

        assertTrue(bst.contains(10));
        assertTrue(bst.contains(5));
        assertFalse(bst.contains(20));

        assertEquals(java.util.List.of(5, 10, 12, 15), bst.inorder());
    }
}
