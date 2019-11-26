public class AVLTree<T extends Comparable<T>> {
    private Node<T> origin;

    public Node<T> getOrigin() {
        return origin;
    }

    public void setOrigin(Node<T> origin) {
        this.origin = origin;
    }
    
    public void insertElement(T element) throws DuplicateException{
        //If the element is already in the tree then we trhow a duplicate exception
        if(search(element))
            throw new DuplicateException("Element already in the tree");
        else
            origin = insertElement(element,origin);
    }

    //search if the element is in the tree
    public boolean search(T element) {

        Node<T> temp = origin; // Start from the root

        while (temp != null) {
            if (element.compareTo(temp.getElement()) < 0)
                temp = temp.getLeft();
            else if (element.compareTo(temp.getElement()) > 0)
                temp = temp.getRight();
            else // element matches temp element
                return true; // Element is found
        }
        return false;
    }

    //insert a new element to the tree
    private Node<T> insertElement(T element, Node<T> origin){
        if(origin==null)
            origin = new Node<T>(element);
        else {
            //if the element goes to the rigth
            if(element.compareTo(origin.getElement())>0) {
                origin.setRight(insertElement(element, origin.getRight()));
                //it is checked that it is balanced
                if(height(origin.getLeft())-height(origin.getRight())==-2) {
                    if(element.compareTo(origin.getRight().getElement())>0) {
                        System.out.println("rotacion simple a la izquierda");
                        origin = rotateSimpleToLeft(origin);
                    }else {
                        System.out.println("rotacion doble a la izquierda");
                        origin = rotateDoubleToLeft(origin);
                        
                    }
                }
            }
            //if the element goes to the left
            if(element.compareTo(origin.getElement())<0) {
                origin.setLeft(insertElement(element, origin.getLeft()));
                //it is checked that it is balanced
                if(height(origin.getLeft())-height(origin.getRight())==2) {
                    if(element.compareTo(origin.getLeft().getElement())<0) {
                        System.out.println("rotacion simple a la derecha");
                        origin = rotateSimpleToRight(origin);
                    }else {
                        System.out.println("rotacion doble a la derecha");
                        origin = rotateDoubleToRight(origin);
                    }
                }
            }
        }
        //Update the inserted node height
        int height = maxHeight(height (origin.getLeft()),height(origin.getRight()));
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
    private int maxHeight(int num1, int num2) {
        if(num1>num2)
            return num1;
        else
            return num2;
    }
    //get the specific height of a node
    private int height(Node<T> node) {
        if(node==null)
            return -1;
        else
            return node.getHeight();
    }
    //find the minimun value of a tree in a node
    private Node<T> findMin( Node<T> node ) {
        if( node == null )
            return node;

        while(node.getLeft() != null )
            node = node.getLeft();
        return node;
    }

    public void deleteNode(T element){
        deleteNode(origin,element);
    }

    private Node<T> deleteNode(Node<T> node, T element){
        if(node == null){ // if the node isn't in the tree 
            return node;
        }
        if(element.compareTo(node.getElement())<0){ //if the element is on the left side
            node.setLeft(deleteNode(node.getLeft(), element));
        }else if(element.compareTo(node.getElement())>0){ // if the element is on the right side
            node.setRight(deleteNode(node.getRight(), element));
        }else if( node.getLeft() != null && node.getRight() != null ) { // case when there is two sons
            node.setElement(findMin(node.getRight()).getElement());
            node.setRight(deleteNode(node.getRight(),node.getElement()));
        }else if(node.getLeft() != null || node.getRight() != null) { // case only one son and we find the smallest left or biggest right depends the child
            if (node.getRight() == null) { // when there is no right son (origin)
                node.setElement(findMin(node.getLeft()).getElement());
                node.setRight(deleteNode(node.getLeft(), node.getElement()));
                node.setLeft(null);
            } else { // when there is no left son (origin)
                node.setElement(findMin(node.getRight()).getElement());
                node.setRight(deleteNode(node.getRight(), node.getElement()));
                node.setRight(null);
            }
        }else{  
            node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        }
        return node; // return the node to delete
    }
    
    /********************************
    * deleteNode2 exclusive methods *
    *********************************/
        
    public void deleteNode2(T element){
        deleteNode2(origin, element);
    }
    private Node<T> deleteNode2(Node<T> node, T element){
        if(node==null) {
            return node;
        }
        if(node.getElement().compareTo(element)==0) {//when we find the element
            return deleteOrigin(node);
        }
        if(node.getElement().compareTo(element) > 0) {//if the element is in the left
            node.setLeft(deleteNode2(node.getLeft(), element));
        }else {
            node.setRight(deleteNode2(node.getRight(), element));//if the element is in the right
        }
        return balance(node); // whe return and balance the tree 
    }
    private  Node<T> deleteOrigin(Node<T> node){
        if(node.getLeft()==null) // whe move the lowest right of the node
            return node.getRight();
        if(node.getRight()==null) // we move the biggest left of the node
            return node.getLeft();

        Node<T> node1 = node.getLeft();
        Node<T> father= node;

        //whe determine who the father is going to be 
        while(node1.getRight() != null) {
            father= node1;
            node1 = node1.getRight();
        }
        node.setElement(node1.getElement());
        if(father == node)
            father.setLeft(node1.getLeft());
        else
            father.setRight(node1.getLeft());
        return node;
    }
    /***
     * this method balance the tree in case it unbalacne when removing a node
     */
    private  Node<T> balance(Node<T> nodeBalance){
        calculateHeight(nodeBalance);
        if (heightTree(nodeBalance.getLeft()) -heightTree(nodeBalance.getRight()) == 2){
            if (heightTree(nodeBalance.getLeft().getLeft()) < heightTree(nodeBalance.getLeft().getRight()))
            nodeBalance.setLeft(rotation1(nodeBalance.getLeft()));
            return rotation2(nodeBalance);
        } 
        if (heightTree(nodeBalance.getLeft())-heightTree(nodeBalance.getRight()) == -2){
            if (heightTree(nodeBalance.getRight().getRight()) < heightTree(nodeBalance.getRight().getLeft()))
            nodeBalance.setRight(rotation2(nodeBalance.getRight()));
            return rotation1(nodeBalance);
        }
        return nodeBalance;
    }
    /***
     * this method makes the rotation for deletion only, whe rearrange the nodes (left and right case cor rotation 1 and 2)
     */
    private  Node<T> rotation1(Node<T> node){
        Node<T> node2 = node.getRight();
        Node<T> node3 = new Node<>(node.getElement(), node.getLeft(), node2.getLeft());
        Node<T> node4 = new Node<>(node2.getElement(), node3, node2.getRight());
        return node4;
    }
    private  Node<T> rotation2(Node<T> node){
        Node<T> node3 = node.getLeft();
        Node<T> node2 = new Node<>(node.getElement(), node3.getRight(), node.getRight());
        Node<T> node4 = new Node<>(node3.getElement(), node3.getLeft(),node2);
        return node4;
    }
    /***
     * this method calculates the height onf a node for deletion only
     */
    private  void calculateHeight(Node<T> nodeHeight){
        if(nodeHeight!=null){
            calculateHeight(nodeHeight.getLeft());
            calculateHeight(nodeHeight.getRight());
            nodeHeight.setHeight(1 + Math.max(heightTree(nodeHeight.getLeft()), heightTree(nodeHeight.getRight()))) ;
        }
    }
    /***
     * this method gets the height
     */
    public int heightTree(Node<T> node){
        if(node== null) {
            return -1;
        }
        return 1+Math.max(heightTree(node.getLeft()),heightTree(node.getRight()));
    }
}
