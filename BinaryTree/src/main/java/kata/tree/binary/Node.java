package kata.tree.binary;

public class Node {
    private Node leftNode = null;
    private Node rightNode = null;
    private final int value;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public boolean isLeftNodeFree() {
        return leftNode == null;
    }

    public boolean isRightNodeFree() {
        return rightNode == null;
    }
}