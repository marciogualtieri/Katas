package kata.tree.binary;

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

    public void insert(Node node, int value) {
        if (value > node.getValue()) {
            if (node.getRightNode() == null) {
                Node newNode = new Node(value);
                node.setRightNode(newNode);
            } else {
                insert(node.getRightNode(), value);
            }
        } else {
            if (node.getLeftNode() == null) {
                Node newNode = new Node(value);
                node.setLeftNode(newNode);
            } else {
                insert(node.getLeftNode(), value);
            }
        }
    }

    public String getTreeAsStringInPreOrder() {
        StringBuffer treeAsStringBuffer = new StringBuffer();
        buildTreeInPreOrder(rootNode, treeAsStringBuffer);
        return treeAsStringBuffer.toString();
    }

    public String getTreeAsStringInPostOrder() {
        StringBuffer treeAsStringBuffer = new StringBuffer();
        buildTreeInPostOrder(rootNode, treeAsStringBuffer);
        return treeAsStringBuffer.toString();
    }

    public String getTreeAsStringInOrder() {
        StringBuffer treeAsStringBuffer = new StringBuffer();
        buildTreeInOrder(rootNode, treeAsStringBuffer);
        return treeAsStringBuffer.toString();
    }

    public String getTreeAsStringInReverseOrder() {
        StringBuffer treeAsStringBuffer = new StringBuffer();
        buildTreeInReverseOrder(rootNode, treeAsStringBuffer);
        return treeAsStringBuffer.toString();
    }
    private void buildTreeInPreOrder(Node rootNode, StringBuffer treeAsStringBuffer) {
        if (rootNode != null) {
            appendToTreeAsStringBuffer(rootNode, treeAsStringBuffer);
            buildTreeInPreOrder(rootNode.getLeftNode(), treeAsStringBuffer);
            buildTreeInPreOrder(rootNode.getRightNode(), treeAsStringBuffer);
        }
    }

    private void buildTreeInPostOrder(Node rootNode, StringBuffer treeAsStringBuffer) {
        if (rootNode != null) {
            buildTreeInPostOrder(rootNode.getLeftNode(), treeAsStringBuffer);
            buildTreeInPostOrder(rootNode.getRightNode(), treeAsStringBuffer);
            appendToTreeAsStringBuffer(rootNode, treeAsStringBuffer);
        }
    }

    private void buildTreeInOrder(Node rootNode, StringBuffer treeAsStringBuffer) {
        if (rootNode != null) {
            buildTreeInOrder(rootNode.getLeftNode(), treeAsStringBuffer);
            appendToTreeAsStringBuffer(rootNode, treeAsStringBuffer);
            buildTreeInOrder(rootNode.getRightNode(), treeAsStringBuffer);
        }
    }

    private void buildTreeInReverseOrder(Node rootNode, StringBuffer treeAsStringBuffer) {
        if (rootNode != null) {
            buildTreeInReverseOrder(rootNode.getRightNode(), treeAsStringBuffer);
            appendToTreeAsStringBuffer(rootNode, treeAsStringBuffer);
            buildTreeInReverseOrder(rootNode.getLeftNode(), treeAsStringBuffer);
        }
    }

    private void appendToTreeAsStringBuffer(Node node, StringBuffer treeAsStringBuffer) {
        if (treeAsStringBuffer.length() > 0) {
            treeAsStringBuffer.append(SEPARATOR);
        }
        treeAsStringBuffer.append(node.getValue());
    }
}
