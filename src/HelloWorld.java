import Utils.TreeNode;
import Utils.VisitBinaryTree;

// This file is to test code
public class HelloWorld {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

//        VisitBinaryTree.visitWithStack(tree);
        VisitBinaryTree.visitWithRecursionPreorder(tree);
//        VisitBinaryTree.morrisPreorderTraverse(tree);
    }
}
