import java.util.LinkedList;
import java.util.Queue;


public class TreePrintByLevel extends BinaryTree {
	
	public static void printByLevel(Node root) {
		Queue<Node> currentLevel = new LinkedList<Node>();
        Queue<Node> nextLevel    = new LinkedList<Node>();

        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            
            for(Node currentNode : currentLevel){
                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                }
                System.out.print(currentNode.data + " "); 
            }

            System.out.println();
            currentLevel = nextLevel;
            nextLevel    = new LinkedList<Node>();

        }

	}

}
