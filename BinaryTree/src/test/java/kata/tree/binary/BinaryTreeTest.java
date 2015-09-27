package kata.tree.binary;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BinaryTreeTest {
    private BinaryTree testBinaryTree;

    @Before
    public void before() throws Exception {
        testBinaryTree = new BinaryTree();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void whenInsertOneNodeInEmptyTree_thenGetOneNodeTree() throws Exception {
        testBinaryTree.insert(1);
        String binaryTreeAsString = testBinaryTree.getTreeAsStringInPreOrder();
        assertThat(binaryTreeAsString, equalTo("1"));
    }

    @Test
    public void whenInsertThreeNodesInEmptyTreeAndPreOrder_thenGetPreOrderTree() throws Exception {
        createThreeNodeTestTree();
        String binaryTreeAsString = testBinaryTree.getTreeAsStringInPreOrder();
        assertThat(binaryTreeAsString, equalTo("2->1->3"));
    }

    @Test
    public void whenInsertThreeNodesInEmptyTreeAndPostOrder_thenGetPostOrderTree() throws Exception {
        createThreeNodeTestTree();
        String binaryTreeAsString = testBinaryTree.getTreeAsStringInPostOrder();
        assertThat(binaryTreeAsString, equalTo("1->3->2"));
    }

    @Test
    public void whenInsertThreeNodesInEmptyTreeAndInOrder_thenGetInOrderTree() throws Exception {
        createThreeNodeTestTree();
        String binaryTreeAsString = testBinaryTree.getTreeAsStringInOrder();
        assertThat(binaryTreeAsString, equalTo("1->2->3"));
    }

    @Test
    public void whenInsertThreeNodesInEmptyTreeAndInReverseOrder_thenGetInReverseOrderTree() throws Exception {
        createThreeNodeTestTree();
        String binaryTreeAsString = testBinaryTree.getTreeAsStringInReverseOrder();
        assertThat(binaryTreeAsString, equalTo("3->2->1"));
    }
    @Test
    public void whenInsertSevenNodesInEmptyTreeAndPreOrder_thenGetPreOrderThree() throws Exception {
        createSevenNodeTestTree();
        String binaryTreeAsString = testBinaryTree.getTreeAsStringInPreOrder();
        assertThat(binaryTreeAsString, equalTo("3->1->0->2->5->4->6"));
    }

    @Test
    public void whenInsertSevenNodesInEmptyTreeAndPostOrder_thenGetPostOrderThree() throws Exception {
        createSevenNodeTestTree();
        String binaryTreeAsString = testBinaryTree.getTreeAsStringInPostOrder();
        assertThat(binaryTreeAsString, equalTo("0->2->1->4->6->5->3"));
    }

    @Test
    public void whenInsertSevenNodesInEmptyTreeAndInOrder_thenGetInOrderThree() throws Exception {
        createSevenNodeTestTree();
        String binaryTreeAsString = testBinaryTree.getTreeAsStringInOrder();
        assertThat(binaryTreeAsString, equalTo("0->1->2->3->4->5->6"));
    }

    @Test
    public void whenInsertSevenNodesInEmptyTreeAndInReverseOrder_thenGetInReverseOrderThree() throws Exception {
        createSevenNodeTestTree();
        String binaryTreeAsString = testBinaryTree.getTreeAsStringInReverseOrder();
        assertThat(binaryTreeAsString, equalTo("6->5->4->3->2->1->0"));
    }

    /**
     * TEST BINARY TREE
     *          (3)
     *       /       \
     *    (1)        (5)
     *   /   \      /   \
     * (0)   (2)  (4)  (6)
     */
    private void createSevenNodeTestTree() {
        testBinaryTree.insert(3);
        testBinaryTree.insert(1);
        testBinaryTree.insert(5);
        testBinaryTree.insert(0);
        testBinaryTree.insert(2);
        testBinaryTree.insert(4);
        testBinaryTree.insert(6);
    }

    /**
     * TEST BINARY TREE
     *      (2)
     *     /   \
     * (1)      (3)
     */
    private void createThreeNodeTestTree() {
        testBinaryTree.insert(2);
        testBinaryTree.insert(3);
        testBinaryTree.insert(1);
    }
} 
