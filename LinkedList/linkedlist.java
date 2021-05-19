public class linkedlist {
    private class Node {
        private int data = 0;
        private Node next = null;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int NumberOfNodes = 0;

    // -------------------------------------------------------------------------
    public int size() {
        return NumberOfNodes;
    }

    // -------------------------------------------------------------------------
    public boolean isEmpty() {
        return NumberOfNodes == 0;
    }

    // -------------------------------------------------------------------------
    protected void handleZeroSize(Node node) {
        this.head = node;
        this.tail = node;
    }

    // -------------------------------------------------------------------------
    protected void addFirstNode(Node node) {
        if (this.size() == 0) {
            handleZeroSize(node);
        } else {
            node.next = head;
            this.head = node;
        }
        this.NumberOfNodes++;
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        addFirstNode(node);
    }

    // -------------------------------------------------------------------------
    protected void addLastNode(Node node) {
        if (this.size() == 0) {
            handleZeroSize(node);
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        NumberOfNodes++;

    }

    public void addLast(int data) {
        Node node = new Node(data);
        addLastNode(node);
    }

    // -------------------------------------------------------------------------
    protected void addNodeAt(Node node, int idx) {
        if (idx == 0) {
            addFirstNode(node);
        } else {
            Node nodeAt = getNodeAt(idx - 1);
            Node forw = nodeAt.next;

            nodeAt.next = node;
            node.next = forw;
            this.NumberOfNodes++;
        }
    }

    public void addAt(int idx, int data) throws Exception {
        if (idx < 0 || idx > this.size()) {
            throw new Exception("Invalid Index");
        }

        Node node = new Node(data);
        addNodeAt(node, idx);
    }

    // -------------------------------------------------------------------------
    protected Node getNodeAt(int idx) {
        Node temp = this.head;
        while (idx-- > 0) {
            temp = temp.next;
        }
        return temp;
    }

    // -------------------------------------------------------------------------
    protected void handleSize1() {
        this.head = null;
        this.tail = null;
    }

    // -------------------------------------------------------------------------
    protected Node removeFirstNode() {
        Node temp = head;
        if (this.size() == 1) {
            handleSize1();
        } else {
            this.head = this.head.next;
        }
        temp.next = null;
        this.NumberOfNodes--;
        return temp;
    }

    public int removeFirst() throws Exception {
        if (this.size() == 0) {
            throw new Exception("Linked list is empty");
        }
        Node node = removeFirstNode();
        return node.data;
    }

    // -------------------------------------------------------------------------
    protected Node removeLasNode() {
        Node temp = this.tail;
        if (this.size() == 1) {
            handleSize1();
        } else {
            Node getNode = getNodeAt(size() - 2);
            getNode.next = null;
            this.tail = getNode;
        }
        NumberOfNodes--;
        temp.next = null;
        return temp;
    }

    public int removeLast() throws Exception {
        if (this.size() == 0) {
            throw new Exception("List is empty");
        }
        Node node = removeLasNode();
        return node.data;
    }

    // -------------------------------------------------------------------------
}