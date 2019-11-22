public class Tree<T extends Comparable<T>>{

    private Node<T> origin;

    public Node<T> getOrigin() {
        return origin;
    }

    public void setOrigin(Node<T> origin) {
        this.origin = origin;
    }
    //we create the root ot the origin
    public void insertElement(T element) throws DuplicateException{
        if(search(element))
            throw new DuplicateException("Number is already in the tree");
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
            if(element.compareTo(origin.getElement())>0) {
                origin.setRight(insertElement(element, origin.getRight()));
                //it is checked that it is balanced
                if(height(origin.getLeft())-height(origin.getRight())==-2) {
                    if(element.compareTo(origin.getRight().getElement())>0)
                        origin= rotateSimpleToLeft(origin);
                    else 
                        origin= rotateDoubleToLeft(origin);
                }
            }
            if(element.compareTo(origin.getElement())<0) {
                origin.setLeft(insertElement(element, origin.getLeft()));
                //it is checked that it is balanced
                if(height(origin.getLeft())-height(origin.getRight())==2) {
                    if(element.compareTo(origin.getLeft().getElement())<0)
                        origin = rotateSimpleToRight(origin);
                    else
                        origin = rotateDoubleToRight(origin);
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
        if(a>b)
            return a;
        else 
            return b;
    }
    //get the specific height of a node
    private int height(Node<T> node) {
        if(node==null)
            return -1;
        else 
            return node.getHeight();
    }
    
    private Node<T> findMin( Node<T> node ) {
        if( node == null )
            return node;
    
        while( node.getLeft() != null )
            node = node.getLeft();
        return node;
    }

    public void deleteNode(T element){
        deleteNode(origin,element);
    }

    private Node<T> deleteNode(Node<T> node, T element){
        if(node == null){
            return node;
        }
        if(element.compareTo(node.getElement())<0){
            node.setLeft(deleteNode(node.getLeft(), element));
        }else if(element.compareTo(node.getElement())>0){
            node.setRight(deleteNode(node.getRight(), element));
        }else if( node.getLeft() != null && node.getRight() != null ) {
            node.setElement(findMin( node.getRight() ).getElement());
            node.setRight(deleteNode(node.getRight(),node.getElement()));
        }else{
            node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        }

        return node;

    }
        
}