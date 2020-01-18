
public class TreeDepth extends BinaryTree {

	public static int treeDepth(Node root) {
		return treeDepthCalc(root);
	}

	public static int treeDepthCalc(Node root) {
		if (root == null)
			return 0;
		else {
			int lDepth = treeDepthCalc(root.left);
			int rDepth = treeDepthCalc(root.right);

			// check the first of the children which change level
			if (lDepth > rDepth)

				return lDepth + 1;
			else
				return rDepth + 1;
		}

	}

}
