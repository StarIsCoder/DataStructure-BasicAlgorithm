package Utils;

import java.util.Stack;

public class VisitBinaryTree {
    public static void visitWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode tmp = stack.pop();
            System.out.println(tmp.val);
            //Need to reverse it because stack is First In Last Our type.
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }

        }
    }

    public static void visitWithRecursionPreorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        visitWithRecursionPreorder(root.left);
        visitWithRecursionPreorder(root.right);
    }

    public static void morrisPreorderTraverse(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                System.out.println(cur.val);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }

                if (pre.right == cur) {
                    pre.right = null;
                    cur = cur.right;
                } else {
                    pre.right = cur;
                    System.out.println(cur.val);
                    cur = cur.left;
                }
            }
        }
    }
}
