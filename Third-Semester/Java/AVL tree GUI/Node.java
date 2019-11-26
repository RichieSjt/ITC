public class Node<T> {
    private T element;
    private Node<T> left;
    private Node<T> right;
    private int height;

    /**
     * Rearrange nodes for deletion balance
     */
    public Node(T elementc, Node<T> node1, Node<T> node2){
        super();
        left = node1;
        element = elementc;
        right = node2;
        height = 1 + Math.max(height(node1), height(node2));
    }

    public  int height(Node<T> nodeHeight){
        if(nodeHeight== null)
            return -1;
        return 1+Math.max(height(nodeHeight.getLeft()),height(nodeHeight.getRight()));
    }
    public Node(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}