package kata.tree.binary;

import com.google.common.collect.ImmutableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class BinaryTreeTest {
    private static final List<Integer> ONE_NODE_LIST = ImmutableList.of(1);
    private static final List<Integer> THREE_NODES_IN_PRE_ORDER_LIST = ImmutableList.of(2, 1, 3);
    private static final List<Integer> THREE_NODES_IN_POST_ORDER_LIST = ImmutableList.of(1, 3, 2);
    private static final List<Integer> THREE_NODES_IN_ORDER_LIST = ImmutableList.of(1, 2, 3);
    private static final List<Integer> THREE_NODES_IN_REVERSE_ORDER_LIST = ImmutableList.of(3, 2, 1);
    private static final List<Integer> SEVEN_NODES_IN_ORDER_LIST = ImmutableList.of(1, 2, 3, 4, 5, 6, 7);
    private static final List<Integer> SEVEN_NODES_IN_REVERSE_ORDER_LIST = ImmutableList.of(7, 6, 5, 4, 3, 2, 1);
    private BinaryTree testBinaryTree;

    @Before
    public void before() throws Exception {
        testBinaryTree = new BinaryTree();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void whenInsertOneNodeInEmptyTree_thenGetOneNode() throws Exception {
        testBinaryTree.insert(1);
        List<Integer> nodes = testBinaryTree.getNodesInPreOrder();
        assertThat(nodes, contains(ONE_NODE_LIST.toArray()));
    }

    @Test
    public void whenInsertThreeNodesInEmptyTreeAndPreOrder_thenGetNodesInPreOrder() throws Exception {
        createThreeNodeTestTree();
        List<Integer> nodes = testBinaryTree.getNodesInPreOrder();
        assertThat(nodes, contains(THREE_NODES_IN_PRE_ORDER_LIST.toArray()));
    }

    @Test
    public void whenInsertThreeNodesInEmptyTreeAndPostOrder_thenGetNodesInPostOrder() throws Exception {
        createThreeNodeTestTree();
        List<Integer> nodes = testBinaryTree.getNodesInPostOrder();
        assertThat(nodes, contains(THREE_NODES_IN_POST_ORDER_LIST.toArray()));
    }

    @Test
    public void whenInsertThreeNodesInEmptyTreeAndInOrder_thenGetNodesInOrder() throws Exception {
        createThreeNodeTestTree();
        List<Integer> nodes = testBinaryTree.getNodesInOrder();
        assertThat(nodes, contains(THREE_NODES_IN_ORDER_LIST.toArray()));
    }

    @Test
    public void whenInsertThreeNodesInEmptyTreeAndInReverseOrder_thenGetNodesInReverseOrder() throws Exception {
        createThreeNodeTestTree();
        List<Integer> nodes = testBinaryTree.getNodesInReverseOrder();
        assertThat(nodes, contains(THREE_NODES_IN_REVERSE_ORDER_LIST.toArray()));
    }

    @Test
    public void whenInsertSevenNodesInEmptyTreeAndInOrder_thenGetNodesInOrder() throws Exception {
        createSevenNodeTestTree();
        List<Integer> nodes = testBinaryTree.getNodesInOrder();
        assertThat(nodes, contains(SEVEN_NODES_IN_ORDER_LIST.toArray()));
    }

    @Test
    public void whenInsertSevenNodesInEmptyTreeAndInReverseOrder_thenGetNodesInReverseOrder() throws Exception {
        createSevenNodeTestTree();
        List<Integer> nodes = testBinaryTree.getNodesInReverseOrder();
        assertThat(nodes, contains(SEVEN_NODES_IN_REVERSE_ORDER_LIST.toArray()));
    }

    // @formatter:off
    /**
     * TEST BINARY TREE
     *         (3)
     *      /       \
     *    (1)       (5)
     *   /   \     /   \
     * (0)  (2)  (4)  (6)
     */
    // @formatter:on
    private void createSevenNodeTestTree() {
        testBinaryTree.insert(4);
        testBinaryTree.insert(2);
        testBinaryTree.insert(6);
        testBinaryTree.insert(1);
        testBinaryTree.insert(3);
        testBinaryTree.insert(5);
        testBinaryTree.insert(7);
    }

    // @formatter:off
    /**
     * TEST BINARY TREE
     *    (2)
     *   /   \
     * (1)  (3)
     */
    // @formatter:on
    private void createThreeNodeTestTree() {
        testBinaryTree.insert(2);
        testBinaryTree.insert(3);
        testBinaryTree.insert(1);
    }
} 
