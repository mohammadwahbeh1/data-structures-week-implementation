package ds.trees;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    @Test
    void testTraversals() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = new BinaryTree.Node<>(1);
        tree.root.left = new BinaryTree.Node<>(2);
        tree.root.right = new BinaryTree.Node<>(3);
        tree.root.left.left = new BinaryTree.Node<>(4);
        tree.root.left.right = new BinaryTree.Node<>(5);

        assertEquals(List.of(4, 2, 5, 1, 3), tree.inorder());
        assertEquals(List.of(1, 2, 4, 5, 3), tree.preorder());
        assertEquals(List.of(4, 5, 2, 3, 1), tree.postorder());
    }
}
