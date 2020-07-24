/*
 * This is a BinaryTree class, uses TreeNode class
A binary search tree with int data, a left node, and a right node
pray that it works
 * @author TAPPLEGATE0006
 */

import java.lang.*;
import static java.lang.Integer.max;

public class BinaryTree {
    
    //private TreeNode to point to the head of the list
    private TreeNode head;
    
    //private int to hold the size of the binary search tree
    private int size =0;
    
    //default constructor
    public void BinaryTree(){
        
        head=null;
    }//end default constructor
    
    //insert int
    public void insert(int intToInsert){
        
        //create a new node to insert
        TreeNode insertNode = new TreeNode(intToInsert);
        
        TreeNode current = head;
        
        //if inserting into an empty list
        if(head==null)
        {
            //head becomes insert node
            head=insertNode;
            //incriment size of the BST
            incrimentSize();
        }//end insert into empty node if
        //else inserting into a non empty list
        else{
            boolean inserted=false;

            while(inserted==false){
                //if the int to insert is greater than the current node data,
                //the int to insert needs to go to the right
                if(intToInsert>current.getData()){
                    //if the right node is null, leaf node has been reached, and
                    //new node can be inserted
                    if(current.getRightNode()==null){
                        //insert the new node
                        current.setRightNode(insertNode);
                        //increase size
                        incrimentSize();
                        //change inserted to true to break while loop
                        inserted=true;
                    }//end if you reached a right leaf node
                    //otherwise you are not at a leaf yet
                    else{
                        //get the right node and continue
                        current=current.getRightNode();
                    }//end else to intToInsert>current.getData()

                }//end if intToInsert>current.getData()

                //otherwise intToInsert is < or = current data, and needs to go to 
                //the left
                else{
                    //if the left node is null, leaf node has been reached and/
                    //new node can be inserted
                    if(current.getLeftNode()==null){
                        current.setLeftNode(insertNode);
                        //incriment size
                        incrimentSize();
                        //change inserted to true to break while loop
                        inserted=true;                    
                    }//end if you reached a left leaf node
                    //otherwise you have not reached a leaf node
                    else{
                        current=current.getLeftNode();
                    }//end else for not reaching a left leaf node

                }//end else for int to insert is < or = current data
            }//end while
        }//end else for inserting into a non empty list
    }//end insert()
    
    //search for an int in the BST
    public int search(int intToSearchFor){
        TreeNode current=head;
        
        while(current!=null){
            //if current holds the int being searched for
            if(current.getData()==intToSearchFor){
                return current.getData();
            }//end if current holds the data to search for
            //else current does not hold the data
            else{
                //if data being searched for is > current, move right
                if(intToSearchFor>current.getData()){
                    //get right node
                    current=current.getRightNode();
                }//end if intToSearchFor > current.getData()
                //else intToSearchFor is < current.getData
                else{
                    //get left node
                    current=current.getLeftNode();
                }//end if intToSearchFor < current.getData()
            }//end else statement for current not holding the intBeingSearched for
            
        }//end of search while loop
        
        //otherwise the data is not found, return a dummy data value
        return -9999;
        
    }//end search()
    
    
     public TreeNode search(TreeNode nodeToSearchFor){
        TreeNode current=head;
        
        while(current!=null){
            //if current holds the int being searched for
            if(current.getData()==nodeToSearchFor.getData()){
                return current;
            }//end if current holds the data to search for
            //else current does not hold the data
            else{
                //if data being searched for is > current, move right
                if(nodeToSearchFor.getData()>current.getData()){
                    //get right node
                    current=current.getRightNode();
                }//end if intToSearchFor > current.getData()
                //else intToSearchFor is < current.getData
                else{
                    //get left node
                    current=current.getLeftNode();
                }//end if intToSearchFor < current.getData()
            }//end else statement for current not holding the intBeingSearched for
            
        }//end of search while loop
        
        //otherwise the data is not found, return a dummy data value
        return null;
        
    }//end search()
    
