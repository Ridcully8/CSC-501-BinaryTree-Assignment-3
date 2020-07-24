import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestBinaryTree {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("prog3in1.txt"));
		final int size = 20; // based on the known number of items in input files
		TreeNode temp= new TreeNode();             // used to store result of search()
		
		BinaryTree tree = new BinaryTree();    // test default construction

		// Before loading the values from the array, let's do a few basic operations
		System.out.println("State of a Default-constructed tree: " ); 
		tree.diag();
		
		System.out.println("\nBegin series of inserts and deletes: " );
		tree.insert(36);    // should be the root since it is the only item
		tree.insert(23);    // left child
		tree.insert(46);    // right child
		tree.diag(); 
		
		tree.startPreorder();    // "see" the tree in its entirety
		System.out.println();    // preorder method has no carriage return at the end
		
		tree.delete(36);     // new root should be 46 
		tree.diag(); 
		
		tree.delete(46);   // new root should be 23
		tree.diag(); 
		tree.delete(9999);   // non-existent item
		
		tree.delete(23);    // delete the root
		tree.diag();
		
		tree.delete(9999);    // delete from an empty tree
		
		
		// now populate the tree with the values from the file 
		int[] array = new int[size];     // array to hold values read from the file
		for (int i = 0; i < size; i++) {
			array[i] = in.nextInt(); 
			tree.insert(array[i]); // inserts the items from the array into the Tree
		}
		
		
		// Display original array contents for reference only
		System.out.println("\nOriginal array contents: " );
		for (int i = 0; i < size; i++) 
			System.out.print(array[i] + " "); 	
		System.out.println();
		
		System.out.println("\nInserting all items from the array:");
		tree.diag(); 
		
		System.out.println("\nPreorder traversal:");
		tree.startPreorder();
		System.out.println("\nInorder traversal:");
		tree.startInorder();
		System.out.println("\nPostorder traversal:");
		tree.startPostorder();
		System.out.println();


		System.out.println("\nSearching for selected elements of the original array:");
		for (int i = 0; i < size; i += 4) {
			System.out.print("Searching for the node with value " + array[i] + ": ");		
			temp.setData(tree.search(array[i]));
			if (temp != null)
				System.out.println("Found node with value: " + temp.getData());
			else
				System.out.println("Did not find a node with value : " + array[i]);
		}
		
		int negativeTest = 9999999; 
		System.out.print("Searching for a node with value " + negativeTest + ": ");
		temp.setData(tree.search(negativeTest)); 
		if (temp != null)
			System.out.println("Found node with value: " + temp.getData());
		else
			System.out.println("Did not find a node with value : " + negativeTest);
		
		
		System.out.println("\nDeleting selected items from the tree:");
		for (int i = 0; i < size; i += 4) {
			System.out.println("\nDeleting " + array[i]);
			tree.delete(array[i]);
			tree.diag(); 
			tree.startPreorder();
			System.out.println();
		}
		
		System.out.println();
		

		System.out.println("\nPreorder traversal:");
		tree.startPreorder();
		System.out.println("\nInorder traversal:");
		tree.startInorder();
		System.out.println("\nPostorder traversal:");
		tree.startPostorder();
		System.out.println();

		in.close();
	}
}
