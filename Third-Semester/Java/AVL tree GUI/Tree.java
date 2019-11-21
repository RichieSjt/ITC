public class Tree<T extends Comparable<T>>{

    private Node<T> origin;

    public Node<T> getOrigin() {
        return origin;
    }

    public void setOrigin(Node<T> origin) {
        this.origin = origin;
    }
    //we create the root ot the origin
    public void insertElement(T element){
        origin = insertElement(element,origin);
    }

    //insert a new element to the tree
    private Node<T> insertElement(T element, Node<T> origin){
        if(origin==null){
            origin = new Node<T>(element);
        }else {
            if(element.compareTo(origin.getElement())>0) {
                origin.setRight(insertElement(element, origin.getRight()));
                //it is checked that it is balanced
                if(height(origin.getLeft())-height(origin.getRight())==-2) {
                    if(element.compareTo(origin.getRight().getElement())>0) {
                        origin= rotateSimpleToLeft(origin);
                    }else {
                        origin= rotateDoubleToLeft(origin);
                    }
                }
            }
            if(element.compareTo(origin.getElement())<0) {
                origin.setLeft(insertElement(element, origin.getLeft()));
                //it is checked that it is balanced
                if(height(origin.getLeft())-height(origin.getRight())==2) {
                    if(element.compareTo(origin.getLeft().getElement())<0) {
                        origin = rotateSimpleToRight(origin);
                    }else {
                        origin = rotateDoubleToRight(origin);
                    }
                }
            }
        }

        int height = maxHeight(height (origin.getLeft()),height(origin.getRight()));
        System.out.println("Height: "+origin.getElement()+" "+height);
        origin.setHeight(height+1);
        return origin;
    }
    //simple rotation to the left
    private Node<T> rotateSimpleToLeft(Node<T> origin){
        Node<T> temp= origin.getRight();
        origin.setRight(temp.getLeft());
        temp.setLeft(origin);
        origin.setHeight(maxHeight(height(origin.getLeft()),height(origin.getRight()))+1);
        temp.setHeight(maxHeight(height(temp.getRight()),height(origin))+1);
        return temp;
    }
    //simple rotation to the right
    private Node<T> rotateSimpleToRight(Node<T> origin){
        Node<T> temp= origin.getLeft();
        origin.setLeft(temp.getRight());
        temp.setRight(origin);
        origin.setHeight(maxHeight(height(origin.getLeft()),height(origin.getRight()))+1);
        temp.setHeight(maxHeight(height(temp.getLeft()),height(origin))+1);
        return temp;
    }
    //double rotation to the left
    private Node<T> rotateDoubleToLeft(Node<T> origin){
        origin.setRight(rotateSimpleToRight(origin.getRight()));
        return rotateSimpleToLeft(origin);
    }
    //double rotation to the right
    private Node<T> rotateDoubleToRight(Node<T> origin){
        origin.setLeft(rotateSimpleToLeft(origin.getLeft()));
        return rotateSimpleToRight(origin);
    }
    //get the maximum height between left and right
    private int maxHeight(int a, int b) {
        if(a>b) {
            return a;
        }else {
            return b;
        }
    }
    //get the specific height of a node
    private int height(Node<T> node) {
        if(node==null) {
            return -1;
        }else {
            return node.getHeight();
        }
    }
    public Node<T> deleteNode(Node<T> origin, T value) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (origin == null)
            return origin;
        // If the value to be deleted is smaller than the root's value,
        // then it lies in left subtree
        if (origin.getElement().compareTo(value)<0) {
            origin.setLeft(deleteNode(origin.getLeft(), value));
        }
            // If the value to be deleted is greater than the root's value,
            // then it lies in right subtree
        else if( origin.getElement().compareTo(value)<0) {
            origin.setRight(deleteNode(origin.getRight(), value));
        }
            // if value is same as root's value, then This is the node
            // to be deleted
        else {
            // node with only one child or no child
            if( (origin.getLeft() == null) || (origin.getRight() == null) ) {
                Node<T> temp;
                if (origin.getLeft() != null) {
                    temp = origin.getLeft();
                }
                else {
                    temp = origin.getRight();
                }
                // No child case
                if(temp == null) {
                    temp = origin;
                    origin = null;
                }
                else { // One child case
                    origin = temp; // Copy the contents of the non-empty child
                }
                temp = null;
            }
            else {
                // node with two children: Get the inorder successor (smallest
                // in the right subtree)
                Node<T> temp = minValueNode(origin.getRight());
                // Copy the inorder successor's data to this node
                origin.setElement(temp.getElement());
                // Delete the inorder successor
                origin.setRight(deleteNode(origin.getRight(), temp.getElement()));
            }
        }
        // If the tree had only one node then return
        if (origin == null)
            return origin;
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        origin.setHeight( Math.max(height(origin.getLeft()), height(origin.getLeft())) + 1);
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        //  this node became unbalanced)
        int balance = getBalance(origin);
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(origin.getLeft()) >= 0)
            return rightRotate(origin);

        // Left Right Case
        if (balance > 1 && getBalance(origin.getLeft()) < 0) {
            origin.setLeft(leftRotate(origin.getLeft()));
            return rightRotate(origin);
        }

        // Right Right Case
        if (balance < -1 && getBalance(origin.getRight()) <= 0)
            return leftRotate(origin);

        // Right Left Case
        if (balance < -1 && getBalance(origin.getRight()) > 0) {
            origin.setRight(rightRotate(origin.getRight()));
            return leftRotate(origin);
        }

        return origin;
    }
    private Node minValueNode(Node<T> node) {
        Node<T> current = node;
        /* loop down to find the leftmost leaf */
        while (current.getLeft() != null)
            current = current.getLeft();
        return current;
    }
    // Get Balance factor of node N
    private int getBalance(Node<T> origin) {
        if (origin == null) {
            return 0;
        }
        return height(origin.getLeft()) - height(origin.getRight());
    }
    private Node rightRotate(Node<T> y) {
        Node<T> x = y.getLeft();
        Node T2 = x.getRight();
        // Perform rotation
        x.setRight(y);
        y.setLeft(T2);
        // Update heights
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight()))+1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight()))+1);
        // Return new root
        return x;
    }

    private Node leftRotate(Node<T> x) {
        Node<T> y = x.getRight();
        Node T2 = y.getLeft();
        // Perform rotation
        y.setLeft(x);
        x.setRight(T2);
        //  Update heights
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight()))+1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight()))+1);
        // Return new root
        return y;
    }
}