    //delete a node, calls the recursive method to delete the node and reshuffle the tree
    public void delete(int intToDelete){
        
        head=delete(intToDelete, head);
        
    }//end delete()
    
    //private recursive method to delete node
    private TreeNode delete(int intToDelete,TreeNode current){
        
        //check if list is empty
        if(current==null){
            System.out.println("Error, item not found in list");
            return null;
        }//end check if list is empty
        //if current is the node to delete
        else if(current.getData()==intToDelete){
            //if left is null
            if(current.getLeftNode()==null){
                decrimentSize();
                return(current.getRightNode());
                }//if left is null
            //if right is null
            else if(current.getRightNode()==null){
                decrimentSize();
                return(current.getLeftNode());
            }//end if right is null
            //else left and right nodes exist
            else{
                //create a temp node and set it to right node
                TreeNode temp = current.getRightNode();
                //search for a chile leaf node
                while(temp.getLeftNode()!=null){
                    //move down the left sub tree
                    temp=temp.getLeftNode();
                }//end of the while loop
                
                //once you get the left child, use it to replace node before it
                current.setData(temp.getData());
                current.setRightNode(delete(temp.getData(),current.getRightNode()));
                return current;
                
            }//end of the else for deleting a node with 2 children
            
        }//end if current has the data to delete
        
        //else if delete value not found in current node
        else{
            //if intToDelete is greater than the current value
            if(current.getData()<intToDelete){
                //move down the right path
                current.setRightNode(delete(intToDelete,current.getRightNode()));
                return current;
            }//end if for intToDelete being greater than the current node value
            //otherwise intToDelete is less than current value
            else{
                //move down the left
                current.setLeftNode(delete(intToDelete,current.getLeftNode()));
                return current;
            }//end of the else for intToDelete being less than current value
        }//end of else data not found at current location
        
    }//end recursive delete(int intToDelete, TreeNode head)
    

    
    
        
    //incrimentSize
    private void incrimentSize(){
        size++;
    }//end incrimentSize()
    
    //decrimentSize
    private void decrimentSize(){
        size--;
    }//end decrimentSize()
    
    //getSize
    public int getSize(){
        //return the size of the BST
        return size;
    }//end getSize()
    
    //boolean for checking if list is empty, returns true for empty list
    public boolean isEmpty(){
        //if size is 0 list is empty
        if(getSize()==0){
            return true;
        }//end if looking for empty list
        //otherwise return false
        return false;        
    }//end isEmpty()
    
    public void startInorder(){
        inOrderTraversal(head);
              
    }//end inorderTraversal
    
    private void inOrderTraversal(TreeNode current){
        if(current==null){
            return;
        }//end null node
        
        inOrderTraversal(current.getLeftNode());
        System.out.println(current.getData() + " ");
        inOrderTraversal(current.getRightNode());
        
        
    }//end inOrderTraversal()
    
    public void startPostorder(){
        postOrderTraversal(head);
    }//end startPostorder()
    
    //postorder traversal
    private void postOrderTraversal(TreeNode current){
        if(current==null){
            return;
        }//end null node
        
        postOrderTraversal(current.getRightNode());
        System.out.println(current.getData() + " ");
        postOrderTraversal(current.getLeftNode());
            
    }//end postOrderTraversal()
    
    public void startPreorder(){
        preOrderTraversal(head);
    }//end startPostorder()
    
    //preorder traversal
    //start by outputting the head node, then left sub tree, then right
    private void preOrderTraversal(TreeNode current){
        if(current==null){
            return;
        }//end null node
        
        System.out.println(current.getData() + " ");
        preOrderTraversal(current.getLeftNode());
        preOrderTraversal(current.getRightNode());
            
    }//end preOrderTraversal()
    
    //get the height of the tree
    public int getHeight(){
        int height = findHeight(head); 
        
        return height;
    }//end getHeight
    
