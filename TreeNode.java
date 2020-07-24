/*
 * TreeNode class to be used with the binary search tree class
holds int data and 2 pointers, one for left and one right node.
 *
 * @author TAPPLEGATE0006
 */
public class TreeNode {
    private int data;//for holding node data
    
    private TreeNode leftNode;//points to left node
    
    private TreeNode rightNode;//points to right node
    
    //default constructor initalizes left and right node to null
    public TreeNode(){
        
        //set node pointers to null
        leftNode=null;
        rightNode=null;
    }//end default constructor
    
    //constructor taking just an int
    public TreeNode(int incommingData)
    {
        data=incommingData;//set data to incommingData
        
        //set node pointers to null
        leftNode=null;
        rightNode=null;
    }//end constructor taking just an int
    
    
    
    //set methods
    
    //set data
    public void setData(int dataToSet){
        
        //set node data to passed data
        data = dataToSet;        
    }//end setSata
    
    //set left node
    public void setLeftNode(TreeNode leftNodeToSet){
        //set left node
        leftNode=leftNodeToSet;
    }//end setLeftNode
    
    //set right node
    public void setRightNode(TreeNode rightNodeToSet){
        //set right node
        rightNode=rightNodeToSet;
    }//end setRightNode
    
    //end set methods
    
    
    //begin get methods
    
    //get data
    public int getData(){
        //return the int data
        return data;
    }//end getData
    
    public TreeNode getLeftNode(){
        //return left node
        return leftNode;
    }//end getLeft
    
    public TreeNode getRightNode(){
        //return right node
        return rightNode;
    }//end getRight
    
}//end of TreeNode class
