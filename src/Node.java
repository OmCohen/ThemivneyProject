public class Node  {
    static int MIN_VALUE = -2147483648;
    static int MAX_VALUE = 2147483647;
    private Node left;
    private Node middle;
    private Node right;
    private Node p;
    private Node leftSibling;
    private Node rightSibling;
    private Key key;


    public Node(Node left, Node middle, Node right, Node p, Node leftSibling, Node rightSibling, Key key) {
        this.left = left;
        this.middle = middle;
        this.right = right;
        this.p = p;
        this.leftSibling = leftSibling;
        this.rightSibling = rightSibling;
        this.key = key;
    }

    public Node(Node left, Node middle, Node right, Node p, Node leftSibling, Node rightSibling) {
        this(left, middle,right, p, leftSibling, rightSibling, null);
    }


    public Node(Key key) {
        this(null, null, null,null,null,null,null);
        this.key = key;
    }

    public Node() {
        this(null, null, null,null,null,null,null);
    }

    public Key getKey() {
        return this.key;
    }

    public void setKey(Key key) {
         this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getMiddle() {
        return middle;
    }

    public void setMiddle(Node middle) {
        this.middle = middle;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getP() {
        return p;
    }

    public void setP(Node p) {
        this.p = p;
    }

    public Node getLeftSibling() {
        return leftSibling;
    }

    public void setLeftSibling(Node leftSibling) {
        this.leftSibling = leftSibling;
    }

    public Node getRightSibling() {
        return rightSibling;
    }

    public void setRightSibling(Node rightSibling) {
        this.rightSibling = rightSibling;
    }

    //finding the optional relevant node to be succssor
    public Node successor(Node x) {
        Node y;
        Node z = x.getP();
        while ((x == z.getRight()) || (z.getRight() == null && x == z.getMiddle())) {
            x = z;
            z = z.getP();
        }
        if (x == z.getLeft()) {
            y = z.getMiddle();
        }else{
            y = z.getRight();
        }
        while (y.getLeft() != null) {
            y = y.getLeft();
        }
        Key maxKey = new Key(MIN_VALUE, MAX_VALUE);
        if (y.getKey().equals(maxKey)){
            return null;
        }
        return y;
    }

    //finding the optional relevant node to be predecessor
    public Node predecessor(Node x) {
        Node y;
        Node z = x.getP();
        while (x == z.getLeft()){
            x = z;
            z = z.getP();
        }
        if (x == z.getRight()){
            y = z.getMiddle();
        }else{
            y = z.getLeft();
        }
        while (y.getRight() != null || (y.getRight() == null && y.getMiddle() != null)){
            if (y.getRight() != null){
                y = y.getRight();
            }else {
                y = y.getMiddle();
            }
        }
        Key minKey = new Key(MAX_VALUE, MIN_VALUE);
        if (y.getKey().equals(minKey)){
            return null;
        }
        return y;
    }

    public Node predecessor(){
        return predecessor(this);
    }


}