    public int findHeight(TreeNode current){ 
        if(current==null){
            return 0;
        }//end if node is null
        
        int leftHeight = findHeight(current.getLeftNode());
        int rightHeight= findHeight(current.getRightNode());
        
        return 1+(max(leftHeight,rightHeight));
        
    }//end findHeight
    
    
    //diag shows size, height, is empty, and data in the root node, or null
    public void diag(){
        
        System.out.println("Getting the size");
        System.out.println(getSize());
        
        System.out.println("Getting the height");
        System.out.println(getHeight());
        
        System.out.println("Checking if list is empty");
        if(isEmpty()==true){
            System.out.println("List Is Empty");
        }
        else{
            System.out.println("List is not empty");
        }
        
        System.out.println("Getting the data in the root node");
        System.out.println(getRoot());
        
    }//end diag
    
    //destroy the list
    public void destroy(){
        head=null;
        size=0;
    }//end destroy
    
    //get data in the root
    //if root is null return -1
    public int getRoot(){
        //if head is null return -1
        if(head==null){
            return -1;
        }//if head is null
        
        return head.getData();        
    }//end getRoot()
    
    /*
    public static void main(String args[]){
        
        //create a new tree
        BinaryTree newTree = new BinaryTree();
        
        //create a new string for print data
        String toPrint = new String();
        
        //insert 11 into the tree
        System.out.println("Inserting 11 into the BST");
        newTree.insert(11);
        
        //output the size
        System.out.println("Outputting the size");
        System.out.println(newTree.getSize());
        
        //insert 7 into the tree
        System.out.println("Inserting 7 into the BST");
        newTree.insert(7);
        
        //insert 15 into the tree
        System.out.println("Inserting 15 into the BST");
        newTree.insert(15);
        
        //insert 9 into the tree
        System.out.println("Inserting 9 into the BST");
        newTree.insert(9);
        
        //insert 4 into the tree
        System.out.println("Inserting 4 into the BST");
        newTree.insert(4);
        
        //output the size
        System.out.println("Outputting the size");
        System.out.println(newTree.getSize());
        
        //searching the list for items
        System.out.println("Searching the BST for 11");
        System.out.println(newTree.search(11));
        
        System.out.println("Searching the BST for 7");
        System.out.println(newTree.search(7));
        
        System.out.println("Searching the BST for 15");
        System.out.println(newTree.search(15));
        
        System.out.println("Searching the BST for 9");
        System.out.println(newTree.search(9));
        
        System.out.println("Searching the BST for 4");
        System.out.println(newTree.search(4));
        
        System.out.println("Searching the BST for 22");
        System.out.println(newTree.search(22));
        
        System.out.println("Deleting 7");
        newTree.delete(7);
        
        System.out.println("Outputting the size");
        System.out.println(newTree.getSize());
        
        System.out.println("Searching the BST for 11");
        System.out.println(newTree.search(11));
        
        System.out.println("Searching the BST for 7");
        System.out.println(newTree.search(7));
        
        System.out.println("Searching the BST for 4");
        System.out.println(newTree.search(4));
        
        System.out.println("Searching the BST for 9");
        System.out.println(newTree.search(9));
        
        System.out.println("Searching the BST for 15");
        System.out.println(newTree.search(15));
        
        System.out.println("Starting In Order Traversal");
        newTree.startInorder();
        
        System.out.println("Starting Post Order Traversal");
        newTree.startPostorder();
        
        System.out.println("Starting Pre Order Traversal");
        newTree.startPreorder();
        
        System.out.println("Finding the height");
        System.out.println(newTree.getHeight());
        
        System.out.println("Running diag");
        newTree.diag();
        
        System.out.println("Destroying the list");
        newTree.destroy();
        
        System.out.println("Running diag");
        newTree.diag();
        
    }//end main
*/
            
    
}//end BinaryTree()
