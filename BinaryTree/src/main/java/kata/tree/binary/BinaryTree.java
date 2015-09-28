package kata.tree.binary;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private Node rootNode = null;
    private static final String SEPARATOR = "->";

    public void insert(int value) {
        if (rootNode == null) {
            rootNode = new Node(value);
        } else {
            insert(rootNode, value);
        }
    }

    private void insert(Node node, int value) {
        if (value > node.getValue()) {
            insertIntoRightSide(node, value);
        } else {
            insertIntoTheLeftSide(node, value);
        }
    }

    private void insertIntoRightSide(Node node, int value) {
        if (node.isRightNodeFree()) {
            node.setRightNode(new Node(value));
        } else {
            insert(node.getRightNode(), value);
        }
    }

    private void insertIntoTheLeftSide(Node node, int value) {
        if (node.isLeftNodeFree()) {
            node.setLeftNode(new Node(value));
        } else {
            insert(node.getLeftNode(), value);
        }
    }

    public List<Integer> getNodesInPreOrder() {
        List<Integer> nodes = new ArrayList<>();
        visitNodesInPreOrderAndAddThemToList(rootNode, nodes);
        return nodes;
    }

    public List<Integer> getNodesInPostOrder() {
        List<Integer> nodes = new ArrayList<>();
        visitNodesInPostOrderAndAddThemToList(rootNode, nodes);
        return nodes;
    }

    public List<Integer> getNodesInOrder() {
        List<Integer> nodes = new ArrayList<>();
        visitNodesInOrderAndAddThemToList(rootNode, nodes);
        return nodes;
    }

    public List<Integer> getNodesInReverseOrder() {
        List<Integer> nodes = new ArrayList<>();
        visitNodesInReverseOrderAndAddThemToList(rootNode, nodes);
        return nodes;
    }

    private void visitNodesInPreOrderAndAddThemToList(Node rootNode, List<Integer> nodes) {
        if (rootNode != null) {
            nodes.add(rootNode.getValue());
            visitNodesInPreOrderAndAddThemToList(rootNode.getLeftNode(), nodes);
            visitNodesInPreOrderAndAddThemToList(rootNode.getRightNode(), nodes);
        }
    }

    private void visitNodesInPostOrderAndAddThemToList(Node rootNode, List<Integer> nodes) {
        if (rootNode != null) {
            visitNodesInPostOrderAndAddThemToList(rootNode.getLeftNode(), nodes);
            visitNodesInPostOrderAndAddThemToList(rootNode.getRightNode(), nodes);
            nodes.add(rootNode.getValue());
        }
    }

    private void visitNodesInOrderAndAddThemToList(Node rootNode, List<Integer> nodes) {
        if (rootNode != null) {
            visitNodesInOrderAndAddThemToList(rootNode.getLeftNode(), nodes);
            nodes.add(rootNode.getValue());
            visitNodesInOrderAndAddThemToList(rootNode.getRightNode(), nodes);
        }
    }

    private void visitNodesInReverseOrderAndAddThemToList(Node rootNode, List<Integer> nodes) {
        if (rootNode != null) {
            visitNodesInReverseOrderAndAddThemToList(rootNode.getRightNode(), nodes);
            nodes.add(rootNode.getValue());
            visitNodesInReverseOrderAndAddThemToList(rootNode.getLeftNode(), nodes);
        }
    }
}
