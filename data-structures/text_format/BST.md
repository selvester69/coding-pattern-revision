
public class BinarySearchTree{

    class Node{
        int data;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }

    Node root;
    public BinarySearchTree(){}

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root==null){
            root = newNode;
            return true;
        }
        Node temp = root;
        while(true){
            if(temp.value ==value){
                return false;
            }else if(value<temp.value){
                if(temp.left==null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }else {
                if(temp.right==null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
        return false;
    }

    public boolean contains(int value){
       
        Node temp = root;
        while(temp!=null){
            if(temp.value==value){
                return true;
            }else if(value<temp.value){
                temp = temp.left;
            }else {
                temp = temp.right;
            }
        }
        return false;
    }

    
}